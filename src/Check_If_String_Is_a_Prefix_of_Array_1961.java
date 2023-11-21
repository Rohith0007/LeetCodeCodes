class Check_If_String_Is_a_Prefix_of_Array_1961 {

    public static void main(String[] args) {
        Check_If_String_Is_a_Prefix_of_Array_1961 c = new Check_If_String_Is_a_Prefix_of_Array_1961();
        String[] words = new String[] {"i","love","leetcode","apples"};
        String s = "iloveleetcode";
        System.out.println(c.isPrefixString(s, words));
    }
    public boolean isPrefixString(String s, String[] words) {

        int l = s.length();
        String res = "";
        int i = 0;

        while(res.length() <= l && i + 1 <=  words.length) {
            res = res + words[i++];
            if(res.equals(s)){
                return true;
            }
        }
        return false;

    }
}
