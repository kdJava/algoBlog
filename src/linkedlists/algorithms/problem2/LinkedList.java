/**
 * 30-Mar-2015 11:47:07 pm
 * GeeksForGeeks/linkedlists.algorithms/Problem2.java
 * ketandikshit
 * Problem2
 * 2015
 */
package linkedlists.algorithms.problem2;

import java.util.Random;

/**
 * @author ketandikshit
 *         30-Mar-2015 11:47:07 pm
 *         GeeksForGeeks/linkedlists.algorithms/Problem2.java
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
	 * Problem2
	 * 30-Mar-2015 11:30:35 pm
	 * ketandikshit
	 * 
	 * @param linkedList
	 *            linked-list instance
	 * @param nodeToBeDeleted
	 *            the node to be deleted
	 * @return the deleted node item after deletion
	 */
	private Node deleteThePointingNode(Node nodeToBeDeleted) {
		// Keep the copy of the node to be deleted
		Node nodeToDel = new Node();
		nodeToDel.item = nodeToBeDeleted.item;
		nodeToDel.next = nodeToBeDeleted.next;

		// Swap the nodeToDelete with the next Node
		Node nextNode = nodeToBeDeleted.next;
		nodeToBeDeleted.item = nextNode.item;
		nodeToBeDeleted.next = nextNode.next;
		size--;
		return nodeToDel;
	}

	/**
	 * SetupHelper for Problem2
	 * 03-Apr-2015 12:15:28 pm
	 * ketandikshit
	 * 
	 * @param linkedList
	 *            linkedlistInstance
	 * @return Item deleted at pos k
	 */
	public Item deleteThePointingNode() {
		Random random = new Random();
		int randomVar = random.nextInt(size);

		int count = 0;
		Node currentNode = first;
		while (count < randomVar) {
			currentNode = currentNode.next;
			count++;
		}
		System.out.println("Randomized Node selected at pos-->" + count
				+ " has Value-->" + currentNode.item);
		return deleteThePointingNode(currentNode).item;
	}

	/**
	 * 30-Mar-2015 11:47:07 pm
	 * ketandikshit
	 * 
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

		System.out.println("Original:" + linkedList);
		int itemDeleted = linkedList.deleteThePointingNode();
		System.out.println("After Deletion:" + linkedList);
		System.out.println("Deleted Element from List-->" + itemDeleted);

	}

}
