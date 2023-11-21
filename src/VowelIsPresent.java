public class VowelIsPresent {
    public static void main(String[] args) {
        String s = "rohith";
        System.out.println("Vowel is present statement is : " + s.toLowerCase().matches(".*[aeiou]*."));
    }
}
