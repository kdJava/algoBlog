/**
 * 02-Apr-2015 7:45:07 pm
 * GeekyAlgoJava/linkedlists.algorithms/Problem3.java
 * ketandikshit
 * Problem3
 * 2015
 */
package linkedlists.algorithms.problem3;

/**
 * @author ketandikshit
 *         02-Apr-2015 7:45:07 pm
 *         GeekyAlgoJava/linkedlists.algorithms/Problem3.java
 *         2015
 */
public class LinkedList<Item> {

	private Node first;
	private int size;

	private class Node {
		private Item item;
		private Node next;
	}

	@Override
	public String toString() {
		String result = "LinkedList--> [";
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
	 * problem3
	 * using the size of the linked list (trivial)
	 * 03-Apr-2015 12:18:53 pm
	 * ketandikshit
	 * 
	 * @param linkedlist
	 *            linkedlist instance
	 * @return item in the middle of linkedlist
	 */
	public Item printMiddleWithSize() {
		int mid = size / 2;
		int count = 0;
		Node currentNode = first;

		while (count < mid) {
			currentNode = currentNode.next;
			count++;
		}
		return currentNode.item;
	}

	/**
	 * problem2 without using the sizeof linkedlist
	 * 03-Apr-2015 12:20:51 pm
	 * ketandikshit
	 * 
	 * @param linkedlist
	 *            linkedlist instance
	 * @return item in the middle of linkedlist
	 */
	public Item printMiddleWithoutSize() {
		Node slow_ptr = first;
		Node fast_ptr = first;

		if (first != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			return slow_ptr.item;
		}
		return null;
	}

	/**
	 * 02-Apr-2015 7:45:07 pm
	 * ketandikshit
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addAtHead(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(40);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(60);
		linkedList.addAtEnd(70);
		linkedList.addAtEnd(80);
		linkedList.addAtEnd(90);
		linkedList.addAtEnd(100);

		System.out.println("Original:" + linkedList);
		int itemInMiddle = linkedList.printMiddleWithSize();
		System.out.println("Middle Found with Size-->" + itemInMiddle);

		int itemInMiddle2 = linkedList.printMiddleWithoutSize();
		System.out
				.println("Middle Found without using size-->" + itemInMiddle2);

	}

}
