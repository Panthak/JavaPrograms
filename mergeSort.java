import java.util.*;

public class mergeSort {

    private void divide(int[] arr, int l, int r) {
        if (r > l) {
            int mid = (r+l)/2;
            divide(arr, l, mid);
            divide(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0; i<n1; i++) {
            L[i] = arr[l+i];
        }
        for(int i=0; i<n2; i++) {
            R[i] = arr[m+1+i];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                k++;
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        } 
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        //printArr(arr);
    }

    private void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {30, 20, 10, 5, 0, 60};
        mergeSort ms = new mergeSort();
        ms.divide(arr, 0, arr.length-1);
        ms.printArr(arr);
    }
}
