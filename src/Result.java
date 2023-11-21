import java.util.Arrays;
import java.util.List;

public class Result {
    public static long getMinimumMoves(List<Integer> quantity) {
        int n = quantity.size();
        long totalQuantity = 0;
        for (int q : quantity) {
            totalQuantity += q;
        }

        long minMoves = Long.MAX_VALUE;
        long sum1 = 0;

        for (int j = 0; j < n - 1; j++) {
            sum1 += quantity.get(j);
            long sum2 = totalQuantity - sum1;
            long movesNeeded = Math.abs(sum1 - sum2);
            minMoves = Math.min(minMoves, movesNeeded);
        }

        return minMoves;
    }

    public static void main(String[] args) {
        List<Integer> quantity = Arrays.asList(3, 1, 4, 2, 2);
        System.out.println(getMinimumMoves(quantity)); // Output: 2
    }
}
