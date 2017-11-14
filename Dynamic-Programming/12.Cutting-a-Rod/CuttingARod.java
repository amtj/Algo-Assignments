// Given a rod of length n inches and an array of prices that contains prices of
// all pieces of size smaller than n. Determine the maximum value obtainable by
// cutting up the rod and selling the pieces. For example, if length of the rod
// is 8 and the values of different pieces are given as following, then the
// maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

// length   | 1   2   3   4   5   6   7   8
// --------------------------------------------
// price    | 1   5   8   9  10  17  17  20

// And if the prices are as following, then the maximum obtainable value is 24
// (by cutting in eight pieces of length 1)

// length   | 1   2   3   4   5   6   7   8
// --------------------------------------------
// price    | 3   5   8   9  10  17  17  20

class CuttingARod {

    int find(int price[], int length) {

        int[] table = new int[length + 1];

        for (int i = 0; i <= length; i++) {

            if (i == 0) {
                table[i] = 0;
                continue;
            }

            int max = -1;

            for (int j = 0; j < i; j++) {

                max = Math.max(max, price[j] + table[i - j - 1]);
                table[i] = max;
            }
        }

        return table[length];
    }
}
