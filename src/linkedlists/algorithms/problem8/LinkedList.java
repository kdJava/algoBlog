/**
 * @createdOn 17-Apr-2015 11:52:56 pm
 * @qualifiedName GeeksForGeeks/linkedlists.algorithms.problem8/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem8;

/**
 * @author ketandikshit
 * @createdOn 17-Apr-2015 11:52:56 pm
 * @qualifiedName GeeksForGeeks/linkedlists.algorithms.problem8/LinkedList.java
 * @year 2015
 */
public class LinkedList<Item> {

	private Node first;
	private int size;

	private class Node {
		private Item item;
		private Node next;
	}

	@Override
	public String toString() {
		String result = "LinkedList--> [";
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
	 * problem8
	 * Function to check if a singly linked list is palindrome
	 * METHOD 1: Use a Stack
	 * A simple solution is to use a stack of list nodes. This mainly involves
	 * three steps.
	 * 1) Traverse the given list from head to tail and push every visited node
	 * to stack.
	 * 2) Traverse the list again. For every visited node, pop a node from stack
	 * and
	 * compare data of popped node with currently visited node.
	 * 3) If all nodes matched, then return true, else false.
	 *
	 * Time complexity of this method is O(n), but it requires O(n) extra
	 * space.
	 * 
	 * @createdOn 18-Apr-2015 12:18:52 am
	 * @author ketandikshit
	 * @param linkedList
	 * @return
	 */
	public boolean checkPalindromeUsingStack(LinkedList<Item> linkedList) {
		Stack<Item> stack = new Stack<>();
		for (Node currentNode = linkedList.first; currentNode != null; currentNode = currentNode.next) {
			stack.push(currentNode.item);
		}

		for (Node currentNode = linkedList.first; currentNode != null; currentNode = currentNode.next) {
			Item itemPoppedFromStack = stack.pop();
			if (currentNode.item != itemPoppedFromStack) {
				System.out.println("!!!!!!!!!! NOT Palindrome !!!!!!!!!!");
				return false;
			}
		}
		System.out.println("************ IS PALLINDROME ***********");
		return true;
	}

	/**
	 * problem8
	 * Function to check if a singly linked list is palindrome
	 * 1) Get the middle of the linked list.
	 * 2) Reverse the second half of the linked list.
	 * 3) Check if the first half and second half are identical.
	 * 4) Construct the original linked list by reversing the second half again
	 * and attaching it back to the first half
	 * 
	 * To divide the list in two halves.
	 * When number of nodes are even, the first and second half contain exactly
	 * half nodes.
	 * The challenging thing in this method is to handle the case when number of
	 * nodes are odd.
	 * We don’t want the middle node as part of any of the lists as we are going
	 * to compare them for equality.
	 * For odd case, we use a separate variable ‘midnode’.
	 * 
	 * This method takes O(n) time and O(1) extra space.
	 * 
	 * @createdOn 18-Apr-2015 3:45:42 pm
	 * @author ketandikshit
	 * @param linkedList
	 * @return
	 */
	public boolean checkPalindromeByReversingSecondHalf(
			LinkedList<Item> linkedList) {

		Node slowCntr = linkedList.first;
		Node fastCntr = linkedList.first;

		Node prevOfSlowPtr = null;
		boolean isPallindrome = false;
		if ((linkedList.first != null) && (linkedList.first.next != null)) {
			/*
			 * Get the middle of the list. Move slow_ptr by 1
			 * and fast_ptrr by 2, slow_ptr will have the middle
			 * node
			 */
			while ((fastCntr != null) && (fastCntr.next != null)) {
				/*
				 * We need previous of the slow_ptr for
				 * linked lists with odd elements
				 */
				prevOfSlowPtr = slowCntr;
				slowCntr = slowCntr.next;
				fastCntr = fastCntr.next.next;
			}

			Node midNode = null;

			/*
			 * fast_ptr would become NULL when there are even elements in list.
			 * And not NULL for odd elements. We need to skip the middle node
			 * for odd case and store it somewhere so that we can restore the
			 * original list
			 */
			if (fastCntr != null) {
				midNode = slowCntr;
				slowCntr = slowCntr.next;
			}

			Node second_half = null;
			// Now reverse the second half and compare it with first half
			second_half = slowCntr;
			prevOfSlowPtr.next = null; // NULL terminate first half
			second_half = reverse(second_half);
			isPallindrome = compareLists(first, second_half);

			/* Construct the original list back */
			reverse(second_half); // Reverse the second half again
			/*
			 * If there was a mid node (odd size case) which
			 * was not part of either first half or second
			 * half.
			 */
			if (midNode != null) {
				prevOfSlowPtr.next = midNode;
				midNode.next = second_half;
			} else {
				prevOfSlowPtr.next = second_half;
			}
		}

		return isPallindrome;

	}
	/**
	 * Reverses the linkedlist
	 * 
	 * @createdOn 18-Apr-2015 5:34:18 pm
	 * @author ketandikshit
	 * @param head
	 *            the head of linkedlist
	 * @return the head of the reversed linkedlist
	 */
	private Node reverse(Node head) {

		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	private boolean compareLists(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		while ((temp1 != null) && (temp2 != null)) {
			if (temp1.item == temp2.item) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else
				return false;
		}

		/* Both are empty reurn 1 */
		if (temp1 == null && temp2 == null)
			return true;

		/*
		 * Will reach here when one is NULL
		 * and other is not
		 */
		return false;
	}

	/**
	 * @createdOn 17-Apr-2015 11:52:58 pm
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		String palindromeWord = "123MALAYALAM321";
		LinkedList<Character> linkedList = new LinkedList<>();
		int count = 0;
		for (Character character : palindromeWord.toCharArray()) {
			if (count == 0)
				linkedList.addAtHead(character);
			else
				linkedList.addAtEnd(character);

			count++;
		}
		System.out.println(linkedList);
		System.out.println(linkedList.checkPalindromeUsingStack(linkedList));
		System.out.println("\n");
		System.out.println(linkedList
				.checkPalindromeByReversingSecondHalf(linkedList));

	}
}
