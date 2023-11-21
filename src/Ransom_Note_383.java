import java.util.*;
import java.util.stream.Collectors;

public class Ransom_Note_383 {
    public static void main(String[] args) {
        Ransom_Note_383 rn = new Ransom_Note_383();
        System.out.println(rn.canConstruct("ax", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Long> mp1 = magazine.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> mp2 = ransomNote.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        for (Map.Entry<Character, Long> entry : mp2.entrySet()) {
            if(mp1.get(entry.getKey()) == null || mp1.get(entry.getKey())<entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
