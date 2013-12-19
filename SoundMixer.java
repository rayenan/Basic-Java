/*
*Renee Fung
*V00778609
*CSC 110 Assignment 5
*Lab B05
*/

import java.util.Scanner;
import java.io.*;

public class SoundMixer
{
	public static void main(String[] args) throws IOException
	{
		File frequency = new File("arraySamples.txt");
		Scanner frequencyInput = new Scanner(frequency);
		Scanner userInput = new Scanner(System.in);
		PrintStream outputFile = new PrintStream(new File("testOutput.txt"));
		
		//Create three arrays with sizes 20, 20 and 25
		double[] sampleArray1 = new double[20];
		double[] sampleArray2 = new double[20];
		double[] sampleArray3 = new double[25];
		
		//Fill the array samples with the sample text 
		for(int i=0; i<sampleArray1.length; i++) {
			sampleArray1[i] = frequencyInput.nextDouble();
		}
				
		for(int j=0; j<sampleArray2.length; j++) {
			sampleArray2[j] = frequencyInput.nextDouble();
		}
				
		for(int k=0; k<sampleArray3.length; k++) {
			sampleArray3[k] = frequencyInput.nextDouble();
		}
		
		//Print a title for each set of arrays in the test output text
		outputFile.println("These are the values for sampleArray1 (size 20): ");
		printArray(sampleArray1, outputFile);
		outputFile.println("These are the values for sampleArray2 (size 20): ");
		printArray(sampleArray2, outputFile);
		outputFile.println("These are the values for sampleArray3 (size 25): ");
		printArray(sampleArray3, outputFile);
		
		//Allows user input for changing volume
		adjustVolumeInputs(userInput, sampleArray1, sampleArray2, sampleArray3, outputFile);
		addInputs(userInput, sampleArray1, sampleArray2, sampleArray3, outputFile);

		reverse(sampleArray1, outputFile);
		printReverse(sampleArray1, outputFile);
		
		reverse(sampleArray2, outputFile);
		printReverse(sampleArray2, outputFile);
		
		reverse(sampleArray3, outputFile);
		printReverse(sampleArray3, outputFile);
		
		printSplice(outputFile, sampleArray1, sampleArray2);
		
		printAdjustFrequency(userInput, sampleArray1, sampleArray2, sampleArray3, outputFile);

	}
	
	
	/*
	*Pass each sample array into this method
	*and print it in my test output text file
	*/
	public static void printArray(double[] samples, PrintStream outputFile)
	{
		for(int i=0; i<samples.length; i++) {
			outputFile.println("Sample " + i + "    " + "[" + samples[i] + "]");
		}
		
		outputFile.println();
	}
	
	/*
	*Allow user inputs for adjusting volume
	*In this method, user will be prompted to choose a sample from the list
	*It will then call the adjust volume method to perform
	*the required calculations
	*/
	public static void adjustVolumeInputs(Scanner userInput, double[] sampleArray1, double[] sampleArray2, double[] sampleArray3, PrintStream outputFile)
	{
		System.out.print("Please choose a sample for volume adjustment: 1, 2, or 3: ");
		int sample = userInput.nextInt();
		
		if(sample == 1) {
			adjustVolume(sampleArray1, userInput, outputFile);
		} else if(sample == 2) {
			adjustVolume(sampleArray2, userInput, outputFile);
		} else {
			adjustVolume(sampleArray3, userInput, outputFile);
		}
	}
	
	/*
	*This method adjusts the volume according to the
	*start index and end index the user will input and the
	*factor in which each indeces will be multiplied
	*
	*
	*When factor > 1, sound becomes flat as the height of the
	*array value cannot exceed 1. When factor < 1, it gives the array
	*a value between 1 and -1
	*/
	public static void adjustVolume(double[] samples, Scanner userInput, PrintStream outputFile)
	{
		System.out.print("Please enter a start index between 0 and " + samples.length + ": ");
		int startIndex = userInput.nextInt();
		
		//Check to make sure parameters are not outside of startIndex values; returns if so
		if(startIndex < 0 || startIndex >= samples.length) {
			System.out.println("Invalid start index");
			System.out.println("This program will now end");
			System.exit(0);
		}
		
		System.out.print("Please enter an end index between " + startIndex + " and " + samples.length + ": ");
		int endIndex = userInput.nextInt();
		
		//Check to make sure parameters are not outside of endIndex values; returns to main if so
		if(endIndex < 0 || endIndex > samples.length) {
			System.out.println("Invalid end index");
			System.out.println("This program will now end");
			System.exit(0);
		}

		System.out.print("Please enter the amount by which sound is increased or decreased: ");
		double factor = userInput.nextDouble();
		if(factor > 1 || factor < -1) {
			System.out.println("Invalid factor");
			System.out.println("This program will now end");
			System.exit(0);
		}
		
		outputFile.println("Sound array before:");
		//If parameters pass checks, continue with for loop
		for(int j= startIndex; j < endIndex; j++) {
			outputFile.println(samples[j]);
		}
		
		outputFile.println();
		
		outputFile.println("Sound array after:");
		
		//If parameters pass checks, continue with for loop
		for(int i= startIndex; i < endIndex; i++) {
			samples[i] = samples[i] * factor;
			outputFile.println(samples[i]);
		}
		
		outputFile.println();
	}
	
	//Overload
	/*
	*I added an overload because I did some user inputs in the 
	*previous method which got way out of hand to do
	*for the addInputs
	*/
	//Method to change the values in the array "samples" from start index to end index by factor amount
	public static void adjustVolume(double [] samples, double startIndex, double endIndex, double factor) 
	{

		//check to make sure parameters are not outside of startIndex values; returns to main if so
		if(startIndex < 0 || startIndex >= samples.length) {
			System.out.println("Invalid startIndex");
			return;

		}
		//check to make sure parameters are not outside of endIndex values; returns to main if so
		if(endIndex < 0 || endIndex > samples.length) {
			System.out.println("Invalid endIndex");
			return;

		}
		//if parameters pass checks, continue with for loop
		for(int i= (int)startIndex; i < endIndex; i++) {
			samples[i] = samples[i] * factor;
		}

	}
	
	//Allow user to choose which samples they like to add
	public static void addInputs(Scanner userInput, double[] sampleArray1, double[] sampleArray2, double[] sampleArray3, PrintStream outputFile)
	{
		System.out.println("Please choose two samples to add: 1, 2, or 3: ");
		int sample1 = userInput.nextInt();
		int sample2 = userInput.nextInt();
		
		if( (sample1 == 1 || sample2 == 1) && (sample1 == 2 || sample2 == 2) ) {
			add(sampleArray1, sampleArray2, outputFile);
		} else if( (sample1 == 1 || sample2 == 1) && (sample1 == 3 || sample2 == 3) ){
			add(sampleArray1, sampleArray3, outputFile);
		} else {
			add(sampleArray2, sampleArray3, outputFile);
		}
	
	}
	
	/*
	*This method takes the two arrays use has chosen
	*and adds each index together. 
	*This will only run if the size of the arrays are equal, 
	*other the program will end.
	*/
	public static void add(double [] samples1, double [] samples2, PrintStream outputFile) 
	{
		//Testing value
		double val = 0.1;
		
		//Exit the program if the two array lengths are not the same
		//In this case, only array 1 and 2 will work
		if(samples1.length != samples2.length) {
			System.out.println("The array length must be equal");
			System.out.println("The program will now end");
			System.exit(0);
		}
		
		outputFile.println("The sum of the two arrays is:");
		for(int i = 0; i < samples1.length; i++) {
			samples1[i] = samples1[i] + samples2[i];
			if(samples1[i] > 1 || samples1[i] < -1) { 
				adjustVolume(samples1, i, i+1, val);

			}
			outputFile.println(samples1[i]);
		}
		
		outputFile.println();

	}

	
	//This method reverses the array values 
	public static void reverse(double[] samples, PrintStream outputFile) 
	{
		for(int i = 0; i<samples.length/2; i++) {
			double temp = samples[i];
			
			samples[i] = samples[samples.length - i - 1];
			samples[samples.length - i - 1] = temp;
		}
		
		outputFile.println();
	}
	
	//Print reverse to test output text file
	public static void printReverse(double[] samples, PrintStream outputFile)
	{
		outputFile.println("The reversed sound samples are:");
		
		for(int i=0; i<samples.length; i++) {
			outputFile.println(samples[i]);
		}
		
		outputFile.println();
	}
	
	//Splice in a segment of array1 into array2 according to the given parameters
	public static void splice(double [] source, int sourceStart, int sourceStop, double [] destination, int destStart) 
	{

		for(int i=sourceStart; i<=sourceStop; i++) {
			destination [destStart + i] = source [sourceStart + i];
			
			if(sourceStop>source.length || destination.length<sourceStop) {
				return;
			}
		}

	}
	
	//Used to print the before and after the splice method 
	public static void printSplice(PrintStream outputFile, double[] sampleArray1, double[] sampleArray2) 
	{
		//Before
		outputFile.println("Sample array 2 before: ");
		for(int i=0; i<sampleArray2.length; i++) {
			outputFile.println(sampleArray2[i]);
		}
		
		outputFile.println();
		
		//After
		outputFile.println("Sample array 2 after a segment of sample array 1 is spliced in: ");
		
		/*
		*For testing purposes, I chose to use index from 0 to 5 in 
		*sample array 1 to splice into sample array 2
		*/
		splice(sampleArray1, 0, 5, sampleArray2, 0);
		for(int i=0; i<sampleArray2.length; i++) {
			outputFile.println(sampleArray2[i]);
		}
		
		outputFile.println();
	}
	
	public static void printAdjustFrequency(Scanner userInput, double[] sampleArray1, double[] sampleArray2, double[] sampleArray3, PrintStream outputFile)
	{
		System.out.print("Please choose a sample to adjust the frequency: 1, 2, or 3: ");
		int sample = userInput.nextInt();
		
		String adjusted = "The adjusted frequency is: ";
		
		//Use factor of 2 for testing purposes 
		if(sample == 1) {
			adjustFrequency(sampleArray1, 2);
			
			outputFile.println(adjusted);
			
			for(int i=0; i<sampleArray1.length; i++) {
				outputFile.println(sampleArray1[i]);
			}
			
		} else if(sample == 2) {
			adjustFrequency(sampleArray2, 2);
			
			outputFile.println(adjusted);
			
			for(int j=0; j<sampleArray2.length; j++) {
				outputFile.println(sampleArray2[j]);
			}
			
		} else {
			adjustFrequency(sampleArray3, 2);
			
			outputFile.println(adjusted);
			
			for(int k=0; k<sampleArray3.length; k++) {
				outputFile.println(sampleArray3[k]);
			}
			
		}
	}
	
	public static double[] adjustFrequency(double[] samples, double factor) 
	{
		//if factor > 1, frequency is decreased; if factor < 1 (but >0), frequency is increased
		int newSamplesIndex = 0;
		double[] newSamples = new double [samples.length/(int)factor];
		double samplesIndex = 0.0;

		for(int i=0; i<=newSamples.length-1; i++) {
			newSamples[newSamplesIndex + i] = samples[(int)samplesIndex];
			samplesIndex = samplesIndex + (int)factor;

		}
		
		return newSamples;
	}
	
}


