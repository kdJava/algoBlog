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
		System.out.println(linkedList.checkPalindromeUsingStack(linkedList));

	}
}
