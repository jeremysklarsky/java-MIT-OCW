package calculator;

import calculator.Lexer;

/*
 * 
 */

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {
	
	@SuppressWarnings("serial")
	static class ParserException extends RuntimeException {
	}

	/**
	 * Type of values.
	 */
	private enum ValueType {
		POINTS, INCHES, SCALAR
	};

	/**
	 * Internal value is always in points.
	 */
	public class Value {
		final double value;
		final ValueType type;

		Value(double value, ValueType type) {
			this.value = value;
			this.type = type;
		}

		@Override
		public String toString() {
			switch (type) {
			case INCHES:
				return value / PT_PER_IN + " in";
			case POINTS:
				return value + " pt";
			default:
				return "" + value;
			}
		}
	}

	private static final double PT_PER_IN = 72;
	private final Lexer lexer;

	// TODO write method spec
	Parser(Lexer lexer) {
		this.lexer = lexer;
	}

	// TODO write method spec
	public Value evaluate(Token tok) {
	    String value = tok.getValue();
	    Type type = tok.getType();
	    if (type == Type.NUMBER) {
	        
	    }
	}
}
