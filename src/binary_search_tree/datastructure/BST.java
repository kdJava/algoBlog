/**
 * @createdOn 22-Jun-2015 4:34:44 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.datastructure/BST.java
 * @author ketandikshit
 * @typeName BST
 * @year 2015
 */
package binary_search_tree.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import linkedlists.datastructure.stack.Stack;

/**
 * This implementation of the ordered symbol-table API uses a binary search tree
 * built from Node objects that contain a Key,associated value,two links,and a
 * node count N;
 * Each Node is the root of the subtree containing N nodes, with its left link
 * pointing to the Node that is the root of the subtree with smaller keys and
 * its right link pointing to the Node that is the root of the subtree with
 * larger keys.
 * The instance variable root points to the Node at the root of the BST.
 * 
 * @author ketandikshit
 * @createdOn 22-Jun-2015 4:34:44 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.datastructure/BST.java
 * @year 2015
 */
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

	private Node root;

	/**
	 * Represents the node in the tree
	 * 
	 * @author ketandikshit
	 * @createdOn 22-Jun-2015 4:44:09 pm
	 * @qualifiedName GeekyAlgoJava/binary_search_tree.datastructure/BST.java
	 * @year 2015
	 */
	private class Node {
		private Key key; // Key
		private Value value; // associated Value
		private Node left, right;// links to left and right subtrees
		private int N; // #nodes in subtree rooted here

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	/**
	 * returns the size of the tree
	 * 
	 * @createdOn 22-Jun-2015 4:46:42 pm
	 * @author ketandikshit
	 * @return the integer representing the size of the tree
	 */
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.N;
		}
	}

	/***********************************************************************
	 * Iterate using an inorder traversal. Implement with a stack.
	 * Iterating through N elements takes O(N) time.
	 ***********************************************************************/
	@Override
	public Iterator<Key> iterator() {
		return new Inorder();
	}

	// an iterator implementation for in-order traversal
	private class Inorder implements Iterator<Key> {
		private Stack<Node> stack = new Stack<Node>();

		Inorder() {
			pushLeft(root);
		}

		// don't implement remove() - it's optional and would mutate the BST
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Key next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node x = stack.pop();
			pushLeft(x.right);
			return x.key;
		}

		public void pushLeft(Node x) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
		}

	}

}
