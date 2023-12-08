import java.util.*;

public class Product_Of_Array_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1,1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int mul = 1;
        boolean one = false;
        boolean two = false;
        for(int i: nums) {
            if(i != 0) {
                mul *= i;
            } else {
                if(!one) {
                    one = true;
                } else {
                    two = true;
                }
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(two) {
                nums[i] = 0;
            } else {
                if(one) {
                    if(nums[i] == 0) {
                        nums[i] = mul;
                    } else {
                        nums[i] = 0;
                    }
                } else {
                    nums[i] = mul/nums[i];
                }
            }
        }
        return nums;
    }
}
