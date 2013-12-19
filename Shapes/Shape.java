/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

import java.awt.*;

public abstract class Shape {
	int initX, initY;
	Color fillColour;

	public Shape() {
		initX = 0;
		initY = 0;
	}

	public Shape(int x, int y) {
		initX = x;
		initY = y;
	}

	public void setInitX (int x) {
		initX = x;
	}

	public void setInitY (int y) {
		initY = y;
	}

	public abstract void draw(Graphics g);
	public abstract double Area();
	public abstract double Perimeter();

	public void Move(int deltaX, int deltaY){
		//future work
	}
}
