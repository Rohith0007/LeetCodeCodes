import java.util.*;

/***
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 ***/
public class Permutation {
    public static void main(String[] args) {
        Permutation m = new Permutation();
        int[] arr= new int[]{1, 2, 3};
        System.out.println(m.permute(arr));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int start){
        if(start == nums.length){
            res.add(convertToList(nums));
        }
        else{
            for(int i = start; i< nums.length; i++){
                swap(i, start, nums);
                backtrack(res, nums, start+1);
                swap(i, start, nums);
            }
        }
    }

    public List<Integer> convertToList(int[] nums){
        List<Integer> li = new ArrayList<>();
        for(int i: nums){
            li.add(i);
        }
        return li;
    }

    public void swap(int i, int start, int[] nums){
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
