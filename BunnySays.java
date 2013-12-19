/*
Name: Renee Fung
Student Number: V00778609
Lab: B05
Assignment #2
*/

//import the java utilities to use scanner
import java.util.Scanner;


//create a class named BunnySays by putting bunny in methods 
public class BunnySays
{
	
	
	//main function 
	public static void main(String[] args)
	{
		//loop the bunny loop three times
		for (int a = 1; a <= 3; a++)
		{
			bunnyLoop();
		}
		
		System.out.print("Too bad. The bunnies are tired now. Goodbye.\n");
		
		//print out the goodbye wave hand
		goodbyeHand();
		
		//add space
		System.out.println();
	}
	
	//bunny loop method
	public static void bunnyLoop()
	{
		//user input 
		speak();
		
		//loop the bunnies
		for (int b = 1; b <= 3; b++)
		{
			printBunny();
			System.out.println();
		}
		
		//ask to say something else!
		System.out.println("Say something else\n");
	}
	
	//speak method
	public static void speak()
	{
		
		//use scanner to allow user input
		Scanner userInputBunny = new Scanner(System.in);
		System.out.print("Enter a message for the bunnies to say: ");
		String bunnyMessage = userInputBunny.nextLine();
		
		//calculatate the length of the message and add 4 characters 
		int lengthOfText = bunnyMessage.length() +4;
		
		//loop top dashes
		for (int c = 0; c < lengthOfText; c++)
		{
			System.out.print("-");
		}
		
		//add space
		System.out.println();
		
		//print out the message
		System.out.println("| " + bunnyMessage + " |");	
		
		//loop bottom dashes
		for (int d = 0; d < lengthOfText; d++)
		{
			System.out.print("-");
		}
		
		//add space
		System.out.println();
	}
	
	
	//put bunny together in a method
	public static void printBunny()
	{
		bunnyEars();
		bunnyFace();
		bunnyPaws();
	}
	
	//method for bunny's ears
	public static void bunnyEars()
	{
		System.out.println(" (\\_/)");
	}
	
	//method for bunny's face
	public static void bunnyFace()
	{
		System.out.println("=(^.^)=");	
	}
	
	//method for bunny's paws
	public static void bunnyPaws()
	{
		System.out.println("(\")_(\")");
	}
	
	//method for goodbye wave hand
	public static void goodbyeHand()
	{
		System.out.println("\t _ _ _ _");
		System.out.println("\t/\t\\");
		System.out.println("\t|\t| _");
		System.out.println("\t|\t|/ /");
		System.out.println("\t|\t  /");
		System.out.println("\t|\t /");
		System.out.println("\t\\\t/");
	}
	
}

//end
