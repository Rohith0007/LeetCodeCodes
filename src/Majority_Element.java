import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Majority_Element {
    public static void main(String[] args) {
        Majority_Element me = new Majority_Element();
        int[] nums = {3,8,3};
        System.out.println(me.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    }
}