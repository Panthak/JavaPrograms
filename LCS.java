import java.util.*;

public class LCS {

    //tabular method
    private int findLCSTabular(char[] s1, char[] s2, int s1_len, int s2_len) {
        int L[][] = new int[s1_len+1][s2_len+1];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<=s1_len; i++) {
            for(int j=0; j<=s2_len; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                }
                else if (s1[i-1] == s2[j-1]) {
                   L[i][j] = 1 + L[i-1][j-1];
                }
                else {
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                    
                }
            }
        }
        for(int i=0; i<=s1_len; i++) {
            for(int j=0; j<=s2_len; j++) {
                System.out.print(L[i][j]+"\t");
            }
            System.out.println();
        }
        
        //tracing the table to get the string
        for(int i=s1_len,j=s2_len; j >1;) {
            System.out.print("i : "+i+"\tj : "+ j);
            if(L[i-1][j-1] == (L[i][j]-1)) {
                sb.append(s1[i-1]);
                System.out.print(s1[i-1]+"\t");
                i--;j--;
            }
            else if (L[i-1][j] < L[i][j-1] ) {
                j--;
            }
            else {
                i--;
            }
            System.out.println();
        }
        System.out.println(sb.reverse());
        return L[s1_len][s2_len];
    }

    //recursive method
    private int findLCS(char[] s1, char[] s2, int s1_len, int s2_len) {
        if (s1_len == 0 || s2_len == 0) {
            return 0;
        }
        if (s1[s1_len-1] == s2[s2_len-1]) {
            return 1 + findLCS(s1, s2, s1_len-1, s2_len-1);
        }
        else {
            return Math.max(findLCS(s1, s2, s1_len, s2_len-1), findLCS(s1, s2, s1_len-1, s2_len));
        }
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        LCS lcs = new LCS();
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        int s1_len = s1_arr.length;
        int s2_len = s2_arr.length;
        System.out.println("LCS recursive : "+lcs.findLCS(s1_arr, s2_arr, s1_len, s2_len));
        System.out.println("LCS tabular : "+lcs.findLCSTabular(s1_arr, s2_arr, s1_len, s2_len));
    }
}
