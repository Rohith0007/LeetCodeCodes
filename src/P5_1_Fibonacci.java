public class P5_1_Fibonacci {
    public static void main(String[] args) {
        int count = 10;
        P5_1_Fibonacci fibo = new P5_1_Fibonacci();
        for (int i=0; i<count; i++) {
            System.out.println(fibo.fibonacci(i));
        }
    }

    public int fibonacci(int count) {
        if (count == 0) {
            return 0;
        } else if (count == 1) {
            return 1;
        } else {
            return fibonacci(count - 1) + fibonacci(count - 2);
        }
    }
}
