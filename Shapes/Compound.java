/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

import java.awt.*; 

public abstract class Compound 
{
	Shape[] compoundShape;
	
	public Compound()
	{
		compoundShape = new Shape[0]; 
	}
	
	public void setShapes(Shape[] pictures)
	{
		compoundShape = pictures;
	}
	
	public  void draw(Graphics g)
	{
		for(int i = 0; i < compoundShape.length; i++) 
		{
		
			compoundShape[i].draw(g);
		}
	}
	
	public abstract double Area();
	public abstract double Perimeter();
	
	
}
