/**
 * @createdOn 24-Apr-2015 1:44:46 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem14/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem14;

/**
 * @author ketandikshit
 * @createdOn 24-Apr-2015 1:44:46 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem14/LinkedList.java
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
	 * problem-14
	 * Pairwise swap elements of a given linked list
	 * Start from the head node and traverse the list.
	 * While traversing swap data of each node with its next node’s data.
	 * Time complexity: O(n)
	 * 
	 * @createdOn 03-May-2015 12:49:12 am
	 * @author ketandikshit
	 * @param linkedList
	 *            linked-list instance to do swapping
	 */
	public void pairWiseSwap(LinkedList<Item> linkedList) {
		Node currentNode = linkedList.first;

		while (currentNode != null && currentNode.next != null) {
			swap(currentNode, currentNode.next);
			currentNode = currentNode.next.next;
		}
	}

	/**
	 * Helper method to swap data of two nodes
	 * 
	 * @createdOn 03-May-2015 12:59:54 am
	 * @author ketandikshit
	 * @param node1
	 *            first node for swapping
	 * @param node2
	 *            second node for swapping
	 */
	private void swap(Node node1, Node node2) {
		Item temp = null;
		temp = node1.item;
		node1.item = node2.item;
		node2.item = temp;
	}

	/**
	 * problem-14
	 * Pairwise swap elements of a given linked list
	 * Recursive Approach
	 * If there are 2 or more than 2 nodes in Linked List then swap the first
	 * two nodes and recursively call for rest of the list.
	 * 
	 * @createdOn 03-May-2015 1:08:34 am
	 * @author ketandikshit
	 * @param linkedList
	 *            linked-list instance to do swapping
	 */
	public void pairwiseSwapUsingRecursion(LinkedList<Item> linkedList) {
		swapAdjacent(linkedList.first);
	}

	/**
	 * Recursive function to pairwise swap elements of a linked list
	 * 
	 * @createdOn 03-May-2015 1:07:47 am
	 * @author ketandikshit
	 * @param node
	 *            node that needs to be swapped with it next one
	 */
	private void swapAdjacent(Node node) {
		/* There must be at-least two nodes in the list */
		if (node != null && node.next != null) {
			/* Swap the node's data with data of next node */
			swap(node, node.next);

			/* Call swapAdjacent() for rest of the list */
			swapAdjacent(node.next.next);
		}
	}

	/**
	 * problem-14
	 * Pairwise swap elements of a given linked list
	 * By Changing the links;
	 * Up till now we were only swapping the data of the nodes, But we will now
	 * actually swap the entire node by changing the links.
	 * Time Complexity: O(n)
	 * 
	 * @createdOn 04-May-2015 2:59:19 pm
	 * @author ketandikshit
	 * @param linkedList
	 */
	public void pairwiseSwapByChangingLinks(LinkedList<Item> linkedList) {
		swapByChangingLinks(linkedList.first);
	}

	/**
	 * Code that performs the pairwise swapping of the adjacent nodes of the
	 * linked-list by changing the links
	 * 
	 * @createdOn 04-May-2015 2:59:24 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linked list
	 */
	private void swapByChangingLinks(Node head) {
		// Empty linked-list check
		if (head == null)
			return;

		// Single Node list check
		if (head.next == null)
			return;

		// Swap the head node with the second Node in list
		Node newHead = head.next;
		Node temp = head.next.next;
		newHead.next = head;
		head.next = temp;

		// initialize the firstNode to new Head
		first = newHead;

		// Recursively swap nodes pairwise by interchanging links
		swapLinks(first.next, first.next.next, first.next.next.next);
	}

	/**
	 * helper method: Recursively swaps the links of the adjacent nodes
	 * 
	 * @createdOn 04-May-2015 2:11:11 pm
	 * @author ketandikshit
	 * @param prevNode
	 *            the left of current node
	 * @param currNode
	 *            the current node
	 * @param nextNode
	 *            the right of the current node
	 */
	private void swapLinks(Node prevNode, Node currNode, Node nextNode) {
		if (nextNode.next != null) {
			prevNode.next = nextNode;
			Node temp = nextNode.next;
			nextNode.next = currNode;
			currNode.next = temp;
			swapLinks(currNode, currNode.next, currNode.next.next);
		} else {
			prevNode.next = nextNode;
			nextNode.next = currNode;
			currNode.next = null;
		}
	}
	/**
	 * @createdOn 24-Apr-2015 1:44:46 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addAtHead(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(40);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(60);
		linkedList.addAtEnd(70);
		linkedList.addAtEnd(80);
		linkedList.addAtEnd(90);
		linkedList.addAtEnd(100);

		System.out.println(linkedList);
		linkedList.pairWiseSwap(linkedList);
		System.out.println(linkedList);
		linkedList.pairwiseSwapUsingRecursion(linkedList);
		System.out.println(linkedList);
		linkedList.pairwiseSwapByChangingLinks(linkedList);
		System.out.println(linkedList);
	}

}
