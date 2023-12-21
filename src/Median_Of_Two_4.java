import java.util.*;

public class Median_Of_Two_4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[] {3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> lis = new ArrayList<>();
        int l=0;
        int r=0;
        while(l<nums1.length && r<nums2.length) {
            if(nums1[l] < nums2[r]) {
                lis.add(nums1[l]);
                l++;
            } else {
                lis.add(nums2[r]);
                r++;
            }
        }
        while(l < nums1.length) {
            lis.add(nums1[l]);
            l++;
        }
        while(r < nums2.length) {
            lis.add(nums2[r]);
            r++;
        }
        int size = lis.size();
        if(size % 2 == 0) {
            return (double) (lis.get(size / 2) + lis.get(size/2 - 1)) / 2;
        } else {
            return lis.get(size / 2);
        }
    }
}
