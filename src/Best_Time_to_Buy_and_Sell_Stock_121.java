import java.math.*;
import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
//        int res = 0;
//        int len = prices.length;
//        for(int i=0; i<len-1; i++) {
//            int[] sub = Arrays.copyOfRange(prices, i+1, len);
//            Arrays.sort(sub);
//            int sub_max = sub[sub.length-1];
//            if (sub_max < prices[i]) {
//                continue;
//            }
//            res = Math.max(res, sub_max - prices[i]);
//        }
//        return res;
    }
}
