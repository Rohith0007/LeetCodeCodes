import java.util.*;
import java.util.stream.Collectors;

public class Ransom_Note_383 {
    public static void main(String[] args) {
        Ransom_Note_383 rn = new Ransom_Note_383();
        System.out.println(rn.canConstruct("ax", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder check = new StringBuilder();
        StringBuilder with = new StringBuilder();
        check.append(ransomNote);
        with.append(magazine);
        for(char c: check.toString().toCharArray()) {
            boolean flag = false;
            for(int i=0; i<with.length(); i++) {
                if(with.charAt(i) == c) {
                    flag = true;
                    with.deleteCharAt(i);
                    break;
                }
            }
            if(!flag) {
                return false;
            }
        }
        return true;
    }
}
