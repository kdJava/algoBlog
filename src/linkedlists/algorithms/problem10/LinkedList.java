/**
 * @createdOn 22-Apr-2015 11:29:52 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem10/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem10;

/**
 * @author ketandikshit
 * @createdOn 22-Apr-2015 11:29:52 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem10/LinkedList.java
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

		@Override
		public String toString() {
			return ("NODE[DATA:" + item + "]" + "-->" + next);
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
	 * problem10
	 * Remove duplicates from a sorted linked list
	 * Algorithm:
	 * 1. Traverse the list from the head (or start) node. While traversing.
	 * 2. Compare each node with its next node.
	 * 3. If data of next node is same as current node then delete the next
	 * node.
	 * 4. Before we delete a node, we need to store next pointer of the node
	 * 
	 * @createdOn 23-Apr-2015 12:07:47 am
	 * @author ketandikshit
	 * @param linkedList
	 *            sorted linked-list from which the duplicates need to be
	 *            removed
	 */
	public void removeDuplicatesFromSortedLinkedList(LinkedList<Item> linkedList) {
		/* Pointer to traverse the linked list */
		Node currentNode = linkedList.first;

		/* Pointer to store the next pointer of a node to be deleted */
		Node nextOfNextNode;

		/* do nothing if the list is empty */
		if (currentNode == null)
			return;

		/* Traverse the list till last node */
		while (currentNode.next != null) {
			/* Compare current node with next node */
			if (currentNode.item.compareTo(currentNode.next.item) == 0) {
				/* The sequence of steps is important */
				nextOfNextNode = currentNode.next.next;
				currentNode.next = nextOfNextNode;
				size--;
			} else /* This is tricky: only advance if no deletion */
			{
				currentNode = currentNode.next;
			}
		}
	}

	/**
	 * @createdOn 22-Apr-2015 11:29:52 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		linkedList.addAtHead(10);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(40);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(60);
		linkedList.addAtEnd(70);
		linkedList.addAtEnd(70);
		linkedList.addAtEnd(80);
		linkedList.addAtEnd(90);
		linkedList.addAtEnd(100);
		linkedList.addAtEnd(100);
		linkedList.addAtEnd(100);

		System.out.println(linkedList);

		linkedList.removeDuplicatesFromSortedLinkedList(linkedList);
		System.out.println(linkedList);
	}

}
