import java.util.Arrays;

public class tshift {

    public static int findCyclicTShift(int[] nums) {
        int maxValue = nums.length;
        int[] maxNums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            maxNums[i] = maxValue-i;
        }
        if (Arrays.equals(nums, maxNums)) {
            return 0;
        }
        for(int i=0; i<maxValue; i++) {
            int last = nums[maxValue-2];
            int first = nums[maxValue-1];
            for(int j=maxValue-2; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = first;
            nums[maxValue-1] = last;
            if(Arrays.equals(nums, maxNums)) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 2, 3};
        int[] nums2 = {3, 2, 1, 5, 4};

        System.out.println("Cyclic shift for nums1: " + findCyclicTShift(nums1));  // Output: -1
        System.out.println("Cyclic shift for nums2: " + findCyclicTShift(nums2));  // Output: 2
    }
}
