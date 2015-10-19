/**
 * 04-Apr-2015 1:25:28 pm
 * GeekyAlgoJava/linkedlists.algorithms.problem6/LinkledList.java
 * ketandikshit
 * LinkledList
 * 2015
 */
package linkedlists.algorithms.problem6;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ketandikshit
 *         04-Apr-2015 1:25:28 pm
 *         GeekyAlgoJava/linkedlists.algorithms.problem6/LinkledList.java
 *         2015
 */
public class LinkedList<Item> {

	private Node first;
	private int size;

	private class Node {
		private Item item;
		private Node next;
		private boolean visited;
	}

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
	public void addAtHead(Item item) {
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
	public void addAtEnd(Item item) {
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
	 * Creates the cycle in linkedlist
	 * 04-Apr-2015 1:56:43 pm
	 * ketandikshit
	 * 
	 * @param atNode
	 *            node at which the cycle needs to created
	 * @param size
	 *            the size of the cycle
	 */
	public void createLoop(Item atNode, int size) {
		Node fromNode = null;
		Node toNode = null;

		Node currentNode = first;

		while (currentNode.next != null) {
			if (currentNode.item == atNode) {
				fromNode = currentNode;
			}
			currentNode = currentNode.next;
		}

		if (fromNode != null) {
			currentNode = fromNode;
			int count = 0;
			while (count < size) {
				currentNode = currentNode.next;
				count++;
			}

			toNode = currentNode;
			toNode.next = fromNode;
		}

		System.out.println("-----Cycle created(Sorry Can't print it !!)-----");
	}

	/**
	 * Detects the loop in linkedlist using the hashing technique to keep track
	 * of the visited nodes
	 * 04-Apr-2015 2:00:29 pm
	 * ketandikshit
	 */
	public void detectTheLoopWithHashing() {
		Set<Item> itemsVisited = new HashSet<Item>();

		Node currentNode = first;

		while (currentNode.next != null) {
			if (itemsVisited.contains(currentNode.item)) {
				System.out.println("Loop found at Node-->" + currentNode.item);
				break;
			} else {
				itemsVisited.add(currentNode.item);
				currentNode = currentNode.next;
			}
		}
	}

	/**
	 * Detects the loop in linkedlist by changing the node structure of
	 * linkedlist, having a boolean field "visited" to keep track if the node
	 * was previously visited or not
	 * 04-Apr-2015 2:01:10 pm
	 * ketandikshit
	 */
	public void detectTheLoopWithExtraVisitedFieldPerNode() {

		Node currentNode = first;

		while (currentNode.next != null) {
			if (currentNode.visited) {
				System.out.println("Loop found at Node-->" + currentNode.item);
				break;
			} else {
				currentNode.visited = true;
				currentNode = currentNode.next;
			}
		}
	}

	/**
	 * Detect the cycle in loop using Floyd's cycle detection algo
	 * Tortoise and Hare pointer mechanics ;)
	 * 04-Apr-2015 5:33:48 pm
	 * ketandikshit
	 * 
	 * @return true if cycle exists false otherwise
	 */
	public boolean detectTheLoopByFloydsAlgo() {
		Node slowPtr = first;
		Node fastPtr = first;

		while (fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {
				System.out.println("Loop Found !!");
				return true;
			}
		}
		return false;
	}

	/**
	 * Detect the cycle using Floyd's algo and also find the size of loop,
	 * the starting point of loop and prints the loop;
	 * 04-Apr-2015 5:44:41 pm
	 * ketandikshit
	 */
	public void detectTheLoopAndPrintIt() {
		Node slowPtr = first;
		Node fastPtr = first;

		// Loop detection ; same as above(Floyd cycle detection algo)
		while (fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {
				System.out.println("Loop Found !!");
				break;
			}
		}

		// Lets find the size of the loop
		Node currPos = slowPtr;
		int sizeOfLoop = 0;
		while (slowPtr.next != currPos) {
			sizeOfLoop++;
			slowPtr = slowPtr.next;
		}
		System.out.println("Size of the loop-->" + sizeOfLoop);

		// Lets find the starting point of cycle
		slowPtr = first;
		while (fastPtr != slowPtr) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}

		System.out.println("Slow-->" + slowPtr.item + " Fast-->" + fastPtr.item
				+ " Thus Starting Point of Cycle-->" + slowPtr.item);

		// Lets print the cycle
		System.out.print("The loop is: ");
		for (int i = 0; i <= sizeOfLoop; i++) {
			System.out.print(slowPtr.item + "-->");
			slowPtr = slowPtr.next;
		}
		System.out.print(slowPtr.item);
	}

	/**
	 * Detects the cycle in given linkedList using Brent's Algo
	 * 24-36% faster on average, than Floyd‘s but little complicated
	 * 04-Apr-2015 11:30:03 pm
	 * ketandikshit
	 * 
	 * @return true if cycle exists, false otherwise
	 */
	public boolean detectLoopUsingBrentsAlgo() {
		Node movingPtr = first;
		Node stationaryPtr = first;
		int stepsTaken = 0;
		int stepLimit = 2;
		while (movingPtr != null) {
			movingPtr = movingPtr.next;
			stepsTaken++;
			if (movingPtr == stationaryPtr) {
				System.out.println("\nLoop Detected !!");
				return true;
			}
			if (stepsTaken == stepLimit) {
				stepLimit = 2 * stepLimit;
				stepsTaken = 0;
				stationaryPtr = movingPtr;
			}
		}
		return false;
	}
	/**
	 * 04-Apr-2015 1:25:28 pm
	 * ketandikshit
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addAtHead(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(40);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(60);
		linkedList.addAtEnd(70);
		linkedList.addAtEnd(80);
		linkedList.addAtEnd(90);
		linkedList.addAtEnd(100);

		System.out.println("Original:" + linkedList);
		linkedList.createLoop(30, 3);
		linkedList.detectTheLoopWithHashing();
		linkedList.detectTheLoopWithExtraVisitedFieldPerNode();
		linkedList.detectTheLoopByFloydsAlgo();
		linkedList.detectTheLoopAndPrintIt();
		linkedList.detectLoopUsingBrentsAlgo();
	}

}
