import java.util.*;

class findSumPair {
    
    //HashSet appraoch with O(N) time complexity..
    void findPairUsingHashSet(int[] arr, int sum) {
        int len = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<len; i++) {
            int temp = sum-arr[i];
            if(hs.contains(temp)) {
                System.out.println("pair found : ["+arr[i]+" , "+temp+"]");
            }
            else {
                hs.add(arr[i]);
            }
        }
    }

    //native approach with O(N^2) time complexity..
    void findPair(int[] arr, int sum) {
        int len = arr.length;
        for(int i=0; i < len-1;i++) {
            for(int j=i+1; j<len;j++) {
                if(arr[i] + arr[j] == sum) {
                    System.out.println("pair found : ["+arr[i]+" , "+arr[j]+"]");
                    arr[i] = arr[j] = 0;
                }
            }
        }
    } 


    public static void main(String[] args) {
        int[] arr = new int[]{1,-1,3,-4,2,3,5,12,6};
        int sum = 8;
        findSumPair ob = new findSumPair();
        //ob.findPair(arr, sum);
        System.out.println("### HashSet ");
        ob.findPairUsingHashSet(arr, sum);
    }
}