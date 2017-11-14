// Given weights and values of n items, put these items in a knapsack of
// capacity W to get the maximum total value in the knapsack. In other words,
// given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
// and weights associated with n items respectively. Also given an integer W
// which represents knapsack capacity, find out the maximum value subset of
// val[] such that sum of the weights of this subset is smaller than or equal
// to W. You cannot break an item, either pick the complete item, or don’t pick
// it (0-1 property).

class ZeroOneKnapsack {

    int find(int[] value, int[] weight, int capacity) {

        int size = weight.length;
        int[][] table = new int[capacity + 1][size + 1];

        for (int i = 0; i <= capacity; i++) {

            for (int j = 0; j <= size; j++) {

                if (i == 0 || j == 0){
                    table[i][j] = 0;
                }

                else if (weight[j - 1] > i) {
                    table[i][j] = table[i - 1][j];
                }

                else {
                    table[i][j] = Math.max(table[i][j - 1], table[i - weight[j - 1]][j - 1] + value[j - 1]);
                }
            }
        }

        return table[capacity][size];
    }
}
