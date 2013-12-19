/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 6
 *Hierarchy
*/

import javax.swing.JFrame;

public class Main
{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		JFrame  drawingFrame = new JFrame ("Draw!");
		drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingFrame  draw = new DrawingFrame(WIDTH, HEIGHT);
		draw.setOpaque(true);

		drawingFrame.setContentPane(draw);
		drawingFrame.setSize(WIDTH,HEIGHT);
		drawingFrame.setVisible(true);
	}
}
