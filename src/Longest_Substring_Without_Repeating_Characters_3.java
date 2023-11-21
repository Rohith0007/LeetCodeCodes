import java.util.*;

public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters_3 ls = new Longest_Substring_Without_Repeating_Characters_3();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int drag = 0;
        StringBuilder st = new StringBuilder();

        // Use a HashSet to keep track of characters in the current substring
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (drag < s.length() && !charSet.contains(s.charAt(drag))) {
                charSet.add(s.charAt(drag));
                st.append(s.charAt(drag));
                drag++;
            }

            max = Math.max(max, st.length());

            // Remove the first character from the set and the StringBuilder
            charSet.remove(s.charAt(i));
            st.deleteCharAt(0);
        }

        return max;
    }
}
