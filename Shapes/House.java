/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

//Draw house
//Has windows, roof, body, door and door knob

public class House extends Compound {
	
	
	public House()
	{
		super();
		
		Shape top = new Triangle(75, 300, 150, 100);
		Shape body = new Rectangle(75, 300, 150, 200);
		Shape windowLeft = new Square(95, 320, 50);
		Shape windowRight = new Square(155, 320, 50);
		Shape door = new Rectangle(160, 430, 40, 70);
		Shape knob = new Circle(185, 460, 10);
		
		Shape[] house = {top, body, windowLeft, windowRight, door, knob};
		
		setShapes(house);
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
