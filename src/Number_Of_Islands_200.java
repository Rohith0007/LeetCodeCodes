import java.util.*;

public class Number_Of_Islands_200 {
    public static void main(String[] args) {
//        System.out.println(numIslands(new char[][] {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        }));
        System.out.println(numIslands(new char[][] {
                {'0','1','0'},
                {'1','0','1'},
                {'0','1','0'}
        }));
    }
    public static int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<List<Integer>> visited = new HashSet<>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1' && !visited.contains(new ArrayList<>(List.of(i,j)))) {
                    bfs(i, j, visited, grid);
                    islands += 1;
                }
            }
        }
        return islands;
    }

    private static void bfs(int i, int j, Set<List<Integer>> visited, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(List.of(i, j));

        List<List<Integer>> dir = new ArrayList<>();
        dir.add(List.of(1,0));
        dir.add(List.of(0,1));
        dir.add(List.of(-1,0));
        dir.add(List.of(0,-1));

        visited.add(List.of(i, j));
        while(q.size() != 0) {
            List<Integer> curr = q.poll();
            int curr_r = curr.get(0);
            int curr_c = curr.get(1);
            for (List<Integer> d : dir) {
                int d_r = d.get(0);
                int d_c = d.get(1);
                if( 0 <= curr_r+d_r && curr_r+d_r < rows && 0 <= curr_c+d_c && curr_c+d_c < cols && grid[curr_r+d_r][curr_c+d_c] == '1' && !visited.contains(List.of(curr_r+d_r, curr_c+d_c))) {
                    visited.add(List.of(curr_r+d_r, curr_c+d_c));
                    q.add(List.of(curr_r+d_r, curr_c+d_c));
                }
            }
        }

    }
}
