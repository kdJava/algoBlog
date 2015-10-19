/**
 * 02-Apr-2015 12:47:17 pm
 * GeekyAlgoJava/binary_search_tree.alogorithms/Problem1.java
 * ketandikshit
 * Problem1
 * 2015
 */
package binary_search_tree.algorithms.problem1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * @author ketandikshit 02-Apr-2015 12:47:17 pm
 *         GeekyAlgoJava/binary_search_tree.alogorithms/Problem1.java 2015
 */
public class BST<Item extends Comparable<Item>> {

	private class Node {
		Item item;
		private Node left;
		private Node right;
	}

	StringBuilder stringBuilder = new StringBuilder();

	private String inOrder(Node node) {
		if (node == null) {
			return stringBuilder.toString();
		} else {
			inOrder(node.left);
			stringBuilder.append(node.item + "-->");
			inOrder(node.right);
		}
		return stringBuilder.toString();
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
			/* do the subtrees */
			mirror(node.left);
			mirror(node.right);

			/* swap the pointers in this node */
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
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
		for (int i = 0; i <= 6; i++) {
			nodesList.add(i);
		}

		@SuppressWarnings("unchecked")
		Node root = createTree((List<Item>) nodesList);

		String inOrderTraversalPrev = inOrder(root);
		/* Print inorder traversal of the input tree */
		System.out.println("\n Inorder traversal of the constructed tree is: "
				+ inOrderTraversalPrev);
		Assert.assertTrue("3-->1-->4-->0-->5-->2-->6-->"
				.equals(inOrderTraversalPrev));
		stringBuilder = new StringBuilder();
		/* Convert tree to its mirror */
		mirror(root);
		String inOrderTraversalMirror = inOrder(root);
		/* Print inorder traversal of the mirror tree */
		System.out.println("\n Inorder traversal of the mirror tree is: "
				+ inOrderTraversalMirror);
		Assert.assertTrue("6-->2-->5-->0-->4-->1-->3-->"
				.equals(inOrderTraversalMirror));
	}

	/**
	 * 02-Apr-2015 12:47:18 pm ketandikshit
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BST<Integer> problem = new BST<Integer>();
		problem.test();
	}
}
