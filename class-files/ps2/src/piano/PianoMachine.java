package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;
import music.NoteEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PianoMachine {
	
	private Midi midi;
    
	public Instrument instrument = Midi.DEFAULT_INSTRUMENT;
	public int transpose = 0;
	public boolean recording = false;
	public List<NoteEvent> noteHistory = new ArrayList<NoteEvent>();

	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    public void beginNote(Pitch rawPitch) {
        int note = rawPitch.toMidiFrequency();
        // NoteEvent(Pitch pitch, long time, Instrument instr, Kind kind)
        noteHistory.add(new NoteEvent(rawPitch, System.currentTimeMillis(), instrument, NoteEvent.Kind.start));
    	midi.beginNote(note + transpose, instrument);
    }

    public void endNote(Pitch rawPitch) {
        int note = rawPitch.toMidiFrequency();
        noteHistory.add(new NoteEvent(rawPitch, System.currentTimeMillis(), instrument, NoteEvent.Kind.stop));
    	midi.endNote(note + transpose, instrument);
    }
    
    public void changeInstrument() {
        instrument = instrument.next();
    }
    
    public void shiftUp() {
    	if (transpose < 24) {
    	    transpose += 12;
    	}
    }
    
    public void shiftDown() {
    	if (transpose > -24) {
    	    transpose -= 12;
    	}
    }
    
    public boolean toggleRecording() {
        if (!recording) {
            noteHistory.clear();
            recording = true;
        } else {
            
            recording = false;
        }
        
        return recording;
    }
    
    protected void playback() {    	
        int i = 0;
        while (i < noteHistory.size()-1) {
            NoteEvent currentNote = noteHistory.get(i);
            NoteEvent nextNote = noteHistory.get(i+1);
            long time = nextNote.getTime() - currentNote.getTime();
            NoteEvent.Kind kind = currentNote.getKind();
            System.out.println(kind);
            if (kind.equals(NoteEvent.Kind.start)) {
                this.beginNote(currentNote.getPitch());
            } else {
                this.endNote(currentNote.getPitch());
            }
            
            try {
                TimeUnit.MILLISECONDS.sleep(time);
                i++;
            } catch (InterruptedException e) {
                
            }
            
        }
    }

}
