public class Count_Number_of_Pairs_With_Absolute_Difference_K_2006 {
    public static void main(String[] args) {
        Count_Number_of_Pairs_With_Absolute_Difference_K_2006 c = new Count_Number_of_Pairs_With_Absolute_Difference_K_2006();
        int[] nums = new int[] {1,2,2,1};
        int k = 1;
        System.out.println(c.countKDifference(nums, k));
    }
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        int temp = 0;
        for(int i =0;i<nums.length; i++) {
            temp = nums[i] + k;
            for(int j = 0; j<nums.length; j++) {
                if(temp == nums[j]) {
                    res = res+1;
                }
            }
        }

        return res;

    }
}
