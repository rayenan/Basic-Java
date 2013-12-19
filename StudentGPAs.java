/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 2
 *Student GPAs PART I
*/ 

//Imports
import java.util.Scanner;
import java.io.*;

public class StudentGPAs
{
	//Main
	public static void main(String [] args)
	{
		
		try {
			File inputFile = new File ("studentData.txt");
			Scanner dataScanner = new Scanner(inputFile);
			
			fillStudentData(dataScanner);
		} 
		
		catch (FileNotFoundException error) {
			System.err.println("Error: " + error);
			System.out.println("File you are trying to read does not exist. Please fix.");
		}
		
	}
	
	//Fill in student data 
	public static void fillStudentData(Scanner dataScanner) 
	{
		//Number of students in record
		int studentsNum = dataScanner.nextInt();
		
		int tempArraySize = 0; 
		
		Student studentData[] = new Student[tempArraySize];
		
		//Fill data
		for(int i = 0; i < studentsNum; i++) {
			dataScanner.nextLine();
			dataScanner.nextLine();
			
			String name = dataScanner.nextLine();
			long id = dataScanner.nextLong(); 
			
			//For assignment, every student completes 5 courses; initialize to avoid magic numbers
			int numOfCourses = 5;
			int numOfTerms = dataScanner.nextInt();
			
			String courseName[][] = new String[numOfTerms][numOfCourses]; 
			String courseGrade[][] = new String[numOfTerms][numOfCourses];
			
			for(int j = 0; j < numOfTerms; j++) {
				for(int k = 0; k < numOfCourses; k++) {
					courseName[j][k] = dataScanner.next();
					courseGrade[j][k] = dataScanner.next();
				}
			}
			
			
			Student student = new Student(name, id, courseName, courseGrade); 
			
			boolean studentInRecord = false; 
			
			for(int r = 0; r < studentData.length; r++) {
				if(student.getName().equals(studentData[r].getName()) && student.getId() == studentData[r].getId()) {
					studentInRecord = true; 
					if(student.getCourseLetterReference().length > studentData[r].getCourseLetterReference().length) {
						studentData[r] = student;
					}
				}
			}
			
			
			if(!studentInRecord) {
				studentData = addStudent(studentData, student);
			}
			
						
			
		}
		
		cumulativeGPA(studentData);
		
	}
	
	//Calculate GPA for all students 
	public static void cumulativeGPA(Student[] studentData) 
	{
		System.out.println();
		
		//NTS: Use .getCumulativeGPA from class
		for(int i = 0; i < studentData.length; i++) {
			System.out.print(studentData[i].getName() + " cumulative GPA is: " + studentData[i].getCumulativeGPA());
			System.out.println();
		}
		
		System.out.println();
	}
	
	
	//Students that don't exist already
	public static Student[] addStudent(Student[] studentData, Student student) 
	{
		Student[] newStudent = new Student[studentData.length + 1]; 
		for(int i = 0; i < studentData.length; i++) {
			newStudent[i] = studentData[i]; 
		}
		
		newStudent[studentData.length] = student; 
		return newStudent;
	}
}
