import java.util.*;
import java.util.Stack;

public class Basic_Calculator_227 {
    public static void main(String[] args) {
        System.out.println(calculate("3 +   2*2"));
    }

    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        char[] arr = s.toCharArray();
        int num = 0;
        char op = '+';
        for(int i=0; i<arr.length; i++) {
            if(Character.isDigit(arr[i])) {
                num = num*10 + arr[i] - '0';
            } if((!Character.isDigit(arr[i]) && arr[i] != ' ') || i == arr.length - 1) {
                if(op == '+') {
                    st.push(num);
                } else if(op == '-') {
                    st.push(-num);
                } else if(op == '*') {
                    st.push(st.pop() * num);
                } else if(op == '/') {
                    st.push(st.pop() / num);
                }
                op = arr[i];
                num = 0;
            }
        }

        while(!st.empty()) {
            res += st.pop();
        }

        return res;
    }
}
