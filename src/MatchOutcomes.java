import java.util.*;
public class MatchOutcomes {
    public static int matchOutcomes(List<Integer> list) {
        int firstScore = 0;
        int secondScore = 0;
        int len = list.size();
        int k = 0;
        boolean reverseList = false;

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                firstScore += list.get(k);
            } else {
                secondScore += list.get(k);
            }
            if (list.remove(k) % 2 == 0) {
                reverseList = !reverseList;
            }
            if (reverseList) {
                k = list.size() - 1;
            } else {
                k = 0;
            }
        }
        return firstScore - secondScore;
    }




    public static void main(String[] args) {
        List<Integer> numSeq = new ArrayList<>();
        numSeq.add(3);
        numSeq.add(6);
        numSeq.add(2);
        numSeq.add(3);
        numSeq.add(5);
        int difference = MatchOutcomes.matchOutcomes(numSeq);
        System.out.println(difference);
    }
}
