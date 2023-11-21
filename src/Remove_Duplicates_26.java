import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Remove_Duplicates_26 {
    public static void main(String[] args) {
        Remove_Duplicates_26 rm = new Remove_Duplicates_26();
        int[] nums = {0, 0, 0, 3};
        System.out.println(rm.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int[] nums1 = Arrays.stream(nums).distinct().toArray();
        System.out.println(Arrays.toString(nums1));
        int len = nums.length;
        int len2 = nums1.length;
        if(len == len2) {
            return len;
        } else {
            for (int i=0; i<len; i++) {
                if (i < len2) {
                    nums[i] = nums1[i];
                } else {
                    nums[i] = 0;
                }
            }
            System.out.println(Arrays.toString(nums));
            return len2;
        }
    }
}
