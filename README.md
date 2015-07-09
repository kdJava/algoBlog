# Algorithmist's Blog : Always learning !!!
Lets See..!!	<<http://kdjava.github.io/algoBlog>>
>This repo conntains some basic data structures and algorithmic questions for practice; All the questions with the solutions can be found posted on my blog;

*******************
####	problem-1: Find the 'k'th node from end of linkedlist;
*******************
	


*******************
####	problem-2: Given only a pointer to a node to be deleted in a singly linked list, how do you delete it?
*******************
A simple solution is to traverse the linked list until you find the node you want to delete. 
But this solution requires pointer to the head node which contradicts the problem statement.

Fast solution is to copy the data from the next node to the node to be deleted and delete the next node;
Caution: This solution doesn’t work if the node to be deleted is the last node of the list. 
To make this solution work we can mark the end node as a dummy node.(No other option known till I code this)



*******************
####	problem-3: Write a function to print the middle of a given linked list
*******************
**Method 1**: Traverse the whole linked list and count the no. of nodes Now traverse the list again till count/2 and return the node at count/2.  
**Method 2**:Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
When the fast pointer reaches end slow pointer will reach middle of the linked list.  



*******************
####	problem-4: Write a function that counts the number of times a given item occurs in a Linked List
*******************
Here is a solution:  

#####	Algorithm:  

	1. Initialize count as zero.  
	2. Loop through each element of linked list:
     	If element data is equal to the key item then
        increment the count, continue the loop;
	3. Return count. 
 
 
 
*******************
####	problem-5: Write a function to reverse a linked list
*******************
######1. Iterative Method
Iterate trough the linked list. In loop, change next to prev, prev to current and current to next.

######2. Recursive Method:
https://www.youtube.com/watch?v=KYH83T4q6Vs
The cool thing about recursion in this problem is that it essentially allows us to iterate through 
the linked list backwards – even though this is impossible in a singly linked list just by using the pointers 
(of course this would certainly be possible in a doubly linked list). 
The reason we can do this in recursion is because of the fact that the stack frames for each function call 
are saved until we get to the very end of the list, and then it is as if we are ‘unwinding’ the stack frames one by one going backwards in the linked list – where each stack frame essentially represents a node in the linked list. 
Make sure you understand this point, because it is important and really helps in your 
understanding of how to use recursion to solve problems.



*******************
####	problem-6: Write a function to detect loop in a linked list
*******************
Following are different ways of doing this:  

######	Method 1. Use Hashing:(Extra Space Needed)  

Traverse the list one by one and keep putting the node addresses in a Hash Table. 
At any point, if NULL is reached then return false and if next of current node points 
to any of the previously stored nodes in Hash then return true.


######	Method 2. Mark Visited Nodes:(Data Structure needs to be changed)  

This solution requires modifications to basic linked list data structure.  Have a visited flag with each node.  Traverse the linked list and keep marking visited nodes.  If you see a visited node again then there is a loop. This solution works in O(n) but requires additional information with each node.
A variation of this solution that doesn’t require modification to basic data structure can be implemented using hash.  Just store the addresses of visited nodes in a hash and if you see an address that already exists in hash then there is a loop.


######	Method 3. Floyd’s cycle detection algorithm  

The Tortoise (Slow ptr) and the Hare (fast ptr) start at the beginning of linked list.
For each iteration, slow ptr moves one step and the fast ptr moves two steps.
If there is a loop, fast ptr will go around the loop and meet with slow ptr.
If there is no loop, the fast prt will get to the end of the list without meeting up with the slow ptr.  


**Size-of-loop**: start the slow ptr again from the current position(one step at a time) until it reaches the current position gain after completing the loop; While moving kepp the counter for counting the number of loops encountered, this counter will give the size of loop;  


**Starting point of loop**: Set the slow ptr from start and fast ptr from its current position , move them both one step at a time now, until they meet at a position, this meeting point will give you the start of the loop;  
	  
	  
**Correctness of algorithm for finding start node of loop:**  
*Lets assume that linked list has a `non-looped` part of size k.*  
*When we apply Floyd’s cycle detection algorithm, we know that after k steps,*  

-`slowPtr will be at start of loop, and is 0 steps into the loop.`  

-`fastPtr is k steps into the loop. since k might be much larger than loop_size,`  
-`it is actually *k%loop_size*. Let’s say it as p. So fastPtr is p steps into the loop.`  

-`slowPtr is p steps behind fastPtr`  

-`fastPtr is *(loop_size – p)* steps behind slowPtr`  

-`fastPtr catches up to slowPtr at a rate of one step per unit of time`  

-`From above points, after *(loop_size – p)* steps, fastPtr and slowPtr meet each other, which means they will be p steps before start of the loop.`  
-`Since *p = k%loop_size ( k = p+M*loop_size)*, it is correct to say that, fastPtr, slowPtr are k steps from start node of the loop.` 
-`If we reinitialise slowPtr to head node and start moving both pointers one node at a time. they both meet at start node of the loop.`  

**Printing the loop(trivial)**
* Starting from the starting point of the loop , move one step at a time equal to size-of-loop; While moving 
keep on printing the the nodes, this will give you all the  nodes in cycle;*  


######	Method 4. Brent’s Cycle detection Algorithm  
	
This algorithm is based on Floyd‘s algorithm. It is more efficient (24-36% faster on average) than Floyd‘s but little complicated.  

1. Start ptr1 (Moving ptr), ptr2 (Stationary pointer) from beginning of the list  

2. ptr1 takes one step per iteration, If it is then at the same position as the ptr2, there is obviously a loop. If it reaches the end of the list, there is no loop.  

3. Teleport ptr2 position to ptr1 position occasionally. We start out waiting just 2 steps before teleportation, and we double that each time we move the ptr2.  



*******************
####	problem-7: Write a function to get the intersection point of two Linked Lists.
*******************
There are two singly linked lists in a system. By some programming error the end node of one of the linked list got linked into the second list, forming a inverted Y shaped list. Write a program to get the point where two linked list merge.


######	Method 1. Simply use two loops
Use 2 nested for loops. 
-Outer loop will be for each node of the 1st list and inner loop will be for 2nd list. 
-In the inner loop, check if any of nodes of 2nd list is same as the current node of first linked list. 
**Time complexity of this method will be O(m*n) where m and n are the number of nodes in two lists.**


 
######	Method 2. Mark Visited Nodes
This solution requires modifications to basic linked list data structure. 
-Have a visited flag with each node. 
-Traverse the first linked list and keep marking visited nodes. 
-Now traverse second linked list, 
-If you see a visited node again then there is an intersection point, return the intersecting node.  

-*This solution works in O(m+n) but requires additional information with each node.* 



######	Method 3. Hash based data structure
A variation of the above solution that doesn’t require modification to basic data structure can be implemented using hash. 

-Traverse the first linked list and store the addresses of visited nodes in a hash.  

-Now traverse the second linked list and if you see an address that already exists in hash then return the intersecting node.  

-*Time complexity is O(m+n) but requires additional space equal O(N) or O(M).*  



######	Method 4. Using difference of node counts
	1) Get count of the nodes in first list, let count be c1.
	2) Get count of the nodes in second list, let count be c2.
	3) Get the difference of counts d = abs(c1 – c2).
	4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
	5) Then we can traverse both the lists in parallel till we come across a common node. 
	*(Note that getting a common node is done by comparing the address of the nodes).*



######	Method 5. Make circle in first list
	1. Traverse the first linked list(count the elements) and make a circular linked list. 
	   (Remember last node so that we can break the circle later on).
	2. Now view the problem as find the loop in the second linked list. So the problem is solved.
	3. Since we already know the length of the loop(size of first linked list) we can traverse those many number of nodes in second list, and then start another pointer from the beginning of second list. we have to traverse until they are equal, and that is the required intersection point.
	4. remove the circle from the linked list.
**Time Complexity: O(m+n)**
**Auxiliary Space: O(1)**	



######	Method 6. Reverse the first list and make equations
1. Let X be the length of the first linked list until intersection point.
   Let Y be the length of the second linked list until the intersection point.
   Let Z be the length of the linked list from intersection point to End of
   the linked list including the intersection node.
   We Have  
   	`X + Z = C1;`  
   	`Y + Z = C2;`
2. Reverse first linked list.
3. Traverse Second linked list. Let C3 be the length of second list - 1.  
   Now we have  

        	`X + Y = C3`  
        
     We have 3 linear equations. By solving them, we get  
     
       	`X = (C1 + C3 – C2)/2;`  
       	`Y = (C2 + C3 – C1)/2;`  
       	`Z = (C1 + C2 – C3)/2;`  
       	
      *WE GOT THE INTERSECTION POINT.*
4.  Reverse first linked list.
*Advantage: No Comparison of pointers.*
*Disadvantage : Modifying linked list(Reversing list).*

**Time complexity: O(m+n)**
**Auxiliary Space: O(1)**



######	Method 7. Method To Detect if there is an intersection in list or Not
*Traverse both lists and compare addresses of last nodes* 
**This method is only to detect if there is an intersection point or not.**  

- Traverse the list 1, store the last node address.
- Traverse the list 2, store the last node address.
- If nodes stored in 1 and 2 are same then they are intersecting.  

*Time complexity of this method is O(m+n) and used Auxiliary space is O(1)*



*******************
####	problem-8: Function to check if a singly linked list is palindrome
*******************
Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.

######	METHOD 1: Use a Stack
A simple solution is to use a stack of list nodes. This mainly involves three steps.
1) Traverse the given list from head to tail and push every visited node to stack.
2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
3) If all nodes matched, then return true, else false.
**Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.**



######	METHOD 2: By reversing the list
*This method takes O(n) time and O(1) extra space.*  

- Get the middle of the linked list.
- Reverse the second half of the linked list.
- Check if the first half and second half are identical.
- Construct the original linked list by reversing the second half again and attaching it back to the first half.  
  

**To divide the list in two halves**  

*When number of nodes are even, the first and second half contain exactly half nodes.*  
*The challenging thing in this method is to handle the case when number of nodes are odd.*  
*We don’t want the middle node as part of any of the lists as we are going to compare them for equality.*  
*For odd case, we use a separate variable ‘midnode’.*  

	


######	METHOD 3: Using Recursion
*Use two pointers left and right. Move right and left using recursion and check for following in each recursive call.*
	- Sub-list is palindrome.
	- Value at current left and right are matching.


+ *If both the above conditions are true then return true.*
+ *The idea is to use function call stack as container.*
+ *Recursively traverse till the end of list.*
+ *When we return from last NULL, we will be at last node.*
+ *The last node to be compared with first node of list.*
+ *In order to access first node of list, we need list head to be available in the last call of recursion.* 
+ *Hence we pass head also to the recursive function. If they both match we need to compare (2, n-2) nodes.* 
+ *Again when recursion falls back to (n-2)nd node, we need reference to 2nd node from head.* 
+ *We advance the head pointer in previous call, to refer to next node in the list.*   

`However, the trick in identifying double pointer. Passing single pointer is as good as pass-by-value, and we will pass the same pointer again and again. We need to pass the address of head pointer for reflecting the changes in parent recursive calls.`
  
*******************
####	problem-9: Given a linked list which is sorted, how will you insert in sorted way;
*******************
####### Algorithm:  
*Let input linked list is sorted in increasing order.*  

1. If Linked list is empty then make the node as head and return it.
2. If value of the node to be inserted is smaller than value of head node, 
    then insert the node at start and make it head.
3. In a loop, find the appropriate node after which the input node (let 9) is
    to be inserted. To find the appropriate node start from head, keep moving 
    until you reach a node GN (10 in the below diagram) who's value is 
    greater than the input node. The node just before GN is the appropriate
    node (7).
4. Insert the node (9) after the appropriate node (7) found in step 3.  


*******************
####	problem-10: Remove duplicates from a sorted linked list.
*******************
*Write a removeDuplicates() function which takes a list sorted linked list and deletes any duplicate nodes from the list. The list should only be traversed once.*  

`For example if the linked list is 11->11->11->21->43->43->60 ,`  
`then removeDuplicates() should convert the list to 11->21->43->60.`  
  

#######	Algorithm:
1. Traverse the list from the head (or start) node. 
2. While traversing, Compare each node with its next node. 
3. If data of next node is same as current node then delete the next node. 
4. Before we delete a node, we need to store next pointer of the node
  
*******************
####	problem-11: Remove duplicates from an unsorted linked list.
*******************
*Write a removeDuplicates() function which takes a list and deletes any* 
*duplicate nodes from the list. The list is not sorted.*  

######	Method-1: Using two loops; (trivial)
- This is the simple way where two loops are used.  
- Outer loop is used to pick the elements one by one and inner loop compares the picked element with rest of the elements.  

######	Method-2: Use Sorting; (After Sorting, it becomes the question: problem-10)
*In general, Merge Sort is the best suited sorting algorithm for sorting linked lists efficiently.*
1. Sort the elements using Merge Sort. We will soon be writing a post about sorting a linked list. O(nLogn)
2. Remove duplicates in linear time using the algorithm for removing duplicates in sorted Linked List. O(n)  
  
  *Please note that this method doesn’t preserve the original order of elements.*  
  **Time Complexity: O(NLogN)**
   
######	Method-3: Use Hashing (trivial)
1. We traverse the link list from head to end. 
2. For every newly encountered element, we check whether it is in the hash table: 
3. If yes, we remove it; otherwise we put it in the hash table.  

**Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average).**
**Space Complexity: O(n)**  

*******************
####	problem-12: Print alternate nodes in a linked list from head to end and then from end to head;
*******************  
Write a function that takes a linked list and then prints the alternate nodes from head to end and  
then prints the alternating nodes from end to head.  
*For eg: if the linked list is: 1-->2-->3-->4-->5, then the function should print: 1 3 5 5 3 1*  
  
*******************
####	problem-13: Move last element to front of a given Linked List
*******************
Write a function that moves last element to front in a given Singly Linked List.  
*For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.*
  

#######	Algorithm:  
	Traverse the list till last node. Use two pointers: one to store the address of last node and other for address of second last node. After the end of loop do following operations.  
	
	i) Make second last as last (secLast->next = NULL).
	ii) Set next of last as head (last->next = *head_ref).
	iii) Make last as head ( *head_ref = last)  
	
*******************
####	problem-14: Pairwise swap elements of a given linked list
*******************
Given a singly linked list, write a function to swap elements pairwise.  
*For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5,*  
*and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.* 

######	METHOD 1: Iterative
Start from the head node and traverse the list. While traversing swap data of each node with its next node’s data.  
**Time complexity: O(n)**  

######	METHOD 2: Recursive
*If there are 2 or more than 2 nodes in Linked List then swap the first two nodes and recursively call for rest of the list.*  
**Time complexity: O(n)**  
 
######	METHOD 3: Changing the links of the nodes
*Up till now we were only swapping the data of the nodes, But we will now actually swap the entire node by changing the links.*  
**Time Complexity: O(n)**  


*******************
####	problem-15: Create a new linked list containing the elements(in sorted order) by having 
####	intersection from 2 already sorted lists;
*******************  
Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.  
The new list should be made with its own memory — the original lists should not be changed.  

*For example, let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8,*  
*then your function should create and return a third list as 2->4->6.*  

######	Method 1: Iterative
This solution is structurally very similar to the above, but it avoids using a dummy node,  
Instead, it maintains a struct node** pointer, lastPtrRef, that always points to the last pointer of the result list.  
This solves the same case that the dummy node did — dealing with the result list when it is empty.  
If you are trying to build up a list at its tail, either the dummy node or the struct node** “reference” strategy can be used.  
**Time Complexity: O(m+n) where m and n are number of nodes in first and second linked lists respectively.**  



######	Method 2: Recursive
**Time Complexity: O(m+n) where m and n are number of nodes in first and second linked lists respectively. ** 
  
  
*******************
####	problem-16: Delete alternate nodes of a Linked List 
*******************
Given a Singly Linked List, starting from the second node delete all alternate nodes of it.  
*For example, if the given linked list is 1->2->3->4->5 then your function should convert it to 1->3->5,*  
*and if the given linked list is 1->2->3->4 then convert it to 1->3.*  

######	Method 1: Iterative; *Time complexity: O(n)*
	
######	Method 2: Recursive; *Time complexity: O(n)*

*******************	
####	problem-17: Alternating split of a given Singly Linked List
*******************
Write a function AlternatingSplit() that takes one list and divides up its nodes to make two smaller lists ‘a’ and ‘b’.  
The sublists should be made from alternating elements in the original list.  
*So if the original list is 0->1->0->1->0->1 then one sublist should be 0->0->0 and the other should be 1->1->1.*  

######	Method 1: Simple Iterative Solution
Just keep on traversing the linked-list and keep on putting alternate elements into 2 different linked-lists.
By the time you will reach the end of the linked-list you would be done.!! ie; have 2 different linked-lists each containing alternate elements of the original linked-list;

######	Method 2: Simple Iteration Only, but space efficient, alters the original list
While iterating the nodes of the linked-list , keep on removing the alternate nodes form the original linked-list and add them to the newer linked-list.
By the time , the iteration finishes, you will have one 2 linked list one the original one and second the new one that you created, both containing the alternate elements of the original linked-list. 

######	Method 3: Recursive Approach, space efficient, But , alters the original list  
	  
	    
	    
*******************	
####	problem-18: Merging two linked lists at alternate positions
*******************
Given 2 linked lists , merge them to a single linked-list such that each alternate node actually belongs to the same linked-list;  If second link list has extra nodes, print them as well.  
Example:
	*5 - -> 10 - -> 15 - -> 20 - ->25 - -> null* 
	*3 - -> 6 - ->9 - -> 12 - ->15 - ->18-->21--> null*

Output :
	*5 - -> 3 - -> 10 - -> 6 - ->15 - -> 9 - -> 20 - -> 12 - -> 25 - ->15 - -> null*
	*Remaining List : 18-->21-->null*



*******************	
####	problem-19: Merging two sorted linked lists
*******************
Given 2 linked lists already sorted individually,Now try to merge them to form a single sorted linked-list.
Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, and merges the two together into one list which is in increasing order. SortedMerge() should return the new list. The new list should be made by splicing
together the nodes of the first two lists.  
	*For eg: lnkLst1= 1-->5-->8-->17-->25 and lnkLst2= -10-->2-->7-->13-->21-->30*
	*Then the final sorted list should be: -10-->1-->2-->5-->7-->8-->13-->17-->21-->25-->30*

**There are many cases to deal with: either ‘a’ or ‘b’ may be empty, during processing either ‘a’ or ‘b’ may run out first, and finally there’s the problem of starting the result list empty, and building it up while going through ‘a’ and ‘b’.**

######	Method 1: Iterative (Time Complexity O(m+n) )
	1. create a new node say result
	2. navigate through both the linked lists at the same time, starting from head
	3. compare the first node values of both the linked lists
	4. which ever is smaller, add it to the result node
	5. move the head pointer of the linked list whose value was smaller
	6. again compare the node values
	7. keep doing until one list gets over
	8. copy the rest of the nodes of unfinished list to the result 
	
	
######	Method 2: Recursive (Time Complexity O(m+n))
	**Base Case :**
	If List A gets fin­ished , return List B.  
	
	If List B gets fin­ished, return List A.  
	**Steps: ** 
	1. Cre­ate a result node and ini­tial­ize it as NULL
	2. Check which node (List A or List B) has a smaller value.
	3. Whichever is smaller, add it to the result node.
	4. Make recur­sive call and add the return node as result.next

******************* 
####  problem-20: Swap Every Kth Node in a LinkedList
*******************
Given a linked list, swap every kth node in that.  
If at the end of the list remain­ing nodes are less than k, leave them untouched.  

  Example:
  *Input: A linked list, A num­ber k.*
  *Input : ->1->2->3->4->5->6->7->8->9->10 , K = 4*
  *Output: ->4->2->3->1->8->6->7->5->9->10*

**Approach:**
  1. Take 3 Point­ers, ptrOne, ptrTwo and ptrTwo_prev.
  2. ptrOne and ptrTwo_prev points at head node.
  3. ptrTwo points at next node of ptrTwo_prev.
  4. Move the ptrTwo and ptrTwo_prev k-2 times, since we need one pointer each at both ends for swap­ping so move point­ers only k-2 times.
  5. Cre­ate another pointer , New­Head and point it to ptrTwo.next.
  6. Now we have ptrOne at head and ptrTwo at kth posi­tion, swap them with the help of ptrTwo_prev.
  7. This func­tion will returns the head.
  8. Now make a recursive call with newHead: ptrOne.next = reverseNodes(newHead, k);  

  
******************* 
####  problem-21: Swap Every Kth Node in a LinkedList with (N-k)th node;
  ie; Swap kth node from head, with the kth node from end(in case both are same, do nothing)
*******************
 Given a Linked List and a number k, Swap Kth Node from the front with the Kth Node from the End
Example:
*->10->20->30->40->50->60->70*

*Swapping 1 Node from the Front and from the End*
*->70->20->30->40->50->60->10*

*Swapping 2 Node from the Front and from the End*
*->70->60->30->40->50->20->10*

*Swapping 3 Node from the Front and from the End*
*->70->60->50->40->30->20->10*

*k = 4, Nodes are same from front and at the end, no swapping*
*->70->60->50->40->30->20->10*

*Swapping 5 Node from the Front and from the End*
*->70->60->30->40->50->20->10*

*Swapping 6 Node from the Front and from the End*
*->70->20->30->40->50->60->10*

*Swapping 7 Node from the Front and from the End*
*->10->20->30->40->50->60->70*

*INVALID NUMBER, No Swapping, k>length of list*
*->10->20->30->40->50->60->70*

**Approach:**
  1. Find the length of the list, say it is ‘Len’.
  2. If k>Len, No Swapping.
  3. If kth node from the front and the end are same (2*k-1=Len), No Swapping.
  4. If above two steps are not true then we need swap­ping of the elements.
  5. Take a pointer left, move it by k nodes. Keep track of node prior to left( call it as left_prev, we need it for the swapping).
  6. Set left_prev = null if k=1.
  7. Take a pointer right, move it by len-k+1 nodes(it will be the kth node from the end). Keep track of node prior to left( call it as right_prev, we need it for the swapping).
  8. Set right_prev = null if k=Len.
  9. If left_prev!=NULL means left node is not the first node, so make left_prev will point to right
  10. If right_prev!=NULL means right node is not the first node, so right_prev will point to left node.
  11. Now just swap the next and right.next to com­plete the swapping.

*NOTE:We need to change the head of list if k =1 (head = right) or k = len (head = left).*

******************* 
####  problem-22: Delete X Nodes After Y Nodes In a Linked List
*******************
Given a Linked List and x and y. Delete x number of nodes after y nodes from the start.
*Example:*
*->10->20->30->40->50->60->70->80->90->100->110->120*
*Deleted 4 Nodes after 5 Nodes*
*->10->20->30->40->50->100->110->120*

**Approach:**
  1.  need two pointers.
  2. One pointer at one node prior to the nodes to be deleted. ( Move it by y start­ing from the head).
  3. Another pointer at one node after to the nodes to be deleted. (Move it by x start­ing from the y, as per pre­vi­ous step).
  4. Then Just link these two nodes.


******************* 
####  problem-23: Add 2 numbers represented by the linked lists, in reverse order; 
  The result should be represented by the linked list(reverse order)
*******************
*Objective: Two numbers represented by a linked list where each node con­tains single digit.* 
*The dig­its are stored in REVERSE order, means head is point­ing to the first digit of the number.*

`Input: Two numbers represented by Linked Lists`
`Out­put: Addition of two numbers rep­re­sented by a Linked List.`

*Example:*
*First Number in REVERSE order: 5957*
*Second Number in REVERSE order : 59*
*Addition in REVERSE order : 0967*
*Actual Result in FORWARD ORDER : 9670*

**Approach:**
1. Take a vari­able int carry =0.
2. Initialize Node newHead = null; and Node curr = null.
3. newHead will be the starting node of our result linked list and curr node will the reference to the current node on which we are working in our result linked list.
4. Navigate Both the lists simultaneously taking one node at a time.
5. Add the data of nodes and carry , say you call this as total.
6. Check if total >=10, if yes put carry =1 and total=total-10.
7. create a new node with value total, say you call it as Node ‘n’.
8. check if newHead is null, if yes then and assign ‘n’ to newHead. Now our starting node of result linked list is fixed.
9. if newHead is not null then add ‘n’ to the result linked list with the help of newHead and curr.
10. Now repeat steps 4 to 9 till any one of the list gets over( considering both the list has different length, if both list has the same length then both lists gets over at the same time, you will not need step 11).
11. Now navigate the list ( whichever is remain­ing) and add it to the result list. (take care of the carry, see Exam­ple). You can avoid this step by making sure that both the list has the same length adding 0 at the end of the shorter list , to see the similar implementation click here.
12. At the End check the carry, if it is not 0, create a new node with value 1 and add it to the result linked list.    
  
  
  
******************* 
####  problem-24: Add 2 numbers represented by the linked lists, in forward order; 
  The result should be represented by the linked list(forward order)
*******************

*Objective: Two num­bers represented by a linked list, where each node contains single digit. The digits are stored in* *Forward order, means head is pointing to the last digit of the number.*

`Input: Two num­bers represented by Linked Lists`
`Output: Addition of two numbers represented by a Linked List.`

*Example:*
*First Number : 1007*
*Second Number : 93*
*Addition : 1100*  

**Approach:**
1. Get the length of both the lists.
2. If lengths are not equal, make them equal by adding nodes with value 0 in front of shorter linked list.
3. Create a global variable carry=0.
4. Create a newHead = null;
5. newHead will be the starting node of our result linked list and curr node will the reference to the current node on which we are working in our result linked list.
6. Now using recursion travel in both the list till the end.
7. So now nodes are stores in a stack
8. Now while coming back, each node will pop out from the stack in reverse order
9. Take node data from both the lists add them along with carry.
10. if sum is >=10 , then make carry as 1 and create a new node with sum-10
11. Else just create a new Node with sum.
12. Add the newly created node to the result linked list with the help of newHead.


******************* 
####  problem-25:Given a Sorted Singly Linked List Array, Convert it into a Balanced Binary search Tree
*******************
*Objective: You have been given a sorted singly List, you need to con­vert it into balanced binary search tree.*

	Why balanced binary tree is important:
	You can also create first node as root and insert all other nodes to the right of the tree because List is in 			increasing order but this constructed tree won’t be balanced tree, it wil be skwed tree and to perform 			operations on this tree will be O(n) not O(logn).

`Input: An sorted Singly Linked List`
`Out­put: Bal­anced Binary Tree`

**Approach:**
1. Say mid is the middle node in the linked list.
2. Recursively con­struct left sub­tree from start to mid-1
3. Make the middle node as root and assign the left sub­tree to it.
4. Recursively construct right subtree from mid+1 to end.
5. Assign the right sub­tree to root.


******************* 
####  problem-26:In a Binary Tree, Create Linked Lists of all the nodes at each depth
*******************
*Objective: Given a Binary tree create Linked Lists of all the nodes at each depth , say if the tree has height k then create k linked lists.*
`Input: A binary tree`
`Output: K linked lists if the height of tree is k. Each linked list will have all the nodes of each level.`

**Approach:**
	--Recursion:
1. Create a ArrayList of Linked List Nodes.
2. Do the level order traversal using queue(Breadth First Search). Click here to know about how to level order traversal.
3. For getting all the nodes at each level, before you take out a node from queue, store the size of the queue in a variable, say you call it as levelNodes.
4. Now while levelNodes>0, take out the nodes and print it and add their children into the queue. add these to a linked list
5. After this while loop put a line break and create a new linked list


******************* 
####  problem-27:Identical Linked Lists
*******************
Two Linked Lists are identical when they have same data and arrangement of data is also same. 
*For example Linked lists a (1->2->3) and b(1->2->3) are identical.*
Write a function to check if the given two linked lists are identical.

*Method 1 (Iterative)*
To identify if two lists are identical, we need to traverse both lists simultaneously, and while traversing we need to compare data.

*Method 2 (Recursive)*
Recursive solution code is much cleaner than the iterative code. 
You probably wouldn’t want to use the recursive version for production code however, 
because it will use stack space which is proportional to the length of the lists

*Time Complexity: O(n) for both iterative and recursive versions. n is the length of the smaller list among a and b.*


******************* 
####  problem-28:Reverse a Linked List in groups of given size
*******************
*Given a linked list, write a function to reverse every k nodes (where k is an input to the function).*

`Example:`
`Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 `
`Output:  3->2->1->6->5->4->8->7->NULL. `

`Inputs:   1->2->3->4->5->6->7->80->NULL and k = 5`
`Output:  5->4->3->2->1->8->7->6->NULL.` 

**Algorithm: reverse(head, k)**
1. Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. Let the pointer to the next node be next and pointer to the previous node be prev. See this post for reversing a linked list.
2. head->next = reverse(next, k) /* Recursively call for rest of the list and link the two sub-lists */
3. return prev /* prev becomes the new head of the list */

******************* 
####  problem-29: Sort a linked list of 0s, 1s and 2s
*******************
Given a linked list of 0s, 1s and 2s, sort it.

**Following steps can be used to sort the given linked list.**
1. Traverse the list and count the number of 0s, 1s and 2s. Let the counts be n1, n2 and n3 respectively.
2. Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1 and finally n3 nodes with 2.

******************* 
####  problem-30: Reverse alternate K nodes in a Singly Linked List
*******************
Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. 
Give the complexity of your algorithm.

`Example:`
`Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3`
`Output:   3->2->1->4->5->6->9->8->7->NULL.` 

**Method 1 (Process 2k nodes and recursively call for rest of the list)** 
This method is basically an extension of the method discussed in this post.

**kAltReverse(struct node *head, int k) Time Complexity: O(n)**
  1.  Reverse first k nodes.
  2.  In the modified list head points to the kth node.  So change next 
       of head to (k+1)th node
  3.  Move the current pointer to skip next k nodes.
  4.  Call the kAltReverse() recursively for rest of the n - 2k nodes.
  5.  Return new head of the list.
  
**Method 2 (Process k nodes and recursively call for rest of the list) **
The method 1 reverses the first k node and then moves the pointer to k nodes ahead. 
So method 1 uses two while loops and processes 2k nodes in one recursive call.
This method processes only k nodes in a recursive call. 
It uses a third bool parameter b which decides whether to reverse the k elements or simply move the pointer.

**_kAltReverse(struct node *head, int k, bool b) Time Complexity: O(n)**
  1.  If b is true, then reverse first k nodes.
  2.  If b is false, then move the pointer k nodes ahead.
  3.  Call the kAltReverse() recursively for rest of the n - k nodes and link 
       rest of the modified list with end of first k nodes. 
  4.  Return new head of the list.  
