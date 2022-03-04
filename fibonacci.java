import java.util.*;

public class fibonacci {
    //fib recursive.. 2^n complexity..
    private int fib(int x) {
        if (x <= 2) {
            return 1;
        }
        else {
            return fib(x-1)+fib(x-2);
        }
    }

    //fib normal.. O(N)
    private int fibo(int x) {
        if (x <= 2) {
            return 1;
        }
        else {
            int a = 1;
            int b = 1;
            int temp;
            System.out.print(a+"\t"+b+"\t");
            for(int i=2; i<x; i++) {
                temp = a;
                a = b;
                b = (temp+b);
                System.out.print(b+"\t");
            }
            System.out.println();
            return b;
        }
    }
    public static void main(String[] args) {
        fibonacci fb = new fibonacci();
        System.out.println("3 - "+fb.fib(3));
        System.out.println("5 - "+fb.fib(5));
        //System.out.println("3 - "+fb.fib(300));
        System.out.println("6 - "+fb.fibo(6));
    }
}
