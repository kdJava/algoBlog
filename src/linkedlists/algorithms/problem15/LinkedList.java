/**
 * @createdOn 05-May-2015 12:26:53 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem15/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem15;

/**
 * @author ketandikshit
 * @createdOn 05-May-2015 12:26:53 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem15/LinkedList.java
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
	 * problem15
	 * Create a new linked list containing the elements(in sorted order) by
	 * having intersection from 2 already sorted lists
	 * Iterative Approach : Time Complexity: O(N+M)
	 * 
	 * @createdOn 05-May-2015 4:17:03 pm
	 * @author ketandikshit
	 * @param linkedList1
	 *            first sorted linked-list
	 * @param linkedList2
	 *            second sorted linked-list
	 * @return Sorted-Intersection List
	 */
	public LinkedList<Item> sortedIntersectionIteratively(
			LinkedList<Item> linkedList1, LinkedList<Item> linkedList2) {
		LinkedList<Item> finalList = new LinkedList<Item>();

		Node currentNodeOfLL1 = linkedList1.first;
		Node currentNodeOfLL2 = linkedList2.first;

		while ((currentNodeOfLL1 != null) && (currentNodeOfLL2 != null)) {
			int result = currentNodeOfLL1.item.compareTo(currentNodeOfLL2.item);
			if (result == 0) {
				finalList.addItem(currentNodeOfLL1.item);
				currentNodeOfLL1 = currentNodeOfLL1.next;
				currentNodeOfLL2 = currentNodeOfLL2.next;
			} else if (result < 0) {
				currentNodeOfLL1 = currentNodeOfLL1.next;
			} else {
				currentNodeOfLL2 = currentNodeOfLL2.next;
			}
		}
		return finalList;
	}

	/**
	 * problem15
	 * Create a new linked list containing the elements(in sorted order) by
	 * having intersection from 2 already sorted lists
	 * Recursive Approach : Time Complexity: O(N+M)
	 * 
	 * @createdOn 05-May-2015 4:19:36 pm
	 * @author ketandikshit
	 * @param linkedList1
	 *            first sorted linked-list
	 * @param linkedList2
	 *            second sorted linked-list
	 * @return Sorted-Intersection List
	 */
	public LinkedList<Item> sortedIntersectionRecursively(
			LinkedList<Item> linkedList1, LinkedList<Item> linkedList2) {
		Node headOfFinalLL = findIntersection(linkedList1.first,
				linkedList2.first);
		LinkedList<Item> finalList = new LinkedList<Item>();
		while (headOfFinalLL != null) {
			finalList.addItem(headOfFinalLL.item);
			headOfFinalLL = headOfFinalLL.next;
		}
		return finalList;
	}

	/**
	 * Recursive Logiv: Internal Helper for
	 * {@linkplain LinkedList#sortedIntersectionRecursively(LinkedList, LinkedList)}
	 * 
	 * @createdOn 05-May-2015 4:21:32 pm
	 * @author ketandikshit
	 * @param currentNodeOfLL1
	 *            Node from linked-list1 to compare
	 * @param currentNodeOfLL2
	 *            Node from linked-list2 to compare
	 * @return the head node of the new resultant linked-list containing the
	 *         intersected elements
	 */
	private Node findIntersection(Node currentNodeOfLL1, Node currentNodeOfLL2) {

		if (currentNodeOfLL1 == null || currentNodeOfLL2 == null)
			return null;

		/* If both lists are non-empty */
		int result = currentNodeOfLL1.item.compareTo(currentNodeOfLL2.item);

		/* advance the smaller list and call recursively */
		if (result < 0)
			return findIntersection(currentNodeOfLL1.next, currentNodeOfLL1);

		if (result > 0)
			return findIntersection(currentNodeOfLL1, currentNodeOfLL2.next);

		// Below lines are executed only when a->data == b->data
		Node temp = new Node();
		temp.item = currentNodeOfLL1.item;

		/* advance both lists and call recursively */
		temp.next = findIntersection(currentNodeOfLL1.next,
				currentNodeOfLL2.next);
		return temp;
	}
	/**
	 * helper utility to insert the item into the linkedlist
	 * 
	 * @createdOn 05-May-2015 1:19:49 pm
	 * @author ketandikshit
	 * @param item
	 *            the item to be inserted
	 */
	private void addItem(Item item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	/**
	 * @createdOn 05-May-2015 12:26:54 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		linkedList1.addAtHead(10);
		linkedList1.addAtEnd(20);
		linkedList1.addAtEnd(30);
		linkedList1.addAtEnd(40);
		linkedList1.addAtEnd(50);
		linkedList1.addAtEnd(60);
		linkedList1.addAtEnd(70);
		linkedList1.addAtEnd(80);
		linkedList1.addAtEnd(90);
		linkedList1.addAtEnd(100);

		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.addAtHead(10);
		linkedList2.addAtEnd(15);
		linkedList2.addAtEnd(20);
		linkedList2.addAtEnd(25);
		linkedList2.addAtEnd(30);
		linkedList2.addAtEnd(35);
		linkedList2.addAtEnd(40);
		linkedList2.addAtEnd(45);
		linkedList2.addAtEnd(50);

		System.out
				.println("***********************Iterative******************");
		System.out.println("FirstLL-->" + linkedList1);
		System.out.println("SecondLL-->" + linkedList2);

		LinkedList<Integer> finalList = linkedList1
				.sortedIntersectionIteratively(linkedList1, linkedList2);
		System.out.println("FinalList-->" + finalList);

		System.out
				.println("\n\n***********************Recursion******************");
		System.out.println("First-->" + linkedList1);
		System.out.println("Second-->" + linkedList2);
		LinkedList<Integer> finalList2 = linkedList1
				.sortedIntersectionRecursively(linkedList1, linkedList2);
		System.out.println("FinalList-->" + finalList2);

	}

}
