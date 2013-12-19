/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

public class Rectangle extends ClosedShape {

	//X, y is the upper left corner
	public Rectangle(int x, int y, int width, int height)
	{
		super(true, 4);
		
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
		double area = width * height; 
		return area;	
	}
	
	//Calculate perimeter
	public double Perimeter()
	{
		double perimeter = 2*width + 2*height;
		return perimeter;
	}
	
	
	

}	
