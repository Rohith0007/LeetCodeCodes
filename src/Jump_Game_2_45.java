public class Jump_Game_2_45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        int[] nums1 = new int[len];
        flag[0] = true;
        nums1[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            while (j < nums[i] && j + i + 1 < len) {
                if(!flag[j + i + 1]) {
                    nums1[j + i + 1] = nums1[i] + 1;
                }
                flag[j + i + 1] = true;
                j++;
            }
        }
        return nums1[len-1];
    }
}
