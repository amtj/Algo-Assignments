public class Fib {

    // O(n) iterative algo.
    // Function: f(n) = (f(n-1) + f(n-2)) % m
    int fib1(int n, int m) {
        int a = 0;
        int b = 1;
        int c = n;

        for (int i = 2; i <= n; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
        }

        return c;
    }

    // O(n) iterative algo.
    // Function: f(n) = (f(n-1) + f(n-3)) % m
    int fib2(int n, int m) {
        if (n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int d = n;

        for (int i = 3; i <= n; i++) {
            d = (a + c) % m;
            a = b;
            b = c;
            c = d;
        }

        return d;
    }

    // O((log(n))^2) algo.
    // Function: f(n) = (f(n-1) + f(n-2)) % m
    int fib3(int n, int m) {
        Matrix matrix = new Matrix();

        int[][] A = {{1, 1}, {1, 0}};

        Power power = new Power();
        A = power.powerModm(A, n, m);

        return A[1][0] % m;
    }

    // O(logn)
    // Here N is in the form of an array of single digit integers.
    // eg, for 12345, N = {1, 2, 3, 4, 5}
    // Function: f(n) = (f(n-1) + f(n-2)) % m
    int fib01(int[] n, int m) {
        Matrix matrix = new Matrix();
        int[][] y = new int[2][2];
        y = matrix.identity(2);

        int[][] A = {{1, 1}, {1, 0}};

        Power power = new Power();

        int i = n.length - 1;
        while (i >= 0) {
            if (n[i] == 0) {
                A = power.powerModm(A, 10, m);
                i--;
                continue;
            }

            y = matrix.multiplyModm(y, power.powerModm(A, n[i], m), m);
            A = power.powerModm(A, 10, m);
            i--;
        }

        return y[1][0] % 100;
    }

    // O(logn)
    // Here N is in the form of an array of single digit integers.
    // eg, for 12345, N = {1, 2, 3, 4, 5}
    // Function: f(n) = (f(n-1) + f(n-3)) % m
    int fib02(int[] n, int m) {
        Matrix matrix = new Matrix();
        int[][] y = new int[3][3];
        y = matrix.identity(3);

        int[][] A = {{1, 0, 1}, {1, 0, 0}, {0, 1, 0}};

        Power power = new Power();

        int i = n.length - 1;
        while (i >= 0) {
            if (n[i] == 0) {
                A = power.powerModm(A, 10, m);
                i--;
                continue;
            }

            y = matrix.multiplyModm(y, power.powerModm(A, n[i], m), m);
            A = power.powerModm(A, 10, m);
            i--;
        }

        return y[1][0] % 100;
    }

    // O(logn)
    // Fibonacci is being implemented via calculating period first.
    // Here N is in the form of an array of single digit integers.
    // eg, for 12345, N = {1, 2, 3, 4, 5}
    // Function: f(n) = (f(n-1) + f(n-2)) % m
    int fib03(int[] n, int m) {

        int a = 0;
        int b = 1;
        int c = 1;
        int range = m * m + 1;
        int period = range;
        int temp = n[0];

        for (int i = 2; i <= range; i++) {
            c = (a + b) % m;
            a = b;

            if (c == 1 && b == 0) {
                period = i - 1;
                break;
            }

            b = c;
        }

        for (int i = 1; i < n.length; i++) {
            if (temp > period) {
                temp = temp % period;
            }

            temp = temp * 10 + n[i];
        }

        return fib1(temp % period, m);
    }

    // O(logn)
    // Fibonacci is being implemented via calculating period first.
    // Here N is in the form of an array of single digit integers.
    // eg, for 12345, N = {1, 2, 3, 4, 5}
    // Function: f(n) = (f(n-1) + f(n-3)) % m
    int fib04(int[] n, int m) {

        int a = 0;
        int b = 1;
        int c = 1;
        int d = 1;
        int range = m * m * m + 1;
        int period = range;
        int temp = n[0];

        for (int i = 3; i <= range; i++) {
            d = (a + c) % m;
            a = b;

            if (d == 1 && c == 1 && b == 0) {
                period = i - 2;
                break;
            }

            b = c;
            c = d;
        }

        for (int i = 1; i < n.length; i++) {
            if (temp > period) {
                temp = temp % period;
            }

            temp = temp * 10 + n[i];
        }

        return fib2(temp % period, m);
    }
}
