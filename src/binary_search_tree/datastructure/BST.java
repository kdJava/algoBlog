/**
 * @createdOn 22-Jun-2015 4:34:44 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.datastructure/BST.java
 * @author ketandikshit
 * @typeName BST
 * @year 2015
 */
package binary_search_tree.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import linkedlists.datastructure.queue.Queue;
import linkedlists.datastructure.stack.Stack;

/**
 * This implementation of the ordered symbol-table API uses a binary search tree
 * built from Node objects that contain a Key,associated value,two links,and a
 * node count N; Each Node is the root of the subtree containing N nodes, with
 * its left link pointing to the Node that is the root of the subtree with
 * smaller keys and its right link pointing to the Node that is the root of the
 * subtree with larger keys. The instance variable root points to the Node at
 * the root of the BST.
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

		/**
		 * @createdOn 20-Sep-2015 1:25:47 pm
		 * @author ketandikshit
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "[key:" + key + "][val:" + value + "][left:" + left.key
					+ "][right:" + right.key + "]";
		}
	}

	/**
	 * @createdOn 20-Sep-2015 1:34:50 pm
	 * @author ketandikshit
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sbuf = new StringBuffer();
		Iterator<Key> iter = this.iterator();
		while (iter.hasNext()) {
			sbuf.append(iter.next() + "-->");
		}
		sbuf.append("null");
		return sbuf.toString();
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

	/**
	 * Get the value corresponding to the given key from the BST
	 * 
	 * @createdOn 08-Jul-2015 8:44:34 am
	 * @author ketandikshit
	 * @param key
	 *            key to search for
	 * @return the value corresponding to the given key
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);

		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return node.value;
		}
	}

	/**
	 * Insert the given key-value pair in the BST
	 * 
	 * @createdOn 08-Jul-2015 8:45:45 am
	 * @author ketandikshit
	 * @param key
	 *            key to be inserted
	 * @param val
	 *            value corresponding to the key
	 */
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node node, Key key, Value val) {
		if (node == null) {
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = put(node.left, key, val);
		} else if (cmp > 0) {
			node.right = put(node.right, key, val);
		} else {
			node.key = key;
			node.value = val;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	/**
	 * Get the minimum element of the BST
	 * 
	 * @createdOn 08-Jul-2015 8:47:06 am
	 * @author ketandikshit
	 * @return the minimum element of the BST
	 */
	public Key min() {
		return min(root).key;
	}

	private Node min(Node node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	/**
	 * Find the maximum element of the BST
	 * 
	 * @createdOn 08-Jul-2015 8:49:31 am
	 * @author ketandikshit
	 * @return the maximum element of the BST
	 */
	public Key max() {
		return max(root).key;
	}

	private Node max(Node node) {
		if (node.right == null) {
			return node;
		}
		return max(node.right);
	}

	public Key floor(Key key) {
		Node node = floor(root, key);
		if (node == null) {
			return null;
		}
		return node.key;
	}

	private Node floor(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		}
		if (cmp < 0) {
			return floor(node.left, key);
		}
		Node temp = floor(node.right, key);
		if (temp != null) {
			return temp;
		} else {
			return node;
		}
	}

	public Key ceiling(Key key) {
		Node node = ceiling(root, key);
		if (node == null) {
			return null;
		}
		return node.key;
	}

	private Node ceiling(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		}
		if (cmp > 0) {
			return ceiling(node.right, key);
		}
		Node temp = ceiling(node.left, key);
		if (temp != null) {
			return temp;
		} else {
			return node;
		}
	}

	public Key select(int k) {
		return select(root, k).key;
	}

	private Node select(Node node, int k) {
		// Return node containing key of rank 'k'
		if (node == null) {
			return null;
		}
		int leftSubTreeSize = size(node.left);
		if (leftSubTreeSize > k) {
			return select(node.left, k);
		} else if (leftSubTreeSize < k) {
			return select(node.right, k - leftSubTreeSize - 1);
		} else {
			return node;
		}
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node node) {
		// return number of keys less than node.key in the subtree rooted at
		// node
		if (node == null) {
			return 0;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return rank(key, node.left);
		} else if (cmp > 0) {
			return (1 + size(node.left) + rank(key, node.right));
		} else {
			return size(node.left);
		}
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = delete(node.left, key);
		} else if (cmp > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.right == null) {
				return node.left;
			}
			if (node.left == null) {
				return node.right;
			}
			Node temp = node;
			node = min(temp.right);
			node.right = deleteMin(temp.right);
			node.left = temp.left;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	List<Key> inOrderSequence = new ArrayList<>();

	private List<Key> inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			inOrderSequence.add(root.key);
			inOrder(root.right);
		}
		return inOrderSequence;
	}

	List<Key> postOrderSequence = new ArrayList<>();

	private List<Key> postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			postOrderSequence.add(root.key);
		}
		return postOrderSequence;
	}

	List<Key> preOrderSequence = new ArrayList<>();

	private List<Key> preOrder(Node root) {
		if (root != null) {
			preOrderSequence.add(root.key);
			preOrder(root.left);
			preOrder(root.right);
		}
		return preOrderSequence;
	}

	public List<Key> inOrder() {
		return inOrder(root);
	}

	public List<Key> postOrder() {
		return postOrder(root);
	}

	public List<Key> preOrder() {
		return preOrder(root);
	}

	public void printInOrder(String ascOrDesc) {
		if (ascOrDesc.equalsIgnoreCase("DESC")) {
			printDesc(root);
		} else {
			printAsc(root);
		}
	}

	private void printAsc(Node node) {
		if (node == null) {
			return;
		}
		printAsc(node.left);
		System.out.print(node.key);
		printAsc(node.right);
	}

	private void printDesc(Node node) {
		if (node == null) {
			return;
		}
		printDesc(node.right);
		System.out.print(node.key);
		printDesc(node.left);
	}

	public Iterable<Key> keys() {
		return keysRange(min(), max());
	}

	public Iterable<Key> keysRange(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
		if (node == null) {
			return;
		}
		int cmplo = lo.compareTo(node.key);
		int cmphi = hi.compareTo(node.key);
		if (cmplo < 0) {
			keys(node.left, queue, lo, hi);
		}
		if ((cmplo <= 0) && (cmphi >= 0)) {
			queue.enqueue(node.key);
		}
		if (cmphi > 0) {
			keys(node.right, queue, lo, hi);
		}
	}

	public void putAllKeys(Map<Key, Value> keys) {
		for (Entry<Key, Value> entry : keys.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	/***********************************************************************
	 * Iterate using an inorder traversal. Implement with a stack. Iterating
	 * through N elements takes O(N) time.
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
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
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
