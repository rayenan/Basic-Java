//Imports
import java.util.Scanner; 
import java.io.*;

//Class
public class MLBPlayerAnalysis 
{
	//Main
	public static void main(String[] args) 
	{
		//Initialize an empty array of objects
		//Starts from 0; Total 144 elements
		MLBPlayer[] dataArray = new MLBPlayer[143]; 
		
		//Store data into the data array
		fillArray(dataArray);
		
		//Count first basemen within data
		int basemenCounter = firstBasemenCounter(dataArray);
		
		//Store first basemen players in an array
		MLBPlayer[] firstBaseArray = new MLBPlayer[basemenCounter];
		
		selectFirstBasemen(dataArray, firstBaseArray);
		sortPlayersByRBI(firstBaseArray);
		
		double averageRuns = calcAvgPlayerRunsCreated(dataArray);
		double[] VORP = calcVORP(firstBaseArray, averageRuns);
		double averageVORP = calcAverageVORP(VORP); 
		
		topTenPlayers(firstBaseArray, VORP, averageVORP);
		
	} //End of main
	
	//Fill data array with player statistics 
	public static void fillArray(MLBPlayer[] dataArray)
	{
		try {
			File inputFile = new File("playerData.txt");
			Scanner fileReader = new Scanner(inputFile);
			
			for(int i=0; i < dataArray.length; i++) {
				if(i == 0) {
					//To store data of first player
					//Skip first two lines in playerData.txt 
					fileReader.nextLine();
					fileReader.nextLine();
					
					dataArray[i] = new MLBPlayer(fileReader.next() + 
								     fileReader.next(),fileReader.next(),fileReader.next(),fileReader.nextInt(),
								     fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),
								     fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),
								     fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),
								     fileReader.nextInt(),fileReader.nextInt());
					
					fileReader.nextLine();
				}
				
				//Fill data
				dataArray[i] = new MLBPlayer(fileReader.next() + 
							   fileReader.next(),fileReader.next(),fileReader.next(),fileReader.nextInt(),
							   fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),
							   fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),
							   fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),fileReader.nextInt(),
							   fileReader.nextInt(),fileReader.nextInt());
			}
		}
		
		catch(FileNotFoundException notFound) {
			System.out.println("Problem with scanning input file.");
		}

	}
	
	//Count the number of players playing first base
	public static int firstBasemenCounter(MLBPlayer[] dataArray) 
	{
		//Initialize counter
		int counter = 0;
		
		for(int i=0; i < dataArray.length; i++) {
			String playerPosition = dataArray[i].getPosition();
			if(playerPosition.equals("1B")) {
				counter++;
			}
		}
		
		return counter;	
	}
	
	//Filter players in first base from the full data 
	public static void selectFirstBasemen(MLBPlayer[] dataArray, MLBPlayer[] firstBaseArray)
	{
		//Initialize variable 
		int k = 0; 
		
		for(int i=0; i < dataArray.length; i++) {
			String position = dataArray[i].getPosition();
			if(position.equals("1B")) {
					firstBaseArray[k] = dataArray[i];
					k++;
			}
		}
	}
	
	//Sort RBI
	public static void sortPlayersByRBI(MLBPlayer[] firstBaseArray) 
	{
		for(int i=0; i < firstBaseArray.length; i++) {
			for(int k=0; k < firstBaseArray.length; k++) {
				if(firstBaseArray[i].getRunsBattedIn() >= firstBaseArray[k].getRunsBattedIn()) {
					MLBPlayer temp = firstBaseArray[i]; 
					firstBaseArray[i] = firstBaseArray[k];
					firstBaseArray[k] = temp; 
				}
			}
		}
	}
	
	//Calculated the average of the player's runs
	public static double calcAvgPlayerRunsCreated(MLBPlayer[] dataArray) 
	{
		//Initialize variables
		double sum = 0;
		double average = 0; 
		
		for(int i=0; i < dataArray.length; i++) {
			sum += dataArray[i].calcRunsCreated(); 
		}
		
		//Calculate average of all player runs
		average = sum/(dataArray.length + 1);
		
		//Return average
		return average;
	}
	
	//Calculate the VORP for all first base players
	public static double[] calcVORP(MLBPlayer[] firstBaseArray, double averageRuns)
	{
		//Set up a new array
		double[] array = new double[20];
		
		//Initialize variable 
		double factor = 0.85;
		
		for(int i=0; i < firstBaseArray.length; i++) {
			array[i] = (firstBaseArray[i].calcRunsCreated() - (averageRuns * factor));
		}
		
		//Return
		return array; 
	}
	
	//Calculate the average VORP
	public static double calcAverageVORP(double[] VORP)
	{
		//Initialize variables
		double sum = 0; 
		double average = 0; 
		
		for(int i=0; i < VORP.length; i++) {
			sum += VORP[i]; 
		}
		
		//Calculate the average
		average = sum/(VORP.length);
		
		//Return
		return average; 
	}
	
	//Find the top ten players 
	public static void topTenPlayers(MLBPlayer[] firstBaseArray, double[] VORP, double averageVORP) 
	{
		try {
			//Create an output file
			PrintStream outputFile = new PrintStream(new File("FirstBasemenReport.txt"));
			
			for(int i=0; i < firstBaseArray.length; i++) {
				for(int k=0; k < firstBaseArray.length; k++) {
					//Sort RBI (high to low) and print to output file
					if(firstBaseArray[i].getRunsBattedIn() <= firstBaseArray[k].getRunsBattedIn()) {
						MLBPlayer temp = firstBaseArray[i];
						firstBaseArray[i] = firstBaseArray[k]; 
						firstBaseArray[k] = temp; 
						
						//Print VORP beside RBI
						double tempTwo = VORP[i];
						VORP[i] = VORP[k];
						VORP[k] = tempTwo;
					}
				}
			} //Exit loop
			
			//Print best selection
			outputFile.println("The best selection to replace Albert Pujols as first basemen");
			outputFile.println("is: Prince Fielder from the Detroit Tigers.");
			outputFile.println("He has the highest VORP and has one of the highest RBI");
			
			outputFile.println();
			
			outputFile.println("Name       " + "Team" + " RBI " + "VORP");
			
			for(int r=0; r < firstBaseArray.length; r++) {
				//Round VORP
				VORP[r] = Math.round(VORP[r] * 100.0) / 100.0;
				outputFile.println(firstBaseArray[r].getName() + " " + firstBaseArray[r].getTeam() +"  " 
						   + firstBaseArray[r].getRunsBattedIn() + " " + VORP[r]);
			}
				
			outputFile.println();
				
			averageVORP = Math.round(averageVORP * 100.0) / 100.0;
				
			outputFile.println("The average VORP for all First Basemen is: " + averageVORP); 
			outputFile.println(); 
				
			for(int j=0; j < firstBaseArray.length; j++) {
				VORP[j] = Math.round(VORP[j] * 100.00) / 100.0; 
					
				//If player doesn't play for LAA but is above average VORP
				//Print to output file
				//Else, skip
					
				if(!firstBaseArray[j].getTeam().equals(("LAA")) && (VORP[j] > averageVORP)) {
						outputFile.println(firstBaseArray[j].getName() + " " + firstBaseArray[j].getTeam()
								   + " " + firstBaseArray[j].getRunsBattedIn() + " " + VORP[j]);
				}
			}
		}
		
		catch(FileNotFoundException notFound) {
			System.out.println("No output file is found");
		}		
			
	}
		
	
}
