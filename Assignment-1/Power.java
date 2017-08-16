public class Power {

    // O(logn) Recursive algo.
    int power1(int x, int n) {
        if (n < 0) {
            return -1;
        }
        else if (n == 0) {
            return 1;
        }
        else if (n % 2 == 0) {
            return power1(x * x, n / 2);
        }
        else {
            return x * power1(x, n - 1);
        }
    }

    // O(logn) iterative algo.
    int power2(int x, int n) {
        int y = 1;

        while (n > 0) {
            if (n % 2 != 0) {
                y = y * x;
            }
            x = x * x;
            n = n / 2;
        }

        return y;
    }

    // Argument 'A' is n*n matrix
    // Returns A^n.
    int [][] powerMatrix(int [][] a, int n) {
        Matrix matrix = new Matrix();
        int aLength = a.length;
        int[][] y = new int[aLength][aLength];
        y = matrix.identity(aLength);

        while (n > 0) {
            if (n % 2 != 0) {
                y = matrix.multiply(y, a);
            }

            a = matrix.multiply(a, a);
            n = n / 2;
        }

        return y;
    }

    // Argument 'A' is n*n matrix
    // Returns A^n.
    int [][] powerModm(int [][] a, int n, int m) {
        Matrix matrix = new Matrix();
        int aLength = a.length;
        int[][] y = new int[aLength][aLength];
        y = matrix.identity(aLength);

        while (n > 0) {
            if (n % 2 != 0) {
                y = matrix.multiplyModm(y, a, m);
            }

            a = matrix.multiplyModm(a, a, m);
            n = n / 2;
        }

        return y;
    }
}
