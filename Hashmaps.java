//Complete this code or write your own from scratch
import java.util.*;

class Hashmaps{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int phone;
        System.out.println("No of records in the phone directory : ");
        int n = in.nextInt();
        HashMap<String, Integer> hm_phone = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            phone = in.nextInt();
            hm_phone.put(name, phone);
            // Write code here
        }
        hm_phone.put("key", 123);
        System.out.println("start searching with names : ");
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(hm_phone.containsKey(s)) {
                System.out.println(s+" -> "+hm_phone.get(s));
            }
            else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}