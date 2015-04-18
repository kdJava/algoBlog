/**
 * 03-Apr-2015 12:57:31 pm
 * GeeksForGeeks/linkedlists.algorithms.problem5/LinkedList.java
 * ketandikshit
 * LinkedList
 * 2015
 */
package linkedlists.algorithms.problem5;

/**
 * @author ketandikshit
 *         03-Apr-2015 12:57:31 pm
 *         GeeksForGeeks/linkedlists.algorithms.problem5/LinkedList.java
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
	 * Reverses the linkedlist iteratively
	 * 03-Apr-2015 12:58:57 pm
	 * ketandikshit
	 */
	public void reverseLinkedListIterative() {
		Node prev = null;
		Node current = first;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		first = prev;
	}

	public void reverseLinkedListRecursively(Node restNode) {

		// check for empty list
		if (restNode == null)
			return;

		/*
		 * if we are at the TAIL node:
		 * recursive base case:
		 */
		if (restNode.next == null) {
			// set HEAD to current TAIL since we are reversing list
			first = restNode;
			System.out
					.println("***********Recursive Stack Created; Now unwinding the stack !!");
			return; // since this is the base case

		}

		System.out.println(this + " has First-->" + first.item + " restNode-->"
				+ restNode.item);

		reverseLinkedListRecursively(restNode.next);
		Node temp = restNode.next;
		System.out.println(this + " Before: has First-->" + first.item
				+ " restNode-->" + restNode.item + " has restNode.Next-->"
				+ restNode.next.item);
		temp.next = restNode;
		restNode.next = null; // set "old" next pointer to NULL
		System.out
				.println(this
						+ " After:has First-->"
						+ first.item
						+ " restNode-->"
						+ restNode.item
						+ " has restNode.Next-->"
						+ ((restNode.next != null)
								? restNode.next.item
								: restNode.next));
	}
	/**
	 * 03-Apr-2015 12:57:31 pm
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

		System.out.println("Original:" + linkedList + " has First-->"
				+ linkedList.first.item);

		linkedList.reverseLinkedListIterative();
		System.out.println("Reversed Iteration:" + linkedList);

		linkedList.reverseLinkedListRecursively(linkedList.first);
		System.out.println("Reversed Recursively-->" + linkedList);
	}

}
