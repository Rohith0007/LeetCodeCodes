//
//import java.util.*;
//
//public class Valid_Parentheses_20 {
//    public static void main(String[] args) {
//        String s = "()";
//        Valid_Parentheses_20 v = new Valid_Parentheses_20();
//        System.out.println(v.isValid(s));
//    }
//    public boolean isValid(String s) {
//
//
//        // Base Case
//        if (s.length() % 2 != 0) {
//            return false;
//        } else {
//            for (char ch : s.toCharArray()) {
//                if (ch == '(' || ch == '[' || ch == '{') {
//                    stack.push(ch);
//                } else {
//                    if (stack.isEmpty()) {
//                        return false;
//                    }
//                    char top = stack.pop();
//                    if (ch == ')' && top != '(') {
//                        return false;
//                    }
//                    if (ch == ']' && top != '[') {
//                        return false;
//                    }
//                    if (ch == '}' && top != '{') {
//                        return false;
//                    }
//                }
//            }
//            return stack.isEmpty();
//        }
//    }
//}
