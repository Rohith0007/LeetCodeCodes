import java.util.*;

public class Course_Schedule_207 {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}, {0,1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> pre = new HashSet<>();
        Set<Integer> can = new HashSet<>();
        Set<Integer> never = new HashSet<>();

        for (int[] prerequisite : prerequisites) {
            if(!never.contains(prerequisite[0])) {
                can.add(prerequisite[0]);
                can.add(prerequisite[1]);
            } else if(!never.contains(prerequisite[0]) && never.contains(prerequisite[1])){
                can.add(prerequisite[0]);
            }
            if(pre.contains(prerequisite[1]) && !can.contains(prerequisite[0])) {
                never.add(prerequisite[1]);
                can.remove(prerequisite[1]);
            }
            pre.add(prerequisite[0]);
        }
        return can.size() == numCourses;
    }
}
