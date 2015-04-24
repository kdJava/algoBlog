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

	/**
	 * Merge sort for linke list
	 * 
	 * @createdOn 24-Apr-2015 10:55:55 am
	 * @author ketandikshit
	 * @param head
	 *            takes the head of the linked list
	 * @return the head of the sorted linked list after doing merge sort
	 */
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

	/**
	 * Internal helper code of merge-sort algo to perform the merge of 2
	 * partitions
	 * 
	 * @createdOn 24-Apr-2015 10:58:17 am
	 * @author ketandikshit
	 * @param leftList
	 *            the head of the left partioned list
	 * @param rightList
	 *            the head of the right partioned list
	 * @return the node of the linked list prepared after merging of the left
	 *         and the right partition
	 * 
	 */
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

	/**
	 * Simply walks over each node and creates a linkedList instance for the
	 * same, structurally
	 * 
	 * @createdOn 24-Apr-2015 10:54:51 am
	 * @author ketandikshit
	 * @param head
	 * @return
	 */
	public LinkedList<Item> arrrangeList(Node head) {
		Node currentNode = head;
		LinkedList<Item> linkedList = new LinkedList<>();
		linkedList.addAtHead(currentNode.item);
		currentNode = currentNode.next;
		while (currentNode != null) {
			linkedList.addAtEnd(currentNode.item);
			currentNode = currentNode.next;
		}
		return linkedList;
	}

	/**
	 * problem10( copied from problem10)
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
		linkedList2.addAtEnd(100);
		linkedList2.addAtEnd(100);
		linkedList2.addAtEnd(80);
		linkedList2.addAtEnd(90);
		linkedList2.addAtEnd(90);
		linkedList2.addAtEnd(90);
		linkedList2.addAtEnd(80);
		linkedList2.addAtEnd(60);
		linkedList2.addAtEnd(60);
		linkedList2.addAtEnd(60);
		linkedList2.addAtEnd(50);
		linkedList2.addAtEnd(40);
		linkedList2.addAtEnd(100);
		linkedList2.addAtEnd(50);
		linkedList2.addAtEnd(30);
		linkedList2.addAtEnd(30);
		linkedList2.addAtEnd(70);
		linkedList2.addAtEnd(20);
		linkedList2.addAtEnd(50);
		linkedList2.addAtEnd(50);
		linkedList2.addAtEnd(10);

		System.out.println("Before Merge Sort-->");
		System.out.println(linkedList2.arrrangeList(linkedList2.first));

		System.out.println("After Merge Sort-->");
		LinkedList<Integer> sortedList = linkedList2.arrrangeList(linkedList2
				.mergeSortList(linkedList2.first));
		System.out.println(sortedList);
		sortedList.removeDuplicatesFromSortedLinkedList(sortedList);
		System.out.println("After Removal of Duplicates-->");
		System.out.println(sortedList);
	}
}
