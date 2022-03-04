import java.util.*;

class PairOfFour {
    static class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void findPairOfFour(int[] arr, int SUM) {
        int len = arr.length;
        int temp = 0;
        HashMap<Integer, List<pair>> hm = new HashMap<>();

        //Now we will find if the difference of SUM and stored partial sum of pairs is present in the hashmap or not..
        for(int i=0; i<len-1; i++) {
            for(int j=0; j<len; j++) {
                temp = arr[i] + arr[j];
                if(hm.containsKey(SUM - temp)) {
                    for(pair p : hm.get(SUM - temp)) {
                        if ((p.x != i && p.x != j) && (p.y != i && p.y != j)) {
                            System.out.println("pair : "+arr[i]+", "+arr[j]+", "+arr[p.x]+", "+arr[p.y]);
                        }
                    }
                }
                else {
                    hm.put(arr[i]+arr[j], new ArrayList<>());
                    hm.get(arr[i]+arr[j]).add(new pair(i, j));
                }
            }
        }
    }
    // O(N^3) time complexity.
    void findPairWithSort(int[] arr, int SUM) {
        Arrays.sort(arr);
        int temp = 0;
        int lptr, rptr;
        int n = arr.length;
        for(int i = 0; i < n-3; i++) {
            for(int j = i+1; j < n-2; j++) {
                temp = arr[i]+arr[j];
                lptr = j+1;
                rptr = n-1;
                while(lptr < rptr) {
                    if(arr[lptr]+arr[rptr] < (SUM - temp)) {
                        lptr++;
                    }
                    else if(arr[lptr]+arr[rptr] > (SUM - temp)) {
                        rptr--;
                    }
                    else {
                        System.out.println("pair : "+arr[i]+", "+arr[j]+", "+arr[lptr]+", "+arr[rptr]);
                        lptr++;
                        rptr--;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        PairOfFour pof = new PairOfFour();
        int[] arr = new int[]{1,-1,0,-2,2};
        int[] arr1 = new int[]{2,2,2,2,2};
        int SUM = 8;
        //pof.findPairOfFour(arr, SUM);
        pof.findPairWithSort(arr1, SUM);
    }
}