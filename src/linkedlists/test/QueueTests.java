/**
 * 28-Mar-2015 3:36:32 pm
 * GeeksForGeeks/tests.queues/QueueTests.java
 * ketandikshit
 * QueueTests
 * 2015
 */
package linkedlists.test;

import static org.junit.Assert.assertEquals;
import linkedlists.datastructure.queue.Queue;

import org.junit.BeforeClass;
import org.junit.Test;
;

/**
 * @author ketandikshit
 *         28-Mar-2015 3:36:32 pm
 *         GeeksForGeeks/tests.queues/QueueTests.java
 *         2015
 */
public class QueueTests {

	static Queue<Integer> queue = null;
	/**
	 * 28-Mar-2015 3:36:32 pm
	 * setUpBeforeClass
	 * QueueTests
	 * ketandikshit
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
	}

	/**
	 * Test method for {@link linkedlists.datastructure.Queue#getSize()}.
	 */
	@Test
	public void testGetSize() {
		System.out.println("QueueTests.testGetSize(): Before-->" + queue);
		int oldSize = queue.getSize();
		queue.enqueue(999);
		queue.enqueue(888);
		int expectedNewSize = oldSize + 2;
		System.out.println("QueueTests.testGetSize(): After-->" + queue);
		assertEquals(expectedNewSize, queue.getSize());
	}

	/**
	 * Test method for
	 * {@link linkedlists.datastructure.Queue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueue() {
		System.out.println("QueueTests.testEnqueue(): Before-->" + queue);
		Integer toAdd = new Integer(1001);
		queue.enqueue(toAdd);
		System.out.println("QueueTests.testEnqueue(): After-->" + queue);
		assertEquals(toAdd, queue.getTail());

	}

	/**
	 * Test method for {@link linkedlists.datastructure.Queue#dequeue()}.
	 */
	@Test
	public void testDequeue() {
		System.out.println("QueueTests.testDequeue(): Before-->" + queue);
		Integer toDelete = queue.getHead();
		Integer deleted = queue.dequeue();
		System.out.println("QueueTests.testDequeue(): After-->" + queue);
		assertEquals(toDelete, deleted);

	}

}
