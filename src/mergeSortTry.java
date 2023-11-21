import java.util.Arrays;

public class mergeSortTry {
    public static void main(String[] args) {
        int[] arr = {1,8,4,2,10,14,6,3};
        mergeSortTry mt = new mergeSortTry();
        System.out.println(Arrays.toString(mt.mergeSort(0, arr.length-1, arr)));
    }

    public int[] mergeSort(int l, int r, int[] arr) {
        if(l<r) {
            int mid = (l+r)/2;
            mergeSort(l, mid, arr);
            mergeSort(mid+1, r, arr);
            merge(l, r, mid, arr);
        }
        return arr;
    }

    public void merge(int l, int r, int mid, int[] arr) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i=0; i<n1; i++) {
            leftArray[i] = arr[l+i];
        }

        for(int i=0; i<n2; i++) {
            rightArray[i] = arr[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=l;

        while(i<n1 && j<n2) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i<n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j<n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
