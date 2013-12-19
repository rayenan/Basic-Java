/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

public class Oval extends ClosedShape {

	
	//X and y indicate the point at the centre of the oval 
	//Width and height specify the bounding rectangle
	public Oval(int x, int y, int width, int height)
	{
		super(false, 0);
		
		this.x = x; 
		this.y = y; 
		this.width = width;
		this.height = height;
		
		int[] xPos = {x, x+width, x+width, x};
		int[] yPos = {y, y, y+height, y+height};
		
		setXYCoords(xPos, yPos);
	}
	
	public void draw()
	{
		//Use draw from ClosedShape	
	}
	
	//Calculate area
	public double Area()
	{
		double area = Math.PI * width/2 * height/2; 
		return area;	
	}
	
	//Calculate perimeter
	public double Perimeter()
	{
		double root = Math.sqrt( ( (width/2) + (height/2) ) / 2);
		double perimeter = 2 * Math.PI * root;
		return perimeter;
	}
	
	
	

}
