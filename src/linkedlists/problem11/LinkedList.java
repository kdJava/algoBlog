/**
 * @createdOn 23-Apr-2015 10:31:25 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.problem11/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.problem11;

/**
 * @author ketandikshit
 * @createdOn 23-Apr-2015 10:31:25 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.problem11/LinkedList.java
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
	 * problem11
	 * Remove duplicates from an unsorted linked list
	 * Using two loops; (trivial)
	 * This is the simple way where two loops are used.
	 * Outer loop is used to pick the elements one by one and inner loop
	 * compares the picked element with rest of the elements.
	 * 
	 * @createdOn 23-Apr-2015 10:44:39 pm
	 * @author ketandikshit
	 * @param linkedlist
	 *            the unsorted linked list to remove duplicates from
	 */
	public void removeDuplicatesUsingDoubleLoops(LinkedList<Item> linkedlist) {
		Node currentNode1 = linkedlist.first;
		while (currentNode1 != null) {
			Node curreNode2 = currentNode1;
			while (curreNode2.next != null) {
				if (currentNode1.item.equals(curreNode2.next.item)) {
					Node duplicate = curreNode2.next;
					curreNode2.next = curreNode2.next.next;
					duplicate = null;
					size--;
				} else {
					curreNode2 = curreNode2.next;
				}
			}
			currentNode1 = currentNode1.next;
		}
	}

	private Node mergeSortList(Node head) {

		if (head == null || head.next == null)
			return head;
		Node left = head;
		Node right = head.next;
		while ((right != null) && (right.next != null)) {
			head = head.next;
			right = (right.next).next;
		}
		right = head.next;
		head.next = null;
		return merge(mergeSortList(left), mergeSortList(right));
	}

	private Node merge(Node leftList, Node rightList) {
		Node temp = new Node();
		Node head = temp;
		Node currentNode = head;
		while ((leftList != null) && (rightList != null)) {
			if (leftList.item.compareTo(rightList.item) <= 0) {
				currentNode.next = leftList;
				currentNode = leftList;
				leftList = leftList.next;
			} else {
				currentNode.next = rightList;
				currentNode = rightList;
				rightList = rightList.next;
			}
		}
		currentNode.next = (leftList == null) ? rightList : leftList;
		return head.next;
	}

	private void mergeSortTheList(LinkedList<Item> linkedList) {
		Node head = mergeSortList(linkedList.first);

		Node currNode = head;
		while (currNode != null) {
			System.out.println(currNode.item);
			currNode = currNode.next;
		}
	}

	/**
	 * @createdOn 23-Apr-2015 10:31:25 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addAtHead(10);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(40);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(50);

		System.out.println(linkedList);
		linkedList.removeDuplicatesUsingDoubleLoops(linkedList);
		System.out.println(linkedList);

		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.addAtHead(100);
		linkedList2.addAtEnd(80);
		linkedList2.addAtEnd(60);
		linkedList2.addAtEnd(50);

		linkedList2.mergeSortTheList(linkedList2);

	}

}
