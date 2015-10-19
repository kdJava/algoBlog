/**
 * @createdOn 20-Jul-2015 12:37:49 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem34/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem34;

import linkedlists.datastructure.queue.Queue;

/**
 * @author ketandikshit
 * @createdOn 20-Jul-2015 12:37:49 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem34/LinkedList.java
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
	public void addAtHead(Item item, Item[] dataList) {
		Node newNode = new Node(); // Create new node to insert
		newNode.item = item; // Set newNode's element to item to to be inserted

		Node oldFirst = first; // save the oldFirst Node in temp variable
		first = newNode; // Set the first to newNode
		first.next = oldFirst; // Set the next of first to oldFirst
		size++; // increment the size

		Node currentNode = first;
		if (dataList != null) {
			for (Item data : dataList) {
				Node newNodeDown = new Node();
				newNodeDown.item = data;
				currentNode.child = newNodeDown;
				currentNode = currentNode.child;
			}
		}
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

	/**
	 * helper utility to insert the item into the linkedlist
	 * 
	 * @author ketandikshit
	 * @param item
	 *            the item to be inserted
	 */
	public void addItem(Item item, Item[] dataList) {
		if (size == 0) {
			addAtHead(item, dataList);
		} else {
			addAtEnd(item, dataList);
		}
	}

	/*
	 * private void setLevelBasedLinks(Node node1, Node node2) { node1.next =
	 * node2; }
	 */

	/*
	 * private void setChildLinks() { Node parentNode1 = this.first; Node
	 * parentNode2 = this.first.next;
	 * 
	 * while ((parentNode1 != null) && (parentNode2 != null)) { Node childNode1
	 * = parentNode1.child; Node childNode2 = parentNode2.child; while
	 * ((childNode1 != null) && (childNode2 != null)) {
	 * setLevelBasedLinks(childNode1, childNode2); childNode1 =
	 * childNode1.child; childNode2 = childNode2.child; } parentNode1 =
	 * parentNode1.next; parentNode2 = parentNode2.next; } }
	 */

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

	private LinkedList<Item> flattenList(Node head) {
		if (head == null) {
			return null;
		} else {
			LinkedList<Item> linkedListNew = new LinkedList<>();
			Node currNode = head;
			Queue<Node> queue = new Queue<Node>();
			while (currNode != null) {
				linkedListNew.addItem(currNode.item, null);
				if (currNode.child != null) {
					queue.enqueue(currNode.child);
				}
				currNode = currNode.next;
				if (currNode == null) {
					if (!queue.isEmpty()) {
						currNode = queue.dequeue();
					}
				}
			}
			return linkedListNew;
		}
	}

	public void testFlattening(LinkedList<Item> linkedList) {
		printListFromHead(linkedList.first);
		LinkedList<Item> newList = flattenList(linkedList.first);
		System.out.println(newList);
	}

	/**
	 * @createdOn 20-Jul-2015 12:37:49 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addItem(new Integer(10), new Integer[] { 12, 15, 18 });
		linkedList.addItem(new Integer(20), new Integer[] { 22, 24, 28 });
		linkedList.addItem(new Integer(40), new Integer[] { 42, 47, 52 });
		linkedList.addItem(new Integer(60), new Integer[] { 60, 65, 75 });
		linkedList.addItem(new Integer(80), new Integer[] { 85, 90, 100 });
		linkedList.testFlattening(linkedList);

	}

}
