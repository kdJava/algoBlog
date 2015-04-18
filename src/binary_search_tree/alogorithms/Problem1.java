/**
 * 02-Apr-2015 12:47:17 pm
 * GeeksForGeeks/binary_search_tree.alogorithms/Problem1.java
 * ketandikshit
 * Problem1
 * 2015
 */
package binary_search_tree.alogorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ketandikshit
 *         02-Apr-2015 12:47:17 pm
 *         GeeksForGeeks/binary_search_tree.alogorithms/Problem1.java
 *         2015
 */
public class Problem1<Item> {

	private class Node {
		Item item;
		private Node left;
		private Node right;
	}

	private Node createNewNode(Item item) {
		Node node = new Node();
		node.item = item;
		node.left = null;
		node.right = null;

		return node;
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		} else {
			Node temp = null;
			/* do the subtrees */
			mirror(node.left);
			mirror(node.right);

			/* swap the pointers in this node */
			temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	void inOrder(Node node) {
		if (node == null) {
			return;
		} else {
			inOrder(node.left);
			System.out.println(node.item);
			inOrder(node.right);
		}
	}

	private Node createTree(List<Item> nodesList) {

		Node root = createNewNode(nodesList.get(0));
		root.left = createNewNode(nodesList.get(1));
		root.right = createNewNode(nodesList.get(2));
		root.left.left = createNewNode(nodesList.get(3));
		root.left.right = createNewNode(nodesList.get(4));
		root.right.left = createNewNode(nodesList.get(5));
		root.right.right = createNewNode(nodesList.get(6));
		return root;
	}

	private void test() {
		List<Integer> nodesList = new ArrayList<>(5);
		for (int i = 1; i <= 7; i++) {
			nodesList.add(i);
		}

		@SuppressWarnings("unchecked")
		Node root = createTree((List<Item>) nodesList);

		/* Print inorder traversal of the input tree */
		System.out
				.println("\n Inorder traversal of the constructed tree is \n");
		inOrder(root);

		/* Convert tree to its mirror */
		mirror(root);

		/* Print inorder traversal of the mirror tree */
		System.out.println("\n Inorder traversal of the mirror tree is \n");
		inOrder(root);
	}

	/**
	 * 02-Apr-2015 12:47:18 pm
	 * ketandikshit
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Problem1<Integer> problem = new Problem1<Integer>();
		problem.test();
	}
}
