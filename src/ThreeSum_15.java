import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[0] = -1;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = -1;
        nums[5] = -4;
        System.out.println("For this Int Array: "+ Arrays.toString(nums) + " : Three Sum Values are: " + threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> f = new HashSet<>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        int nums_len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < nums_len - 1; i++) {
            for (int j = i + 1; j < nums_len; j++) {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                li.add(j);
                map.put(li, nums[i] + nums[j]);
            }
        }

        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            for (int i=0; i<nums_len; i++) {
                List<Integer> key = entry.getKey();
                if (key.get(1) < i && entry.getValue() == nums[i] * -1) {
                    f.add(new ArrayList<>(Arrays.asList(nums[key.get(0)], nums[key.get(1)], nums[i])));
                }
            }
        }

        return new ArrayList<>(f);
    }
}

