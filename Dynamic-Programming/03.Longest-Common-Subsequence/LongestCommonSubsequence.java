// Given two sequences, find the length of longest subsequence present in both
// of them. A subsequence is a sequence that appears in the same relative order,
// but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”,
// ”acefg”, etc. are subsequences of “abcdefg”. So a string of length n has 2^n
// different possible subsequences.

// It is a classic computer science problem, the basis of diff (a file
// comparison program that outputs the differences between two files), and has
// applications in bioinformatics.

// Examples:
// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
// LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

class LongestCommonSubsequence {

    int[][] tableLCS(String input1, String input2) {

        int length1 = input1.length();
        int length2 = input2.length();
        int[][] table = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {

                if (i == 0 && j == 0) {
                    if (input1.charAt(i) == input2.charAt(j)) {
                        table[i][j] = 1;
                    }
                }
                else if (i == 0) {
                    if (table[i][j - 1] == 1) {
                        table[i][j] = 1;
                    }
                    else {
                        if (input1.charAt(i) == input2.charAt(j)) {
                            table[i][j] = 1;
                        }
                    }
                }
                else if (j == 0) {
                    if (table[i - 1][j] == 1) {
                        table[i][j] = 1;
                    }
                    else {
                        if (input1.charAt(i) == input2.charAt(j)) {
                            table[i][j] = 1;
                        }
                    }
                }
                else {
                    if (input1.charAt(i) == input2.charAt(j)) {
                        table[i][j] = table[i - 1][j - 1] + 1;
                    }
                    else {
                        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                    }
                }
                // System.out.println("table[" + i + "][" + j + "] = " + table[i][j]);
            }
        }

        return table;
    }

    int sizeLCS(String input1, String input2) {

        int[][] table = tableLCS(input1, input2);

        return table[input1.length() - 1][input2.length() - 1];
    }
}
