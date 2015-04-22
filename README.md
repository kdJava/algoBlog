# algoBlog
This repo conntains some basic data structures and algorithmic questions for practice; All the questions with the solutions can be found posted on my blog;

*******************
	problem-1: Find the 'k'th node from end of linkedlist;
*******************
	


*******************
	problem-2: Given only a pointer to a node to be deleted in a singly linked list, how do you delete it?
*******************
A simple solution is to traverse the linked list until you find the node you want to delete. 
But this solution requires pointer to the head node which contradicts the problem statement.

Fast solution is to copy the data from the next node to the node to be deleted and delete the next node;
Caution: This solution doesn’t work if the node to be deleted is the last node of the list. 
To make this solution work we can mark the end node as a dummy node.(No other option known till I code this)



*******************
	problem-3: Write a function to print the middle of a given linked list
*******************
Method 1: Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2.  
Method 2:Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
When the fast pointer reaches end slow pointer will reach middle of the linked list.  



*******************
	problem-4: Write a function that counts the number of times a given item occurs in a Linked List
*******************
Here is a solution:  

Algorithm:  

1. Initialize count as zero.  
2. Loop through each element of linked list:
     If element data is equal to the key item then
        increment the count, continue the loop;
3. Return count. 
 
 
 
*******************
	problem-5: Write a function to reverse a linked list
*******************
1. Iterative Method
Iterate trough the linked list. In loop, change next to prev, prev to current and current to next.

2. Recursive Method:
https://www.youtube.com/watch?v=KYH83T4q6Vs
The cool thing about recursion in this problem is that it essentially allows us to iterate through 
the linked list backwards – even though this is impossible in a singly linked list just by using the pointers 
(of course this would certainly be possible in a doubly linked list). 
The reason we can do this in recursion is because of the fact that the stack frames for each function call 
are saved until we get to the very end of the list, and then it is as if we are ‘unwinding’ the stack frames one by one going backwards in the linked list – where each stack frame essentially represents a node in the linked list. 
Make sure you understand this point, because it is important and really helps in your 
understanding of how to use recursion to solve problems.



*******************
	problem-6: Write a function to detect loop in a linked list
*******************
Following are different ways of doing this:  

	1. Use Hashing:(Extra Space Needed)  

Traverse the list one by one and keep putting the node addresses in a Hash Table. 
At any point, if NULL is reached then return false and if next of current node points 
to any of the previously stored nodes in Hash then return true.


	2. Mark Visited Nodes:(Data Structure needs to be changed)  

This solution requires modifications to basic linked list data structure.  Have a visited flag with each node.  Traverse the linked list and keep marking visited nodes.  If you see a visited node again then there is a loop. This solution works in O(n) but requires additional information with each node.
A variation of this solution that doesn’t require modification to basic data structure can be implemented using hash.  Just store the addresses of visited nodes in a hash and if you see an address that already exists in hash then there is a loop.


	3) Floyd’s cycle detection algorithm  

The Tortoise (Slow ptr) and the Hare (fast ptr) start at the beginning of linked list.
For each iteration, slow ptr moves one step and the fast ptr moves two steps.
If there is a loop, fast ptr will go around the loop and meet with slow ptr.
If there is no loop, the fast prt will get to the end of the list without meeting up with the slow ptr.  


	Size-of-loop: start the slow ptr again from the current position(one step at a time) until it reaches the current position gain after completing the loop; While moving kepp the counter for counting the number of loops encountered, this counter will give the size of loop;  


	Starting point of loop: Set the slow ptr from start and fast ptr from its current position , move them both one step at a time now, until they meet at a position, this meeting point will give you the start of the loop;  
	  
	  
Correctness of algorithm for finding start node of loop:  
Lets assume that linked list has a “non-looped” part of size k.  
When we apply Floyd’s cycle detection algorithm, we know that after k steps,  
--slowPtr will be at start of loop, and is 0 steps into the loop.  
--fastPtr is k steps into the loop. since k might be much larger than loop_size,it is actually k%loop_size. Let’s say it as p. So fastPtr is p steps into the loop.  
--slowPtr is p steps behind fastPtr.  
--fastPtr is loop_size – p steps behind slowPtr.  
--fastPtr catches up to slowPtr at a rate of one step per unit of time.  

From above points, after loop_size – p steps, fastPtr and slowPtr meet each other, which means they will be p steps before start of the loop.  
Since p = k%loop_size ( k = p+M*loop_size), it is correct to say that, fastPtr, slowPtr are k steps from start node of the loop.  
If we reinitialise slowPtr to head node and start moving both pointers one node at a time. they both meet at start node of the loop.  

	Printing the loop(trivial): starting from the starting point of the loop , move one step at a time equal to size-of-loop; While moving 
keep on printing the the nodes, this will give you all the  nodes in cycle;  


	4)Brent’s Cycle detection Algorithm  
	
This algorithm is based on Floyd‘s algorithm. It is more efficient (24-36% faster on average) than Floyd‘s but little complicated.  

1. Start ptr1 (Moving ptr), ptr2 (Stationary pointer) from beginning of the list  

2. ptr1 takes one step per iteration, If it is then at the same position as the ptr2, there is obviously a loop. If it reaches the end of the list, there is no loop.  

3. Teleport ptr2 position to ptr1 position occasionally. We start out waiting just 2 steps before teleportation, and we double that each time we move the ptr2.  



*******************
	problem-7: Write a function to get the intersection point of two Linked Lists.
*******************
There are two singly linked lists in a system. By some programming error the end node of one of the linked list got linked into the second list, forming a inverted Y shaped list. Write a program to get the point where two linked list merge.


	Method 1(Simply use two loops)
Use 2 nested for loops. 
Outer loop will be for each node of the 1st list and inner loop will be for 2nd list. 
In the inner loop, check if any of nodes of 2nd list is same as the current node of first linked list. 
Time complexity of this method will be O(m*n) where m and n are the number of nodes in two lists.


 
	Method 2 (Mark Visited Nodes)
This solution requires modifications to basic linked list data structure. 
Have a visited flag with each node. 
Traverse the first linked list and keep marking visited nodes. 
Now traverse second linked list, 
If you see a visited node again then there is an intersection point, return the intersecting node. 
This solution works in O(m+n) but requires additional information with each node. 



	Method 3( Hash based data structure)
A variation of the above solution that doesn’t require modification to basic data structure can be implemented using hash. 
Traverse the first linked list and store the addresses of visited nodes in a hash. 
Now traverse the second linked list and if you see an address that already exists in hash then return the intersecting node.
Time complexity is O(m+n) but requires additional space equal O(N) or O(M).



	Method 4(Using difference of node counts)
	1) Get count of the nodes in first list, let count be c1.
	2) Get count of the nodes in second list, let count be c2.
	3) Get the difference of counts d = abs(c1 – c2).
	4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
	5) Then we can traverse both the lists in parallel till we come across a common node. 
	(Note that getting a common node is done by comparing the address of the nodes).



	Method 5(Make circle in first list)
	1. Traverse the first linked list(count the elements) and make a circular linked list. 
	   (Remember last node so that we can break the circle later on).
	2. Now view the problem as find the loop in the second linked list. So the problem is solved.
	3. Since we already know the length of the loop(size of first linked list) we can traverse those many number of nodes in second list, and then start another pointer from the beginning of second list. we have to traverse until they are equal, and that is the required intersection point.
	4. remove the circle from the linked list.
Time Complexity: O(m+n)
Auxiliary Space: O(1)	



	Method 6 (Reverse the first list and make equations)
1) Let X be the length of the first linked list until intersection point.
   Let Y be the length of the second linked list until the intersection point.
   Let Z be the length of the linked list from intersection point to End of
   the linked list including the intersection node.
   We Have
           X + Z = C1;
           Y + Z = C2;
2) Reverse first linked list.
3) Traverse Second linked list. Let C3 be the length of second list - 1. 
     Now we have
        X + Y = C3
     We have 3 linear equations. By solving them, we get
       X = (C1 + C3 – C2)/2;
       Y = (C2 + C3 – C1)/2;
       Z = (C1 + C2 – C3)/2;
      WE GOT THE INTERSECTION POINT.
4)  Reverse first linked list.
Advantage: No Comparison of pointers.
Disadvantage : Modifying linked list(Reversing list).

Time complexity: O(m+n)
Auxiliary Space: O(1)



	Method 7: Method To Detect if there is an intersection in list or Not
(Traverse both lists and compare addresses of last nodes) 
This method is only to detect if there is an intersection point or not.
1) Traverse the list 1, store the last node address.
2) Traverse the list 2, store the last node address.
3) If nodes stored in 1 and 2 are same then they are intersecting.
Time complexity of this method is O(m+n) and used Auxiliary space is O(1)



*******************
	problem-8: Function to check if a singly linked list is palindrome
*******************
Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.

	METHOD 1: Use a Stack
A simple solution is to use a stack of list nodes. This mainly involves three steps.
1) Traverse the given list from head to tail and push every visited node to stack.
2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
3) If all nodes matched, then return true, else false.
Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.



	METHOD 2: By reversing the list
This method takes O(n) time and O(1) extra space.
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half.  

To divide the list in two halves  

When number of nodes are even, the first and second half contain exactly half nodes. 
The challenging thing in this method is to handle the case when number of nodes are odd. 
We don’t want the middle node as part of any of the lists as we are going to compare them for equality. 
For odd case, we use a separate variable ‘midnode’.
	


	METHOD 3: Using Recursion
Use two pointers left and right. Move right and left using recursion and check for following in each recursive call.
1) Sub-list is palindrome.
2) Value at current left and right are matching.  

If both above conditions are true then return true.The idea is to use function call stack as container.Recursively traverse till the end of list. When we return from last NULL, we will be at last node. The last node to be compared with first node of list.In order to access first node of list, we need list head to be available in the last call of recursion. 
Hence we pass head also to the recursive function. If they both match we need to compare (2, n-2) nodes. 
Again when recursion falls back to (n-2)nd node, we need reference to 2nd node from head. 
We advance the head pointer in previous call, to refer to next node in the list.
However, the trick in identifying double pointer. Passing single pointer is as good as pass-by-value, and we will pass the same pointer again and again. We need to pass the address of head pointer for reflecting the changes in parent recursive calls.
  
*******************
	problem-8: Given a linked list which is sorted, how will you insert in sorted way;
*******************
Algorithm:  
Let input linked list is sorted in increasing order.  

1. If Linked list is empty then make the node as head and return it.
2. If value of the node to be inserted is smaller than value of head node, 
    then insert the node at start and make it head.
3. In a loop, find the appropriate node after which the input node (let 9) is
    to be inserted. To find the appropriate node start from head, keep moving 
    until you reach a node GN (10 in the below diagram) who's value is 
    greater than the input node. The node just before GN is the appropriate
    node (7).
4. Insert the node (9) after the appropriate node (7) found in step 3.  
