public class Valid_Palindrome_125 {
    public static void main(String[] args) {
        String s = "0P";
        boolean flag = isPalindrome(s);
        if (flag) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }
    }

    public static boolean isPalindrome(String s) {
        String sb = s.strip().toLowerCase().replaceAll("[^a-z0-9]", "");
        int s_len = sb.length();
        if (s_len == 1) {
            return true;
        }
        char[] charArray = sb.toCharArray();
        for(int i=0; i<s_len/2; i++) {
            if (charArray[i] != charArray[s_len-1-i]) {
                return false;
            }
        }
        return true;
    }
}
