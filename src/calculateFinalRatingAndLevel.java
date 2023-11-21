//class Solution {
//    public String calculateFinalRatingAndLevel(int initial, int[] changes) {
//        for(int change: changes) {
//            initial += change;
//        }
//        if (initial < 1000) {
//            return "beginner";
//        } else if (initial < 1500) {
//            return "intermediate";
//        } else if (initial < 2000) {
//            return "advanced";
//        } else {
//            return "pro";
//        }
//    }
//
//    public static void main(String[] args) {
//        solution solution = new solution();
//        int initial1 = 1500;
//        int[] changes1 = {-100, -300, -450, 500, -500, -600};
//        System.out.println(solution.calculateFinalRatingAndLevel(initial1, changes1)); // Output: pro
//    }
//}
