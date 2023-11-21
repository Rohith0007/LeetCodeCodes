import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,6,4,9,10,15,12};
        Arrays.sort(arr);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an element to search: ");
        int searchElement = sc.nextInt();

        int start = 0;
        int end = arr.length-1;
        System.out.print("So the element " + searchElement + " found statement is: "+recusrion(arr, start, end, searchElement));
    }

    public static boolean recusrion(int[] arr, int start, int end, int searchElement) {
        while(start <= end) {
            int mid = start+(end-start)/2;
            if (arr[mid] == searchElement) {
                return true;
            } else if (arr[mid] < searchElement) {
                return recusrion(arr, mid+1, end, searchElement);
            } else {
                return recusrion(arr, start, mid-1, searchElement);
            }
        }
        return false;
    }
}
