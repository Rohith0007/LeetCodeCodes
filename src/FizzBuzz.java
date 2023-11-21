public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fz = new FizzBuzz();
        fz.fizzbuzz();
    }

    public void fizzbuzz() {
        for(int i=1; i<101; i++) {
            if(i%15 == 0) {
                System.out.println("FizzBuzz");
            } else if(i%5 == 0) {
                System.out.println("Buzz");
            } else if(i%3 == 0) {
                System.out.println("Fizz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}


