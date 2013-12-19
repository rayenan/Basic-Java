/*
Name: Renee Fung
Student Number: V00778609
Lab: B05
Assignment 1
*/

//nts: surface area of a cylinder = 2(pi)(r^2) + 2(pi)rh
//nts: answer should be approximately 87.9m
//nts: to use pi, call " Math.PI "

public class MathCalculations
{
	public static void main(String[] args)
	{
		//Store value of the circumference of a circle
		//Circumference = pi x diameter
		double circumferenceArea = Math.PI * 4;
		
		//Store value of the area of a circle 
		//Area = pi x r^2
		double circleArea = Math.PI * 2 * 2;
		
		//Store value of the rectangular area of the cylinder
		//Area = 2(pi)rh
		double rectangleArea = 2 * Math.PI * 2 * 5;
		
		//Store value for the surface area
		double surfaceArea = circumferenceArea + circleArea + rectangleArea;
		
		//Question
		System.out.println("What is the surface area of a cylinder \nif the height is 5m and \nthe diameter is 4m?\n");
		//Statement showing circumference of a circle
		System.out.println("Circumference of a circle = " + circumferenceArea + "m");
		//Statement showing area of a circle
		System.out.println("Area of a circle = " + circleArea + "m");
		//Statement showing rectangular area of the cylinder
		System.out.println("Rectangular area of the cylinder = " + rectangleArea + "m");
		//The surface area of this cylinder is
		System.out.println("Answer is: " + surfaceArea + "m");
	}
}
//end

//references
//http://en.wikibooks.org/wiki/Java_Programming/Math
