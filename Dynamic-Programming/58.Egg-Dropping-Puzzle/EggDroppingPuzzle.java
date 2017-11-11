class EggDroppingPuzzle {

    int find(int eggs, int floors) {

        int[][] table = new int[eggs + 1][floors + 1];

        for (int i = 0; i <= eggs; i++) {
            for (int j = 0; j <= floors; j++) {

                if (j == 0 || j == 1) {
                    table[i][j] = 1;
                }
                else if (i == 0 || i == 1) {
                    table[i][j] = j;
                }
                else {
                    int min = floors;

                    for (int k = 1; k <= j; k++) {
                        int temp = Math.max(table[i - 1][k - 1], table[i][j - k]) + 1;
                        if (min > temp) min = temp;
                    }

                    table[i][j] = min;
                }
            }
        }

        return table[eggs][floors];
    }
}
