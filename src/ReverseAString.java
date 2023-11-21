public class ReverseAString {
    public static void main(String[] args) {
        String s = "rohith";
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i=c.length-1; i>=0; i--) {
            sb.append(c[i]);
        }
        System.out.print(sb);
    }
}
