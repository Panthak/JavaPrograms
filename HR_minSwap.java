import java.util.*;

public class HR_minSwap {
    static int count = 0;
    private void minSwaps(int[] arr, int n) {
        boolean isSwapReq = false;
        int min, min_index;
        for(int i=0; i<n-1; i++) {
            min = arr[i];
            min_index = i;
            for(int j=i+1; j<n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_index = j;
                    isSwapReq = true;
                }
            }
            if(isSwapReq) {
                
                swap(arr, i, min_index);
                isSwapReq = false;
            }
        }
        printArr(arr);
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        count++;
    }

    private void printArr(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            System.out.print(arr[i]+"\t");
        }

    }
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       HR_minSwap hrm = new HR_minSwap();
       int n = scan.nextInt();
       scan.nextLine();
       String[] s = scan.nextLine().split(" ");
       int[] arr = new int[n];
       for(int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(s[i]);
       }
       hrm.minSwaps(arr, n);
       System.out.println("Min swaps : "+count);
   } 
}  
