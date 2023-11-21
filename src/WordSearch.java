import java.util.Stack;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCEFSADEESE"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int k, int i, int j) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' '; // Mark the cell as visited

        boolean result = dfs(board, word, k + 1, i + 1, j) ||
                dfs(board, word, k + 1, i - 1, j) ||
                dfs(board, word, k + 1, i, j + 1) ||
                dfs(board, word, k + 1, i, j - 1);

        board[i][j] = temp; // Restore the cell

        return result;
    }
}
