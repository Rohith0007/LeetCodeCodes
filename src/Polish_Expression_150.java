import java.util.*;
public class Polish_Expression_150 {
    public static void main(String[] args) {
        evalRPN(new String[] {"2","1","+","3","*"});
    }

    public static int evalRPN(String[] tokens) {
        return helperClass(new ArrayList<>(Arrays.asList(tokens)));
    }

    public static int helperClass(List<String> list) {
        if(list.size() == 1) {
            return Integer.parseInt(list.get(0));
        }
        int len = list.size();
        for(int i=0; i<len; i++) {
            String s = list.get(i);
            switch (s) {
                case "*" -> {
                    List<String> temp = new ArrayList<>(list.subList(0, i-2));
                    int a = Integer.parseInt(list.get(i-2));
                    int b = Integer.parseInt(list.get(i-1));
                    temp.add(String.valueOf(a*b));
                    temp.addAll(list.subList(i+1, len));
                    return helperClass(temp);
                }
                case "/" -> {
                    List<String> temp = new ArrayList<>(list.subList(0, i-2));
                    int a = Integer.parseInt(list.get(i-2));
                    int b = Integer.parseInt(list.get(i-1));
                    temp.add(String.valueOf(a/b));
                    temp.addAll(list.subList(i+1, len));
                    return helperClass(temp);
                }
                case "+" -> {
                    List<String> temp = new ArrayList<>(list.subList(0, i-2));
                    int a = Integer.parseInt(list.get(i-2));
                    int b = Integer.parseInt(list.get(i-1));
                    temp.add(String.valueOf(a+b));
                    temp.addAll(list.subList(i+1, len));
                    return helperClass(temp);
                }
                case "-" -> {
                    List<String> temp = new ArrayList<>(list.subList(0, i-2));
                    int a = Integer.parseInt(list.get(i-2));
                    int b = Integer.parseInt(list.get(i-1));
                    temp.add(String.valueOf(a-b));
                    temp.addAll(list.subList(i+1, len));
                    return helperClass(temp);
                }
            }
        }
        return 0;
    }
}
