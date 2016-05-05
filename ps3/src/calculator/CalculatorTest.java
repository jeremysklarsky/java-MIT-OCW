package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculator() {
        MultiUnitCalculator testCalc = new MultiUnitCalculator();

        assertEquals("5.2", testCalc.evaluate("3.2 + 2 ="));
        assertEquals("5.4", testCalc.evaluate("3 + 2.4 ="));
//        assertEquals("-1.4", testCalc.evaluate("1 - 2.4 ="));
//        assertEquals("16.8", testCalc.evaluate("(3 + 4)*2.4 ="));
//        assertEquals("5.4in", testCalc.evaluate("3 + 2.4in ="));
//        assertEquals("518.4pt", testCalc.evaluate("3pt * 2.4in ="));
//        assertEquals("7.2in", testCalc.evaluate("3in * 2.4 ="));
//        assertEquals("522.4pt", testCalc.evaluate("4pt+(3in*2.4) ="));
//        assertEquals("5.4in", testCalc.evaluate("(3 + 2.4) in ="));
//        assertEquals("518.4pt", testCalc.evaluate("(3in * 2.4) pt ="));        
    }

	boolean approxEquals(String expr1, String expr2, boolean compareUnits) {
		return new Value(expr1).approxEquals(new Value(expr2), compareUnits);
	}

	static class Value {
		static float delta = 0.001f;
 
		enum Unit {
			POINT, INCH, SCALAR
		}

		Unit unit;
		// in points if a length
		float value;

		Value(String value) {
			value = value.trim();
			if (value.endsWith("pt")) {
				unit = Unit.POINT;
				this.value = Float.parseFloat(value.substring(0,
						value.length() - 2).trim());
			} else if (value.endsWith("in")) {
				unit = Unit.INCH;
				this.value = 72 * Float.parseFloat(value.substring(0,
						value.length() - 2).trim());
			} else {
				unit = Unit.SCALAR;
				this.value = Float.parseFloat(value);
			}
		}

		boolean approxEquals(Value that, boolean compareUnits) {
			return (this.unit == that.unit || !compareUnits)
					&& Math.abs(this.value - that.value) < delta;
		}
	}

}
