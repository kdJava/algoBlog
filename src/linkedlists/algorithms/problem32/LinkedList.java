/**
 * @createdOn 09-Jul-2015 6:40:05 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem32/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem32;

/**
 * @author ketandikshit
 * @createdOn 09-Jul-2015 6:40:05 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem32/LinkedList.java
 * @year 2015
 */
public class LinkedList {

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
	public void addItem(Integer item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	public Node segregateEvenOdd(Node head_ref) {
		Node end = head_ref;

		Node prev = null;
		Node curr = head_ref;

		/* Get pointer to the last node */
		while (end.next != null) {
			end = end.next;
		}

		Node new_end = end;

		/*
		 * Consider all odd nodes before the first even node and move then after
		 * end
		 */
		while (((curr.item % 2) != 0) && (curr != end)) {
			new_end.next = curr;
			curr = curr.next;
			new_end.next.next = null;
			new_end = new_end.next;
		}

		// 10->8->17->17->15
		/* Do following steps only if there is any even node */
		if ((curr.item % 2) == 0) {
			/* Change the head pointer to point to first even node */
			head_ref = curr;

			/* now current points to the first even node */
			while (curr != end) {
				if ((curr.item % 2) == 0) {
					prev = curr;
					curr = curr.next;
				} else {
					/* break the link between prev and current */
					prev.next = curr.next;

					/* Make next of curr as NULL */
					curr.next = null;

					/* Move curr to end */
					new_end.next = curr;

					/* make curr as new end of list */
					new_end = curr;

					/* Update current pointer to next of the moved node */
					curr = prev.next;
				}
			}
		} else {
			prev = curr;
		}

		/*
		 * If there are more than 1 odd nodes and end of original list is odd
		 * then move this node to end to maintain same order of odd numbers in
		 * modified list
		 */
		if ((new_end != end) && (((end.item) % 2) != 0)) {
			prev.next = end.next;
			end.next = null;
			new_end.next = end;
		}
		return head_ref;
	}

	public LinkedList alignEvenOdd(LinkedList linkedList) {
		Node headRef = segregateEvenOdd(linkedList.first);
		return getListFromHead(headRef);
	}

	public LinkedList alignEvenOddMethod2(LinkedList linkedList) {
		Node newHead = segregateEvenAndOdd2(linkedList.first);
		return getListFromHead(newHead);
	}

	public Node segregateEvenAndOdd2(Node head) {
		Node current = head;
		Node oddList = new Node();
		Node oddCurrent = oddList;
		Node evenList = new Node();
		Node evenCurrent = evenList;
		while (current != null) {
			if ((current.item % 2) == 0) {
				evenCurrent.next = current;
				evenCurrent = current;
			} else {
				oddCurrent.next = current;
				oddCurrent = current;
			}
			current = current.next;
		}
		evenCurrent.next = oddList.next;
		return evenList.next;
	}

	/**
	 * Helper to form a new linkedList instance traversing from the head-node
	 * 
	 * @createdOn 09-Jul-2015 6:14:13 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of the linkedList
	 * @return the newly assembled linkedlist
	 */
	private LinkedList getListFromHead(Node head) {
		LinkedList newList = new LinkedList();
		Node currentNode = head;
		while (currentNode != null) {
			newList.addItem(currentNode.item);
			currentNode = currentNode.next;
		}
		return newList;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addItem(11);
		linkedList.addItem(12);
		linkedList.addItem(13);
		linkedList.addItem(14);
		linkedList.addItem(15);
		linkedList.addItem(21);
		linkedList.addItem(22);
		linkedList.addItem(23);
		linkedList.addItem(24);
		linkedList.addItem(25);
		System.out.println("LinkedList:" + linkedList);
		LinkedList alignedList = linkedList.alignEvenOdd(linkedList);
		System.out.println("AlignedList-->" + alignedList);

		LinkedList linkedList2 = new LinkedList();
		linkedList2.addItem(11);
		linkedList2.addItem(12);
		linkedList2.addItem(13);
		linkedList2.addItem(14);
		linkedList2.addItem(15);
		linkedList2.addItem(21);
		linkedList2.addItem(22);
		linkedList2.addItem(23);
		linkedList2.addItem(24);
		linkedList2.addItem(25);

		System.out.println("SecondOne-->" + linkedList2);
		LinkedList newAlignedList = linkedList2
				.alignEvenOddMethod2(linkedList2);
		System.out.println(newAlignedList);
	}

}
