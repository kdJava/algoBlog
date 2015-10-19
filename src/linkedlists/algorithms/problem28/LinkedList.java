/**
 * @createdOn 29-Jun-2015 1:01:18 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem28/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem28;

/**
 * @author ketandikshit
 * @createdOn 29-Jun-2015 1:01:19 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem28/LinkedList.java
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
	 * problem-28
	 * Reverse the linkedList in groups of given size 'k'
	 * 
	 * @createdOn 29-Jun-2015 1:06:58 pm
	 * @author ketandikshit
	 * @param linkedList
	 * @param k
	 * @return
	 */
	public Node reverseInGroups(Node head, int k) {
		Node currentNode = head;
		Node nextNode = null;
		Node prevNode = null;
		int count = 0;

		/* reverse first k nodes of the linked list */
		while ((currentNode != null) && (count < k)) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node
		 * Recursively call for the list starting from current.
		 * And make rest of the list as next of first node
		 */
		if (nextNode != null) {
			head.next = reverseInGroups(nextNode, k);
		}

		/* prev is new head of the input list */
		return prevNode;
	}

	public LinkedList<Item> reverse(LinkedList<Item> linkedList, int groupSize) {
		Node newHead = reverseInGroups(linkedList.first, groupSize);
		return getListFromHead(newHead);
	}

	private LinkedList<Item> getListFromHead(Node head) {
		LinkedList<Item> newList = new LinkedList<>();
		Node currentNode = head;
		while (currentNode != null) {
			newList.addItem(currentNode.item);
			currentNode = currentNode.next;
		}
		return newList;
	}

	/**
	 * @createdOn 29-Jun-2015 1:01:21 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
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
		System.out.println("LinkedList:" + linkedList);
		System.out.println(linkedList.reverse(linkedList, 3));
	}

}
