public class PrimeOrNot {
    public static void main(String[] args) {
        int n=17;
        boolean flag = true;
        for(int i=1; i<n/2; i++) {
            if (n%i == 0) {
                flag = false;
            }
        }

        System.out.println("So " + n + " is Prime or Not: "+flag);
    }
}
