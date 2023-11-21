import java.util.*;
public class Longest_Repeating_Character_Replacement_424 {
    public static void main(String[] args) {
        Longest_Repeating_Character_Replacement_424 lr = new Longest_Repeating_Character_Replacement_424();
        System.out.println(lr.characterReplacement("ABBB", 2));
    }
    public int characterReplacement(String s, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int s_len = sb.length();
        int max = 0;
        int res = 0;
        int x = k;
        for(int i=0; i<s_len-1; i++) {
            char c = sb.charAt(i);
            max = 1;
            boolean flag = true;
            x = k;
            for(int j=i+1; j<s_len; j++) {
                char c1 = sb.charAt(j);
                if(flag) {
                    if (c == c1) {
                        max = max + 1;
                    } else if(x!=0) {
                        max += 1;
                        x-=1;
                    } else {
                        flag = false;
                    }
                }
            }
            res = Math.max(res, max);
        }
        if(x!=0 && res<s_len) {
            res += 1;
        }
        return res;
    }
}
