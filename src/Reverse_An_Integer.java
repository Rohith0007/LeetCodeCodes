import java.util.Scanner;

public class Reverse_An_Integer {
    public static void main(String[] args) {
        Reverse_An_Integer ri = new Reverse_An_Integer();
        System.out.println("Enter an Integer: ");
        Scanner sc = new Scanner(System.in);
        System.out.println(ri.reverseAnInteger(sc.nextInt()));
    }

    public int reverseAnInteger(int num) {
        int res = 0;
        int digit;
        while(num!=0) {
            digit = num%10;
            res = res*10+digit;
            num = num/10;
        }
        return res;
    }
}
