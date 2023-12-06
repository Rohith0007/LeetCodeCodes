import java.util.*;
import java.util.Stack;

public class Rotate_Array_189 {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k>len) {
            k = k%len;
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++) {
            st.push(nums[(len-k+i)%len]);
        }
        for(int j = len-1; j>=0; j--) {
            nums[j] = st.pop();
        }
        System.out.println(Arrays.toString(nums));
    }
}
