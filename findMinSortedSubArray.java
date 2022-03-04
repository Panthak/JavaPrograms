import java.util.*;

//11,12,13,0,1,2,3,4 --> find min value
public class findMinSortedSubArray {
    private int divide(int[] arr, int l, int r) {
        int len = arr.length;
        int mid = (r-1)/2;
        if(arr[l] > arr[mid]) {
            if(arr[mid] > arr[mid-1]) {
                while(arr[mid] > arr[mid-1]) {
                    mid--;
                }
            }
            return arr[mid];
        }
        else if(arr[l] < arr[mid]) {
            if(arr[mid] > arr[mid-1]) {
                while(arr[mid] > arr[mid-1]) {
                    mid--;
                }
                return arr[mid];
            }
        }
        return arr[l];
        
    }

    private int bruteforce(int[] arr) {
        int min = arr[0];
        int len = arr.length;
        for(int i=0; i<len; i++) {
            if(arr[i] < min) {
                min = arr[i];
                break;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {11,12,13,0,1,2,3,4};
        findMinSortedSubArray fmss = new findMinSortedSubArray();
        System.out.println(fmss.bruteforce(arr));
        System.out.println(fmss.divide(arr, 0, arr.length));
    }
}
