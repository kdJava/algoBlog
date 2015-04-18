/**
 * 30-Mar-2015 11:17:08 am
 * GeeksForGeeks/linkedlists.algorithms/Problem1.java
 * ketandikshit
 * Problem1
 * 2015
 */
package linkedlists.algorithms.problem1;

/**
 * @author ketandikshit
 *         30-Mar-2015 11:17:08 am
 *         GeeksForGeeks/linkedlists.algorithms/Problem1.java
 *         2015
 */
public class LinkedList<Item> {

	private Node first;
	private int size;

	private class Node {
		private Item item;
		private Node next;
	}

	@Override
	public String toString() {
		String result = "LinkedList--> [";
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
	 * getKthElementFromLast using size
	 * 30-Mar-2015 11:00:25 pm
	 * ketandikshit
	 * 
	 * @param linkedList
	 *            the linked-list instance
	 * @param k
	 *            the 'k'th position from last
	 * @return the item at kth position from last
	 */
	public Item getKthElementFromLast(int k) {
		int countFromHead = getSize() - k;
		int count = 0;
		Node currentNode = first;
		while (count < countFromHead) {
			currentNode = currentNode.next;
			count++;
		}
		return currentNode.item;
	}

	/**
	 * getKthElementFromLast without using size
	 * 30-Mar-2015 11:00:25 pm
	 * ketandikshit
	 * 
	 * @param linkedList
	 *            the linked-list instance
	 * @param k
	 *            the 'k'th position from last
	 * @return the item at kth position from last
	 */
	public Item getKthElementFromLastWithoutSize(int k) {
		int count = 0;
		Node pointer1 = first;
		Node pointer2 = first;

		while (count < (k - 1)) {
			pointer1 = pointer1.next;
			count++;
		}

		while (pointer1.next != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer2.item;
	}

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
		int kthPosFromLast = 5;
		int kthItemFromLast = linkedList.getKthElementFromLast(kthPosFromLast);
		System.out.println("Kth Element from Last-->" + kthItemFromLast);
		int kthItemFromLastAgain = linkedList
				.getKthElementFromLastWithoutSize(kthPosFromLast);
		System.out.println("Keth Element from last again-->"
				+ kthItemFromLastAgain);
	}
}
