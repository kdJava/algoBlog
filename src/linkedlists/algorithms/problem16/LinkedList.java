/**
 * @createdOn 05-May-2015 4:36:39 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem16/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem16;

/**
 * @author ketandikshit
 * @createdOn 05-May-2015 4:36:39 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem16/LinkedList.java
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
	 * problem-16
	 * Delete alternate nodes of a Linked List
	 * Iterative Approach
	 * Time complexity: O(n)
	 * 
	 * @createdOn 06-May-2015 4:27:59 pm
	 * @author ketandikshit
	 * @param linkedlist
	 *            instance f linkedlist
	 */
	public void deleteAlterNodesIterative(LinkedList<Item> linkedlist) {

		if (linkedlist.size == 0)
			return;

		Node currNode = linkedlist.first;
		while (currNode != null && currNode.next != null) {
			currNode.next = currNode.next.next;
			currNode = currNode.next;
			size--;
		}
	}

	/**
	 * problem-16
	 * Delete alternate nodes of a Linked List
	 * Recursive Approach
	 * Time complexity: O(n)
	 * 
	 * @createdOn 06-May-2015 4:30:57 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            instance of linkedlist
	 */
	public void deleteAlterNodesRecursive(LinkedList<Item> linkedList) {
		delAlternate(linkedList.first);
	}

	private void delAlternate(Node currNode) {
		if (currNode == null)
			return;

		Node nextNode = currNode.next;

		if (nextNode == null)
			return;

		/* Change the next link of head */
		currNode.next = nextNode.next;
		this.size--;

		/* Recursively call for the new next of head */
		delAlternate(currNode.next);
	}
	/**
	 * @createdOn 05-May-2015 4:36:39 pm
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

		System.out
				.println("**********************Iterative Approach****************");
		System.out.println(linkedList);
		linkedList.deleteAlterNodesIterative(linkedList);
		System.out.println(linkedList);
		System.out
				.println("********************************************************");

		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.addItem(10);
		linkedList2.addItem(20);
		linkedList2.addItem(30);
		linkedList2.addItem(40);
		linkedList2.addItem(50);
		linkedList2.addItem(60);
		linkedList2.addItem(70);
		linkedList2.addItem(80);
		linkedList2.addItem(90);
		linkedList2.addItem(100);
		System.out
				.println("\n*********************Recursvive Approach********************");
		System.out.println(linkedList2);
		linkedList2.deleteAlterNodesRecursive(linkedList2);
		System.out.println(linkedList2);
		System.out
				.println("**************************************************************");
	}

}
