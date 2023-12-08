import java.util.*;

public class Kth_Largest_215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        while(k != 0) {
            res = helperClass(nums);
            k--;
        }
        return res;
    }

    public static int helperClass(int[] nums) {
        int m = Integer.MIN_VALUE;
        int temp;
        int k=0;
        for(int i=0; i<nums.length; i++) {
            temp = m;
            m = Math.max(m, nums[i]);
            if(m != temp) {
                k = i;
            }
        }
        int temp1 = nums[k];
        nums[k] = Integer.MIN_VALUE;
        return temp1;
    }
}
