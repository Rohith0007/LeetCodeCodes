
import java.math.*;
public class Container_With_Most_Water_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int res = 0;
        int left = 0;
        int right = len-1;

        while(left<right) {
            int l = Math.min(height[left], height[right]);
            res = Math.max(res, l*(right-left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;

//        int len = height.length;
//        int res = 0;
//        if (len == 2) {
//            return Math.min(height[0], height[1]);
//        }
//        for(int i=0; i<len-1; i++) {
//            for(int j=i+1; j<len; j++) {
//                res = Math.max(res, Math.min(height[i], height[j]) * (j-i));
//            }
//        }
//        return res;
    }
}
