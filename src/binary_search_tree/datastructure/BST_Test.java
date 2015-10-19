/**
 * @createdOn 20-Sep-2015 1:31:22 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.datastructure/BST_Test.java
 * @author ketandikshit
 * @typeName BST_Test
 * @year 2015
 */
package binary_search_tree.datastructure;

import linkedlists.datastructure.queue.Queue;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ketandikshit
 * @createdOn 20-Sep-2015 1:31:22 pm
 * @qualifiedName GeekyAlgoJava/binary_search_tree.datastructure/BST_Test.java
 * @year 2015
 */
public class BST_Test {

	private static final BST<Integer, String> bst = new BST<>();

	/**
	 * @createdOn 20-Sep-2015 1:31:22 pm
	 * @author ketandikshit
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bst.put(0, "Val0");
		bst.put(1, "Val1");
		bst.put(2, "Val2");
		bst.put(3, "Val3");
		bst.put(4, "Val4");
		bst.put(5, "Val5");
		bst.put(6, "Val6");
		bst.put(7, "Val7");
		bst.put(8, "Val8");
		bst.put(9, "Val9");
		bst.put(12, "Val12");
		bst.put(15, "Val15");
		System.out.println(bst);

	}

	/**
	 * Test method for
	 * {@link binary_search_tree.datastructure.BST#get(java.lang.Comparable)}.
	 */
	@Test
	public void testGet() {
		Assert.assertEquals("Val5", bst.get(5));
		Assert.assertEquals("Val7", bst.get(7));
		Assert.assertEquals(null, bst.get(20));
	}

	/**
	 * Test method for
	 * {@link binary_search_tree.datastructure.BST#put(java.lang.Comparable, java.lang.Object)}
	 * .
	 */
	@Test
	public void testPut() {
		bst.put(10, "Val10");
		Assert.assertEquals("Val10", bst.get(10));
		Assert.assertNotEquals(null, bst.get(10));
		bst.delete(10);
	}

	/**
	 * Test method for {@link binary_search_tree.datastructure.BST#min()}.
	 */
	@Test
	public void testMin() {
		bst.put(-1, "TempMinimalValue");
		Assert.assertEquals(Integer.valueOf(-1), bst.min());
		bst.delete(-1);
	}

	/**
	 * Test method for {@link binary_search_tree.datastructure.BST#max()}.
	 */
	@Test
	public void testMax() {
		bst.put(100, "TempMaximalValue");
		Assert.assertEquals(Integer.valueOf(100), bst.max());
		bst.delete(100);
	}

	/**
	 * Test method for
	 * {@link binary_search_tree.datastructure.BST#floor(java.lang.Comparable)}.
	 */
	@Test
	public void testFloor() {
		Assert.assertEquals(Integer.valueOf(9), bst.floor(11));
	}

	/**
	 * Test method for
	 * {@link binary_search_tree.datastructure.BST#ceiling(java.lang.Comparable)}
	 * .
	 */
	@Test
	public void testCeiling() {
		Assert.assertEquals(Integer.valueOf(12), bst.ceiling(11));
	}

	/**
	 * Test method for
	 * {@link binary_search_tree.datastructure.BST#rank(java.lang.Comparable)}.
	 */
	@Test
	public void testRank() {
		Assert.assertEquals(5, bst.rank(5));
	}

	/**
	 * Test method for {@link binary_search_tree.datastructure.BST#deleteMin()}.
	 */
	@Test
	public void testDeleteMin() {
		bst.put(-1, "TempMin");
		Assert.assertEquals(Integer.valueOf(-1), bst.min());
		bst.deleteMin();
		Assert.assertNotEquals(Integer.valueOf(-1), bst.min());
	}

	/**
	 * Test method for {@link binary_search_tree.datastructure.BST#deleteMax()}.
	 */
	@Test
	public void testDeleteMax() {
		bst.put(101, "TempMax");
		Assert.assertEquals(Integer.valueOf(101), bst.max());
		bst.deleteMax();
		Assert.assertNotEquals(Integer.valueOf(101), bst.max());
	}

	/**
	 * Test method for
	 * {@link binary_search_tree.datastructure.BST#delete(java.lang.Comparable)}
	 * .
	 */
	@Test
	public void testDelete() {
		bst.put(11, "TempVal");
		Assert.assertEquals("TempVal", bst.get(11));
		bst.delete(11);
		Assert.assertEquals(null, bst.get(11));
	}

	/**
	 * Test method for {@link binary_search_tree.datastructure.BST#keys()}.
	 */
	@Test
	public void testKeys() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(12);
		queue.enqueue(15);
		Assert.assertEquals(queue, bst.keys());
	}

	/**
	 * Test method for range of keys
	 * {@link binary_search_tree.datastructure.BST#keysRange(java.lang.Comparable, java.lang.Comparable)}
	 * 
	 */
	@Test
	public void testKeysRange() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		Assert.assertEquals(queue, bst.keysRange(4, 8));
	}

}
