/*
Name: Renee Fung
Student Number: V00778609
Lab: B05
Assignment #4
*/

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class ChuckALuck
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Call new Scanner to be passed into different methods
		Scanner userInput = new Scanner(System.in);
		
		introduction();
		instructions();
		
		//Used for bankroll
		String message = "How much do you want to add to your bankroll? ";

		double playerAmount = bankRoll(userInput, message);
		
		if(playerAmount <0) {
			System.out.println("You cannot add a negative amount, this game has ended.");
			System.exit(0);
		}
		
		System.out.println();
		
		//Variables used in do-while loop
		char again;
		int totalBet = 1;
		double newBankRoll = 0;
		
		do { 
			
			//EXTRA: If the player amount is zero, ask if they would like to add more money
			while (playerAmount == 0) {
				playerAmount = addMoreMoney(userInput, newBankRoll, message, playerAmount);
			}
			
			//EXTRA: Ask player if they would like to add more money if they have less than 5 dollars
			while (playerAmount <= 5) {
				playerAmount = lowOnMoney(userInput, newBankRoll, message, playerAmount);
				
				//If the player amount didn't change, break out of loop
				if (playerAmount == playerAmount) {
					break;
				}
			}
			
			
			//If bet amount isn't in range, end the game
			double bet = betAmount(userInput, playerAmount);
			
			if(bet <0) {
				System.out.println("You have not entered a bet amount in the range, this game has ended.");
				System.exit(0);
			}
			
			//If chosen number not in range, end the game
			int number = chooseNum(userInput);
			if(number <0) {
				System.out.println("Not in range, the game has ended.");
				System.exit(0);
			}
		
			//Roll the dice 
			int diceNum1 = rollDice();
			int diceNum2 = rollDice();
			int diceNum3 = rollDice();
		
		
			//Print player's bankroll 
			double moneyWon = playerWinnings(diceNum1, diceNum2, diceNum3, bet, number);
			if (moneyWon != 0) {
				playerAmount += moneyWon;
			} else {
				playerAmount -= bet;
			}
		
			System.out.println("After bet " + totalBet + " your bankroll is $" + playerAmount);
			
			//Ask if player wants to play again
			again = playAgain(userInput);
			
			//Increment bet count
			totalBet++;
		
		} while (again == 'y' || again == 'Y');
		
		
	}
	
	//EXTRA: It's not perfect yet, but I tried! 
	public static void introduction() throws FileNotFoundException
	{
		//Give user an introduction to the game
		File introduction = new File("introduction.txt");
		Scanner scanIntroText = new Scanner(introduction);
		
		while(scanIntroText.hasNext()) {
			String text = scanIntroText.nextLine();
			System.out.print(text + " ");

		}
		
		System.out.println();
		System.out.println();
		
	}
	
	//EXTRA: It's not perfect yet, but I tried!
	public static void instructions() throws FileNotFoundException
	{
		//Give user some instructions for the game
		File instructions = new File("instructions.txt");
		Scanner scanText = new Scanner(instructions);
		
		while(scanText.hasNext()) {
			String text = scanText.nextLine();
			System.out.print(text + " ");

		}
		
		System.out.println();
		System.out.println();		
	}

	public static double bankRoll(Scanner userInput, String message)
	{
		double bankRollInitial;
		
		//Loop -- if player inputs negative amount, ask question again; stop program if repeated 3 times
		for(int i=0; i<3; i++) {
			System.out.print("\n" + message);
			bankRollInitial = userInput.nextDouble();
			
			if(bankRollInitial >= 0) {
				return bankRollInitial;
			}
			
			System.out.println("Invalid value\n");
		}
		
		return -1.0;
	}
	
	public static double betAmount(Scanner userInput, double playerAmount)
	{
		double bet;
		
		//Loop -- return the bet amount if it is within range; otherwise print invalid value 3 times and end loop
		for(int i=0; i<3; i++) {
			System.out.print("What is the value of your next bet? ($0.00 - $" + playerAmount + ") ");
			bet = userInput.nextDouble();
			if(bet >= 0 && bet <= playerAmount) {
				return bet;
			}
		
			System.out.println("Invalid value\n");
		}
		
		return -1.0;
	}
	
	public static int chooseNum(Scanner userInput)
	{
		int number;
		
		//Loop -- if player inputs number not in range, print invalid value 3 times and end loop
		for(int i=0; i<3; i++) {
			System.out.print("Choose a number between 1 and 6: ");
			number = userInput.nextInt();
			if(number >= 1 && number <=6) {
				return number;
			} 
			
			System.out.println("Invalid value\n");
		}
		
		return -1;
	}
	
	public static int rollDice()
	{
		Random diceRoll = new Random();
		
		//Return a number between 1 and 6
		int diceResult = diceRoll.nextInt(6) + 1;
		return diceResult;
	}
	
	public static double playerWinnings(int diceNum1, int diceNum2, int diceNum3, double bet, int number)
	{
		System.out.println("Dice Rolls: " + diceNum1 + " " + diceNum2 + " " + diceNum3);
		
		//if only first dice matches
		if (diceNum1 == number && diceNum2 != number && diceNum3 != number) {
			return bet;
		//if only second dice matches
		} else if (diceNum2 == number && diceNum1 != number && diceNum3 != number) {
			return bet;
		//if only third dice matches
		} else if (diceNum3 == number && diceNum1 != number && diceNum2 != number) {
			return bet;
		//if first and second dice matches 
		} else if (diceNum1 == number && diceNum2 == number && diceNum3 != number) {
			return bet*2;
		//if first and third dice matches
		} else if (diceNum1 == number && diceNum3 == number && diceNum2 != number) {
			return bet*2;
		//if second and third dice matches 
		} else if (diceNum2 == number && diceNum3 == number && diceNum1 != number) {
			return bet*2;
		//if all three dice matches
		} else if (diceNum1 == number && diceNum2 == number && diceNum3 == number) {
			return bet*10;
		} else {
			return 0.00;
		}

	}
	
	public static double addMoreMoney(Scanner userInput, double newBankRoll, String message, double playerAmount) 
	{
		double addAmount;
		String yOrN;
		
		//Ask if player would like to add more money, if not, end the game
		System.out.println("Sorry, you have no more money");
		System.out.print("Would you like to add more? ");
		yOrN = userInput.next();
		addAmount = yOrN.charAt(0);
				
		if (addAmount == 'y' || addAmount == 'Y') {
			newBankRoll = bankRoll(userInput, message);
			playerAmount = newBankRoll;
			return playerAmount;
		} else {
			System.out.println("You need money to play.");
			System.out.println("The game has ended");
			System.exit(0);
		}
		
		return -1.0;
	}
	
	public static double lowOnMoney(Scanner userInput, double newBankRoll, String message, double playerAmount)
	{
		double addAmount;
		String yOrN;
		
		//Ask if player would like to add more money since they're low on cash
		System.out.println("You're low on cash");
		System.out.print("Would you like to add more? ");
		yOrN = userInput.next();
		addAmount = yOrN.charAt(0);
				
		if (addAmount == 'y' || addAmount == 'Y') {
			newBankRoll = bankRoll(userInput, message);
			playerAmount += newBankRoll;
			return playerAmount;
		} else {
			System.out.println("That's fine, keep playing.");
		}
		
		//Return the orginal amount if they didn't want to add more money
		return playerAmount;
	}
	
	public static char playAgain(Scanner userInput)
	{
		String yOrN;
		char again; 
		
		//Ask player if they would like to play again
		System.out.print("\nDo you want to keep playing? (yes or no) ");
		yOrN = userInput.next();
		System.out.println();
		
		again = yOrN.charAt(0);
		
		return again;
	}
	
}




