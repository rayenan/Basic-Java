/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 7
 *Doubly Linked List
*/

public class CircularDLL implements DoubleCircle
{
	private Node pointer;
	private int size; 
	
	//default constructor
	public void CircularDLL()
	{
		this.pointer = null;
		this.size = 0;
	}
	
	// returns true when the list is empty
	public boolean isEmpty() 
	{
		if (this.pointer == null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	// adds a Node immediately before the pointer
	public void addBefore(Object data)
	{
		//if there is no data in the list, add a new node containing
		//the data and make it point to itself
		if(this.size == 0) {
			Node newNode = new Node(data);
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			this.pointer = newNode;
			
			//increase the size 
			this.size++;
			
		//if there is only one node in the list, add the new node
		//and make them point to each other
		} else if(this.size == 1) {
			Node newNode = new Node(data);
			Node current = this.pointer;
			
			current.setNext(newNode);
			current.setPrevious(newNode);
			newNode.setNext(current);
			newNode.setPrevious(current);
			
			//increase the size
			this.size++;
			
		//if the size is > 1 then add the new node accordingly
		} else {
			Node newNode = new Node(data);
			Node current = this.pointer;
			Node previous = this.pointer.getPrevious();
			
			previous.setNext(newNode);
			newNode.setNext(current);
			newNode.setPrevious(previous);
			current.setPrevious(newNode);
			
			
			//increase the size
			this.size++;
		}
		
	}
	
	//adds a Node immediately after the pointer
	public void addAfter(Object data)
	{
		//if there is no data in the list, add a new node containing
		//the data and make it point to itself
		if(this.size == 0) {
			Node newNode = new Node(data);
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			this.pointer = newNode;
			
			//increase the size
			this.size++;
			
		//if there is only one node in the list, add the new node
		//and make them point to each other
		} else if(this.size == 1) {
			Node newNode = new Node(data);
			Node current = this.pointer;
			
			current.setNext(newNode);
			current.setPrevious(newNode);
			newNode.setNext(current);
			newNode.setPrevious(current);
			
			//increase the size
			this.size++;
			
		//if the size is > 1 then add the new node accordingly
		} else {
			Node newNode = new Node(data);
			Node current = this.pointer; 
			Node after = this.pointer.getNext();
			
			current.setNext(newNode);
			newNode.setPrevious(current);
			newNode.setNext(after);
			after.setPrevious(newNode);
			
			//increase the size
			this.size++;
		}
	}
	
	// removes the Node exactly at the pointer
	public void removeAtList()
	{
		//if the list is not empty 
		//remove accordingly
		if(size != 0) {
			Node newPointer = this.pointer.getNext();
			Node newPrevious = this.pointer.getPrevious();
			
			newPointer.setPrevious(newPrevious);
			newPrevious.setNext(newPointer);
			this.pointer = newPointer;
			
			//decrease the size
			this.size--;
			
		//otherwise, let user know there is nothing to remove
		} else {
			System.out.println("Nothing to remove");
		}
		
	}
	
	//removes a Node containing the specified data
	//nts: this must be recursive
	public void removeSpecified(Object data)
	{
		//if the list is not empty 
		//remove accordingly
		if(size != 0) {
			if(this.pointer.getItem().equals(data)) {
				removeAtList();
			} else {
				this.pointer = removeSpecified(data, this.pointer.getNext());
				
				//decrease the size
				this.size--;
			}
		//otherwise, let user know there is nothing to remove	
		} else {
			System.out.println("Nothing to remove");
		}
		
	}
	
	private Node removeSpecified(Object data, Node current)
	{
		
		//this if statement 
		if(this.pointer != current) {
			if(current.getItem().equals(data)) {
				Node newPointer = current.getNext();
				Node newPrevious = current.getPrevious();
				
				newPointer.setPrevious(newPrevious);
				newPrevious.setNext(newPointer);
				current = newPointer;
				
				return current;
				
			} else {
				return removeSpecified(data, current.getNext());
			}
		}
		
		return this.pointer;		
			
	}
	
	//prints out all data in the list
	//nts: this must be recursive
	public String toString() 
	{
		if(isEmpty()) {
			return " ";
		} else {
			return toString(this.pointer);
		}
	}
	
	public String toString(Node current) 
	{
		
		if(current == this.pointer.getPrevious()) {
			return " " + current.getItem();
		} else {
			return " " + current.getItem() + " ==>" + toString(current.getNext());
		}
	
	}
	
	
	
	
}
