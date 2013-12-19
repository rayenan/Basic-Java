/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

public class Line extends OpenShape {

	
	//X and y indicate the leftmost point of line
	//Angle is in radians
	//Length is the length of the line
	public Line(int x, int y, double angle, double length)
	{
		super(length, x, y);
		
		double x2 = x - ( length * Math.cos(angle) );
		double y2 = y - ( length * Math.sin(angle) );
		
		int[] xVertices = {x, (int)x2};
		int[] yVertices = {y, (int)y2};
		
		setXYCoords(xVertices, yVertices);
		
	}
	

}
