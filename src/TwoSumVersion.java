import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSumVersion {
    public static void main(String[] args) {
        TwoSumVersion tw = new TwoSumVersion();
        System.out.println("Enter number of Elements in the array: ");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i=0; i<len; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter target number: ");
        int target = sc.nextInt();
        tw.twoSum(array, target);
    }

    public void twoSum(int[] array, int target) {
        int carry = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0; i<array.length; i++) {
            carry = target-array[i];
            if (map.containsKey(carry)) {
                res[0] = i;
                res[1] = map.get(carry);
            } else {
                map.put(array[i], i);
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
