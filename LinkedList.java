/*
**
** Renee Fung
** V00778609
** CSC 225 Programming 1B
**
*/

import java.util.*;
import java.io.*;

public class LinkedList {
	int n;
	ListNode start;
	ListNode rear;

	public LinkedList() {
		n = 0;
		start = null;
		rear = null;
	}
	
	public LinkedList(int size, ListNode first, ListNode last) {
		n = size;
		start = first;
		rear = last;
	}
	
	public static LinkedList readBigInteger(Scanner in) {
		int y = readInteger(in);
		if(y == -1) return null; //RF: If it doesn't read an integer, return null
		
		LinkedList x;
		
		// Question 1 code goes here.
		
		x = new LinkedList(); // You can move this statement.
		
		x.n = y; //RF: Set first integer 
		
		//RF: If the first integer is 1, the start and rear will point to the same node
		if(x.n == 1) {
			x.start = new ListNode(readInteger(in), null);
			x.rear = x.start;
		} else { 
			//RF: Read next integer and make it rear, it's next pointer will point to null
			x.rear = new ListNode(readInteger(in), null);
			//RF: The next integer read is the new start and it's next pointer will point to rear
			x.start = new ListNode(readInteger(in), x.rear);
			
			//RF: Keep adding to the start 
			for(int i = 2; i < x.n; i++) {
				x.start = new ListNode(readInteger(in), x.start);
			}
		}
		
		return(x);
	}
	
	
	public void printBigInteger()
	{
   		// Question 2 code goes here.
   		
		int level = 0; //RF: Start level count at 0 
   		
		this.reverse(level); //RF: Reverse the list 
   		
   		//RF: Traverse and print first n-1 digits
   		ListNode current = this.start;
   		
   		boolean leadingZeros = true;
   		
   		for (int i = 1; i < this.n; i++) {
   			if (current.data == 0 && leadingZeros) {
   			} else {
   				leadingZeros = false;
   				System.out.print(current.data);
   			}
   			current = current.next;
   		}
   		
   		System.out.println(current.data); //RF: Print a newline after last digit
   	
   		this.reverse(level); //RF: Reverse list back to original to retain integrity of list
   	}
	
	public void reverse(int level) {
		Test.checkList(this); // Do not remove or move this statement.
		
		// Question 3 code goes here.
		
		if(this.n == 1) { //RF: If size is 1 then return 
			return;
		} else {
			ListNode temp = this.start; //RF: Create temporary node 
			
			for(int i = 0; i < this.n/2 - 1; i++) { //RF: Traverse to middle of list 
				temp = temp.next;
			}
			
			//RF: Split into two lists
			LinkedList firstHalf = new LinkedList(this.n/2, this.start, temp);
			
			int ceil = n - n/2;
			LinkedList secondHalf = new LinkedList(ceil, temp.next, this.rear);
			
			firstHalf.rear.next = null;
			
			firstHalf.reverse(level + 1); //RF: Repeat until list is 1 	
			secondHalf.reverse(level + 1); //RF: Repeat until list is 1
			
			// Add the two reversed lists together.
			secondHalf.rear.next = firstHalf.start;
			this.start = secondHalf.start;
			this.rear = firstHalf.rear;
			this.rear.next = null;
			
		}
		
	}
	
	public void plus_plus() {
		// Question 4 code goes here.
		int tracker = 1; //RF: Use this to go through list
		
		if(start.data != 9) { //RF: If the data in start is not 9
			start.data++; //RF: Increment the integer in start node
		} else {
			start.data = 0; //RF: If the data in start is 9, make it 0
			ListNode temp = start; //RF: Set a new node temp to start
			
			while(temp.next != null && temp.next.data == 9) { //RF: If the next is not null and it has a value of 9
				temp = temp.next; //RF: Move temp's position
				temp.data = 0; //RF: Change the data to 0
				tracker++; //RF: Increment tracker
			}
			
			if(tracker == n) { //RF: When tracker hits the end of list
				temp.next = new ListNode(1, null); //RF: Create new node with value of 1
				rear = temp.next; //RF: Set the rear 
				n++; //RF: Increase the list size
				//System.out.println("test " + temp.next.data); 
			} else {
				temp.next.data++; //RF: Otherwise add 1 
			}
		}
	}
	
	
	
	public LinkedList plus(LinkedList y) {
		LinkedList z;
	
		z= new LinkedList();
	
		// Question 5 code goes here.
		
		ListNode nodeX = this.start; //RF: First list
		ListNode nodeY = y.start; //RF: Second list
		ListNode nodeZ = null;
		
		ListNode nodeW;
		
		int value;
		boolean addOne = false; //RF: Determines if a 1 is carried to next addition
		
		while(nodeX != null || nodeY != null) { //RF: If the two nodes (at start) are not null 
			value = 0; 
			
			if(nodeX != null) { //RF: If x node is not null
				value += nodeX.data; //RF: Add the data into value
				nodeX = nodeX.next; //RF: Move the node to the next one in list
			}
			
			if(nodeY != null) { //RF: If y node is not null
				value += nodeY.data; //RF: Add the data into value
				nodeY = nodeY.next; //RF: Most the node to the next one in list 
			}
			
			if(addOne) { //RF: If addOne is true
				value++; //RF: Carry the one 
			}
			
			if(value < 10) { //RF: If the value is less than 10 
				nodeW = new ListNode(value, null);
				addOne = false; //RF: addOne will be false, no carries are required
			} else {
				nodeW = new ListNode(value % 10, null); //RF: Otherwise mod 10 
				addOne = true; //RF: addOne will be true, carry will be needed
			}
			
			if(z.n == 0) { //RF: If z's size is 0
				z.start = nodeW; //RF: Set the start to the new node I created
				nodeZ = z.start; //RF: Set nodeZ to z's start
			} else {
				nodeZ.next = nodeW; //RF: Otherwise set the next node to the new node I created 
				nodeZ = nodeZ.next; //RF: Set nodeZ to it's next
			}
			
			z.n++; //RF: Increase size of z
			z.rear = nodeZ; //RF: Set the rear to nodeZ
			
		}
		
		if(addOne) { //RF: If addOne is true, make new node for the carry
				z.rear.next = new ListNode(1, null);
				z.rear = z.rear.next;
				z.n++; //RF: Increase the size of z
		}
	
		return(z);
	}


	
	// You can use these routines for this assignment:
	
	// Tries to read in a non-negative integer from the input stream.
	// If it succeeds, the integer read in is returned. 
	// Otherwise the method returns -1.
	public static int readInteger(Scanner in) {
		int n;
		
		try{
			n= in.nextInt();
		if (n >=0) return(n);
			else return(-1);
		}
			catch(Exception e)
		{
		//We are assuming legal integer input values are >= zero.
			return(-1);
		}
	}
	
	// Use this for debugging only.
	
	public void printList(){
		ListNode current;
	
		int count=0;
	
		current= start;
	
		while (current != null) {
			count++;
	   
			System.out.println("Item " + count + " in the list is " 
			    + current.data);
			current= current.next;
		}
	}

}
