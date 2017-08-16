// A bare-bones collection of static methods for manipulating matrices.

public class Matrix {

    // return int n-by-n identity matrix I
    public static int[][] identity(int n) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
        a[i][i] = 1;
        return a;
    }

    // return int c = (a * b) % m
    public static int[][] multiplyModm(int[][] a, int[][] b, int m) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
        int[][] c = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += (a[i][k] * b[k][j]) % m;
                }
            }
        }
        return c;
    }

    // return int c = a * b
    public static int[][] multiply(int[][] a, int[][] b) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
        int[][] c = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return c;
    }
}
