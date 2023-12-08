public class Search_A_2D {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}, 5));
//        System.out.println(searchMatrix(new int[][] {{5}, {6}}, 6));
//        System.out.println(searchMatrix(new int[][] {{1,4}, {2,5}}, 3));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}