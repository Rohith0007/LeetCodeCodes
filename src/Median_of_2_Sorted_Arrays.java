import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */

public class Median_of_2_Sorted_Arrays{

    public static void main(String[] args) {
        Median_of_2_Sorted_Arrays m = new Median_of_2_Sorted_Arrays();
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int m1_len = nums1.length;
        int m2_len = nums2.length;

        int[] arr3 = new int[m1_len+m2_len];

        while(i < m1_len){
            arr3[k++] = nums1[i++];
        }

        while(j < m2_len){
            arr3[k++] = nums2[j++];
        }

        Arrays.sort(arr3);

        int arr3_len = arr3.length;

        if(arr3_len == 0){
            return 0;
        }
        else if (arr3_len == 1){
            return arr3[0];
        }
        else{
            if(arr3_len %2 == 0){
                return (arr3[arr3_len/2] + arr3[(arr3_len/2)-1])/2.0;
            }
            else{
                return arr3[(arr3_len-1)/2];
            }
        }
    }
}