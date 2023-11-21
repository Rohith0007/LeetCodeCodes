import java.util.HashSet;
import java.util.Set;

public class Maximum_Operations {
    public static int getMaximumOperations(String s) {
        Set<String> modifiedStrings = new HashSet<>();
        getMaximumOperationsRecursively(s, modifiedStrings);

        int i=0;
        if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)) {
            modifiedStrings.remove(s.substring(0, i + 2) + s.charAt(i) + s.substring(i + 3));
        }

        return modifiedStrings.size();
    }

    public static void getMaximumOperationsRecursively(String s, Set<String> modifiedStrings) {
        int l = s.length();
        int i = 0;
        while (i < l - 2) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)) {
                String modifiedString = s.substring(0, i + 2) + s.charAt(i) + s.substring(i + 3);
                if (modifiedStrings.add(modifiedString)) {
                    getMaximumOperationsRecursively(modifiedString, modifiedStrings);
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        String s = "aabaab";
        System.out.println(getMaximumOperations(s));
    }
}
