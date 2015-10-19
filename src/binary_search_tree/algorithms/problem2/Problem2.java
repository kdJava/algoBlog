/**
 * @createdOn 02-Oct-2015 3:10:01 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.algorithms.problem2/BST.java
 * @author ketandikshit
 * @typeName BST
 * @year 2015
 */
package binary_search_tree.algorithms.problem2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import binary_search_tree.datastructure.BST;

/**
 * @author ketandikshit
 * @createdOn 02-Oct-2015 3:10:01 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.algorithms.problem2/BST.java
 * @year 2015
 */
public class Problem2 {

	/**
	 * A simple way is to one by once search every node of first tree in second
	 * tree. Time complexity of this solution is O(m * h) where m is number of
	 * nodes in first tree and h is height of second tree.
	 * 
	 * @createdOn 02-Oct-2015 3:33:41 pm
	 * @author ketandikshit
	 * @param root1
	 *            root for tree1
	 * @param root2
	 *            root for tree2
	 */
	public void printCommonNodesMethod1(BST<Integer, String> bst1,
			BST<Integer, String> bst2) {
		List<Integer> bst1InOrder = bst1.inOrder();
		List<Integer> bst2InOrder = bst2.inOrder();
		Set<Integer> commonKeys = new HashSet<Integer>();

		for (Integer bst1Key : bst1InOrder) {
			for (Integer bst2Key : bst2InOrder) {
				if (bst1Key.equals(bst2Key)) {
					commonKeys.add(bst2Key);
				}
			}
		}
		System.out.println("Common Nodes-->" + commonKeys);
	}

	/**
	 * @createdOn 02-Oct-2015 3:10:01 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		BST<Integer, String> bst1 = new BST<Integer, String>();
		BST<Integer, String> bst2 = new BST<Integer, String>();

		Map<Integer, String> mapForBST1 = new HashMap<>();
		mapForBST1.put(10, "Val10");
		mapForBST1.put(20, "Val20");
		mapForBST1.put(30, "Val30");
		mapForBST1.put(40, "Val40");
		mapForBST1.put(50, "Val50");
		mapForBST1.put(60, "Val60");
		mapForBST1.put(70, "Val70");
		mapForBST1.put(80, "Val80");
		mapForBST1.put(90, "Val90");
		bst1.putAllKeys(mapForBST1);

		Map<Integer, String> mapForBST2 = new HashMap<>();
		mapForBST2.put(5, "Val5");
		mapForBST2.put(20, "Val20");
		mapForBST2.put(35, "Val35");
		mapForBST2.put(40, "Val40");
		mapForBST2.put(55, "Val55");
		mapForBST2.put(60, "Val60");
		mapForBST2.put(75, "Val75");
		mapForBST2.put(80, "Val80");
		mapForBST2.put(95, "Val95");
		bst2.putAllKeys(mapForBST2);

		Problem2 problem2 = new Problem2();
		problem2.printCommonNodesMethod1(bst1, bst2);
	}

}
