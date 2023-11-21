import java.util.Scanner;

public class GrassHopper {
    public static String getTown(String[] peopleNames) {
        if (peopleNames == null || peopleNames.length == 0) {
            return "";  // Return empty string if no names provided
        }

        // Convert all names to lowercase
        for (int i = 0; i < peopleNames.length; i++) {
            peopleNames[i] = peopleNames[i].toLowerCase();
        }

        int maxCommonLength = peopleNames[0].length();

        // Iterate through the names to find the maximum common prefix length
        for (int i = 1; i < peopleNames.length; i++) {
            int j = 0;
            while (j < maxCommonLength && j < peopleNames[i].length() &&
                    peopleNames[0].charAt(j) == peopleNames[i].charAt(j)) {
                j++;
            }
            maxCommonLength = j;  // Update the maximum common length
        }

        char[] c = new char[maxCommonLength];

        // Store the maximum common prefix in the char array
        for (int i = 0; i < maxCommonLength; i++) {
            c[i] = peopleNames[0].charAt(i);
        }

        return new String(c, 0, maxCommonLength);  // Convert char array to string
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input for peopleNames
        int peopleNames_size = in.nextInt();
        String peopleNames[] = new String[peopleNames_size];
        for (int idx = 0; idx < peopleNames_size; idx++) {
            peopleNames[idx] = in.next();
        }

        String result = getTown(peopleNames);
        System.out.print(result);
    }
}
