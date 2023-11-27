import java.util.*;

public class Longest_Consecutive_128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,2};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        List<Integer> set = new ArrayList<>();
        int max=0;
        int len=0;
        for(int i: nums) {
            set.add(i);
        }
        for(int i: set) {
            len=0;
            if(!set.contains(i-1)) {
                while(set.contains(i+len)) {
                    len+=1;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
