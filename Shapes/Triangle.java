/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

public class Triangle extends ClosedShape {
	
	int base;
	
	//Assume this represents an isosolese triangle
	//Two equal sides up
	//X and y is the lower left point
	public Triangle(int x, int y, int base, int height)
	{
		super(true, 3);
		
		this.x = x; 
		this.y = y; 
		this.base = base;
		this.height = height;
		
		int[] xPos = {x, x + base, x + base/2};
		int[] yPos = {y, y, y - height};
		
		setXYCoords(xPos, yPos);
	}
	
	public void draw()
	{
		//Use draw from ClosedShape	
	}
	
	//Calculate area
	public double Area()
	{
		double area = (base * height) / 2; 
		return area;	
	}
	
	//Calculate perimeter 
	public double Perimeter()
	{
		double sides = Math.sqrt( Math.pow((base/2), 2) + Math.pow(height, 2) );
		double perimeter = base + 2*sides;
		return perimeter;
	}

}
