/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

//Draw tree
//Oval as the leaves and branches
//Rectangle as the tree trunk
public class Tree extends Compound {
	
	
	public Tree()
	{
		super();
		
		Shape leaves = new Oval(340, 340, 150, 60);
		Shape trunk = new Rectangle(400, 400, 30, 100);
		
		
		Shape[] tree = {leaves, trunk};
		
		setShapes(tree);
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
