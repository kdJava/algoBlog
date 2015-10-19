/**
 * @createdOn 17-Apr-2015 11:52:56 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem8/LinkedList.java
 * @author ketandikshit
 * @typeName LinkedList
 * @year 2015
 */
package linkedlists.algorithms.problem8;


/**
 * @author ketandikshit
 * @createdOn 17-Apr-2015 11:52:56 pm
 * @qualifiedName GeekyAlgoJava/linkedlists.algorithms.problem8/LinkedList.java
 * @year 2015
 */
public class LinkedList<Item> {

	private Node first;
	private int size;

	/**
	 * Internal data structure representing the node in linked-list
	 * 
	 * @author ketandikshit
	 * @createdOn 20-Apr-2015 10:28:44 pm
	 * @qualifiedName
	 *                GeekyAlgoJava/linkedlists.algorithms.problem8/LinkedList.
	 *                java
	 * @year 2015
	 */
	private class Node {
		private Item item;
		private Node next;

		@Override
		public String toString() {
			return ("NODE[DATA:" + item + "]" + "-->" + next);
		}
	}

	/**
	 * Overriding the {@linkplain Object#toString()} to denote the linked-lists
	 * in simple format
	 * 
	 * @createdOn 20-Apr-2015 10:29:11 pm
	 * @author ketandikshit
	 * @see java.lang.Object#toString()
	 */
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
	 * Function to check if a singly linked list is pallindrome
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

		if (isPallindrome)
			System.out.println("************ IS PALLINDROME ***********");

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

	/**
	 * Compares 2 linkedlists Node by Node
	 * 
	 * @createdOn 20-Apr-2015 10:31:15 pm
	 * @author ketandikshit
	 * @param head1
	 *            first linkedlist
	 * @param head2
	 *            second linkedlist
	 * @return true if 2 given linkedlists are identical, false otherwise
	 */
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
	 * problem8
	 * Function to check if a singly linked list is pallindrome
	 * Use two pointers left and right. Move right and left using recursion and
	 * check for following in each recursive call.
	 * 1) Sub-list is palindrome.
	 * 2) Value at current left and right are matching.
	 * 
	 * If both above conditions are true then return true.
	 * The idea is to use function call stack as container.
	 * Recursively traverse till the end of list. When we return from last NULL,
	 * we will be at last node.
	 * The last node to be compared with first node of list.
	 * In order to access first node of list, we need list head to be available
	 * in the last call of recursion.
	 * Hence we pass head also to the recursive function. If they both match we
	 * need to compare (2, n-2) nodes.
	 * Again when recursion falls back to (n-2)nd node, we need reference to 2nd
	 * node from head.
	 * We advance the head pointer in previous call, to refer to next node in
	 * the list.
	 * However, the trick in identifying double pointer.
	 * Passing single pointer is as good as pass-by-value, and we will pass the
	 * same pointer again and again.
	 * We need to pass the address of head pointer for reflecting the changes in
	 * parent recursive calls.
	 * In JAVA, till date it is not possible to pass-by-reference, ( ie; double
	 * pointer mechanism in C eg: **node or &node ), so we need to keep the
	 * leftNode {@linkplain LinkedList#leftNode} out of the calling stack scope,
	 * so that we can change it in each of the recursion-unwinding steps, to
	 * move it forward on at a time; (Please understand this clearly, would help
	 * you to crack many recursive limitations in Java where you might feel the
	 * need of changing the recursive-call-stack variables in each of the
	 * stack-unwinding steps)
	 * 
	 * @createdOn 20-Apr-2015 10:40:06 pm
	 * @author ketandikshit
	 * @param linkedList
	 * @return true if the given linkedlist's values represent a pallindrome ,
	 *         false otherwise
	 */
	public boolean checkPalindromeUsingRecursion(LinkedList<Item> linkedList) {
		linkedList.leftNode = linkedList.first;
		boolean isReallyPallindrome = false;
		if (isReallyPallindrome = isPallindrome(linkedList.first))
			System.out.println("************ IS PALLINDROME ***********");

		return isReallyPallindrome;
	}
	/**
	 * This node is specifically used by the
	 * {@link LinkedList#checkPalindromeUsingRecursion(LinkedList)} method to
	 * keep the left-node pointer out of the recursive call stack scope
	 */
	private Node leftNode;

	/**
	 * Recursive call method to check the pallindrome
	 * 
	 * @see {@linkplain LinkedList#checkPalindromeUsingRecursion(LinkedList)}
	 *      for triggering
	 *      this off ;)
	 * @createdOn 21-Apr-2015 9:58:31 pm
	 * @author ketandikshit
	 * @param rightNode
	 *            the current right-node pointer
	 * @return true if the rightNode pointer reaches the end of the list, false
	 *         otherwise
	 */
	private boolean isPallindrome(Node rightNode) {

		/*
		 * Recursion Terminating condition(base condition);
		 * Recursion Stops when we reach the end of the linkedlist
		 */
		if (rightNode == null)
			return true;

		/*
		 * Recursive calls ,
		 * helps us to traverse to end of the linked list , one step at a time;
		 */
		if (!isPallindrome(rightNode.next))
			return false;

		/*
		 * Pallindrome INVARIANT: Always the 'i'th element should be equal to
		 * 'N-i'th element
		 * Check if the current-leftNode is equal to the current-rightNode
		 */
		boolean isPal = (leftNode.item == rightNode.item);
		// Set the current-leftNode to next Node in the list
		leftNode = leftNode.next;
		return isPal;
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
		System.out.println("Using Stack-->"
				+ linkedList.checkPalindromeUsingStack(linkedList));
		System.out.println("\n");

		System.out.println(linkedList);
		System.out.println("Using Recusrion-->"
				+ linkedList.checkPalindromeUsingRecursion(linkedList));
		System.out.println("\n");

		System.out.println(linkedList);
		System.out.println("Reversing the SecondHalf of LL-->"
				+ linkedList.checkPalindromeByReversingSecondHalf(linkedList));

	}
}
