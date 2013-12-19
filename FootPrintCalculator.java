/*
Name: Renee Fung
Student Number: V00778609
Lab: B05
Assignment #3

Extras: box for breakdown; loop for new calculation
*/

//Import scanner 
import java.util.Scanner; 

public class FootPrintCalculator
{
	//Main method
	public static void main(String[] args)
	{
		//Set scanner to use in parameters of methods
		Scanner calculationResult = new Scanner(System.in);
		
		//Infinite Loop --- Chapter 2.4
		for(int calcAgain=1; calcAgain >=1; calcAgain++)
		{
			//Instruction message
			System.out.println("To calculate the total carbon usage for your personal transport \nplease answer the following questions carefully.");
			System.out.println();
			
			//Declare variables
			double pau = carbonPrivateAutoUsage(calculationResult);
			double pao = carbonPrivateAutoOwnership(calculationResult);
			double pt = carbonPublicTransport(calculationResult);
			double at = carbonAirTransport(calculationResult);
		
			double result = carbonTotal(pau, pao, pt, at, calculationResult);
			
			//Pass parameter in for printing report
			printReport(pau, pao, pt, at, result);
			
			//Allow user to calculate again with different values
			System.out.println();
			System.out.println("Calculate again?");
			System.out.println();

		}
		

	}
	
	//Method to calculate the carbon for private auto usage
	public static double carbonPrivateAutoUsage(Scanner userInput)
	{
		//Allow user input for Km per day
		System.out.print("How many kilometers do you travel per day in your car? ");
		double kmPerDay = userInput.nextDouble();
		
		//Allow user input for Km per L
		System.out.print("How much Km/L does your car get? ");
		double kmPerL = userInput.nextDouble();
		
		//Do calculations using formula
		double calculationResult = (12.85 * 365 * (kmPerDay/kmPerL));
		
		System.out.println();
		
		//Return the value of equation
		return calculationResult;
		
	}
	
	//Method to calculate the carbon for private auto ownership
	public static double carbonPrivateAutoOwnership(Scanner userInput)
	{
		//Allow user input for car's age
		System.out.print("How old is your car (in years)? ");
		double carAge = userInput.nextDouble();
		
		//Do calculations for carbon used
		double carbonUsed = ((120*26.127*1.94) / carAge);
		
		//Do calculations for carbon maintenance 
		double carbonMaintenance = 3.8*26.137*1.94;
		
		//Add the carbon used and carbon maintenance per year
		double calculationResult = carbonUsed + carbonMaintenance;
		
		System.out.println();
		
		//Return the value of eqation
		return calculationResult;
		
	}
	
	//Method to calculate carbon for public transit
	public static double carbonPublicTransport(Scanner userInput)
	{
		//Allow user input for the number of times they take the bus per month
		System.out.print("How many times do you take the bus in a month? ");
		double numOfBus = userInput.nextDouble();
		
		//Allow user input for distance of travel
		System.out.print("What is the distance you usually travel by bus (km)? ");
		double kmOfTravel = userInput.nextDouble();
		
		//Calculate the distance they travel per month
		double kmPerMonth = (kmOfTravel / numOfBus);
		
		//Calculate using 0.18, number of months in a year, and the distance they travel per month
		double calculationResult = (0.18 * 12 * kmPerMonth);
		
		System.out.println();
		
		return calculationResult;
		
	}
	
	//Method to calculate carbon for air transportation
	public static double carbonAirTransport(Scanner userInput)
	{
		//Assign values to variables 
		double shortHaul = 0.10;
		double longHaul = 0.20;
		
		//Allow user input for short haul distance
		System.out.print("What is the total distance of travel for short haul flights (km)? ");
		double kmShortHaul = userInput.nextDouble();
		
		//Allow user input for long haul distance
		System.out.print("What is the total distance of travel for long haul flights? (km)? ");
		double kmLongHaul = userInput.nextDouble();
				
		//Calculate the carbon used from the distance of flights
		double calculationResult = (shortHaul * kmShortHaul) + (longHaul * kmLongHaul);
		
		System.out.println();
		
		return calculationResult;
		
	}
	
	//Method to calculate the total
	public static double carbonTotal(double pau, double pao, double pt, double at, Scanner test)
	{
		//Add all values to give total amount
		//Divide by 1000 for metric tons per year
		double totalAmountOfCarbon = (pau + pao + pt + at)/1000 ;
		return totalAmountOfCarbon;
	}
	
	//Method to print the report
	public static void printReport(double pau, double pao, double pt, double at, double ct)
	{
		//Print total amount
		System.out.println("You produce an annual total of " + ct + " metric tons \nof carbon per year for your personal transport");
		
		System.out.println();
		
		//Top dashes
		for (int dash = 0; dash < 70; dash++)
		{
			System.out.print("-");
		}
		
		System.out.println();
		
		//Print breakdown
		System.out.println("The breakdown is as follows: ");
		System.out.println("\tPrivate Automobile Usage\t" + (pau/1000));
		System.out.println("\tPrivate Automobile Ownership\t" + (pao/1000));
		System.out.println("\tPublic Transport\t\t" + (pt/1000));
		System.out.println("\tAir Transport\t\t\t" + (at/1000));
		
		//Bottom Dashes
		for (int bDash = 0; bDash < 70; bDash++)
		{
			System.out.print("-");
		}
		
		System.out.println();
		
	}

}


