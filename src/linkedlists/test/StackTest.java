/**
 * 28-Mar-2015 2:56:44 pm
 * GeekyAlgoJava/tests.stacks/StackTest.java
 * ketandikshit
 * StackTest
 * 2015
 */
package linkedlists.test;

import static org.junit.Assert.assertEquals;
import linkedlists.datastructure.stack.Stack;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ketandikshit
 *         28-Mar-2015 2:56:44 pm
 *         GeekyAlgoJava/tests.stacks/StackTest.java
 *         2015
 */
public class StackTest {

	static Stack<Integer> stack = null;

	/**
	 * 28-Mar-2015 2:56:44 pm
	 * setUpBeforeClass
	 * StackTest
	 * ketandikshit
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stack = new Stack<Integer>();
		stack.push(50);
		stack.push(40);
		stack.push(30);
		stack.push(20);
		stack.push(10);
	}

	/**
	 * Test method for {@link linkedlists.datastructure.Stack#getSize()}.
	 */
	@Test
	public void testGetSize() {
		System.out.println("StackTest.testGetSize(): Before-->" + stack
				+ " has Size=" + stack.getSize());
		int oldSize = stack.getSize();
		stack.push(75);
		stack.push(85);
		int expectedSize = oldSize + 2;
		System.out.println("StackTest.testGetSize(): After-->" + stack
				+ " has Size=" + stack.getSize());
		assertEquals(expectedSize, stack.getSize());
	}
	/**
	 * Test method for
	 * {@link linkedlists.datastructure.Stack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		System.out.println("StackTest.testPush(): Before-->" + stack);
		Integer toPush = new Integer(999);
		stack.push(toPush);
		System.out.println("StackTest.testPush(): After-->" + stack);
		assertEquals(toPush, stack.getTopOfStack());
	}

	/**
	 * Test method for {@link linkedlists.datastructure.Stack#pop()}.
	 */
	@Test
	public void testPop() {
		System.out.println("StackTest.testPop(): Before-->" + stack);
		Integer expectedDeleted = stack.getTopOfStack();
		Integer deletedOne = stack.pop();
		System.out.println("StackTest.testPop(): After-->" + stack);
		assertEquals(expectedDeleted, deletedOne);
	}

}
