import java.util.Scanner;

public class Longest_Palindrome_Substring {
    public static void main(String[] args) {
        Longest_Palindrome_Substring lp = new Longest_Palindrome_Substring();
        System.out.println("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        System.out.println(lp.subString(sc.next()));
    }

    public String subString(String s) {
        if(s == null || s.length() < 2) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)){
                return s;
            } else{
                return s.substring(0, 1);
            }
        }
        int left = 0;
        int right = s.length()-1;
        int fI = 0;
        int lI = 0;
        boolean flag = true;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                if(s.charAt(left+1) == s.charAt(right)) {
                    left++;
                } else if(s.charAt(left) == s.charAt(right-1)) {
                    right--;
                } else if(s.charAt(left+1) == s.charAt(right-1)) {
                    left++;
                    right--;
                }
                flag = true;
            }
            else {
                if (flag) {
                    fI = left;
                    lI = right+1;
                }
                left++;
                right--;
                flag = false;
            }
        }
        return s.substring(fI, lI);
    }
}
