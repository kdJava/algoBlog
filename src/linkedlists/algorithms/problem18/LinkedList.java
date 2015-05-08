/**
 * @createdOn 08-May-2015 11:32:16 am
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem18/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem18;

/**
 * @author ketandikshit
 * @createdOn 08-May-2015 11:32:16 am
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem18/LinkedList.java
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
	 * problem-18
	 * Merges 2 linked lists alternately
	 * 
	 * @createdOn 08-May-2015 12:46:14 pm
	 * @author ketandikshit
	 * @param linkedList1
	 *            first linked list
	 * @param linkedList2
	 *            second linked list
	 */
	public void mergeAlternate(LinkedList<Item> linkedList1,
			LinkedList<Item> linkedList2) {

		Node currNode1 = linkedList1.first;
		Node currNode2 = linkedList2.first;
		while (currNode1 != null && currNode2 != null) {
			Node nextCurrNode1 = currNode1.next;
			Node nextCurrNode2 = currNode2.next;
			currNode1.next = currNode2;
			currNode2.next = nextCurrNode1;
			linkedList1.size++;
			linkedList2.size--;
			currNode1 = nextCurrNode1;
			currNode2 = nextCurrNode2;
		}
		System.out.println("AlternateMergedList:" + linkedList1);
		System.out.println("Remaining Nodes are:");
		display(currNode2);
	}

	/**
	 * Helper utility to display the linked list, while traversing the same
	 * 
	 * @createdOn 08-May-2015 12:47:15 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linkedList
	 */
	private void display(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print("-->" + currNode.item);
			currNode = currNode.next;
		}
	}
	/**
	 * @createdOn 08-May-2015 11:32:16 am
	 * @author ketandikshit
	 * @param args
	 */
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
		linkedList2.addItem(110);
		linkedList2.addItem(120);
		linkedList2.addItem(130);
		linkedList2.addItem(140);
		linkedList2.addItem(150);

		System.out.println("First:" + linkedList);
		System.out.println("Second:" + linkedList2);
		linkedList.mergeAlternate(linkedList, linkedList2);

	}

}
