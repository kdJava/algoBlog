/**
 * @createdOn 24-Apr-2015 1:11:39 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem13/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem13;

/**
 * @author ketandikshit
 * @createdOn 24-Apr-2015 1:11:39 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem13/LinkedList.java
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

	/**
	 * problem13
	 * moves the last node of the linked list to the head
	 * 
	 * @createdOn 24-Apr-2015 1:39:13 pm
	 * @author ketandikshit
	 * @param linkedlist
	 *            linked list to operate upon
	 */
	public void moveLastToFirst(LinkedList<Item> linkedlist) {
		Node secondLastNode = null;
		Node lastNode = linkedlist.first;

		while (lastNode.next != null) {
			secondLastNode = lastNode;
			lastNode = lastNode.next;
		}
		linkedlist.addAtHead(secondLastNode.next.item);
		secondLastNode.next = null;
		size--;
	}
	/**
	 * @createdOn 24-Apr-2015 1:11:39 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Character> linkedList = new LinkedList<Character>();
		linkedList.addAtHead('A');
		linkedList.addAtEnd('B');
		linkedList.addAtEnd('C');
		linkedList.addAtEnd('D');
		linkedList.addAtEnd('E');
		linkedList.addAtEnd('F');
		linkedList.addAtEnd('G');
		linkedList.addAtEnd('H');
		linkedList.addAtEnd('I');
		linkedList.addAtEnd('J');
		linkedList.addAtEnd('K');

		System.out.println("Before-->" + linkedList);
		linkedList.moveLastToFirst(linkedList);
		System.out.println("After-->" + linkedList);

	}
}
