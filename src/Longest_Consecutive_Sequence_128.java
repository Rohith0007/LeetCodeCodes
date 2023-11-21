import java.util.*;

public class Longest_Consecutive_Sequence_128 {
    public static void main(String[] args) {
        Longest_Consecutive_Sequence_128 ls = new Longest_Consecutive_Sequence_128();
        int[] nums = {100,4,200,1,2};
        System.out.println(ls.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        int max = 0;
        for(int i: nums) {
            lis.add(i);
        }

        for(int i: lis) {
            if(!lis.contains(i-1)) {
                int len = 0;
                while(lis.contains(i+len)){
                    len +=1;
                }
                max = Math.max(max, len);
            }
        }


        return max;
    }

//    public int longestConsecutive(int[] nums) {
//        Arrays.sort(nums);
//        List<Integer> lis = new ArrayList<>();
//        for(int i: nums) {
//            lis.add(i);
//        }
//        int max = 1;
//        for(int i: nums) {
//            max = Math.max(sequence(i, lis), max);
//        }
//        return max;
//    }
//
//    public int sequence(int n, List<Integer> nums) {
//        boolean flag = true;
//        int res = 1;
//        while(flag) {
//            n = n+1;
//            if(nums.contains(n)) {
//                res +=1;
//            } else {
//                flag = false;
//            }
//        }
//        return res;
//    }
}
