/**
 * @createdOn 08-Jul-2015 5:45:18 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem30/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem30;

/**
 * @author ketandikshit
 * @createdOn 08-Jul-2015 5:45:18 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem30/LinkedList.java
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
	 * Logic for approach-1( Problem-30 )
	 * 
	 * @createdOn 09-Jul-2015 4:54:06 pm
	 * @author ketandikshit
	 * @param head
	 *            head of the linkedlist
	 * @param k
	 *            group size to reverse the elements
	 * @return the head of the group-reversed linkedlist
	 */
	private Node kAlternateReverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;

		/* 1) reverse first k nodes of the linked list */
		while ((current != null) && (count < k)) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * 2) Now head points to the kth node. So change next of head to (k+1)th
		 * node
		 */
		if (head != null) {
			head.next = current;
		}
		/*
		 * 3) We do not want to reverse next k nodes. So move the current
		 * pointer to skip next k nodes
		 */
		count = 0;
		while ((count < k - 1) && (current != null)) {
			current = current.next;
			count++;
		}

		/*
		 * 4) Recursively call for the list starting from current->next. And
		 * make rest of the list as next of first node
		 */
		if ((current != null)) {
			current.next = kAlternateReverse(current.next, k);
		}

		/* 5) prev is new head of the input list */
		return prev;
	}

	/**
	 * problem-30: reverse the nodes in groups of size 'k' in alternate order
	 * Approach-1 O(N)
	 * 
	 * @createdOn 09-Jul-2015 4:09:18 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            linkledlist instance
	 * @param k
	 *            the group size
	 * @return the list after required rotations.
	 */
	public LinkedList<Item> kAlternateReverse(LinkedList<Item> linkedList, int k) {
		Node newHead = kAlternateReverse(linkedList.first, k);
		return getListFromHead(newHead);
	}

	private LinkedList<Item> getListFromHead(Node head) {
		LinkedList<Item> newList = new LinkedList<>();
		Node currentNode = head;
		while (currentNode != null) {
			newList.addItem(currentNode.item);
			currentNode = currentNode.next;
		}
		return newList;
	}

	/**
	 * problem-30: reverse the nodes in groups of size 'k' in alternate order
	 * Approach-2 O(N)
	 * 
	 * @createdOn 09-Jul-2015 4:10:02 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            linkedlist instance
	 * @param k
	 *            block size
	 * @return the new LinkeedList after alternate reversing
	 */
	public LinkedList<Item> kAlternateReverse2Approach(
			LinkedList<Item> linkedList, int k) {
		Node newHead = _kAltReverse(linkedList.first, k, true);
		return getListFromHead(newHead);
	}

	/**
	 * Logic for approach-2(problem-30)
	 * 
	 * @createdOn 09-Jul-2015 4:11:50 pm
	 * @author ketandikshit
	 * @param node
	 *            node in a linkedlist
	 * @param k
	 *            group size for reversing elements
	 * @param continueRecursion
	 *            recursion termination variable
	 * @return the head of the group-reversed linkedlist
	 */
	private Node _kAltReverse(Node node, int k, boolean continueRecursion) {
		if (node == null)
			return null;

		int count = 1;
		Node prev = null;
		Node current = node;
		Node next;

		/*
		 * The loop serves two purposes 1) If b is true, then it reverses the k
		 * nodes 2) If b is false, then it moves the current pointer
		 */
		while ((current != null) && (count <= k)) {
			next = current.next;

			/* Reverse the nodes only if b is true */
			if (continueRecursion == true)
				current.next = prev;

			prev = current;
			current = next;
			count++;
		}

		/*
		 * 3) If b is true, then node is the kth node. So attach rest of the
		 * list after node. 4) After attaching, return the new head
		 */
		if (continueRecursion == true) {
			node.next = _kAltReverse(current, k, !continueRecursion);
			return prev;
		}

		/*
		 * If b is not true, then attach rest of the list after prev. So attach
		 * rest of the list after prev
		 */
		else {
			prev.next = _kAltReverse(current, k, !continueRecursion);
			return node;
		}
	}

	/**
	 * @createdOn 08-Jul-2015 5:45:18 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
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
		System.out.println("LinkedList:" + linkedList);
		final int k = 3;
		LinkedList<Integer> newList = linkedList.kAlternateReverse(linkedList,
				k);
		System.out.println("After:" + newList);

		LinkedList<Integer> originalList = linkedList
				.kAlternateReverse2Approach(newList, 3);
		System.out.println("Again Reversed:" + originalList);
	}

}
