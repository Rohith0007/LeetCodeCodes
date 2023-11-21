import java.util.Arrays;

public class Number_of_1_Bits_191 {
    public static void main(String[] args) {
        Number_of_1_Bits_191 nb = new Number_of_1_Bits_191();
        int binaryNumber = 0b00000000000000000000000000001011;
        System.out.println(nb.hammingWeight(binaryNumber));
    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
