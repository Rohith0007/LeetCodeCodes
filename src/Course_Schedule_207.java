import java.util.*;

public class Course_Schedule_207 {
    public static void main(String[] args) {
//        System.out.println(canFinish(5, new int[][]{{1,4}, {2,4}, {3,1}, {3,2}}));
//        System.out.println(canFinish(2, new int[][]{{1,0}, {0,1}}));
        System.out.println(canFinish(3, new int[][]{{0,1}, {0,2}, {1,2}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> map = new ArrayList<>();
        for(int[] pre: prerequisites) {
            int k=0;
            if (map.contains(pre[0])) {
                k = map.indexOf(pre[0]);
            }
            List<Integer> lis = map.subList(k, map.size());
            List<Integer> prevlis = map.subList(0, k);
            if(!map.contains(pre[0]) && !map.contains(pre[1])) {
                map.add(pre[0]);
                map.add(pre[1]);
            } else if(map.contains(pre[0])) {
                map.add(map.indexOf(pre[0]), pre[1]);
            }
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int repeatedCount = 0;
        for (Integer element : map) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        for (int frequency : frequencyMap.values()) {
            if (frequency != 1) {
                repeatedCount++;
            }
        }

        return numCourses == numCourses - repeatedCount;
    }
}
