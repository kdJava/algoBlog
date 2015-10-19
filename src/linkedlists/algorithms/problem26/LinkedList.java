/**
 * @createdOn 17-Jun-2015 3:12:44 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem26/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem26;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ketandikshit
 * @createdOn 17-Jun-2015 3:12:44 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem26/LinkedList.java
 * @year 2015
 */
public class LinkedList<Item extends Comparable<Item>> {

	private final List<Node> levelList = new ArrayList<>();

	private TreeNode treeRoot;
	private Node first;
	private int size;

	/**
	 * Internal data structure representing the node in linked-list
	 * 
	 * @author ketandikshit
	 * @year 2015
	 */
	private class Node {
		private int item;
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
	public void addAtHead(int item) {
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
	public void addAtEnd(int item) {
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
	public void addItem(int item) {
		if (size == 0) {
			addAtHead(item);
		} else {
			addAtEnd(item);
		}
	}

	public void levelOrder(TreeNode root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printLevels(root, i);
			System.out.println("");
		}
	}

	public void printLevels(TreeNode root, int h) {
		if (root == null)
			return;
		if (h == 1)
			System.out.print(" " + root.data);
		else {
			printLevels(root.left, h - 1);
			printLevels(root.right, h - 1);
		}
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public void levelOrderQueue(TreeNode root) {
		Queue<TreeNode> queue = new java.util.LinkedList<>();
		int levelNodes = 0;
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			levelNodes = queue.size();
			Node head = null;
			Node curr = null;
			while (levelNodes > 0) {
				TreeNode treeNode = queue.remove();
				Node lvlNod = new Node();
				lvlNod.item = treeNode.data;
				if (head == null) {
					head = lvlNod;
					curr = lvlNod;
				} else {
					curr.next = lvlNod;
					curr = curr.next;
				}
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
				levelNodes--;
			}
			levelList.add(head);
		}
		display(levelList);
	}

	public void display(List<Node> levelList) {
		for (Node linkedList : levelList) {
			printListAtLevel(linkedList);
		}
	}

	private void printListAtLevel(Node head) {
		Node currentNode = head;
		System.out.println();
		while (currentNode != null) {
			System.out.print(currentNode.item + "-->");
		}
	}

	class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private TreeNode generateTree(int depth) {
		if (depth < 0)
			return null;
		TreeNode currentNode = new TreeNode(depth);
		if (depth > 0) {
			currentNode.left = generateTree(depth - 1);
			currentNode.right = generateTree(depth - 1);
		}
		return currentNode;
	}

	public TreeNode printTreeInorder(TreeNode root) {
		if (root != null) {
			printTreeInorder(root.left);
			System.out.print("   " + root.data);
			printTreeInorder(root.right);
		}
		return root;
	}

	public static void main(String[] args) throws java.lang.Exception {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.levelOrderQueue(test.printTreeInorder(test.generateTree(4)));
	}
}
