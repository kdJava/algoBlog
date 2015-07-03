/**
 * @createdOn 15-Jun-2015 3:17:27 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem25/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem25;

/**
 * @author ketandikshit
 * @createdOn 15-Jun-2015 3:17:27 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem25/LinkedList.java
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
	 * helper utility to insert the item into the linkedlist
	 * 
	 * @author ketandikshit
	 * @param item
	 *            the item to be inserted
	 */
	public void addItem(Item item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	public BSTNode LLToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		BSTNode leftChild = LLToBST(start, mid - 1);
		BSTNode root = new BSTNode(first.item);
		root.left = leftChild;
		first = first.next;
		root.right = LLToBST(mid + 1, end);
		return root;
	}

	public void inorder(BSTNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print("   " + root.item);
			inorder(root.right);
		}
	}

	class BSTNode {
		Item item;
		BSTNode left;
		BSTNode right;

		BSTNode(Item item) {
			this.item = item;
			left = null;
			right = null;
		}

		/**
		 * @createdOn 15-Jun-2015 3:23:50 pm
		 * @author ketandikshit
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "BSTNode [item=" + item + ", left=" + left.item + ", right="
					+ right.item + "]";
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addItem(10);
		linkedList.addItem(20);
		linkedList.addItem(30);
		linkedList.addItem(40);
		linkedList.addItem(50);
		linkedList.addItem(60);
		linkedList.addItem(70);
		linkedList.addItem(80);
		linkedList.addItem(90);
		linkedList.addItem(100);

		System.out.println("LinkedList-->" + linkedList);
		System.out.println("Tree is-->");
		linkedList.inorder(linkedList.LLToBST(1, linkedList.size));

	}
}
