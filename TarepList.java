/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 5
 *Linked Lists
*/

import java.util.Scanner;
import java.io.*; 

public class TarepList {

	public static void main(String [] args) {
		
		//Try
		try {
		
		// create a list to store the Tarep items
		LinkedList TarepOne = new LinkedList();

		// Open the AddData.txt file and add the items appropriately to the list
		File inputFileA = new File("AddData.txt");
		Scanner input = new Scanner(inputFileA);

		while(input.hasNext()) 
		{
			String text = input.next();
			
			if(text.equals("head")) {
				TarepOne.addHead(input.next());
			} else if(text.equals("tail")) {
				
				TarepOne.addTail(input.next());
			} else if(text.equals("position")) {
				int position = input.nextInt();
				TarepOne.add(input.next(), position);
			} else {
				System.out.println("No location found for one of the nodes");
			}
		
		}
		
		// Print out the entire list
		System.out.println("After adding data from AddData.txt");
		System.out.println("----------------------------------");
		System.out.println(TarepOne + "\n");

		// Open the RemoveData.txt file and remove the specified items from the list
		File inputFileB = new File("RemoveData.txt");
		input = new Scanner(inputFileB);
		
		while(input.hasNext()) 
		{
			String text = input.next();
			
			if(text.equals("head")) {
				TarepOne.removeHead();
			} else if(text.equals("tail")) {
				TarepOne.removeTail();
			} else if(text.equals("position")) {
				TarepOne.remove(input.nextInt());
			} else {
				System.out.println("No location found for one of the nodes");
			}
		
		}

		// Print out the entire list
		System.out.println("After removing data from RemoveData.txt");
		System.out.println("----------------------------------");
		System.out.println(TarepOne + "\n");

		// Empty the TarepOne list and then print out the entire list
		TarepOne.makeEmpty();
		
		System.out.println("After emptying the list");
		System.out.println("----------------------------------");
		System.out.println(TarepOne);
		
		//Catch exception 
		} catch(FileNotFoundException e) {
			System.err.println(e);
			System.out.println("No file found.");
		}

	}
}
