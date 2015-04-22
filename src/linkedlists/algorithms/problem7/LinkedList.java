/**
 * 06-Apr-2015 10:35:05 pm
 * GeekyAlgoJava/linkedlists.algorithms.problem7/LinkedList.java
 * ketandikshit
 * LinkedList
 * 2015
 */
package linkedlists.algorithms.problem7;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ketandikshit
 * @createdOn 09-Apr-2015 5:28:29 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem7/LinkedList.java
 * @year 2015
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

	private Node getNodeAtPos(int pos) {
		int count = 1;
		Node currentNode = first; // Maintain currentNode's address

		while (count < pos) {
			currentNode = currentNode.next;
			count++;
		}

		return currentNode;
	}

	public void createIntersection(LinkedList<Item> linkedlist1,
			LinkedList<Item> linkedlist2, int posIn1) {

		Node nodeAtPos = linkedlist1.getNodeAtPos(posIn1);

		Node currentNode2 = linkedlist2.first;
		// find last node of linkedlist2
		while (currentNode2.next != null) {
			currentNode2 = currentNode2.next;
		}

		// merge the lists
		currentNode2.next = nodeAtPos;
		// increment the size of list2
		linkedlist2.size += (linkedlist1.size - linkedlist2.size);

		System.out
				.println("***************Intersection-Created*****************");
	}
	/**
	 * Detects the intersection between 2 linkedlists
	 * Time complexity of this method is O(m+n) and
	 * used Auxiliary space is O(1)
	 * ketandikshit
	 * 
	 * @param linkedlist1
	 *            first linkedlist
	 * @param linkedlist2
	 *            second linkedList
	 * @return true if linkededlis1 and linkedlist2 intersects, false otherwise;
	 */
	public boolean detectIntersection(LinkedList<Item> linkedlist1,
			LinkedList<Item> linkedlist2) {

		Node currentNode1 = linkedlist1.first;
		Node currentNode2 = linkedlist2.first;

		// find last Node of linkedlist1
		while (currentNode1.next != null) {
			currentNode1 = currentNode1.next;
		}

		// find last node of linkedlist2
		while (currentNode2.next != null) {
			currentNode2 = currentNode2.next;
		}

		// check if both have same last nodes
		if (currentNode1 == currentNode2)
			return true;
		else
			return false;

	}

	/**
	 * problem-7
	 * Find intersection/merge point of 2 linkedlists
	 * Outer loop will be for each node of the 1st list and inner loop will be
	 * for 2nd list.
	 * In the inner loop, check if any of nodes of 2nd list is same as the
	 * current node of first linked list.
	 * Time complexity of this method will be O(m*n) where m and n are the
	 * number of nodes in two lists.
	 * 
	 * @param linkedlist1
	 *            first linked-list
	 * @param linkedlist2
	 *            second linked-list
	 * @return the item at intersection/merge point(node) of 2 linked lists
	 */
	public Item findIntersectionPointUsing2NestedLoops(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2) {

		Node currentNode1 = linkedlist1.first;
		Node currentNode2 = linkedlist2.first;

		while (currentNode1.next != null) {
			while (currentNode2.next != null) {
				if (currentNode1 == currentNode2) {
					System.out.println("---------Intersection-Found---------");
					return currentNode2.item;
				} else {
					currentNode2 = currentNode2.next;
				}
			}
			currentNode1 = currentNode1.next;
			currentNode2 = linkedlist2.first;
		}

		System.out.println("----The lists don't intersect !!-----");
		return null; // No intersection point found :(
	}

	/**
	 * problem-7
	 * Find intersection/merge point of 2 linkedlists
	 * This solution requires modifications to basic linked list data structure.
	 * Have a visited flag with each node.
	 * Traverse the first linked list and keep marking visited nodes.
	 * Now traverse second linked list,
	 * If you see a visited node again then there is an intersection point,
	 * return the intersecting node.
	 * This solution works in O(m+n) but requires additional information with
	 * each node.
	 * 
	 * @param linkedlist1
	 *            first linked-list
	 * @param linkedlist2
	 *            second linked-list
	 * @return the item at intersection/merge point(node) of 2 linked lists
	 */
	public Item findIntersectionPointByMarkingVisitedNodes(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2) {

		Node currentNode = linkedlist1.first;

		while (currentNode != null) {
			currentNode.visited = true;
			currentNode = currentNode.next;
		}

		currentNode = linkedlist2.first;

		while (currentNode != null) {
			if (currentNode.visited) {
				System.out.println("---------Intersection-Found---------");
				return currentNode.item;
			}
			currentNode = currentNode.next;
		}

		System.out.println("----The lists don't intersect !!-----");
		return null; // No intersection point found :(
	}

	/**
	 * problem-7
	 * Find intersection/merge point of 2 linkedlists
	 * A variation of the above solution that doesn’t require modification to
	 * basic data structure can be implemented using hash.
	 * Traverse the first linked list and store the addresses of visited nodes
	 * in a hash.
	 * Now traverse the second linked list and if you see an address that
	 * already exists in hash then return the intersecting node.
	 * Time complexity is O(m+n) but requires additional space equal O(N) or
	 * O(M) depending upon which linkedlist is put into hash based data set for
	 * reference;
	 * For address part we will use hashCodes of objects in Java
	 * hashCode is equivalent to address pointers in C++
	 * Not actually!! HashCode in java by default(if not overridden) is
	 * calculated based on the memory address of the Object(under
	 * consideration) on heap memory
	 * Though there to hashcode calculation in java, but memeory address
	 * is the uniquely identified base parameter.
	 * 
	 * @see {@link Object#hashCode()} to know more about it.
	 *
	 * @param linkedlist1
	 *            first linked-list
	 * @param linkedlist2
	 *            second linked-list
	 * @return the item at intersection/merge point(node) of 2 linked lists
	 */
	public Item findIntersectionPointUsingHashBasedDataSet(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2) {

		Set<Integer> hashSet = new HashSet<>(linkedlist1.size);

		Node currentNode = linkedlist1.first;

		while (currentNode != null) {
			final int hashCodeForNode = currentNode.hashCode();
			hashSet.add(hashCodeForNode);
			currentNode = currentNode.next;
		}

		currentNode = linkedlist2.first;

		while (currentNode != null) {
			if (hashSet.contains(currentNode.hashCode())) {
				System.out.println("---------Intersection-Found---------");
				return currentNode.item;
			}
			currentNode = currentNode.next;
		}
		System.out.println("----The lists don't intersect !!-----");
		return null; // No intersection point found :(
	}

	/**
	 * problem-7
	 * Find intersection/merge point of 2 linkedlists using size
	 * Assuming I know the size of the linkedList
	 * 1) Get the difference of counts d = abs(c1 – c2)
	 * 2) Now traverse the bigger list from the first node till d nodes so that
	 * from here onwards both the lists have equal no of nodes.
	 * 3) Then we can traverse both the lists in parallel till we come across a
	 * common node.
	 * (Note that getting a common node is done by comparing the address of the
	 * nodes)
	 * 
	 * @param linkedlist1
	 *            first linked-list
	 * @param linkedlist2
	 *            second linked-list
	 * @param sizeOfLinkedList1
	 *            size of linkedList1
	 * @param sizeOfLinkedList2
	 *            size of linkedList1
	 * @return the item at intersection/merge point(node) of 2 linked lists
	 */
	public Item findIntersectionPointUsingSizeDiff(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2,
			int sizeOfLinkedList1, int sizeOfLinkedList2) {

		int diffInSize = Math.abs(sizeOfLinkedList1 - sizeOfLinkedList2);

		/*
		 * We are assuming here that first linked-list is longer than second
		 * one, In case the second one is longer than the first then swap the
		 * linkedlists(ie, first becomes second and second becomes first
		 * linked-list)
		 */
		if (sizeOfLinkedList2 > sizeOfLinkedList1) {
			LinkedList<Item> temp = linkedlist1;
			linkedlist1 = linkedlist2;
			linkedlist2 = temp;
			temp = null;
		}

		/*
		 * Traverse the first linkedlist(longer) 'k' steps , where 'k'is the
		 * difference in size of the linked-lists
		 */
		int count = 0;
		Node currentNodeBigList = linkedlist1.first;
		while (count < diffInSize) {
			currentNodeBigList = currentNodeBigList.next;
		}

		Node currentNodeSmallList = linkedlist2.first;

		/*
		 * Now traverse both the linked-list simultaneously comparing their
		 * corresponding nodes, if they are equal, that node is the intersection
		 * point, else keep on traversing
		 */
		while (currentNodeSmallList != null) {
			if (currentNodeBigList == currentNodeSmallList) {
				System.out.println("---------Intersection-Found---------");
				return currentNodeBigList.item;
			} else {
				currentNodeBigList = currentNodeBigList.next;
				currentNodeSmallList = currentNodeSmallList.next;
			}
		}
		System.out.println("----The lists don't intersect !!-----");
		return null; // No intersection point found :(
	}

	/**
	 * Traverse the given linked-list to get its size
	 * 
	 * @createdOn 09-Apr-2015 11:18:23 pm
	 * @author ketandikshit
	 * @param linkedList
	 * @return the size of the linked-list
	 */
	private int getSizeOfLinkedList(LinkedList<Item> linkedList) {
		int sizeOfList = 0;
		Node currentNode = linkedList.first;
		while (currentNode != null) {
			sizeOfList++;
			currentNode = currentNode.next;
		}
		return sizeOfList;
	}

	/**
	 * problem-7
	 * Find intersection/merge point of 2 linkedlists using size.
	 * In case I don't know the size of the linkedLists in advance
	 * This method basically calls the
	 * {@link LinkedList#getSizeOfLinkedList(LinkedList)} method to get the size
	 * of both the linkedlist
	 * and then just passes the same to the
	 * {@link LinkedList#findIntersectionPointUsingSizeDiff(LinkedList, LinkedList, int, int)}
	 * method,
	 * to get the intersection/merge point of the linkedlists
	 * 
	 * @createdOn 09-Apr-2015 5:44:48 pm
	 * @author ketandikshit
	 * @param linkedlist1
	 *            first linked-list
	 * @param linkedlist2
	 *            second linked-list
	 * @return the item at intersection/merge point(node) of 2 linked lists
	 */
	public Item findIntersectionPointUsingSizeDiffWithoutKnowingTheSize(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2) {

		int sizeOfList1 = getSizeOfLinkedList(linkedlist1);
		int sizeOfList2 = getSizeOfLinkedList(linkedlist2);

		return findIntersectionPointUsingSizeDiff(linkedlist1, linkedlist2,
				sizeOfList1, sizeOfList2);

	}

	/**
	 * problem-7
	 * Find intersection/merge point of 2 linkedlists using size
	 * 1. Traverse the first linked list(count the elements) and make a circular
	 * linked list.
	 * (Remember last node so that we can break the circle later on).
	 * 2. Now view the problem as find the loop in the second linked list. So
	 * the problem is solved.
	 * 3. Since we already know the length of the loop(size of first linked
	 * list) we can traverse those many number of nodes in second list,
	 * and then start another pointer from the beginning of second list. we have
	 * to traverse until they are equal, and that is the required intersection
	 * point.
	 * 4. remove the circle from the linked list.
	 * Time Complexity: O(m+n)
	 * Auxiliary Space: O(1)
	 * 
	 * @createdOn 09-Apr-2015 11:50:05 pm
	 * @author ketandikshit
	 * @param linkedlist1
	 * @param linkedlist2
	 * @return
	 */
	public Item findIntersectionPointByMakingOneListCircular(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2) {

		/*
		 * Get the size of the linked-list(any one) and also create the loop by
		 * pointing the last node to the first; Also remember the last node to
		 * break the cycle later
		 */
		int sizeOfFirstList = 1;
		Node currentNode1 = linkedlist1.first;

		// get the size
		while (currentNode1.next != null) {
			sizeOfFirstList++;
			currentNode1 = currentNode1.next;
		}

		// Make the linked-list circular and also remember this lastNode of this
		// linked-list to remove the cycle, when finished
		currentNode1.next = linkedlist1.first;

		/*
		 * Now its a simple problem: Determine the starting node of loop in
		 * linkedList [problem-6]
		 */

		// traverse the second list k steps, where k=size of the first linked
		// list(loop/circular-list now)
		Node currentNode2 = linkedlist2.first;
		int count = 0;
		while (count < sizeOfFirstList) {
			currentNode2 = currentNode2.next;
			count++;
		}

		Node currentNode2FromHead = linkedlist2.first;

		/*
		 * Now traverse the second list using currentNode2 and
		 * currentNode2FromHead
		 * one step at a time until they meet at a common node,
		 * this node will give you the intersection/merge point of linked-lists
		 */
		while (currentNode2FromHead.next != null) {
			if (currentNode2FromHead == currentNode2) {
				System.out.println("---------Intersection-Found---------");
				break;
			}
			currentNode2 = currentNode2.next;
			currentNode2FromHead = currentNode2FromHead.next;
		}

		// Remove the cycle form the first linked-list;
		currentNode1.next = null;

		// return the intersection/merge point of the linked-lists
		return currentNode2.item;
	}

	/**
	 * Reverses the linked list while traversing it
	 * 
	 * @createdOn 17-Apr-2015 11:53:27 pm
	 * @author ketandikshit
	 * @param linkedList
	 *            the linked to be reversed
	 * @return the reversed linkedlist
	 */
	private LinkedList<Item> reverseLinkedList(LinkedList<Item> linkedList) {
		Node prev = null;
		Node current = linkedList.first;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		linkedList.first = prev;
		return linkedList;
	}

	/**
	 * problem7
	 * Find intersection/merge point of 2 linkedlists by solving equations
	 * 1) Let X be the length of the first linked list until intersection point.
	 * Let Y be the length of the second linked list until the intersection
	 * point.
	 * Let Z be the length of the linked list from intersection point to End of
	 * the linked list including the intersection node.
	 * We Have
	 * X + Z = C1;
	 * Y + Z = C2;
	 * 2) Reverse first linked list.
	 * 3) Traverse Second linked list. Let C3 be the length of second list - 1.
	 * Now we have
	 * X + Y = C3
	 * We have 3 linear equations. By solving them, we get
	 * X = (C1 + C3 – C2)/2;
	 * Y = (C2 + C3 – C1)/2;
	 * Z = (C1 + C2 – C3)/2;
	 * WE GOT THE INTERSECTION POINT.
	 * 4) Reverse first linked list.
	 * Advantage: No Comparison of pointers.
	 * Disadvantage : Modifying linked list(Reversing list).
	 * 
	 * @createdOn 17-Apr-2015 11:54:12 pm
	 * @author ketandikshit
	 * @param linkedlist1
	 * @param linkedlist2
	 * @return
	 */
	public Item findIntersectionPointBySolvingEquations(
			LinkedList<Item> linkedlist1, LinkedList<Item> linkedlist2) {
		int C1 = linkedlist1.size;
		int C2 = linkedlist2.size;
		LinkedList<Item> reveresedlinkedList1 = reverseLinkedList(linkedlist1);
		int C3 = linkedlist2.size - 1;

		int X = (C1 + (C3 - C2)) / 2;
		int Y = (C2 + (C3 - C1)) / 2;
		int Z = (C1 + (C2 - C3)) / 2;

		System.out.println("X=" + X + " Y=" + Y + " Z=" + Z);

		Node currentNode = linkedlist2.first;
		int count = 0;
		while (count < Y) {
			currentNode = currentNode.next;
			count++;
		}

		Item intersectionPoint = currentNode.item;
		reverseLinkedList(reveresedlinkedList1);
		return intersectionPoint;
	}
	/**
	 * Main method
	 * 
	 * @createdOn 09-Apr-2015 5:29:18 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		linkedList1.addAtHead(10);
		linkedList1.addAtEnd(20);
		linkedList1.addAtEnd(30);
		linkedList1.addAtEnd(40);
		linkedList1.addAtEnd(50);
		linkedList1.addAtEnd(60);
		linkedList1.addAtEnd(70);
		linkedList1.addAtEnd(80);
		linkedList1.addAtEnd(90);
		linkedList1.addAtEnd(100);

		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.addAtHead(110);
		linkedList2.addAtEnd(120);
		linkedList2.addAtEnd(130);
		linkedList2.addAtEnd(140);

		System.out
				.println("*****************Before-Intersection****************");
		System.out.println("First-linkedlist:" + linkedList1);
		System.out.println("Second-linkedList:" + linkedList2);
		System.out
				.println("****************************************************");

		/*
		 * Here for simplicity of demonstration I am assuming that
		 * linkedlist1 is of greater size than linkedlist2
		 */
		linkedList2.createIntersection(linkedList1, linkedList2, 5);

		System.out
				.println("****************After-Intersection******************");
		if (linkedList2.detectIntersection(linkedList1, linkedList2)) {
			System.out.println("Intersection Detected !!!");
			System.out.println("First-linkedlist:" + linkedList1);
			System.out.println("Second-linkedList:" + linkedList2);

			System.out.println("Intersection/Merge Point-->"
					+ linkedList2.findIntersectionPointUsing2NestedLoops(
							linkedList1, linkedList2));

			System.out.println("Intersection/Merge Point-->"
					+ linkedList1.findIntersectionPointByMarkingVisitedNodes(
							linkedList1, linkedList2));

			System.out.println("Intersection/Merge Point-->"
					+ linkedList2.findIntersectionPointUsingHashBasedDataSet(
							linkedList1, linkedList2));

			// If I know the size of linkedLists in advance
			int sizeOfLL1 = linkedList1.size;
			int sizeOfLL2 = linkedList2.size;
			System.out.println("Intersection/Merge Point-->"
					+ linkedList1.findIntersectionPointUsingSizeDiff(
							linkedList1, linkedList2, sizeOfLL1, sizeOfLL2));

			// If I don't know the size of linkedlists in advance
			System.out
					.println("Intersection/Merge Point-->"
							+ linkedList1
									.findIntersectionPointUsingSizeDiffWithoutKnowingTheSize(
											linkedList1, linkedList2));

			System.out.println("Intersection/Merge Point-->"
					+ linkedList2.findIntersectionPointByMakingOneListCircular(
							linkedList1, linkedList2));

			System.out.println("Intersection/Merge Point---->"
					+ linkedList1.findIntersectionPointBySolvingEquations(
							linkedList1, linkedList2));

		}
		System.out
				.println("*****************************************************");
	}
}
