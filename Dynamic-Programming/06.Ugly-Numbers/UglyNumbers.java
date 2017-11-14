// Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
// convention, 1 is included.
//
// Given a number n, the task is to find n'th Ugly number.

class UglyNumbers {

    int findUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;

        int min2 = 2;
        int min2Counter = 1;
        int min3 = 3;
        int min3Counter = 1;
        int min5 = 5;
        int min5Counter = 1;

        for (int counter = 1; counter < n; counter++) {

            ugly[counter] = Math.min(Math.min(min2, min3), min5);

            if (ugly[counter] == min2) min2 = 2 * ugly[++min2Counter - 1];
            if (ugly[counter] == min3) min3 = 3 * ugly[++min3Counter - 1];
            if (ugly[counter] == min5) min5 = 5 * ugly[++min5Counter - 1];
        }

        return ugly[n - 1];
    }
}
