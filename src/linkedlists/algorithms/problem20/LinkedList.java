/**
 * @createdOn 17-May-2015 5:13:28 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem20/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem20;

/**
 * @author ketandikshit
 * @createdOn 17-May-2015 5:13:28 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem20/LinkedList.java
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
	 * problem-20
	 * Swap every nth node in the linked list with (n+k)th node
	 * 
	 * @createdOn 17-May-2015 11:31:06 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            the linked-list instance
	 * @param k
	 *            the 'k'th value to swap
	 * @return the linkedList whose every kth element has been swapped
	 */
	public LinkedList<Item> swapEveryKthNodeWithCurrentPos(
			LinkedList<Item> linkedList, int k) {
		return createLinkedList(reverseNodes(linkedList.first, k));
	}

	/**
	 * 
	 * @createdOn 17-May-2015 11:30:55 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linked list
	 * @param k
	 *            the 'k'th value to perform swapping
	 * @return the head of the modified linkedList
	 */
	private Node reverseNodes(Node head, int k) {
		int x = k;
		Node currNode = head;
		Node currNode_prev = head;
		Node currNode_next = null;
		if (k < 2)
			return head;
		if (currNode != null) {
			currNode_next = head.next;
		} else
			return null;
		while ((x - 2) > 0) {
			if (currNode_next != null) {
				currNode_prev = currNode_next;
				currNode_next = currNode_next.next;
				x--;
			} else {
				return head;
			}
		}
		Node newHead = currNode_next.next;
		currNode_prev.next = currNode;
		currNode_next.next = currNode.next;
		currNode.next = reverseNodes(newHead, k);
		return currNode_next;
	}

	/**
	 * For simplicity purpose we create a new linked list
	 * We traverse the node to tail and add all the elements to this newly
	 * created linkedlist
	 * 
	 * @createdOn 17-May-2015 11:32:35 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linked-list
	 * @return the newly created linkedlist
	 */
	private LinkedList<Item> createLinkedList(Node head) {
		LinkedList<Item> linkedList = new LinkedList<>();
		while (head != null) {
			linkedList.addItem(head.item);
			head = head.next;
		}
		return linkedList;
	}
	/**
	 * @createdOn 17-May-2015 5:13:29 pm
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

		System.out.println(linkedList);
		final int K = 4;
		LinkedList<Integer> finalLinkedList = linkedList
				.swapEveryKthNodeWithCurrentPos(linkedList, K);
		System.out.println(finalLinkedList);

	}

}
