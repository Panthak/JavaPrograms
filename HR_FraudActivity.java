/*
HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.

Given the number of trailing days  and a client's total daily expenditures for a period of  days, determine the number of times the client will receive a notification over all  days.

----

Example
exp = {10,20,30,40,50}
d = 3

On the first three days, they just collect spending data. At day , trailing expenditures are . The median is  and the day's expenditure is . Because , there will be a notice. The next day, trailing expenditures are  and the expenditures are . This is less than  so no notice will be sent. Over the period, there was one notice sent.

Note: The median of a list of numbers can be found by first sorting the numbers ascending. If there is an odd number of values, the middle one is picked. If there is an even number of values, the median is then defined to be the average of the two middle values
*/

import java.util.*;

public class HR_FraudActivity {
    public class mergeSort {
        public void sort(int[] arr, int l, int r) {
            if (r > l) {
                int mid = l + (r-l)/2;
                sort(arr, l, mid);
                sort(arr, mid+1, r);
                merge(arr, l, mid, r);
            }
        }
    
        public void merge(int[] arr, int l, int m, int r) {
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
    
        public void printArr(int[] arr) {
            for(int i=0; i<arr.length; i++) {
                System.out.print(arr[i]+"\t");
            }
            System.out.println();
        }
    
    }

    private void notify(int[] expenditure, int d) {
        mergeSort ms = new mergeSort();
        
        int l = 0;
        while(d < expenditure.length) {
            ms.sort(expenditure, l, d-1);
            if (expenditure[d] >= (2*maiden(expenditure, l, d-1))) {
                System.out.println("Notify at "+expenditure[d]);
            }
            l++;
            d++;
        }
    }
    private int maiden(int[] arr, int l, int r) {
        int m = (r+l)/2;
        //System.out.println("Length "+(r - l));
        if ((r - l)%2 != 0) {
            //subtraction of two odd number is always even
            //if the array has even length, return avg of middle elements.
            //System.out.println("Maiden at "+l+" -- "+r+" is : "+((m+(m+1))/2));
            return ((m+(m+1))/2);
        }
        else {
            //if the array has odd length return the middle element
            //System.out.println("Odd || Maiden at "+l+" -- "+r+" is : "+arr[m]);
            return arr[m];
        }

    }
    /*
    -- coding
    -- time management
    -- technical communication

    -- ask clarifying questions
    -- confirm the requirements
    -- explain the algo
    -- implement the algo
    -- quality of the code (corner case, syntax error, optimization, test manually and find bugs)

    
    */


    public static void main(String[] args) {
        int[] expenditure = {10,20,30,40,50};
        int d = 3;
        HR_FraudActivity hrf = new HR_FraudActivity();
        hrf.notify(expenditure, d);
    }
}

