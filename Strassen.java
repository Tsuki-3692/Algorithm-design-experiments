public class Strassen {
    //flag用与检测是否为第一次调用
    public static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }
        //划分矩阵
        int[][] A11 = new int[n / 2][n / 2];
        int[][] A12 = new int[n / 2][n / 2];
        int[][] A21 = new int[n / 2][n / 2];
        int[][] A22 = new int[n / 2][n / 2];
        int[][] B11 = new int[n / 2][n / 2];
        int[][] B12 = new int[n / 2][n / 2];
        int[][] B21 = new int[n / 2][n / 2];
        int[][] B22 = new int[n / 2][n / 2];
        int[][] C11 = new int[n / 2][n / 2];
        int[][] C12 = new int[n / 2][n / 2];
        int[][] C21 = new int[n / 2][n / 2];
        int[][] C22 = new int[n / 2][n / 2];
        //需要计算的七个矩阵
        int[][] M1;
        int[][] M2;
        int[][] M3;
        int[][] M4;
        int[][] M5;
        int[][] M6;
        int[][] M7;
        //初始化A11,A12,A21,A22,B11,B12,B21,B22
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + n / 2];
                A21[i][j] = A[i + n / 2][j];
                A22[i][j] = A[i + n / 2][j + n / 2];
                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + n / 2];
                B21[i][j] = B[i + n / 2][j];
                B22[i][j] = B[i + n / 2][j + n / 2];
            }
        }
        //创建S1-S10
        int[][] s1 = new int[n / 2][n / 2];
        int[][] s2 = new int[n / 2][n / 2];
        int[][] s3 = new int[n / 2][n / 2];
        int[][] s4 = new int[n / 2][n / 2];
        int[][] s5 = new int[n / 2][n / 2];
        int[][] s6 = new int[n / 2][n / 2];
        int[][] s7 = new int[n / 2][n / 2];
        int[][] s8 = new int[n / 2][n / 2];
        int[][] s9 = new int[n / 2][n / 2];
        int[][] s10 = new int[n / 2][n / 2];
        //计算S1-S10
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                s1[i][j] = B12[i][j] - B22[i][j];
                s2[i][j] = A11[i][j] + A12[i][j];
                s3[i][j] = A21[i][j] + A22[i][j];
                s4[i][j] = B21[i][j] - B11[i][j];
                s5[i][j] = A11[i][j] + A22[i][j];
                s6[i][j] = B11[i][j] + B22[i][j];
                s7[i][j] = A12[i][j] - A22[i][j];
                s8[i][j] = B21[i][j] + B22[i][j];
                s9[i][j] = A11[i][j] - A21[i][j];
                s10[i][j] = B11[i][j] + B12[i][j];
            }
        }
        //计算M1-M7
        M1 = strassen(A11, s1);

        printMatrix(M1);

        M2 = strassen(s2, B22);

        printMatrix(M2);

        M3 = strassen(s3, B11);

        printMatrix(M3);

        M4 = strassen(A22, s4);

        printMatrix(M4);

        M5 = strassen(s5, s6);

        printMatrix(M5);

        M6 = strassen(s7, s8);

        printMatrix(M6);

        M7 = strassen(s9, s10);

        printMatrix(M7);

        //计算C11-C22
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C11[i][j] = M5[i][j] + M4[i][j] - M2[i][j] + M6[i][j];
                C12[i][j] = M1[i][j] + M2[i][j];
                C21[i][j] = M3[i][j] + M4[i][j];
                C22[i][j] = M5[i][j] + M1[i][j] - M3[i][j] - M7[i][j];
            }
        }
        //合并C11-C22
        int[][] C = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C[i][j] = C11[i][j];
                C[i][j + n / 2] = C12[i][j];
                C[i + n / 2][j] = C21[i][j];
                C[i + n / 2][j + n / 2] = C22[i][j];
            }
        }
        return C;

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
