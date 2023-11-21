import java.util.*;
public class Finding_3_Digit_Even_Numbers_2094 {
    public static void main(String[] args) {
        Finding_3_Digit_Even_Numbers_2094 f = new Finding_3_Digit_Even_Numbers_2094();
        int[] digits = new int[] {2, 1, 3, 0};
        System.out.println(Arrays.toString(f.findEvenNumbers(digits)));
    }
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> hashSet = new HashSet<Integer>();

        for(int i = 0; i<digits.length; i++){
            for(int j = 0; j<digits.length; j++){
                if (i != j) {
                    for(int k = 0; k<digits.length; k++){
                        if(digits[k] %2 == 0 && i!=k && j!=k && digits[i] != 0){
                            hashSet.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                        }
                    }
                }
            }
        }

        int[] res = new int[hashSet.size()];
        int j = 0;
        for (Integer i: hashSet) {
            res[j++] = i;
        }
        Arrays.sort(res);
        return res;
    }
}
