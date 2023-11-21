public class Reverse {
    public static void main(String[] args) {
        String s = "however";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = s.length()-1; i>= 0; i--){
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
