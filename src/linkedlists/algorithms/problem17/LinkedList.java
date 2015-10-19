/**
 * @createdOn 07-May-2015 1:09:15 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem17/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem17;

/**
 * @author ketandikshit
 * @createdOn 07-May-2015 1:09:15 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem17/LinkedList.java
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
	 * problem-17
	 * Alternating split of a given Linked List
	 * Iterative Approach
	 * Time Complexity: O(n)
	 * 
	 * @createdOn 08-May-2015 11:05:32 am
	 * @author ketandikshit
	 * @param linkedlist
	 *            instance of linked-list : {@linkplain LinkedList}
	 */
	public void alternateSplitIterative(LinkedList<Item> linkedlist) {

		LinkedList<Item> linkedList1 = new LinkedList<Item>();
		LinkedList<Item> linkedList2 = new LinkedList<Item>();

		boolean split = false;

		Node currNode = linkedlist.first;
		while (currNode != null) {
			if (split) {
				linkedList2.addItem(currNode.item);
			} else {
				linkedList1.addItem(currNode.item);
			}

			currNode = currNode.next;
			split = !split;
		}

		System.out.println(linkedList1);
		System.out.println(linkedList2);
	}

	/**
	 * problem-17
	 * Alternating split of a given Linked List
	 * Iterative Approach: Space Efficient, but alters the original linked list
	 * Time Complexity: O(n)
	 * 
	 * @createdOn 08-May-2015 11:06:58 am
	 * @author ketandikshit
	 * @param linkedlist
	 *            instance of linked-list : {@linkplain LinkedList}
	 * @return the newly created ( splitted list) list , also the original list
	 *         is modified to create the another list
	 */
	public LinkedList<Item> alternateSplitIterativeSpaceEfficient(
			LinkedList<Item> linkedlist) {

		LinkedList<Item> linkedList2 = new LinkedList<Item>();

		Node currNode = linkedlist.first;
		while (currNode != null && currNode.next != null) {
			linkedList2.addItem(currNode.next.item);
			currNode.next = currNode.next.next;
			currNode = currNode.next;
			size--;
		}
		return linkedList2;
	}

	/**
	 * problem-17
	 * Alternating split of a given Linked List
	 * Recursive Approach: Space Efficient, but alters the original linked list
	 * as well; Recursively moves the alternate elements of the original
	 * linked-list and keeps adding them to the new one
	 * Time Complexity: O(n)
	 * 
	 * @createdOn 08-May-2015 11:09:00 am
	 * @author ketandikshit
	 * @param linkedList
	 * @return
	 */
	public LinkedList<Item> alternateSplitRecursive(LinkedList<Item> linkedList) {
		altSplit(linkedList.first);
		LinkedList<Item> linkedListNew = new LinkedList<Item>();
		for (Node cntr = newHead; cntr != null; cntr = cntr.next) {
			linkedListNew.addItem(cntr.item);
		}
		return linkedListNew;
	}

	boolean isHead = true;
	boolean isSplit = false;
	Node newHead = null;
	Node newList = null;

	/*
	 * Recursive Utility Method for helping
	 * the alternate splitting of linked list
	 */
	private void altSplit(Node currNode) {
		if (currNode == null)
			return;

		Node nextNode = currNode.next;
		addToNewList(nextNode);

		if (nextNode == null)
			return;

		/* Change the next link of head */
		currNode.next = nextNode.next;
		this.size--;

		/* Recursively call for the new next of head */
		altSplit(currNode.next);
	}

	/**
	 * Helps with the addition off nodes to new linked list
	 * Assigns the head if the linked-list is empty, else keeps on adding to the
	 * existing list , while incrementing the nose pointer
	 * 
	 * @createdOn 08-May-2015 11:11:56 am
	 * @author ketandikshit
	 * @param node
	 *            the node to add to linked list
	 */
	private void addToNewList(Node node) {
		if (isHead) {
			newList = node;
			newHead = node;
			isHead = !isHead;
		} else {
			newList.next = node;
			newList = newList.next;
		}
	}
	/**
	 * @createdOn 07-May-2015 1:09:15 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Character> linkedList = new LinkedList<Character>();
		linkedList.addItem('A');
		linkedList.addItem('A');
		linkedList.addItem('B');
		linkedList.addItem('B');
		linkedList.addItem('C');
		linkedList.addItem('C');
		linkedList.addItem('D');
		linkedList.addItem('D');
		linkedList.addItem('E');
		linkedList.addItem('E');
		linkedList.addItem('F');
		linkedList.addItem('F');
		linkedList.addItem('G');
		linkedList.addItem('G');
		linkedList.addItem('H');
		linkedList.addItem('H');
		linkedList.addItem('I');
		linkedList.addItem('I');
		linkedList.addItem('J');
		linkedList.addItem('J');
		linkedList.addItem('K');
		linkedList.addItem('K');
		linkedList.addItem('L');
		linkedList.addItem('L');
		linkedList.addItem('M');
		linkedList.addItem('M');
		linkedList.addItem('N');
		linkedList.addItem('N');
		linkedList.addItem('O');
		linkedList.addItem('O');
		linkedList.addItem('P');
		linkedList.addItem('P');

		System.out
				.println("**********************Iterative*********************");
		System.out.println(linkedList);
		linkedList.alternateSplitIterative(linkedList);
		System.out
				.println("****************************************************");

		System.out
				.println("\n**********************Iterative(Space Efficient)*********************");
		System.out.println(linkedList);
		LinkedList<Character> splittedList = linkedList
				.alternateSplitIterativeSpaceEfficient(linkedList);
		System.out.println(splittedList);
		System.out.println(linkedList);
		System.out
				.println("*********************************************************************");

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
				.println("\n******************************Recursive*****************************");
		System.out.println(linkedList2);
		LinkedList<Integer> newLinkedList = linkedList2
				.alternateSplitRecursive(linkedList2);
		System.out.println(linkedList2);
		System.out.println(newLinkedList);
		System.out
				.println("********************************************************************");

	}

}
