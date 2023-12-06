import java.util.*;
public class Rodblox_1 {
    public static int solution(int[] numbers) {
        int n = numbers.length;
        Set<Integer> uniqueNumbers = new HashSet<>();
        int distinctPairs = 0;
        Map<Integer, Integer> countNumbers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            uniqueNumbers.add(numbers[i]);
            countNumbers.put(numbers[i], countNumbers.getOrDefault(numbers[i], 0) + 1);
        }

        for (Integer uniqueNumber : uniqueNumbers) {
            for (int number : numbers) {
                if (canSwap(uniqueNumber, number)) {
                    if (uniqueNumber != number) {
                        distinctPairs++;
                    } else {
                        distinctPairs -= countNumbers.get(uniqueNumber) - 1;
                    }
                }
            }
        }

        return distinctPairs/2;
    }

    private static boolean canSwap(int uniqueNumber, int number) {
        String uniqueNumberStr = String.valueOf(uniqueNumber);
        String numberStr = String.valueOf(number);

        if (uniqueNumberStr.length() != numberStr.length()) {
            return false;
        }

        int mismatches = 0;

        for (int i = 0; i < uniqueNumberStr.length(); i++) {
            if (uniqueNumberStr.charAt(i) != numberStr.charAt(i)) {
                mismatches++;
            }
        }

        return mismatches <= 2;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 23, 156, 1650, 651, 165, 321};
        int distinctPairs = solution(numbers);
        System.out.println(distinctPairs); // 6

        numbers = new int[]{123, 321, 1231};
        distinctPairs = solution(numbers);
        System.out.println(distinctPairs); // 3
    }
}
