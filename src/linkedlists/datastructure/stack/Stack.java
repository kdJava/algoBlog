/**
 * 27-Mar-2015 9:46:58 am
 * GeekyAlgoJava/linkedlists.datastructure/Stack.java
 * ketandikshit
 * Stack
 * 2015
 */
package linkedlists.datastructure.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author ketandikshit 27-Mar-2015 9:46:58 am
 *         GeekyAlgoJava/linkedlists.datastructure/Stack.java 2015
 */
public class Stack<Item> implements Iterable<Item> {

	private Node first;
	private int size;

	/**
	 * Internal Node structure data-model
	 * 
	 * @author ketandikshit
	 * @createdOn 18-Apr-2015 12:04:00 am
	 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem8/Stack.java
	 * @year 2015
	 */
	private class Node {
		Item item;
		Node next;
	}

	/**
	 * 
	 * 27-Mar-2015 9:58:53 am
	 * ketandikshit
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "Stack--> [";
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

	/**
	 * Checks if the stack is currently empty
	 * 
	 * @createdOn 17-Apr-2015 11:59:07 pm
	 * @author ketandikshit
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null; // or size==0;
	}

	/**
	 * Gives the current size of the stack
	 * 
	 * @createdOn 17-Apr-2015 11:59:50 pm
	 * @author ketandikshit
	 * @return the size of the stack
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the element at the top of the stack
	 * ( doesn't removes it)
	 * 
	 * @createdOn 18-Apr-2015 12:00:19 am
	 * @author ketandikshit
	 * @return the element at top of the stack
	 */
	public Item getTopOfStack() {
		return first.item;
	}

	/**
	 * Pushes the given element on top of the stack
	 * 
	 * @createdOn 18-Apr-2015 12:01:20 am
	 * @author ketandikshit
	 * @param item
	 *            the element to be inserted at the top of the stack
	 */
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}

	/**
	 * Removes the element from the top of the stack
	 * 
	 * @createdOn 18-Apr-2015 12:02:38 am
	 * @author ketandikshit
	 * @return the item after removal from the top of the stack
	 */
	public Item pop() {
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}

	/**
	 * 
	 * 27-Mar-2015 9:58:42 am
	 * ketandikshit
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * Implementation of the List based iterator
	 * 
	 * @author ketandikshit
	 * @createdOn 18-Apr-2015 12:03:17 am
	 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem8/Stack.java
	 * @year 2015
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		/**
		 * 
		 * 27-Mar-2015 9:58:28 am
		 * ketandikshit
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		/**
		 * 
		 * 27-Mar-2015 9:58:22 am
		 * ketandikshit
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		/**
		 * 
		 * 27-Mar-2015 9:58:14 am
		 * ketandikshit
		 * 
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new ConcurrentModificationException(
					"ILLEGAL OPERATION ATTEMPTED...remove()");
		}
	}

}
