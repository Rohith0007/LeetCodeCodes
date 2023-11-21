public class Swap {
    public static void main(String[] args) {
        int a=1;
        int b=2;

        b=b+a;
        a=b-a;
        b=b-a;

        System.out.println("Swapped Numbers:");
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
