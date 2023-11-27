public class Max_SubArray_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {0,2}));
    }
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int max=Integer.MIN_VALUE;
        int temp=1;
        int k = 1;
        for (int num : nums) {
            if(num != 0) {
                if (temp < 0 && num < 0) {
                    temp = k * num;
                } else if (temp > 0 && num > 0) {
                    temp = temp * num;
                } else {
                    k = k * num * temp;
                    temp = -1;
                }
                max = Math.max(max, temp);
            } else {
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
