/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

//Draw line on the bottom of house and tree as earth
public class Earth extends Compound {
	
	
	public Earth()
	{
		super();
		
		Shape line = new Line(600, 500, 0, 600); 
		
		Shape[] earth = {line};
		
		setShapes(earth);
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
