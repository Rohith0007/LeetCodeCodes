public class Best_Time_122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {6,1,3,2,4,7}));
    }
    public static int maxProfit(int[] prices) {
        int start = 0;
        int end = 0;
        int profit =0;
        boolean flag = true;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i]<prices[i+1]){
                if(flag) {
                    start = prices[i];
                    flag=false;
                }
                if(i+1 == prices.length-1) {
                    profit += (prices[i+1]-start);
                }
            } else {
                if(!flag){
                    end=prices[i];
                    profit+=(end-start);
                    flag=true;
                }
            }
        }
        if(profit==0 && prices[prices.length-1]>prices[0]) {
            return prices[prices.length-1]-prices[0];
        }
        return profit;
    }
}
