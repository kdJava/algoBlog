/**
 * @createdOn 19-Jun-2015 2:21:50 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem27/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem27;

/**
 * @author ketandikshit
 * @createdOn 19-Jun-2015 2:21:50 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem27/LinkedList.java
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
	 * problem-27
	 * Check if the linked-lists are identical or not
	 * Iterative solution
	 * 
	 * @createdOn 19-Jun-2015 4:19:01 pm
	 * @author ketandikshit
	 * @param linkedList1
	 *            first linkedlist instance
	 * @param linkedList2
	 *            second linkedlist instance
	 * @return true if linkedlists are equal , false otherwise
	 */
	public boolean areIdentical(LinkedList<Item> linkedList1,
			LinkedList<Item> linkedList2) {
		Node currentNodeOf1 = linkedList1.first;
		Node currentNodeOf2 = linkedList2.first;
		if ((linkedList1.isEmpty() && !linkedList2.isEmpty())
				|| (!linkedList1.isEmpty() && linkedList2.isEmpty())) {
			return false;
		}

		if (linkedList1.isEmpty() && linkedList2.isEmpty()) {
			return true;
		}

		while (currentNodeOf1 != null && currentNodeOf2 != null) {
			if (currentNodeOf1.item.equals(currentNodeOf2.item)) {
				currentNodeOf1 = currentNodeOf1.next;
				currentNodeOf2 = currentNodeOf2.next;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * problem:27
	 * Check if given 2 linkedLists are identical
	 * Recursive
	 * 
	 * @createdOn 22-Jun-2015 4:30:26 pm
	 * @author ketandikshit
	 * @param head1
	 *            head of the first linkedList
	 * @param head2
	 *            head of the second linkedList
	 * @return true if the linkedlists are identical, false otherwise
	 */
	public boolean areIdentical(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1 == null && head2 != null) {
			return false;
		}
		if (head1 != null && head2 == null) {
			return false;
		}
		if (head1.item != head2.item) {
			return false;
		}

		/*
		 * If we reach here, then a and b are not NULL and their
		 * data is same, so move to next nodes in both lists
		 */
		return areIdentical(head1.next, head2.next);
	}

	/**
	 * @createdOn 19-Jun-2015 2:21:50 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<Integer> linkedList1 = new LinkedList<>();
		linkedList1.addItem(10);
		linkedList1.addItem(20);
		linkedList1.addItem(30);
		linkedList1.addItem(40);
		linkedList1.addItem(50);
		System.out.println("LinkedList1==>" + linkedList1);
		LinkedList<Integer> linkedList2 = new LinkedList<>();
		linkedList2.addItem(10);
		linkedList2.addItem(20);
		linkedList2.addItem(30);
		linkedList2.addItem(40);
		linkedList2.addItem(50);
		System.out.println("LinkedList2==>" + linkedList2);

		System.out.println("IsIdentical(Iterative):"
				+ linkedList1.areIdentical(linkedList1, linkedList2));
		System.out.println("IsIdentical(Recursive):"
				+ linkedList1
						.areIdentical(linkedList1.first, linkedList2.first));

	}
}
