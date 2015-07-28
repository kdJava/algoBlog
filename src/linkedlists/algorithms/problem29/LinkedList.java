/**
 * @createdOn 07-Jul-2015 6:05:47 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problems29/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem29;

/**
 * @author ketandikshit
 * @createdOn 07-Jul-2015 6:05:47 pm
 * @qualifiedName
 *                GeekyAlgoJava/linkedlists.algorithms.problems29/LinkedList.
 *                java
 * @year 2015
 */
public class LinkedList {

	private Node first;
	private int size;

	/**
	 * Internal data structure representing the node in linked-list
	 * 
	 * @author ketandikshit
	 * @year 2015
	 */
	private class Node {
		private Integer item;
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
	public void addAtHead(Integer item) {
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
	public void addAtEnd(Integer item) {
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
	public void addItem(Integer item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	public void sortMePlease(LinkedList linkedList) {
		Node currentNode = linkedList.first;
		int[] itemsCount = new int[3];

		// Count different types of elements
		while (currentNode != null) {
			itemsCount[currentNode.item] += 1;
			currentNode = currentNode.next;
		}

		currentNode = linkedList.first;
		int i = 0;

		/*
		 * Let say count[0] = n1, count[1] = n2 and count[2] = n3
		 * now start traversing list from head node,
		 * 1) fill the list with 0, till n1 > 0
		 * 2) fill the list with 1, till n2 > 0
		 * 3) fill the list with 2, till n3 > 0
		 */
		while (currentNode != null) {
			if (itemsCount[i] == 0)
				++i;
			else {
				currentNode.item = i;
				--itemsCount[i];
				currentNode = currentNode.next;
			}
		}
	}

	/**
	 * @createdOn 29-Jun-2015 1:01:21 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addItem(0);
		linkedList.addItem(2);
		linkedList.addItem(2);
		linkedList.addItem(1);
		linkedList.addItem(0);
		linkedList.addItem(2);
		linkedList.addItem(0);
		linkedList.addItem(0);
		linkedList.addItem(1);
		linkedList.addItem(1);
		System.out.println("LinkedList:" + linkedList);
		linkedList.sortMePlease(linkedList);
		System.out.println("After:-->" + linkedList);
	}
}
