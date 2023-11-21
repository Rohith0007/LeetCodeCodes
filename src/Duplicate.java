import java.util.*;

public class Duplicate {
    public static void main(String[] args) {
        Duplicate dp = new Duplicate();
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for(int i=0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }
        boolean b = dp.containsDuplicate(nums);

        if(b) {
            System.out.println("Array: " + Arrays.toString(nums) + " doesn't contain duplicates");
        } else {
            System.out.println("Array: " + Arrays.toString(nums) + " contain duplicates");
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            set.add(i);
        }
        return set.size() != nums.length;
//        Map<Integer, Integer> mp = new HashMap<>();
//        for (int i: nums) {
//            if (mp.containsKey(i)) {
//                return false;
//            } else {
//                mp.put(i, 1);
//            }
//        }
//        return true;
    }
}
