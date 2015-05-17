/**
 * @createdOn 17-May-2015 11:59:50 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem22/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem22;

/**
 * @author ketandikshit
 * @createdOn 17-May-2015 11:59:50 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem22/LinkedList.java
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
	 * problem-22
	 * Delete 'Y' nodes after 'X' nodes from the given linked-list
	 * 
	 * @createdOn 18-May-2015 12:09:46 am
	 * @author ketandikshit
	 * @param linkedList
	 *            the linked-list instance
	 * @param X
	 *            value of X, nodes to ignore
	 * @param Y
	 *            value of Y, nodes to delete after X nodes
	 * @return the modified LinkedList
	 */
	public LinkedList<Item> deleteYAfterX(LinkedList<Item> linkedList, int X,
			int Y) {
		int sizeOfList = linkedList.getSize();
		if (X >= sizeOfList) {
			System.out.println("\nINVALID NUMBER");
			return null;
		}
		Node currNode = linkedList.first;
		/*
		 * since we need to move to one node prior before we start
		 * deleting the current
		 */
		while (X > 1) {
			currNode = currNode.next;
			X--;
		}
		Node temp = currNode;
		/*
		 * since we need the node, after deleting y nodes
		 */
		Y = Y + 1;
		while (Y > 0 && currNode != null) {
			currNode = currNode.next;
			Y--;
			linkedList.size--;
		}
		temp.next = currNode;
		linkedList.size++;

		return linkedList;
	}

	/**
	 * @createdOn 17-May-2015 11:59:50 pm
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
		int X = 2;
		int Y = 3;

		LinkedList<Integer> finalLinkedList = linkedList.deleteYAfterX(
				linkedList, X, Y);
		System.out.println(finalLinkedList);

	}

}
