public class Count_Primes_204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }
    public static int countPrimes(int n) {
        boolean[] visi = new boolean[n];
        int res = 0;

        for(int i=2; i<n; i++) {
            if(visi[i]) continue;
            res++;
            for(int k=i; k<n; k+=i) {
                visi[k] = true;
            }
        }
        return res;
    }
}
