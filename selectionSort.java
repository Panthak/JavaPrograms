import java.util.*;

class selectionSort{
    static int minIndex = 0, minValue = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1,2,0,0,33,-2,-5};
        System.out.println("Given array : \n");
        printArray(arr);
        sort(arr);
        System.out.println("Sorted array : ");
        printArray(arr);
    }

    static void sort(int[] arr) {
        int length = arr.length;
        boolean flag = false;
        for(int i=0; i < length-1; i++) {
            minIndex = i;
            minValue = arr[i];
            //System.out.println("New min index : "+minIndex+"\t New min value : "+minValue);
            for(int j=i+1; j<length; j++) {
                // System.out.println("checking : "+minValue+"\t"+arr[j]);
                if (isMin(arr[j])) {
                    minIndex = j;
                    minValue = arr[j];
                    // System.out.println("minIndex and minValue : "+minIndex+"\t"+arr[minIndex]);
                    flag = true;
                }
            }
            if (flag) {  
                // System.out.println("Swapping : "+arr[i]+"\t"+arr[minIndex]);
                swap(arr, i, minIndex);
                //printArray(arr);
                flag = false;
            }
            else {
                // System.out.println("No swapping required");
            }
        }
    }

    static boolean isMin(int b) {
        if (b < minValue) {
            return true;
        }
        return false;
    }

    static void swap(int[] arr, int index, int j) {
        int temp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = temp;
    }

    static void printArray(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

}