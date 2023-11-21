public class Is_Subsequence_392 {
    public static void main(String[] args) {
        Is_Subsequence_392 is = new Is_Subsequence_392();
        System.out.println(is.isSubsequence("abc", "ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        int k = 0;
        for(int i=0; i<t.length(); i++) {
            char sub = s.charAt(k);
            if(sub == t.charAt(i)) {
                k++;
            }
            if(k == s.length()) {
                return true;
            }
        }
        return false;
    }
}
