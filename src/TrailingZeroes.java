import java.util.*;
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }
    public static int trailingZeroes(int n) {
        int k=0;
        for(int i=1; i<n+1; i++) {
            int a = i;
            while(a/5 != 0) {
                a = a/5;
                k++;
            }
        }
        return k;
    }
}
