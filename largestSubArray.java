/*
Find the largest subarray formed by consecutive integers
Input:  { 2, 0, 2, 1, 4, 3, 1, 0 }
 
Output: The largest subarray is { 0, 2, 1, 4, 3 }
*/
import java.util.*;

public class largestSubArray {
    // set
    // insert elements until we find duplicate, and store length of it
    //return max length
    private void findLargestSubArray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        int low = 0, high = 0;
        int max = 0, last_low_index = 0, last_high_index=0;
        for(int i=0; i<n; i++) {
            
            if(set.contains(arr[i])) {
                if(max < (high-low)) {
                    max = high-low;
                    last_low_index = low;
                    last_high_index = high;
                }
                low++;
            }
            if (high == n-1) {
                //if last element is reached and the element is also new
                if(max < (high-low)) {
                    max = high-low;
                    last_low_index = low;
                    last_high_index = high+1;
                }
            }
            high++;
            set.add(arr[i]);
        }
        if(max == 0) {
            //entire array is unique
            max = n;
            last_low_index = 0;
            last_high_index = n;
        }
        System.out.println("max length : "+max);
        for(int i=last_low_index; i<last_high_index; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 0, 2, 3, 4, 5, 6};
        int[] arr2 = { 2, 0, 2, 1, 4, 3, 1, 0 };
        int[] arr3 = {4,1,0,2};
        int[] arr = { 2, 0, 2, 1, 4, 3, 9, 0, 5, 7, 8, 10, 11, 2};
        largestSubArray ls = new largestSubArray();
        ls.findLargestSubArray(arr1);
        ls.findLargestSubArray(arr2);
        ls.findLargestSubArray(arr3);
        ls.findLargestSubArray(arr);

    }
}
