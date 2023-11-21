public class Find_the_Index_28 {
    public static void main(String[] args) {
        Find_the_Index_28 fi = new Find_the_Index_28();
        System.out.println(fi.strStr("sadbutsad", "sad"));
    }

    public int strStr(String haystack, String needle) {
        haystack = haystack.replace(needle, "0");
        boolean flag = true;
        int i=0;
        while(flag) {
            if(i < haystack.length() && haystack.charAt(i) == '0') {
                flag = false;
                return i;
            }
            if(i == haystack.length()) {
                flag = false;
            }
            i++;
        }
        return -1;
    }
}
