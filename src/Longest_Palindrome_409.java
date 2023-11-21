import java.util.*;

public class Longest_Palindrome_409 {

    public static void main(String[] args) {
        Longest_Palindrome_409 l = new Longest_Palindrome_409();
        System.out.println(l.longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> dic = new HashMap<Character, Integer>();
        int res = 0;
        int val = 0;
        for(int i=0; i<s.length(); i++){
            if(dic.keySet().contains(s.charAt(i))){
                dic.put(s.charAt(i), dic.get(s.charAt(i))+1);
            } else{
                dic.put(s.charAt(i), 1);
            }
        }

        for(Character c : dic.keySet()) {
            val = dic.get(c);
            if(val % 2 == 0) {
                res+=val;
            } else if(val > 0) {
                res+=val-1;
            }
        }

        if(s.length() > res){
            res += 1;
        }

        return res;
    }
}
