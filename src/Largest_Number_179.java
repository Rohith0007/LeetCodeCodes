import java.util.Arrays;
import java.util.*;

public class Largest_Number_179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {3,30,34,5,9}));
    }

    public static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        extracted(nums, s);
        Comparator<String> c = (o1, o2) -> o2.compareTo(o1);
        Arrays.sort(s, c);
        return s[0].equals("0") ? "0" : String.join("",s);
    }

    private static void extracted(int[] nums, String[] s) {
        for(int i = 0; i< nums.length; i++)
        {
            s[i] = String.valueOf(nums[i]);
        }
    }
}
