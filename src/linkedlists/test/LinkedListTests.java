/**
 * 27-Mar-2015 10:35:14 am
 * GeekyAlgoJava/tests.linkedlists/LinkedListTests.java
 * ketandikshit
 * LinkedListTests
 * 2015
 */
package linkedlists.test;

import static org.junit.Assert.assertEquals;
import linkedlists.datastructure.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ketandikshit
 *         27-Mar-2015 10:35:14 am
 *         GeekyAlgoJava/tests.linkedlists/LinkedListTests.java
 *         2015
 */
public class LinkedListTests {

	private static LinkedList<Integer> linkedlist = null;
	/**
	 * 27-Mar-2015 10:35:14 am
	 * setUpBeforeClass
	 * LinkedListTests
	 * ketandikshit
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		linkedlist = new LinkedList<Integer>();
		linkedlist.addAtHead(50);
		linkedlist.addAtHead(40);
		linkedlist.addAtHead(30);
		linkedlist.addAtHead(20);
		linkedlist.addAtHead(10);
		linkedlist.addAtEnd(60);
		linkedlist.addAtEnd(70);
		linkedlist.addAtEnd(80);
		linkedlist.addAtEnd(90);
		linkedlist.addAtEnd(100);
	}

	/**
	 * Test method for
	 * {@link linkedlists.datastructure.LinkedList#addAtHead(java.lang.Object)}.
	 */
	@Test
	public void testAddAtHead() {
		System.out.println("LinkedListTests.testAddAtHead(): Before-->"
				+ linkedlist);
		Integer toAddToHead = new Integer(5);
		linkedlist.addAtHead(toAddToHead);
		System.out.println("LinkedListTests.testAddAtHead(): After-->"
				+ linkedlist);
		assertEquals(toAddToHead, linkedlist.getAtHead());
	}

	/**
	 * Test method for
	 * {@link linkedlists.datastructure.LinkedList#deleteFromHead()}.
	 */
	@Test
	public void testDeleteFromHead() {
		System.out.println("LinkedListTests.testDeleteFromHead(): Before-->"
				+ linkedlist);
		Integer oldHead = linkedlist.getAtHead();
		Integer deletedOne = linkedlist.deleteFromHead();
		System.out.println("LinkedListTests.testDeleteFromHead(): After-->"
				+ linkedlist);
		assertEquals(oldHead, deletedOne);
	}
	/**
	 * Test method for
	 * {@link linkedlists.datastructure.LinkedList#addAtEnd(java.lang.Object)}.
	 */
	@Test
	public void testAddAtEnd() {
		System.out.println("LinkedListTests.testAddAtEnd(): Before-->"
				+ linkedlist);
		Integer toAdd = new Integer(110);
		linkedlist.addAtEnd(toAdd);
		System.out.println("LinkedListTests.testAddAtEnd(): After-->"
				+ linkedlist);
		assertEquals(toAdd, linkedlist.getLast());
	}

	/**
	 * Test method for
	 * {@link linkedlists.datastructure.LinkedList#deleteFromEnd()}.
	 */
	@Test
	public void testDeleteFromEnd() {
		System.out.println("LinkedListTests.testDeleteFromEnd(): Before-->"
				+ linkedlist);
		Integer oldLast = linkedlist.getLast();
		Integer deletedOne = linkedlist.deleteFromEnd();
		System.out.println("LinkedListTests.testDeleteFromEnd(): After-->"
				+ linkedlist);
		assertEquals(oldLast, deletedOne);
	}

	/**
	 * Test method for
	 * {@link linkedlists.datastructure.LinkedList#addAtIndex(java.lang.Object, int)}
	 * .
	 */
	@Test
	public void testAddAtIndex() {
		System.out.println("LinkedListTests.testAddAtIndex(): Before-->"
				+ linkedlist);
		Integer toAdd = new Integer(999);
		linkedlist.addAtIndex(toAdd, 5);
		System.out.println("LinkedListTests.testAddAtIndex(): After-->"
				+ linkedlist);
		assertEquals(toAdd, linkedlist.getItemAtPos(5));
	}

	/**
	 * Test method for
	 * {@link linkedlists.datastructure.LinkedList#deleteFromIndex(int)}.
	 */
	@Test
	public void testDeleteFromIndex() {
		System.out.println("LinkedListTests.testDeleteFromIndex(): Before-->"
				+ linkedlist);
		Integer itemAtPos = linkedlist.getItemAtPos(5);
		Integer deletedOne = linkedlist.deleteFromIndex(5);
		System.out.println("LinkedListTests.testDeleteFromIndex(): After-->"
				+ linkedlist);
		assertEquals(itemAtPos, deletedOne);
	}
}
