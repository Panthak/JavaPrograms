/*
find the number of occurrances of a character in the repeated string.
Example :
string - aba
repeatation - till 10 characters
so the repeted string would be - abaabaabaa 
No. of char 'a' = 7.
*/
import java.util.*;

public class RepeatedStringCharOccurance {

    private long findOccurance(String s, int repeatCount, char x) {
        int length = s.length();
        long occuranceInTotal = 0;
        // System.out.println("Occurance in a single string : "+occuranceInS);
        int rem = repeatCount%length;
        occuranceInTotal = (getCharCount(s, length, x) * (repeatCount/length))+getCharCount(s, rem, x);
        return occuranceInTotal;
    }

    private long getCharCount(String s, int len, char x) {
        long occuranceInS = 0;
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == x) {
                occuranceInS++;
            }
        }
        return occuranceInS;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int repeatCount = scan.nextInt();
        RepeatedStringCharOccurance rs = new RepeatedStringCharOccurance();
        System.out.println("Occurrance in total : "+rs.findOccurance(s, repeatCount, 'a'));
    }    
}
