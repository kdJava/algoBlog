package arrays.problem1;

import java.util.Arrays;


/*
 * Given an array of size n where all elements are in range from 0 to n-1, 
 * change contents of arr[] so that arr[i] = j is changed to arr[j] = i.

Examples:

Example 1:
Input: arr[]  = {1, 3, 0, 2};
Output: arr[] = {2, 0, 3, 1};
Explanation for the above output.
Since arr[0] is 1, arr[1] is changed to 0
Since arr[1] is 3, arr[3] is changed to 1
Since arr[2] is 0, arr[0] is changed to 2
Since arr[3] is 2, arr[2] is changed to 3

Example 2:
Input: arr[]  = {2, 0, 1, 4, 5, 3};
Output: arr[] = {1, 2, 0, 5, 3, 4};

Example 3:
Input: arr[]  = {0, 1, 2, 3};
Output: arr[] = {0, 1, 2, 3};

Example 4:
Input: arr[]  = {3, 2, 1, 0};
Output: arr[] = {3, 2, 1, 0};
A Simple Solution is to create a temporary array and one by one copy ‘i’ to ‘temp[arr[i]]’ where i varies from 0 to n-1.
 */
public class Problem1 {

	static void rearrangeNaive(int arr[], int n)
	{
	    // Create an auxiliary array of same size
		int[] temp=new int[n];
	    
		// Store result in temp[]
	    for (int i=0; i<n; i++){
	    	temp[arr[i]] = i;
	    }
	 
	    // Copy temp back to arr[]
	    for (int i=0; i<n; i++){
	    	arr[i] = temp[i];
	    }
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 0, 2};
	 
	    System.out.println("Given array is:"+Arrays.toString(arr));
	 
	    rearrangeNaive(arr,  arr.length);
	 
	    System.out.println("Modified array is:"+Arrays.toString(arr));

	}
	
	interface ABC{
		default void func(){
			System.out.println("Hi..!!");
		}
		
		static void fun2(){
			System.out.println("Hi2..!!");
		}
	}

}
