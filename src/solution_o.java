import java.util.ArrayList;
import java.util.List;

public class solution_o {
    public static int[] processQueries(int[] a, int[] b, int[][] queries) {
        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];

            if (type == 0) {
                // Process type 0 query
                b[x] += a[x];
            } else {
                // Process type 1 query
                int count = 0;
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < b.length; j++) {
                        if (a[i] + b[j] == x) {
                            count++;
                        }
                    }
                }
                results.add(count);
            }
        }

        // Convert the results to an array
        int[] resultArray = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArray[i] = results.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] b1 = {1, 4};
        int[][] queries1 = {{1, 5}, {0, 0, 2}, {1, 5}};
        int[] result1 = processQueries(a1, b1, queries1);
        System.out.println("Result 1: " + java.util.Arrays.toString(result1)); // Output: [1, 2]

//        int[] a2 = {1, 2, 2};
//        int[] b2 = {2, 3};
//        int[][] queries2 = {{1, 4}, {0, 0, 1}, {1, 5}};
//        int[] result2 = processQueries(a2, b2, queries2);
//        System.out.println("Result 2: " + java.util.Arrays.toString(result2)); // Output: [3, 4]
    }
}
