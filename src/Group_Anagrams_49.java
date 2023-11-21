import java.util.*;

public class Group_Anagrams_49 {
    public static void main(String[] args) {
        Group_Anagrams_49 ga = new Group_Anagrams_49();
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.groupAnagrams(str));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            String sortedAnagram = findAnagram(s);
            if (map.containsKey(sortedAnagram)) {
                // Anagram already exists, add the new string to the list
                map.get(sortedAnagram).add(s);
            } else {
                // Anagram does not exist, create a new entry
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                map.put(sortedAnagram, anagramList);
            }
        }
//        System.out.println(map);
        res.addAll(map.values());
        return res;
    }

    public String findAnagram(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
