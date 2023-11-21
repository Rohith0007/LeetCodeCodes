import java.util.*;

public class Subsets_78 {

    public static void main(String[] args) {
        Subsets_78 ss = new Subsets_78();
        int[] nums = {1, 2, 3};
        System.out.println(ss.subsets(nums));
    }

    public Set<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            HashSet<List<Integer>> emptySubset = new HashSet<>();
            emptySubset.add(new ArrayList<>());
            return emptySubset;
        }

        HashSet<List<Integer>> a = new HashSet<>();
        HashSet<List<Integer>> temp = new HashSet<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            ArrayList<Integer> singleSubset = new ArrayList<>();
            singleSubset.add(nums[i]);
            a.add(singleSubset);
        }

        while (len > 0) {
            len--;
            temp.clear();
            for (List<Integer> subset : a) {
                for (int i = 0; i < len; i++) {
                    if (!subset.contains(nums[i])) {
                        ArrayList<Integer> newSubset = new ArrayList<>(subset);
                        newSubset.add(nums[i]);
                        temp.add(newSubset);
                    }
                }
            }
            a.clear();
            a.addAll(temp);
        }
        return a;
    }
}
