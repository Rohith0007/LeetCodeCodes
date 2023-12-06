public class House_Robber_II_213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,3,2}));
    }

    public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        int temp = 0;
        int temp1 = 0;
        if(nums.length == 1) {
            return nums[0];
        }
        for(int i=0; i<nums.length-1; i++) {
            temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        rob1 = 0;
        rob2 = 0;

        for(int i=nums.length-1; i>0; i--) {
            temp1 = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp1;
        }
        return Math.max(temp, temp1);
    }
}
