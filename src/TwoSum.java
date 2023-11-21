import java.util.*;

/***
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that
 * they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 ***/
public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(ts.twoSum(nums, 9)));
    }
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;

        for(int i=0; i<nums.length; i++){
            c = target-nums[i];
            if(map.containsKey(c)){
                return new int[] {map.get(c), i};
            }
            map.put(nums[i], i);

        }

        return null;
    }
}