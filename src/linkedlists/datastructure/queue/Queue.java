/**
 * 27-Mar-2015 10:27:08 am
 * GeeksForGeeks/linkedlists.datastructure/Queue.java
 * ketandikshit
 * Queue
 * 2015
 */
package linkedlists.datastructure.queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author ketandikshit
 *         27-Mar-2015 10:27:08 am
 *         GeeksForGeeks/linkedlists.datastructure/Queue.java
 *         2015
 */
public class Queue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		Item item;
		Node next;
	}

	/**
	 * 
	 * 27-Mar-2015 27-Mar-2015
	 * ketandikshit
	 * toString
	 * 
	 * @see @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "QUEUE--> [";
		int counter = 0;
		for (Node i = first; i != null; i = i.next) {
			if (counter == size - 1) {
				result += i.item + "]";
			} else {
				result += i.item + ", ";
			}
			counter++;
		}
		return result;
	}

	public boolean isEmpty() {
		return (first == null); // Or size==0;
	}

	public int getSize() {
		return size;
	}

	public Item getHead() {
		return first.item;
	}

	public Item getTail() {
		return last.item;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty())
			first = last;
		else
			oldLast.next = last;

		size++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;

		if (isEmpty())
			last = null;

		size--;
		return item;
	}

	/**
	 * 
	 * 27-Mar-2015 27-Mar-2015
	 * ketandikshit
	 * iterator
	 * 
	 * @see @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		/**
		 * 
		 * 27-Mar-2015 27-Mar-2015
		 * ketandikshit
		 * hasNext
		 * 
		 * @see @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		/**
		 * 
		 * 27-Mar-2015 27-Mar-2015
		 * ketandikshit
		 * next
		 * 
		 * @see @see java.util.Iterator#next()
		 */
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		/**
		 * 
		 * 27-Mar-2015 27-Mar-2015
		 * ketandikshit
		 * remove
		 * 
		 * @see @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new ConcurrentModificationException(
					"ILLEGAL OPERATION ATTEMPTED...remove()");
		}
	}

}
