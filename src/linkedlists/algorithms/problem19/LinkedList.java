/**
 * @createdOn 08-May-2015 12:17:38 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem19/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem19;

/**
 * @author ketandikshit
 * @createdOn 08-May-2015 12:17:38 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem19/LinkedList.java
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
	 * problem-19
	 * Merges 2 already sorted linked lists into a single linked lists
	 * Iterative
	 * TimeComplexity: O(n+m)
	 * 
	 * @createdOn 08-May-2015 12:46:05 pm
	 * @author ketandikshit
	 * @param linkedList1
	 *            first sorted linked list
	 * @param linkedList2
	 *            second sorted linkedlist
	 * @return the finally merged linked list
	 */
	public LinkedList<Item> sortedMergeIterative(LinkedList<Item> linkedList1,
			LinkedList<Item> linkedList2) {
		LinkedList<Item> mergedList = new LinkedList<>();

		Node currNode1 = linkedList1.first;
		Node currNode2 = linkedList2.first;

		while (currNode1 != null && currNode2 != null) {
			// System.out.println(a.head.data + " " + b.head.data);
			if (currNode1.item.compareTo(currNode2.item) < 0) {
				mergedList.addItem(currNode1.item);
				currNode1 = currNode1.next;
			} else {
				mergedList.addItem(currNode2.item);
				currNode2 = currNode2.next;
			}
		}
		while (currNode1 != null) {
			mergedList.addItem(currNode1.item);
			currNode1 = currNode1.next;
		}
		while (currNode2 != null) {
			mergedList.addItem(currNode2.item);
			currNode2 = currNode2.next;
		}

		return mergedList;
	}

	/**
	 * problem 19
	 * Merges 2 already sorted linked lists into a single linked lists
	 * Recursive
	 * TimeComplexity: O(n+m)
	 * 
	 * @createdOn 08-May-2015 1:19:55 pm
	 * @author ketandikshit
	 * @param linkedList1
	 *            the first sorted linked list
	 * @param linkedList2
	 *            the second sorted linked list
	 * @return the finally merged sorted linked list
	 */
	public LinkedList<Item> sortedMergeRecursive(LinkedList<Item> linkedList1,
			LinkedList<Item> linkedList2) {
		Node headOfMergedList = mergeIt(linkedList1.first, linkedList2.first);

		LinkedList<Item> mergedLinkedList = new LinkedList<>();
		while (headOfMergedList != null) {
			mergedLinkedList.addItem(headOfMergedList.item);
			headOfMergedList = headOfMergedList.next;
		}
		return mergedLinkedList;
	}

	/**
	 * delegated method
	 * contains Actual logic for the recursion approach
	 * 
	 * @createdOn 08-May-2015 1:33:06 pm
	 * @author ketandikshit
	 * @param currNode1
	 *            the first sorted linked list
	 * @param currNode2
	 *            the second sorted linked list
	 * @return the finally merged sorted linked list
	 */
	private Node mergeIt(Node currNode1, Node currNode2) {
		Node result = null;
		if (currNode1 == null)
			return currNode2;
		else if (currNode2 == null)
			return currNode1;

		// Check which node has a smaller value
		if (currNode1.item.compareTo(currNode2.item) < 0) {
			result = currNode1; // add it to the result node
			// Recursive call and add the return node as result.next
			result.next = mergeIt(currNode1.next, currNode2);
		} else {
			result = currNode2; // add it to the result node
			// Recursive call and add the return node as result.next
			result.next = mergeIt(currNode1, currNode2.next);
		}
		return result;
	}

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

		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.addItem(5);
		linkedList2.addItem(12);
		linkedList2.addItem(17);
		linkedList2.addItem(35);
		linkedList2.addItem(45);
		linkedList2.addItem(85);
		linkedList2.addItem(95);
		linkedList2.addItem(110);
		linkedList2.addItem(120);
		linkedList2.addItem(130);
		linkedList2.addItem(150);
		linkedList2.addItem(180);
		linkedList2.addItem(200);

		System.out
				.println("\n***********************Iterative***********************");
		System.out.println("First:" + linkedList);
		System.out.println("Second:" + linkedList2);
		LinkedList<Integer> mergedList = linkedList.sortedMergeIterative(
				linkedList, linkedList2);
		System.out.println("Merged:" + mergedList);
		System.out
				.println("**********************************************************");

		System.out
				.println("\n********************Recursive Approach***********************");
		System.out.println("First:" + linkedList);
		System.out.println("Second:" + linkedList2);
		LinkedList<Integer> mergedList2 = linkedList.sortedMergeRecursive(
				linkedList, linkedList2);
		System.out.println("Merged:" + mergedList2);
		System.out
				.println("***************************************************************");
	}

}
