import java.util.*;

public class Tim {
    public static int minLines(int[][] frndCoord, int timX, int timY) {
        Set<Double> uniqueSlopes = new HashSet<>();

        for (int i = 0; i < frndCoord.length; i++) {
            int x = frndCoord[i][0];
            int y = frndCoord[i][1];

            // Calculate slope using the formula: (y2 - y1) / (x2 - x1)
            double slope;
            if (x == timX) {
                // Handle the case where the line is vertical (undefined slope)
                slope = Double.POSITIVE_INFINITY;
            } else {
                slope = (double) (y - timY) / (x - timX);
            }

            uniqueSlopes.add(slope);
        }

        return uniqueSlopes.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input for frndCoord
        int frndCoord_row = in.nextInt();
        int frndCoord_col = in.nextInt();
        int frndCoord[][] = new int[frndCoord_row][frndCoord_col];
        for (int idx = 0; idx < frndCoord_row; idx++) {
            for (int jdx = 0; jdx < frndCoord_col; jdx++) {
                frndCoord[idx][jdx] = in.nextInt();
            }
        }

        // Input for timX
        int timX = in.nextInt();

        // Input for timY
        int timY = in.nextInt();

        int result = minLines(frndCoord, timX, timY);
        System.out.print(result);
    }
}

