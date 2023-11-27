import java.util.*;
public class Palindrome_Partitioning_131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ls = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int len = s.length();
        StringBuilder sub = new StringBuilder();
        for(int i=0; i<len; i++) {
            temp = new ArrayList<>();
            for(int j=0; j<len; j++) {
                sub.append(s.charAt(j));
                if(!isPalindrome(sub.toString())) {
                    temp.add(sub.toString());
                    sub.delete(0, sub.length()-1);
                }
            }
            ls.add(temp);
        }
        return ls;
    }

    public static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
