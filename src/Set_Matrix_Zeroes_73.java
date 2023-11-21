import java.util.Arrays;

class Set_Matrix_Zeroes_73 {
    public static void main(String[] args) {
        int[][] data = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Set_Matrix_Zeroes_73 sm = new Set_Matrix_Zeroes_73();
        sm.setZeroes(data);
    }
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] matrixCopy = new int[r][c];

        for(int i=0; i<r; i++) {
            System.arraycopy(matrix[i], 0, matrixCopy[i], 0, c);
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j] == 0){
                    makeAllZero(i, j, matrixCopy);
                }
            }
        }
        for(int i=0; i<r; i++) {
            System.arraycopy(matrixCopy[i], 0, matrix[i], 0, c);
        }
    }

    public void makeAllZero(int i, int j, int[][] matrixCopy) {
        int r = matrixCopy.length;
        int c = matrixCopy[0].length;
        int temp1 = 0;
        int temp2 = 0;

        while(temp1<r) {
            matrixCopy[temp1][j] = 0;
            temp1++;
        }

        while(temp2<c) {
            matrixCopy[i][temp2] = 0;
            temp2++;
        }
    }
}