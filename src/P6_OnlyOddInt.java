import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P6_OnlyOddInt {
    public static void main(String[] args) {
        P6_OnlyOddInt odd = new P6_OnlyOddInt();
        System.out.print(odd.oddInt(Arrays.asList(2,4)));
    }
    public boolean oddInt(List<Integer> list) {
        return list.parallelStream().anyMatch(x -> x%2 != 0);
    }
}
