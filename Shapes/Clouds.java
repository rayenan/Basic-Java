/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

//Draw blue clouds at the top 
public class Clouds extends Compound {
	
	
	public Clouds()
	{
		super();
		
		Shape cloudA = new Oval(25, 25, 150, 30);
		Shape cloudB = new Oval(200, 60, 170, 40);
		Shape cloudC = new Oval(400, 10, 130, 30);
		
		Shape[] cloud = {cloudA, cloudB, cloudC};
		
		setShapes(cloud);
	}
	
	//Calculate area
	public double Area()
	{
		return 0.0;
	}
	
	//Calculate perimeter
	public double Perimeter()
	{
		return 0.0;
	}

}
