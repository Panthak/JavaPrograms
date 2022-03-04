import java.util.*;
//heap space issue..
public class mergeLists {
    private List<Integer> merge(List<List<Integer>> list) {
        List<Integer> answer = new ArrayList<>();
        for(int i= 0; i<list.size()-1; i++) {
            System.out.println("Iteration -- "+i);
            int x=0,y=0;
            int len_1 = list.get(i).size();
            int len_2 = list.get(i+1).size();
            int xx, yy;
            while(x < len_1 && y < len_2) {
                xx = list.get(i).get(x++);
                yy = list.get(i+1).get(y++);
                if(xx <= yy) {
                    System.out.println("Added -- "+xx);
                    answer.add(xx);
                }
                else {
                    answer.add(yy);
                    System.out.println("Added -- "+xx);
                }
            }
            while(x < len_1) {
                System.out.println("Added REST -- "+list.get(i).get(x));
                answer.add(list.get(i).get(x++));
                
            }
            if((i+1) == list.size()-1) {
                while(y < len_2) {
                    System.out.println("Added REST last -- "+list.get(i).get(y));
                    answer.add(list.get(i+1).get(y++));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(5);
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(10);
        list2.add(15);
        List<Integer> list3 = new ArrayList<>();
        list3.add(8);
        list3.add(16);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(lists);
        mergeLists ml = new mergeLists();
        
        System.out.println(ml.merge(lists));
    }
}
