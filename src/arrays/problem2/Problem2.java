package arrays.problem2;

public class Problem2 {

	// Simple binary search algorithm
	static int binarySearch(int arr[], int lo, int hi, int key)
	{
	    if (hi>=lo)
	    {
	        int mid = lo + (hi - lo)/2;
	        if (key == arr[mid]){
	        	 return mid;
	        }else if(key > arr[mid]){
	        	return binarySearch(arr, mid+1, hi, key);
	        }else if(key < arr[mid]){
	        	return binarySearch(arr, lo, mid-1, key);
	        }
	        
	    }
	    return -1;
	}
	
	// function takes an infinite size array and a key to be
	//  searched and returns its position if found else -1.
	// We don't know size of arr[] and we can assume size to be 
	// infinite in this function.
	static int findPos(int arr[], int key)
	{
		int low = 0, high = 1;
		int val = arr[0];
 
		// Find h to do binary search
		while (val < key)
		{
			low = high;  		// store previous high
			high = 2*high;      // double high index
			/*
			 * to take care cases where 2*High >>> arr.length and hence 
			 * the arr[2*high] below throw ArrayIndexOutOfBoundsException
			 * as we cannot denote infinite array.. 
			 * But moving 1 index at a time like newHigh=oldHigh+1, the
			 * complexity increases greatly and from O(logN) goes to O(N)
			 * ie; lograthmic to linear
			 * so we can do high=high+1; as below
			 */
			//high+=1;  
			System.out.println("High-->"+high+" . Low-->"+low);
			val = arr[high]; // update new val
		}
		
		System.out.println("Decided High and Low Values for Binary Search: low-->"+low+" ,high-->"+high);
 
		// at this point we have updated low and high indices,
		// thus use binary search between them
		return binarySearch(arr, low, high, key);
	}
	
	/*
	 * In our current example the code can throw ArrayIndexOutOfBoundsException
	 * if the 2*high( ie the new high) exceeds the arrayLimit as we cannot denote an infinite array here
	 *  
	 */
	public static void main(String[] args) {
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		System.out.println("ArraySize-->"+arr.length);
	    int ans = findPos(arr, 170);
	    if (ans==-1){
	    	 System.out.println("Element not found"); 
	    }
	    else{
	    	System.out.println("Element found at index-->"+ans);
	    }
	}
}
