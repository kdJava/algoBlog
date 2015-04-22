/**
 * @createdOn 22-Apr-2015 9:31:44 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem9/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem9;

/**
 * @author ketandikshit
 * @createdOn 22-Apr-2015 9:31:44 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem9/LinkedList.java
 * @year 2015
 */
public class LinkedList<Item extends Comparable<Item>> {

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
			return ("NODE[DATA:" + item + "]" + "-->" + next);
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

	public void insertIntoSortedList(LinkedList<Item> linkedlist,
			Item itemToInsert) {

		Node newNode = new Node();
		newNode.item = itemToInsert;

		if (linkedlist.size <= 0) {
			linkedlist.first = newNode;
			size++;
			return;
		}

		if (itemToInsert.compareTo(linkedlist.first.item) < 0) {
			newNode.next = first;
			first = newNode;
			size++;
			return;
		}

		Node prevToCurrent = null;
		Node currentNode = linkedlist.first;

		while ((currentNode != null)
				&& (itemToInsert.compareTo(currentNode.item) > 0)) {
			prevToCurrent = currentNode;
			currentNode = currentNode.next;
		}

		prevToCurrent.next = newNode;
		newNode.next = currentNode;
		linkedlist.size++;

	}
	public static void main(String[] args) {
		LinkedList<Integer> linkedlist = new LinkedList<>();
		System.out.println("[Empty-TEST]-->" + linkedlist);
		linkedlist.insertIntoSortedList(linkedlist, 5);
		System.out.println(linkedlist);
		linkedlist.addAtHead(10);
		linkedlist.addAtEnd(20);
		linkedlist.addAtEnd(30);
		linkedlist.addAtEnd(40);
		linkedlist.addAtEnd(50);
		linkedlist.addAtEnd(60);
		linkedlist.addAtEnd(70);
		linkedlist.addAtEnd(80);
		linkedlist.addAtEnd(90);
		linkedlist.addAtEnd(100);

		System.out.println(linkedlist);
		linkedlist.insertIntoSortedList(linkedlist, 5);
		linkedlist.insertIntoSortedList(linkedlist, 10);
		linkedlist.insertIntoSortedList(linkedlist, 15);
		linkedlist.insertIntoSortedList(linkedlist, 25);
		linkedlist.insertIntoSortedList(linkedlist, 35);
		linkedlist.insertIntoSortedList(linkedlist, 45);
		linkedlist.insertIntoSortedList(linkedlist, 55);
		linkedlist.insertIntoSortedList(linkedlist, 65);
		linkedlist.insertIntoSortedList(linkedlist, 75);
		linkedlist.insertIntoSortedList(linkedlist, 85);
		linkedlist.insertIntoSortedList(linkedlist, 95);
		linkedlist.insertIntoSortedList(linkedlist, 100);
		linkedlist.insertIntoSortedList(linkedlist, 110);
		System.out.println(linkedlist);

	}

}
