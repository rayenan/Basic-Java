/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 8
 *Stacks
*/



/* UVic CSc 115 Winter 2009 & Fall 2012- Assignment #4
 *            & Spring 2013 - Assignment #8
 *
 * Original Design: Rhodes Brown
 * Updated By: LillAnne Jackson
 */

import java.util.Scanner;

/**
 * Represent a simple arithmetic expression consisting of integers an operators.
 * Support conversion from infix to postfix expression forms.
 * Support interpretation (i.e. compute the value) of infix expressions.
 */
public class Expression {

	// Operator "tokens" used by expressions:
	static final String PLUS   = "+";
	static final String MINUS  = "-";
	static final String TIMES  = "*";
	static final String DIVIDE = "/";
	static final String OPEN   = "(";
	static final String CLOSE  = ")";
	static final int MAX_ARRAY_SIZE = 25;

	// The tokens held by this expression:
	private String[] tokens;

	/** Initialize an empty expression with no tokens. */
	public Expression() {
		tokens = new String[MAX_ARRAY_SIZE];
	}

	/** Initialize an expression by parsing tokens from a string of text. */
	public Expression(String text)	throws ExpressionFormatException {
		this(new Scanner(text)); //: make a Scanner over text and transfer to the other constructor
	}

	/** Initialize an expression by reading from a scanner. */
	// Places an empty String in the element immediately following the last token.
	public Expression(Scanner input)  throws ExpressionFormatException  {
		tokens = new String[MAX_ARRAY_SIZE];
		int i=0;
		while(  input.hasNext() ) {
			String token = input.next();
			token = token.trim(); //: remove any spaces, tabs, etc. at front or back

			if ( isOperator(token) || isBracket(token) || isValue(token) )
				tokens[i++] = token;
			else
				throw new ExpressionFormatException("invalid token: "+token);
		}
		tokens[i] = "";
	}

	/** Convert this expression to a single string of text. */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for ( String token : tokens ) {
			if (token != "") {
				builder.append(token);
				builder.append(' ');
			}
			else break;
		}
		return builder.toString().trim();
	}

	/**
	 * Assuming this expression is an infix expression, get an equivalent postfix expression.
	 * NOTE: this expression is not modified!
	 */
	public Expression toPostfix()	throws ExpressionFormatException {
		// If this assignment asked you to write a method to convert from infix to post fix
		//  it would be write here!  (But there is no such requirement!)
		return new Expression();  // would be replaced in an implementation
	}

	/**
	 * Assuming this expression is in postfix form, evaluate the expression.
	 */
	public int evaluateAsPostfix()	throws ExpressionFormatException, EmptyStackException{
		// FIXME
		int i = 0; 
		LinkedStack temp = new LinkedStack();
		
		//Used to store values for operation
		int a = 0; 
		int b = 0; 
		
		//Answer stored in here
		int value = 0; 
		
		//While the tokens is not empty 
		while(tokens[i] != "") 
		{
			if(isOperator(tokens[i]) )
			{
				b = (Integer)temp.pop();
				a = (Integer)temp.pop();
				
				//Calculator according to it's operator
				if(tokens[i].equals(PLUS)) 
				{
					value = a + b;
					temp.push(value);
					
				} else if(tokens[i].equals(MINUS)) {
					
					value = a - b;
					temp.push(value);
					
				} else if(tokens[i].equals(TIMES)) {
					
					value = a * b; 
					temp.push(value);
					
				} else if(tokens[i].equals(DIVIDE)) {
					
					value = a / b; 
					temp.push(value);
					
				} else {
					return 0; 
				}
			
			} else {
				temp.push(Integer.parseInt(tokens[i]));
			}
			
			//Increment in array
			i++;
		}
		
		//Return the answer
		return (Integer)temp.pop();
	}

	/**
	 * Determine the precedence of an operator.
	 * @return 0 for + and -, 1 for * and /
	 */
	static int precedence(String op) {
		if ( op.equals(PLUS) || op.equals(MINUS) )
			return 0;

		if ( op.equals(TIMES) || op.equals(DIVIDE) )
			return 1;

		throw new IllegalArgumentException("Not an operator: "+op);
	}

	/** Is the given token a valid operator? */
	public static boolean isOperator(String token) {
		return token.equals(PLUS) || token.equals(MINUS) || token.equals(TIMES) || token.equals(DIVIDE);
	}

	/** Is the given token an opening or closing bracket (parenthesis)? */
	public static boolean isBracket(String token) {
		return token.equals(OPEN) || token.equals(CLOSE);
	}

	/** Is the given token an integer value? */
	public static boolean isValue(String token) {
		try {
			Integer.parseInt(token);
			return true; //: success!
		}
		catch ( NumberFormatException ex ) { // => token was not a number!
			return false;
		}
	}
}
