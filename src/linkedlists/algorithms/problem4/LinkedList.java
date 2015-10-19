/**
 * 03-Apr-2015 12:40:31 pm
 * GeekyAlgoJava/linkedlists.algorithms.problem4/LinkedList.java
 * ketandikshit
 * LinkedList
 * 2015
 */
package linkedlists.algorithms.problem4;

import org.junit.Assert;

/**
 * @author ketandikshit
 *         03-Apr-2015 12:40:31 pm
 *         GeekyAlgoJava/linkedlists.algorithms.problem4/LinkedList.java
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
	 * get the count for given item in linkedList
	 * 03-Apr-2015 12:42:59 pm
	 * ketandikshit
	 * 
	 * @param key
	 *            the item whose occurances need to be counted
	 * @return the count of given item in linkedlist
	 */
	public int getKeyCount(Item key) {
		Node currentNode = first;
		int count = 0;

		while (currentNode.next != null) {
			if (currentNode.item == key)
				count++;

			currentNode = currentNode.next;
		}
		return count;
	}

	/**
	 * 03-Apr-2015 12:40:31 pm
	 * ketandikshit
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addAtHead(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(60);
		linkedList.addAtEnd(70);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(100);

		System.out.println(linkedList);
		int keyToSearch = 50;
		int countOfKey = linkedList.getKeyCount(keyToSearch);
		System.out.println("The item-->" + keyToSearch + " occurs-->"
				+ countOfKey + " times");
		Assert.assertEquals(5, countOfKey);
	}

}
