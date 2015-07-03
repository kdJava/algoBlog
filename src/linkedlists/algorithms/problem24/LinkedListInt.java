/**
 * @createdOn 19-May-2015 12:28:18 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem24/LinkedListInt.java
 * @author ketandikshit
 * @typeName LinkedListInt
 * @year 2015
 */
package linkedlists.algorithms.problem24;

import linkedlists.algorithms.problem22.LinkedList;

/**
 * @author ketandikshit
 * @createdOn 19-May-2015 12:28:18 pm
 * @qualifiedName
 *                GeekyAlgoJava/linkedlists.algorithms.problem24/LinkedListInt.
 *                java
 * @year 2015
 */
public class LinkedListInt extends LinkedList<Integer> {

	private Node first;
	private int size;

	/**
	 * Internal data structure representing the node in linked-list
	 * 
	 * @author ketandikshit
	 * @year 2015
	 */
	private class Node {
		private Integer item;
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
	@Override
	public boolean isEmpty() {
		return first == null; // or size==0;
	}

	/**
	 * Gets the current size of the linked-list
	 * 
	 * @return the current size of linked-list
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Add the item as first element in linked-list
	 * 
	 * @param item
	 *            item to be added as first element in linked-list
	 */
	@Override
	public void addAtHead(Integer item) {
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
	@Override
	public void addAtEnd(Integer item) {
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
	@Override
	public void addItem(Integer item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	/**
	 * problem-24
	 * Adds two numbers each represented by a linked-list, in a forward manner
	 * 
	 * @createdOn 19-May-2015 5:26:21 pm
	 * @author ketandikshit
	 * @param num1
	 *            linkedlist representing number1
	 * @param num2
	 *            linkedlist representing number2
	 * @return the linkedlist representing the sum of 2 numbers
	 */
	public LinkedListInt addNumbersForward(LinkedListInt num1,
			LinkedListInt num2) {

		Node headOfNum1 = num1.first;
		Node headOfNum2 = num2.first;
		int num1Size = num1.getSize();
		int num2Size = num2.getSize();

		Node sumHeadNode = add(headOfNum1, headOfNum2, num1Size, num2Size);
		LinkedListInt sumNumList = getLinkedListInt(sumHeadNode);
		return sumNumList;
	}

	/**
	 * Actual Logic for problem24
	 * 
	 * @createdOn 19-May-2015 5:28:46 pm
	 * @author ketandikshit
	 * @param headOfNum1
	 *            head of the linkedlist representing number1
	 * @param headOfNum2
	 *            head of the linkedlist representing number2
	 * @param num1Size
	 *            the size of the linkedList1( number of digits in num1)
	 * @param num2Size
	 *            the size of the linkedfList2(number of digits in num2)
	 * @return the head of the new linkedlist representing the sum of 2 numbers
	 */
	public Node add(Node headOfNum1, Node headOfNum2, int num1Size, int num2Size) {
		/*
		 * first we need to ensure that both the Linked list has same no of
		 * nodes, to ensure that we will append 0 in front of shorter list
		 */
		if (num1Size > num2Size) {
			int diff = num1Size - num2Size;
			while (diff > 0) {
				Node newNode = new Node();
				newNode.item = 0;
				newNode.next = headOfNum2;
				headOfNum2 = newNode;
				diff--;
			}
		}
		if (num1Size < num2Size) {
			int diff = num2Size - num1Size;
			while (diff > 0) {
				Node newNode = new Node();
				newNode.item = 0;
				newNode.next = headOfNum1;
				headOfNum1 = newNode;
				diff--;
			}
		}

		return addBackRecursion(headOfNum1, headOfNum2);
	}

	private int carry = 0;
	private Node newHead = null;
	public Node addBackRecursion(Node headOfNum1, Node headOfNum2) {
		if (headOfNum1 == null && headOfNum2 == null) {
			return null;
		}
		addBackRecursion(headOfNum1.next, headOfNum2.next);
		int sumOfNodesAtSameLevel = headOfNum1.item + headOfNum2.item + carry;
		carry = 0; // re-initialize carry to 0
		if (sumOfNodesAtSameLevel >= 10) {
			carry = 1;
			sumOfNodesAtSameLevel = sumOfNodesAtSameLevel % 10;
		}
		Node newNode = new Node();
		newNode.item = sumOfNodesAtSameLevel;
		if (newHead == null) {
			newHead = newNode;
		} else {
			newNode.next = newHead;
			newHead = newNode;
		}
		// carry=0;
		return newHead;
	}

	/**
	 * Derives the actual linkedlist from the head of the node representing the
	 * number
	 * Utility Method
	 * 
	 * @createdOn 19-May-2015 5:31:20 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linked list representing the number
	 * @return the LinkedList representing the number
	 */
	private LinkedListInt getLinkedListInt(Node head) {
		LinkedListInt num = new LinkedListInt();
		Node currNode = head;
		while (currNode != null) {
			num.addItem(currNode.item);
			currNode = currNode.next;
		}
		return num;
	}

	/**
	 * Derives the number in String format from the linkedList representing the
	 * number
	 * Helper Method
	 * 
	 * @createdOn 19-May-2015 5:32:38 pm
	 * @author ketandikshit
	 * @param linkedListInt
	 *            the linkedList representing the number
	 * @return the StringBuilder instance containing the number in String form
	 *         to
	 *         play with
	 */
	private StringBuilder getNumFromList(LinkedListInt linkedListInt) {
		StringBuilder numString = new StringBuilder();
		Node currNode = linkedListInt.first;
		while (currNode != null) {
			numString.append(currNode.item);
			currNode = currNode.next;
		}
		return numString;
	}
	/**
	 * @createdOn 19-May-2015 12:28:18 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListInt num1 = new LinkedListInt();
		num1.addItem(1);
		num1.addItem(0);
		num1.addItem(0);
		num1.addItem(7);
		System.out.println("NUM-1-->" + num1.getNumFromList(num1));
		LinkedListInt num2 = new LinkedListInt();
		num2.addItem(9);
		num2.addItem(3);
		System.out.println("NUM-2-->" + num2.getNumFromList(num2));

		LinkedListInt sumOfNumList = num1.addNumbersForward(num1, num2);

		System.out.println("SUM---->" + num2.getNumFromList(sumOfNumList));

	}

}
