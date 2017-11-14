// Write a function int fib(int n) that returns F(n). For example, if n = 0,
// then fib() should return 0. If n = 1, then it should return 1. For n > 1, it
// should return F(n-1) + F(n-2).

class FibonacciNumbers {

    int fib(int n) {
        int fib0 = 0;
        int fib1 = 1;

        if      (n == 0) return fib0;
        else if (n == 1) return fib1;

        for (int i = 2; i <= n; i++) {
            int temp = fib0;
            fib0 = fib1;
            fib1 += temp;
        }

        return fib1;
    }
}
