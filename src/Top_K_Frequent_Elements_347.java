import java.util.*;

public class Top_K_Frequent_Elements_347 {
    public static void main(String[] args) {
        Top_K_Frequent_Elements_347 top = new Top_K_Frequent_Elements_347();
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(top.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1 && nums.length == k) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] frequencyArray = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (frequencyArray[frequency] == null) {
                frequencyArray[frequency] = new ArrayList<>();
            }
            frequencyArray[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = frequencyArray.length - 1; i >= 0 && index < k; i--) {
            if (frequencyArray[i] != null) {
                for (int num : frequencyArray[i]) {
                    result[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
