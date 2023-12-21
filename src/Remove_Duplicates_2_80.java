import java.util.Arrays;

public class Remove_Duplicates_2_80 {
    public static int removeDuplicates(int[] nums) {
        int k=0;
        for(int i=0; i<nums.length-1; i++) {
            if(i==0) {
                nums[k++] = nums[i];
            } else if(nums[i] == nums[i+1] && nums[i] == nums[i-1]) {
                continue;
            } else {
                nums[k++] = nums[i];
            }
        }
        nums[k++] = nums[nums.length - 1];
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,1,2,2,3}));
    }
}
