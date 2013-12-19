public interface HeapADT {

	//createHeap() // This can be the default constructor
	// Creates an empty heap.

	public boolean heapIsEmpty();
	// Determines whether a heap is empty.

	public void heapInsert(double newItem) throws HeapException;
	// Inserts newItem into a heap. Throws
	// HeapException if heap is full.

	public double heapDelete() ;
	// Retrieves and then deletes a heap’s root
	// item. This item has the largest search key.
}
