import java.util.*;
public class Perfect_Squares_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int res = Integer.MAX_VALUE;
        int i=1;
        while(i*i<=n) {
            list.add(i*i);
            i++;
        }
        int num;
        i=0;
        int j;
        while(i<list.size()) {
            num = n - list.get(i);
            j=0;
            if(num == 0) {
                j++;
            }
            while(num >= 0) {
                int maxLessThanTarget = Integer.MIN_VALUE;
                for (int number : list) {
                    if (number <= num && number > maxLessThanTarget) {
                        maxLessThanTarget = number;
                    }
                }
                num = num - maxLessThanTarget;
                j++;
            }
            res = Math.min(res, j);
            i++;
        }
        for(int l: list) {
            i=2;
            while(i<l) {
                if(l*i == n) {
                    res = Math.min(res, i);
                }
                i++;
            }
        }
        return res;
    }
}
