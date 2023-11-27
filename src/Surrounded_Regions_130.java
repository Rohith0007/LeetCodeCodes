import java.util.Arrays;
import java.util.*;

public class Surrounded_Regions_130 {
    public static void main(String[] args) {
        solve(new char[][]{{'X', 'X', 'X', 'X'},{'X','O','O','X'},{'X', 'X','O','X'},{'X','O','X','X'}});
    }
    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Set<List<Integer>> visi = new HashSet<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O' && !visi.contains(List.of(i,j))) {
                    bfs(i, j, board, visi);
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    private static void bfs(int i, int j, char[][] board, Set<List<Integer>> visi) {
        int rows = board.length;
        int cols = board[0].length;
        List<List<Integer>> dir = new ArrayList<>();
        dir.add(List.of(-1,0));
        dir.add(List.of(1,0));
        dir.add(List.of(0,1));
        dir.add(List.of(0,-1));
        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(List.of(i,j));
        Set<List<Integer>> temp_visi = new HashSet<>();
        boolean flag = true;
        if(i == 0 || j == 0 || i == rows-1 || j == cols-1) {
            flag = false;
        }
        visi.add(List.of(i, j));
        temp_visi.add(List.of(i, j));
        while(q.size() != 0) {
            List<Integer> curr = q.poll();
            int curr_r = curr.get(0);
            int curr_c = curr.get(1);
            for(List<Integer> d: dir) {
                int sum_r = curr_r + d.get(0);
                int sum_c = curr_c + d.get(1);
                if(0<=sum_r && sum_r<rows && 0<= sum_c && sum_c<cols && board[sum_r][sum_c] == 'O' && !visi.contains(List.of(sum_r, sum_c))) {
                    visi.add(List.of(sum_r, sum_c));
                    temp_visi.add(List.of(sum_r, sum_c));
                    q.add(List.of(sum_r, sum_c));
                    if(sum_r == 0 || sum_r == rows-1 || sum_c == 0 || sum_c == cols-1) {
                        flag = false;
                    }
                }
            }
        }

        if(flag) {
            for(List<Integer> li: temp_visi) {
                board[li.get(0)][li.get(1)] = 'X';
            }
        }
    }
}
