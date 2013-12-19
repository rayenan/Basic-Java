/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 8
 *Stacks
*/


//Class will be implementing Stack.java
//Must have all of Stack's methods 
public class LinkedStack implements Stack
{
	
	private Node head; 
	
	//Constructor
	public LinkedStack()
	{
		// FILL IN THE CONSTRUCTOR
		head = null;
		
	}
	
	//Push item
	public void push(Object item) 
	{
		Node newNode = new Node(item);
		newNode.setNext(head);
		head = newNode;
	}
	
	//Pop item
	public Object pop() throws EmptyStackException 
	{
		
		//If it's empty, return null
		if(isEmpty()) {
			return null;
		}
		
		//If there's something in it, get data 
		Object firstItem = head.getData();
		head = head.getNext();
		return firstItem;
	}

	//Peek
	public Object top() throws EmptyStackException
	{
		if(isEmpty()) {
			return null;
		}
		return head.getData();
		
	}

	//Check if it's empty
	public boolean isEmpty()
	{
		
		return (head == null);
		
	}


	
	
}
