package calculator;

/*
 * TODO define your symbols and groups from problem 1 here
 * NUMBER: integer 0-9
 * OPERATOR: +,-, /, *
 * PARENTHESIS: (,)
 * UNIT: in, pt
 */

/**
 * Token type.
 */
enum Type {
	NUMBER, 
	PLUS, 
	MINUS, 
	DIVIDE, 
	MULTIPLY, 
	OPEN_PARENS, 
	CLOSE_PARENS, 
	UNIT, 
	EOF
}