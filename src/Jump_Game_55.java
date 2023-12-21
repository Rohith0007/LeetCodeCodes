import java.util.Arrays;

public class Jump_Game_55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2,0,0}));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len != 0 && len != 1) {
            if (nums[0] == 0) {
                return false;
            }
            boolean[] flag = new boolean[len];
            flag[0] = true;
            for (int i = 0; i < nums.length; i++) {
                int j = 0;
                while (j < nums[i] && j + i + 1 < len) {
                    flag[j + i + 1] = true;
                    j++;
                }
            }
            for (boolean fl : flag) {
                if (!fl) {
                    return false;
                }
            }
        }
        return true;
    }
}
