import java.util.*;
public class WordBreak_139 {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsandogcat", new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat","an"))));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        return checkString(s, wordDict, s, false);
    }

    private static boolean checkString(String s, List<String> wordDict, String perm, boolean flag) {
        if(s.length() == 0) {
            return true;
        }
        for (int i = 0; i < perm.length(); i++) {
            StringBuilder temp = new StringBuilder();
            if(perm.substring(0, i).length() == 0 || wordDict.contains(perm.substring(0, i))) {
                for (int j = 0; j < s.length(); j++) {
                    temp.append(s.charAt(j));
                    if (wordDict.contains(temp.toString())) {
                        for (String k : wordDict) {
                            if (k.equals(s.substring(j + 1))) {
                                return true;
                            }
                        }
                        if(flag) {
                            wordDict.add(wordDict.get(wordDict.size()-1)+s.substring(0,j+1));
                        } else {
                            wordDict.add(s.substring(0,j+1));
                        }
                        return checkString(s.substring(j + 1), wordDict, perm, true);
                    }
                }
            }
        }
        return false;
    }
}
