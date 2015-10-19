/**
 * @createdOn 18-May-2015 5:19:43 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem23/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem23;

import linkedlists.algorithms.problem22.LinkedList;

/**
 * @author ketandikshit
 * @createdOn 18-May-2015 5:19:43 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem23/LinkedList.java
 * @year 2015
 */
class LinkedListInt extends LinkedList<Integer> {

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
	 * problem23
	 * Add two numbers represented by a linked list, Numbers are Stored in
	 * REVERSE order
	 * 
	 * @createdOn 19-May-2015 3:16:18 pm
	 * @author ketandikshit
	 * @param num1
	 *            the linked-list representing the number-1
	 * @param num2
	 *            the linked-list representing the number-2
	 * @return The new linked-list representing the sum of num-1 and num-2
	 */
	public LinkedListInt addNumberReverse(LinkedListInt num1, LinkedListInt num2) {
		Node sumHead = add(num1.first, num2.first);
		return getLinkedListInt(sumHead);
	}

	/**
	 * problem23: Actual Logic
	 * 
	 * @createdOn 19-May-2015 5:00:54 pm
	 * @author ketandikshit
	 * @param head1
	 *            head of the first linked-list representing the number
	 * @param head2
	 *            head of the second linked-list representing the number
	 * @return The head of the new linkedlist created, representing the sum of
	 *         num1 and num2
	 */
	private Node add(Node head1, Node head2) {
		int carry = 0;
		Node newHead = null;
		Node curr = null;
		while (head1 != null && head2 != null) {
			Integer a = head1.item;
			Integer b = head2.item;
			int total = a + b + carry;
			if (total >= 10) {
				carry = 1;
				total = total - 10;
			}
			if (newHead == null) {
				newHead = new Node();
				newHead.item = total;
				curr = newHead;
			} else {
				Node newNode = new Node();
				newNode.item = total;
				curr.next = newNode;
				curr = curr.next;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		while (head1 != null) {
			int x = head1.item + carry;
			Node newNode = new Node();
			newNode.item = x;
			curr.next = newNode;
			curr = curr.next;
			head1 = head1.next;
			carry = 0;
		}
		while (head2 != null) {
			int x = head2.item + carry;
			Node newNode = new Node();
			newNode.item = x;
			curr.next = newNode;
			curr = curr.next;
			head2 = head2.next;
			carry = 0;
		}
		if (carry > 0) {
			Node newNode = new Node();
			newNode.item = 1;
			curr.next = newNode;
			curr = curr.next;
		}
		return newHead;
	}

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
	 * Extract the number out of the linkedlist
	 * 
	 * @createdOn 19-May-2015 5:02:47 pm
	 * @author ketandikshit
	 * @param linkedListInt
	 *            the linked list representing the number
	 * @return the number representation in String format
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
	 * @createdOn 18-May-2015 5:19:43 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListInt num1 = new LinkedListInt();
		num1.addItem(5);
		num1.addItem(9);
		num1.addItem(5);
		num1.addItem(7);
		StringBuilder num1Str = num1.getNumFromList(num1);
		System.out.println("NUM-1 in REVERESE order-->" + num1Str
				+ " ,ACTUAL-->" + num1Str.reverse());
		LinkedListInt num2 = new LinkedListInt();
		num2.addItem(5);
		num2.addItem(9);
		StringBuilder num2Str = num2.getNumFromList(num2);
		System.out.println("NUM-2 in REVERESE order-->" + num2Str
				+ " ,ACTUAL-->" + num2Str.reverse());

		LinkedListInt sum = num1.addNumberReverse(num1, num2);
		StringBuilder sumRevStr = num1.getNumFromList(sum);
		System.out.println("SUM IN REVERSE ODRDER-->" + sumRevStr);
		System.out.println("ActualResult FORWARD ORDER-->"
				+ sumRevStr.reverse());
	}
}
