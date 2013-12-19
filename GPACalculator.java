/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 1
 *GPA Calculator 
*/ 


import java.util.Scanner;
import java.io.*; 

public class GPACalculator
{ 
	//Create constants to be accessed throughout the class
	
	
	//Exceptional work
	static final double A_PLUS = 9.0; 
	
	//Outstanding work
	static final double A = 8.0; 
	
	//Excellent work
	static final double A_MINUS = 7.0;
	
	//Very good work
	static final double B_PLUS = 6.0; 
	
	//Acceptable 
	static final double B = 5.0; 
	
	//Unacceptable 
	static final double B_MINUS = 4.0;
	static final double C_PLUS = 3.0; 
	static final double C = 2.0;
	static final double D = 1.0; 
	
	//Failing grade 
	static final double F = 0.0;
	
	
	/*
	 * Calculate and output a student's sessional 
	 * Grade Point Average (GPA) for one term of courses
	 * Using UVIC standards  
	*/
	public static void main(String[] args) throws FileNotFoundException
	{
		/*Program entry point*/
		System.out.println("\nGPA CALCULATOR\n");
		
		
		/*Necessary files and scanners*/
		
		//File that will be read 
		File inputFile = new File("gradeInput.txt");
		//Scanner to read file 
		Scanner studentInfo = new Scanner(inputFile);
		
		
		while(studentInfo.hasNextLine()) {
		
			/*Information*/
			
			studentInfo(studentInfo);
			
			//Get the number of classes the student is taking --- to make an equivalent array 
			int getClassNum = classes(studentInfo); 
			
			
			/*Grades*/
			
			//Create arrays to store student's grade and GPA for that grade 
			//Array size should be equal to the number of classes student took 
			String[] classGrade = new String[getClassNum];
			double[] classGPA = new double[getClassNum]; 
			
			grades(classGrade, classGPA, studentInfo);
			
			/*GPA*/
			
			//Calculate the GPA
			double studentGPA = calculateGPA(getClassNum, classGPA);
			System.out.println("\nYour GPA is: " + studentGPA);
			
			studentInfo.nextLine();
			studentInfo.nextLine();
		}
		
	}
	
		
	public static void studentInfo(Scanner studentInfo) 
	{
		//Read and print student's information
		System.out.println( "\nName: " + studentInfo.nextLine() );
		System.out.println( "Student ID: " + studentInfo.nextLine() );	
	}
	
	
	public static int classes(Scanner studentInfo)
	{
		//Get the number of classes the student took --- it will be the array size
		int classNum = studentInfo.nextInt();
		
		System.out.println("You are taking " + classNum + " classes.");
		
		System.out.println();
		
		return classNum; 
	}
	
	
	public static void grades(String[] classGrade, double[] classGPA, Scanner studentInfo)
	{
		//Loop through and fill in the arrays 
		for(int i=0; i < classGrade.length; i++) {
			classGrade[i] = studentInfo.next();
			
			System.out.print("Class: " + (i+1) + " "); 
			
			//Print letter grade 
			System.out.print("Grade: " + classGrade[i] + " ");
			
			//Print GPA for letter grade 			
			if(classGrade[i].equals("A+")) {
				
				classGPA[i] = A_PLUS; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("A")) {
				
				classGPA[i] = A; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("A-")) {
				
				classGPA[i] = A_MINUS; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("B+")) {
				
				classGPA[i] = B_PLUS; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("B")) {
				
				classGPA[i] = B; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("B-")) {
				
				classGPA[i] = B_MINUS; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("C+")) {
				
				classGPA[i] = C_PLUS; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("C")) {
				
				classGPA[i] = C; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else if(classGrade[i].equals("D")) {
				
				classGPA[i] = D; 
				System.out.println("GPA: " + classGPA[i]);
				
			} else {
				
				classGPA[i] = F; 
				System.out.println("GPA: " + classGPA[i]);
			}
	
		}		
	
	}
	
	
	public static double calculateGPA(int getClassNum, double[] classGPA) 
	{
		//Create a variable to store total GPA 
		double totalGPA = 0.0; 
		
		for(int i=0; i < classGPA.length; i++) {
			//Add all the GPAs together
			totalGPA += classGPA[i]; 
		}
		
		//Divide total GPA with the number of classes the student took
		double studentGPA = (totalGPA / getClassNum); 
		
		//Return the student's GPA
		return studentGPA; 
		
	}
	

}

