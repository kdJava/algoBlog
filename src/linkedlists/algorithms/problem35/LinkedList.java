/**
 * @createdOn 20-Jul-2015 4:02:14 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem35/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem35;

/**
 * @author ketandikshit
 * @createdOn 20-Jul-2015 4:02:14 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem35/LinkedList.java
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
			if (counter == (size - 1)) {
				result += i.item + "]";
			} else {
				result += i.item + "-->";
			}
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

	private Node rotateClockwise(LinkedList<Item> linkedList, int k) {
		Node currentNode = linkedList.first;
		int cnt = 0;
		Node prevOfNewHead = null;
		Node newHead = null;
		while (currentNode.next != null) {
			if (cnt == (k - 1)) {
				prevOfNewHead = currentNode;
			}
			if (cnt == k) {
				newHead = currentNode;
			}
			currentNode = currentNode.next;
			cnt++;
		}
		currentNode.next = linkedList.first;
		prevOfNewHead.next = null;
		return newHead;
	}

	public LinkedList<Item> getRotation(LinkedList<Item> linkedList,
			int k, boolean isCLockwise) {
		if (!isCLockwise) {
			k = size - k;
		}
		Node newHead = rotateClockwise(linkedList, k);
		return getNewListFromNode(newHead);
	}

	private LinkedList<Item> getNewListFromNode(Node newHead) {
		LinkedList<Item> linkedList = new LinkedList<>();
		Node currentNode = newHead;
		while (currentNode != null) {
			linkedList.addItem(currentNode.item);
			currentNode = currentNode.next;
		}
		return linkedList;
	}

	/**
	 * @createdOn 20-Jul-2015 4:02:14 pm
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
		linkedList1.addItem(60);
		linkedList1.addItem(70);
		linkedList1.addItem(80);
		linkedList1.addItem(90);
		linkedList1.addItem(100);
		System.out.println("Original-->" + linkedList1);
		int k = 3;
		LinkedList<Integer> rotatedLinkedList = linkedList1
				.getRotation(linkedList1, k, true);
		System.out.println("After-->" + rotatedLinkedList);

	}

}
