import java.util.*;
import java.io.*;
/* This class is for creating a singly linked class of big integer nodes. */
/* Hand this in together with your LinkedList.java. */
class BigIntegerList {
	int n; // Number of items in the list.
	BigIntegerNode start;
	BigIntegerNode rear;
	
	// You can set debug=true when you are debugging and want
	// to print out what your program is doing.
	// Please leave your debugging messages in your code when
	// you submit it. Change debug back to false before
	// submitting your code.
	static final boolean debug= false;
	
	public BigIntegerList() {
		n=0;
		start= null;
		rear= null;
	}
	
	public static BigIntegerList readBigIntegerList(Scanner in) {
		// Insert your code for Question 3 here.
		
		BigIntegerList problem;
		problem = new BigIntegerList(); //RF: Make problem a new big integer list
		
		problem.n = LinkedList.readInteger(in); //RF: Read list size
		
		if(problem.n == -1) return(null); //RF: Handle null pointer exception
		
		LinkedList list = new LinkedList(); //RF: Create new list
		list = list.readBigInteger(in);
		
		BigIntegerNode node = new BigIntegerNode(list, null); //RF: Create node
		
		//RF: For a list with one node, both start and rear will point to node
		problem.start = node;
		problem.rear = node;
		
		////RF: Fill rest of list
		for(int i = 1; i < problem.n; i++) {
			list = new LinkedList();
			list = list.readBigInteger(in);
			
			node.next = new BigIntegerNode(list, null);
			
			node = node.next;
			problem.rear = node;
		}
		
		return problem; //RF: Return list
		
	}
	
	
	public void printBigIntegerList() {
		// Insert your code for Question 4 here.
		BigIntegerNode printNode = this.start;
		
		//RF: NTS: print big integer x; use printBigInteger in LinkedList
		for(int i = 0; i < this.n; i++) {
			printNode.x.printBigInteger(8);
			if(printNode.x.n >= 8) {
				System.out.print(" ");
			}
			printNode = printNode.next;
			
			if( ( (i+1) % 10) == 0) { //RF: If there's 10 ints on a line
				System.out.println(); //RF: Print new line
			}
			
		}
		
		System.out.println();
	}
	
	public void quickSort(int level) {
		// Insert your code for Question 5 here.
		
		if(n <= 1) return; //RF If list has size 1, don't have to sort
		
		BigIntegerNode pivot = this.start; //RF: Set pivot to first list node
		
		//RF: Create three lists (greater than, less than, and equal to)
		BigIntegerList lessThan = new BigIntegerList(); 
		BigIntegerList equalTo = new BigIntegerList(); 
		BigIntegerList greaterThan = new BigIntegerList(); 
		
		//RF: Traverse list and remove all cells and place it into new list
		BigIntegerNode current = this.start;
		
		for(int i = 0; i < this.n; i++) {
			
			//RF: Current is equal to pivot; Put in equalTo list
			if( (current.x.compare(pivot.x)) == 0) {				
				if(equalTo.n == 0) {
					equalTo.start = current;
					equalTo.rear = current;
					equalTo.n = 1;
				} else {
					equalTo.rear.next = current;
					equalTo.rear = current;
					equalTo.n++;
				}
				
			//RF: Current is greater than pivot; Put in greaterThan list
			} else if( (current.x.compare(pivot.x)) > 0) {	
				if(greaterThan.n == 0) {
					greaterThan.start = current;
					greaterThan.rear = current;
					greaterThan.n = 1;
				} else {
					greaterThan.rear.next = current;
					greaterThan.rear = current;
					greaterThan.n++;
				}
				
			//RF: Current is less than pivot; Put in lessThan list
			} else if( (current.x.compare(pivot.x)) < 0) {	
				if(lessThan.n == 0) {
					lessThan.start = current;
					lessThan.rear = current;
					lessThan.n = 1;
				} else {
					lessThan.rear.next = current;
					lessThan.rear = current;
					lessThan.n++;
				}
			}
			
			if(current.next != null){
				current = current.next;
			}
			
		}
		
		lessThan.quickSort(level++);
		greaterThan.quickSort(level++);
		
		//RF: Marry list
		if(lessThan.n == 0 && greaterThan.n == 0) { 
			
			this.start = equalTo.start;
			this.rear = equalTo.rear;

		} else if(lessThan.n == 0) {
			
			this.start = equalTo.start;
			equalTo.rear.next = greaterThan.start;
			this.rear = greaterThan.rear;

		} else if(greaterThan.n == 0) {
			
			this.start = lessThan.start;
			lessThan.rear.next = equalTo.start;
			this.rear = equalTo.rear;

		} else {
			
			this.start = lessThan.start;
			lessThan.rear.next = equalTo.start;
			equalTo.rear.next = greaterThan.start;
			this.rear = greaterThan.rear;
			
		}
		
		this.rear.next = null;
		
	}
	
}
