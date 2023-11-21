public class P7_Palindrome {
    public static void main(String[] args) {
        P7_Palindrome pali = new P7_Palindrome();
        String s = "arrrra";
        System.out.print("So string: "+s+" is a palindrome statement is: "+ pali.palindrome(s));
    }

    public boolean palindrome(String s) {
        char[] arr = s.toCharArray();
        boolean pali = true;
        for (int i=0; i<arr.length/2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                pali = false;
                break;
            }
        }
        return pali;
    }
}
