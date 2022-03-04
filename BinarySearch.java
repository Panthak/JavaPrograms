import java.util.*;

public class BinarySearch {
    
    void binarySearch(int[] arr, int l,int r, int x) {
        if (x == arr[r]) {
            System.out.println("Element found");
        }
        else if (x < arr[r]) {
            if (r > 0) {
                r = r/2;
                binarySearch(arr, l, r, x);
            }
            else {
                System.out.println("Element not found");
            }
        }
        else if (x > arr[r]) {
            l = r;
            r = (l + (arr.length))/2;
            if (l != r) {
                binarySearch(arr, l, r, x);
            }
            else {
                System.out.println("Element not found");
            }
        }
    }   
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int length = arr.length;
        int r = (length-1)/2;
        int x = 103;
        BinarySearch bSearch = new BinarySearch();
        bSearch.binarySearch(arr, 0, r, x);

    }
}
