/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

//Import graphics 
import java.awt.Graphics;

public abstract class OpenShape extends Shape {
	double length;
	
	//Initialize variables to draw
	int[] xVertices;
	int[] yVertices;
	int numPoints;
	

	public OpenShape(double length) {
		this.length = length;
	}
	public OpenShape(double length, int x, int y) {
		super(x,y);
		this.length = length;
	}
	
	//Set x and y coordinates 
	public void setXYCoords(int[] x, int[] y)
	{
		this.xVertices = x;
		this.yVertices = y; 
		this.numPoints = x.length; 
	}
	
	public double Area(){
		return 0.0;
	}
	public double Perimeter() {
		return length;
	}
	
	//Draw method
	public void draw(Graphics g) {
		
		g.drawPolyline(xVertices, yVertices, numPoints);
		
	}
}
