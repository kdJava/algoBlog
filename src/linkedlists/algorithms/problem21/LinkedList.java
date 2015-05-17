/**
 * @createdOn 17-May-2015 11:29:53 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem21/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem21;

/**
 * @author ketandikshit
 * @createdOn 17-May-2015 11:29:53 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem21/LinkedList.java
 * @year 2015
 */
public class LinkedList<Item> {

	private Node first;
	private int size;

	/**
	 * Internal data structure representing the node in linked-list
	 * 
	 * @author ketandikshit
	 * @year 2015
	 */
	private class Node {
		private Item item;
		private Node next;

		@Override
		public String toString() {
			return ("Node[" + item + "]");
		}

	}

	/**
	 * Overriding the {@linkplain Object#toString()} to denote the linked-lists
	 * in simple format
	 * 
	 * @author ketandikshit
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "LinkedList--> [";

		if (size == 0) {
			result += "NULL]";
			return result;
		}
		int counter = 0;
		for (Node i = first; i != null; i = i.next) {
			if (counter == (size - 1))
				result += i.item + "]";
			else
				result += i.item + "-->";
			counter++;
		}
		return result;
	}

	/**
	 * Checks if the linked list is empty
	 * 
	 * @return true if linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null; // or size==0;
	}

	/**
	 * Gets the current size of the linked-list
	 * 
	 * @return the current size of linked-list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Add the item as first element in linked-list
	 * 
	 * @param item
	 *            item to be added as first element in linked-list
	 */
	public void addAtHead(Item item) {
		Node newNode = new Node(); // Create new node to insert
		newNode.item = item; // Set newNode's element to item to to be inserted

		Node oldFirst = first; // save the oldFirst Node in temp variable
		first = newNode; // Set the first to newNode
		first.next = oldFirst; // Set the next of first to oldFirst
		size++; // increment the size
	}

	/**
	 * Add the item as last element in linkedList
	 * 
	 * @param item
	 *            item to be added at last
	 */
	public void addAtEnd(Item item) {
		Node newNode = new Node(); // Create new node to insert
		newNode.item = item; // Set newNode's element to item to to be inserted
		newNode.next = null; // Set the newNode's next to NULL, as it is to be
								// inserted at end

		Node currentNode = first;
		// Lets get the lastNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}

		currentNode.next = newNode; // set the last node's next to new Node
		size++; // increment the size
	}

	/**
	 * helper utility to insert the item into the linkedlist
	 * 
	 * @author ketandikshit
	 * @param item
	 *            the item to be inserted
	 */
	public void addItem(Item item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	/**
	 * problem-21
	 * Swap kth Node from start with Kth Node form end
	 * 
	 * @createdOn 17-May-2015 11:36:31 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            the linked list instance
	 * @param k
	 *            the value/pos of 'K' for swapping
	 * @return the Node of the modified linked linked list whose 'K'th Node from
	 *         the start is swapped with the Kth node form end
	 */
	public LinkedList<Item> swapKthNodeFromFrontWithKthNodeFromEnd(
			LinkedList<Item> linkedList, int k) {
		Node head = linkedList.first;
		int sizeOfList = linkedList.getSize();

		if (k > sizeOfList) {
			System.out
					.println("\n INVALID NUMBER, No Swapping, k>length of list");
			return null;
		}
		if (((2 * k) - 1) == sizeOfList) {
			System.out
					.println("\nk = "
							+ k
							+ ", Nodes are same from front and at the end, no swapping");
			// both are same, No need for swaping
			return null;
		}

		Node left = head;
		Node prevOfLeft = null;
		int j = k;
		while (j > 1) {
			prevOfLeft = left;
			left = left.next;
			j--;
		}

		Node right = head;
		Node prevOfRight = null;
		j = sizeOfList - k + 1;
		while (j > 1) {
			prevOfRight = right;
			right = right.next;
			j--;
		}

		if (prevOfLeft != null) {
			prevOfLeft.next = right;
		}

		if (prevOfRight != null) {
			prevOfRight.next = left;
		}

		Node temp = left.next;
		left.next = right.next;
		right.next = temp;

		/*
		 * change the head in case of i=1 .
		 */
		if (k == 1) {
			head = right;
		}
		/*
		 * change the head in case of i=len
		 */
		if (k == sizeOfList) {
			head = left;
		}
		return linkedList;
	}

	/**
	 * @createdOn 17-May-2015 11:29:53 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addItem(10);
		linkedList.addItem(20);
		linkedList.addItem(30);
		linkedList.addItem(40);
		linkedList.addItem(50);
		linkedList.addItem(60);
		linkedList.addItem(70);
		linkedList.addItem(80);
		linkedList.addItem(90);
		linkedList.addItem(100);

		System.out.println(linkedList);
		int K = 4;
		LinkedList<Integer> finalList = linkedList
				.swapKthNodeFromFrontWithKthNodeFromEnd(linkedList, K);
		System.out.println(finalList);

	}
}
