/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class DrawingFrame extends javax.swing.JPanel
{
	public DrawingFrame (int w, int h)
	{
		setFocusable(true);
		setBackground(Color.black);
		setSize(w,h);
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		/*
		//Shape test is for testing purposes 
		Shape test = new Rectangle(10, 50, 90, 50);
		g.setColor(Color.red);
		test.draw(g);
		
		test = new Triangle(300, 300, 40, 60);
		g.setColor(Color.blue);
		test.draw(g);
		
		test = new Square(150, 150, 90);
		g.setColor(Color.yellow);
		test.draw(g);
		
		test = new Oval(40, 400, 80, 100);
		g.setColor(Color.cyan);
		test.draw(g);
		
		test = new Circle(400, 40, 60);
		g.setColor(Color.magenta);
		test.draw(g);
		
		test = new Line(300, 100, 0, 500);
		g.setColor(Color.orange);
		test.draw(g);
		*/
		
		Compound cTest = new House();
		g.setColor(Color.magenta);
		cTest.draw(g);
		
		cTest = new Earth();
		g.setColor(Color.green);
		cTest.draw(g);
		
		cTest = new Tree();
		g.setColor(Color.gray);
		cTest.draw(g);
		
		cTest = new Clouds();
		g.setColor(Color.blue);
		cTest.draw(g);

		//g.setColor(Color.yellow);
		//g.drawString("Hello world!", 200,200);

		int[] x = {100, 100, 200, 200};
		int[] y = {500, 200, 200, 500};



		//g.fillPolygon(x,y,3);
	}


}
