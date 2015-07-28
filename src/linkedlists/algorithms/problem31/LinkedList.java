/**
 * @createdOn 09-Jul-2015 5:39:30 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem31/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem31;

/**
 * @author ketandikshit
 * @createdOn 09-Jul-2015 5:39:30 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem31/LinkedList.java
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
	 * problem-31 remove all the nodes which have a greater value on next
	 * node(right side)
	 * 
	 * @createdOn 09-Jul-2015 6:07:44 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            instance of linked-list
	 * @return modified linkedList
	 */
	public LinkedList<Item> delLesserNodes(LinkedList<Item> linkedList) {
		/*
		 * Deletes nodes which have a node with greater value node on left side
		 */

		Node head_ref = linkedList.first;
		/* 1) Reverse the linked list */
		head_ref = reverseList(head_ref);

		/*
		 * 2) In the reversed list, delete nodes which have a node with greater
		 * value node on left side. Note that head node is never deleted because
		 * it is the leftmost node.
		 */
		head_ref = _delLesserNodes(head_ref);

		/*
		 * 3) Reverse the linked list again to retain the original order
		 */
		head_ref = reverseList(head_ref);

		return getListFromHead(head_ref);
	}

	/**
	 * Logic for problem-31 remove all the nodes which have a greater value on
	 * next
	 * 
	 * @createdOn 09-Jul-2015 6:07:30 pm
	 * @author ketandikshit
	 * @param head
	 *            head of the linkedlist
	 * @return the head of the linkedList after performing required operations
	 */
	Node _delLesserNodes(Node head) {
		/* Deletes nodes which have greater value node(s) on left side */

		Node current = head;

		/* Initialize max */
		Node maxnode = head;
		Node temp = null;

		while ((current != null) && (current.next != null)) {
			/* If current is smaller than max, then delete current */
			if (current.next.item.compareTo(maxnode.item) < 0) {
				temp = current.next;
				current.next = temp.next;
				temp = null; // free temp
			}
			/*
			 * If current is greater than max, then update max and move current
			 */
			else {
				current = current.next;
				maxnode = current;
			}
		}
		return head;
	}

	/**
	 * reverse the linked list
	 * 
	 * @createdOn 09-Jul-2015 6:13:37 pm
	 * @author ketandikshit
	 * @param headref
	 *            head of the original linkedList
	 * @return the head of the reversed linked list
	 */
	private Node reverseList(Node headref) {
		/* Utility function to reverse a linked list */
		Node current = headref;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		headref = prev;
		return headref;
	}

	/**
	 * Helper to form a new linkedList instance traversing from the head-node
	 * 
	 * @createdOn 09-Jul-2015 6:14:13 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linkedList
	 * @return the newly assembled linkedlist
	 */
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
	 * @createdOn 09-Jul-2015 5:39:31 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addItem(12);
		linkedList.addItem(15);
		linkedList.addItem(10);
		linkedList.addItem(11);
		linkedList.addItem(5);
		linkedList.addItem(6);
		linkedList.addItem(2);
		linkedList.addItem(3);
		System.out.println("LinkedList:" + linkedList);

		LinkedList<Integer> modifiedOne = linkedList.delLesserNodes(linkedList);
		System.out.println("Changed:" + modifiedOne);

	}

}
