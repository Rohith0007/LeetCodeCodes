import java.util.HashMap;
import java.util.Map;

public class Isomorphic_205 {
    public static void main(String[] args) {
        Isomorphic_205 is = new Isomorphic_205();
        System.out.println(is.isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();

        if (s_length != t_length) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap();

        for (int i = 0; i < s_length; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToT.put(sChar, tChar);
            }

            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToS.put(tChar, sChar);
            }
        }

        return true;
    }
}
