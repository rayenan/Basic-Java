/* Example use of an expression evaluator.
 * Reads an expression from the first command line argument,
 * converts the expression from infix to postfix, and evaluates
 * the expression in postfix form.
 */

import java.io.*;
import java.util.*;

public class Calculator {

	public static void main(String[] args) throws ExpressionFormatException, FileNotFoundException, EmptyStackException 	{

		Scanner in = new Scanner (new File("MyPostfix.txt"));

		while (in.hasNextLine()) {
			Expression e1 = new Expression( in.nextLine() );
			System.out.println( e1 );
			System.out.println( e1.evaluateAsPostfix() );
		}
	}

}
