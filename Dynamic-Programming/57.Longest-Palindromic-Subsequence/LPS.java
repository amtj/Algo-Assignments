// Given a sequence, find the length of the longest palindromic subsequence in
// it. For example, if the given sequence is “BBABCBCAB”, then the output should
// be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB” and
// “BBCBB” are also palindromic subsequences of the given sequence, but not the
// longest ones.

class LPS {

    int sizeLPS(String input) {
        int length = input.length();
        int[][] table = new int[length][length];

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length - i; j++) {

                if (input.charAt(j) == input.charAt(i + j)) {

                    if (j == (i + j)) {
                        table[j][i + j] = 1;
                    }
                    else {
                        table[j][i + j] = table[j + 1][i + j - 1] + 2;
                    }
                }
                else {
                    if (j == (i + j)) {
                        table[j][i + j] = 0;
                    }
                    else {
                        table[j][i + j] = Math.max(table[j][i + j - 1], table[j + 1][i + j]);
                    }
                }
            }
        }

        return table[0][length - 1];
    }
}
