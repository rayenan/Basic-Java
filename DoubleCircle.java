/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 7
 *Doubly Linked List
*/

public interface DoubleCircle {
	public boolean isEmpty() ;
	// returns true when the list is empty
	
	public void addBefore(Object data) ;
	// adds a Node immediately before the pointer
	
	public void addAfter(Object data) ;
	//adds a Node immediately after the pointer
	
	public void removeAtList();
	// removes the Node exactly at the pointer
	
	public void removeSpecified(Object data);
	//removes a Node containing the specified data
}

//Code from assignment outline 
