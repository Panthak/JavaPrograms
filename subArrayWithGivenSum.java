/*
Input:  {2, 6, 0, 9, 7, 3, 1, 4, 1, 10}, sum 15
Output: Subarray {6, 0, 9} exists with sum 15

Check if the given array has any subarray which equals to the given sum.
*/
import java.util.*;

public class subArrayWithGivenSum { 

    private void map_isSubArrayPresent(int[] arr, int sum) {
        //use map to store sum, ith index
        //keep adding elements in the map with it's sum with previous element until we find (currentSum - sum)
        int n = arr.length; 
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // to take care of the index starting from 0 in the value column

        for(int i=0; i<n; i++) {
            currentSum += arr[i];
            if(map.containsKey(currentSum - sum)) {
                System.out.println("pair index : "+(map.get(currentSum - sum)+1)+" -- "+ i);
            }
            
            map.put(currentSum, i);
        }
    }

    private boolean set_isSubArrayPresent(int[] arr, int sum) {
        //just to check if such sub array is present or not.
        int n = arr.length;
        int currentSum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i=0;i<n;i++) {
            currentSum += arr[i];
            if(set.contains(currentSum - sum)) {
                return true;
            }
            set.add(currentSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10};
        int sum = 15;
        subArrayWithGivenSum sws = new subArrayWithGivenSum();
        sws.map_isSubArrayPresent(arr, sum);
        System.out.println(sws.set_isSubArrayPresent(arr, sum));
    }
}