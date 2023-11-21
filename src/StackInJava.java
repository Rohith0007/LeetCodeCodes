import java.util.Scanner;

public class StackInJava {
    public static void main(String[] args) {
        System.out.print("Enter the length of stack: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack s = new Stack(n);
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
class Stack{
    int n;
    int top;
    int[] stack;
    Stack(int n) {
        this.n = n;
        stack = new int[n];
    }
    public void push(int a) {
        if (top == n - 1) {
            System.out.println("Stack is full. Cannot push " + a);
            return;
        }
        stack[++top] = a;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
