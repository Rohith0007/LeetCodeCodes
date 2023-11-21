import java.util.Scanner;

public class hcf {
    public static void main(String[] args) {
        hcf h = new hcf();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("HCF of "+ a + " and " +b+ " is "+ h.hcfFunction(a, b));
    }
    public int hcfFunction(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
//        int hcf =0;
//        for (int i=1; i<=a && i<=b; i++) {
//            if (a%i == 0 && b%i == 0) {
//                hcf = i;
//            }
//        }
//        return hcf;
    }
}
