import java.util.Arrays;
import java.util.Scanner;

public class clockwise {
    public static void main(String[] args) {
        System.out.print(Arrays.deepToString(matrixRotation()));
    }

    public static int[][] matrixRotation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int r = sc.nextInt();

        System.out.println("Enter number of Columns");
        int c = sc.nextInt();

        int[][] mat = new int[r][c];
        int[][] mat90 = new int[c][r];

        System.out.println("Enter the matrix, in horizontal fasion");
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                mat[i][j] = sc.nextInt();
                mat90[j][i] = mat[i][j];
            }
        }

        return mat90;
    }
}
