import java.util.*;

public class dupInRange {

    private void findDupUsingMap(int[] arr, int window) {
        Map<Integer, Integer> map = new HashMap<>();

    }

    //good imlementation using set
    private void findDupUsingSet(int[] arr, int window) {
        boolean flag = false;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(set.contains(arr[i])) {
                System.out.println("Dup found : "+arr[i]);
                flag = true;
            }
            set.add(arr[i]);
            if(i >= window) {
                set.remove(arr[i-window]);
            }
        }
        if(!flag) {
            System.out.println("Dup not found");
        }
        
    }
    //bad implementation
    private void isDupPresent(int[] arr, int start, int window) {
        Set<Integer> set = new HashSet<>();
        for(int i=start; i<=(start+window); i++) {
            set.add(arr[i]);
        }
        System.out.println("set size "+set.size());
        for(int i : set) {
            System.out.print(i+"\t");
        }
        if((window+1) == set.size()) {
            System.out.println("No dup in "+start+","+(start+window));
        }
        else {
            System.out.println("dup found in "+start+","+(start+window));
        }
        set.clear();
    }
    private void findDup(int[] arr, int window) {
        int len = arr.length;
        for(int i=0; i<(len-window); i++) {
            isDupPresent(arr, i, window);
        }
    }
    public static void main(String[] args) {
        dupInRange dir = new dupInRange();
        // arr
        int[] arr = {5, 6, 8, 2, 4, 6, 9};
        // window
        int window = 4;
        //start silidng the window and check the duplicate
        //dir.findDup(arr, window);
        dir.findDupUsingSet(arr, window);
    }
}
