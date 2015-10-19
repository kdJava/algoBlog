/**
 * @createdOn 15-Jul-2015 3:37:08 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem33/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem33;

/**
 * @author ketandikshit
 * @createdOn 15-Jul-2015 3:37:08 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem33/LinkedList.java
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
		private Node child;

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
	public void addAtEnd(Item item, Item[] dataList) {
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
		currentNode = currentNode.next;

		if (dataList != null) {
			for (Item data : dataList) {
				Node newNodeDown = new Node();
				newNodeDown.item = data;
				currentNode.child = newNodeDown;
				currentNode = currentNode.child;
			}
		}
	}

	void pushNodesVertical(Item item, Item[] dataList) {
		addAtEnd(item, dataList);
	}

	/* Function to print nodes in the flattened linked list */
	void printList(Node node) {
		while (node != null) {
			System.out.printf("%d ", node.item);
			node = node.child;
		}
	}

	// A utility function to merge two sorted linked lists
	private Node merge(Node a, Node b) {
		// If first list is empty, the second list is result
		if (a == null) {
			return b;
		}

		// If second list is empty, the second list is result
		if (b == null) {
			return a;
		}

		// Compare the data members of head nodes of both lists
		// and put the smaller one in result
		Node result = null;
		if (a.item.compareTo(b.item) < 0) {
			result = a;
			result.child = merge(a.child, b);
		} else {
			result = b;
			result.child = merge(a, b.child);
		}

		return result;
	}

	public void printListFromHead(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.item + "-->");
			Node currNodeDown = currentNode.child;
			while (currNodeDown != null) {
				System.out.print(currNodeDown.item + "-->");
				currNodeDown = currNodeDown.child;
			}
			System.out.print("null");
			currentNode = currentNode.next;
			System.out.println("\n|");
		}
		System.out.println("null");
	}

	// The main function that flattens a given linked list
	Node flatten(Node root) {
		// Base cases
		if ((root == null) || (root.next == null)) {
			return root;
		}

		// Merge this list with the list on right side
		return merge(root, flatten(root.next));
	}

	public void testFlattening(LinkedList<Item> linkedList) {

		printListFromHead(linkedList.first);
		// Let us flatten the list
		Node head = flatten(linkedList.first);

		// Let us print the flatened linked list
		printList(head);

	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addAtHead(10);

		linkedList.pushNodesVertical(new Integer(20), new Integer[] { 20, 29,
				35 });
		linkedList.pushNodesVertical(new Integer(40), new Integer[] { 42, 47,
				52 });
		linkedList.pushNodesVertical(new Integer(60), new Integer[] { 60, 65,
				75 });
		linkedList.pushNodesVertical(new Integer(80), new Integer[] { 85, 90,
				100 });
		linkedList.testFlattening(linkedList);

	}
}
