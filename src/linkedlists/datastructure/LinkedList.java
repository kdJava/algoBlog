package linkedlists.datastructure;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

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

	public Item getAtHead() {
		return first.item;
	}

	public Item getLast() {
		Node currentNode = first;
		// Lets get the lastNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}

		return currentNode.item;
	}

	public Item getItemAtPos(int pos) {
		int count = 0;
		Node currentNode = first; // Maintain currentNode's address

		while (count < pos) {
			currentNode = currentNode.next;
			count++;
		}

		return currentNode.item;
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
	 * Delete the first element in linked-list
	 * 
	 * @return item deleted from list
	 */
	public Item deleteFromHead() {
		// Check for underflow: Nothing to delete
		if (isEmpty()) {
			return null;
		}

		Node oldFirst = first;
		first = oldFirst.next;
		size--;
		return oldFirst.item;
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
	 * Delete the last element in linked-list
	 * 
	 * @return the item deleted
	 */
	public Item deleteFromEnd() {
		// Check for underflow: Nothing to delete
		if (isEmpty()) {
			return null;
		}

		Node currentNode = first;
		Node prevToLast = null;
		// Lets get the lastNode;
		while (currentNode.next != null) {
			prevToLast = currentNode;
			currentNode = currentNode.next;
		}

		prevToLast.next = null; // set the second last node's next to null
		size--; // decrement the size
		return currentNode.item; // return the deleted node's item
	}

	/**
	 * Add the item to 'k'th position in linked-list
	 * 
	 * @param item
	 *            item to to be added
	 */
	public void addAtIndex(Item item, int pos) {
		// Check for invalid position
		if ((pos > size) || (pos < 1)) {
			System.out.println("Cannot add the item-->" + "item at pos-->"
					+ pos
					+ " as the current-size of the linked-list is only-->"
					+ size);
			return;
		}

		// Check for only one element in linkedList
		if (pos == 1) {
			addAtHead(item);
			return;
		}

		Node newNode = new Node(); // Create new node to insert
		newNode.item = item; // Set newNode's element to item to to be inserted
		int count = 0;
		Node currentNode = first; // Maintain currentNode's address
		Node prevNode = null; // Maintain address to prevNode to the currentNode
								// as well

		// Lets find the kth Node
		while (count < pos) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			count++;
		}

		prevNode.next = newNode; // Set prevNode's next to newNode
		newNode.next = currentNode; // Set newNode's next to currentNode at 'k'
									// pos
		size++; // increment the size
	}

	/**
	 * 
	 * 30-Mar-2015 10:59:15 pm
	 * ketandikshit
	 * 
	 * @param pos
	 *            position from which the element neeeds to be deleted
	 * @return Item deleted from position
	 */
	public Item deleteFromIndex(int pos) {
		// Check for invalid position
		if ((pos > size) || (pos < 1)) {
			System.out.println("Cannot add the item-->" + "item at pos-->"
					+ pos
					+ " as the current-size of the linked-list is only-->"
					+ size);
			return null;
		}

		// Check for only one element in linkedList
		if (pos == 1) {
			return deleteFromEnd();
		}

		int count = 0;
		Node currentNode = first; // Maintain currentNode's address
		Node prevNode = null; // Maintain address to prevNode to the currentNode
								// as well

		// Lets find the kth Node
		while (count < pos) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			count++;
		}

		prevNode.next = currentNode.next; // Set next of (k-1)th Node to (k+1)th
											// node, So that deletes the 'k'th
											// node
		size--; // decrement the size
		return currentNode.item; // return the deleted node's item
	}

	/*
	 * *********************************************************
	 * Iterator Implementation
	 * *********************************************************
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		@Override
		public void remove() {
			throw new ConcurrentModificationException(
					"ILLEGAL OPERATION ATTEMPTED: remove() is not allowed.!!");
		}
	}

	/*
	 * ***********************************************************
	 */
}
