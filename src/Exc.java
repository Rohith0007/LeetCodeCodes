public class Exc {
    public static void main(String[] args) {
        Exc ex = new Exc();
        ex.division();
    }

    public void division() {
        try {
            int y = 10 / 0;
        } catch (ArithmeticException ex) {
            System.out.println("In Arth");
        }
    }
}
