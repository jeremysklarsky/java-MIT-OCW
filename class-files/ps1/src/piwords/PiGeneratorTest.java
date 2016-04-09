package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));
        assertEquals(16, PiGenerator.powerMod(2, 4, 23));
        assertEquals(-1, PiGenerator.powerMod(1, -1, 1));
    }

    // TODO: Write more tests (Problem 1.a, 1.c)
    @Test
    public void computePiInHexTest() {
        assertArrayEquals(new int[]{2,4,3}, PiGenerator.computePiInHex(3));
    }
}
