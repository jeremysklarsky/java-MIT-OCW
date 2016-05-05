package calculator;

import calculator.Type;

import java.util.ArrayList;


/**
 * Calculator lexical analyzer.
 */
public class Lexer {
    private final String s;
    private int i;
    public ArrayList<Token> tokens; 
	/**
	 * Token in the stream.
	 */
	public static class Token {
		final Type type;
		final String text;

		Token(Type type, String text) {
			this.type = type;
			this.text = text;
		}

		Token(Type type) {
			this(type, null);
		}
	    public Type getType() {
	        return type;
	    }
	    
	    public String getValue() {
	        return text;
	    }		
	}

	@SuppressWarnings("serial")
	static class TokenMismatchException extends Exception {
	}

	public Lexer(String input) {
	    this.s = input.replaceAll("\\s+","");
	}
	
    public Token next() {
        switch (s.charAt(i)) {
        case '+':
            ++i;
            return new Token(Type.PLUS, "+");
        case '-':
            ++i; 
            return new Token(Type.MINUS, "-");
        case '*':
            ++i; 
            return new Token(Type.MULTIPLY, "*");
        case '/':
            ++i; 
            return new Token(Type.DIVIDE, "/");            
        case '=':
            return new Token(Type.EOF, "=");
            
        default:
            // it's a Number token.  Find where it ends.
            int start = i;
            while ("1234567890inpt.".indexOf(s.charAt(i)) != -1) {
                ++i;
            }
            int end = i;
            return new Token(Type.NUMBER, s.substring(start, end));
        }
    }

}
