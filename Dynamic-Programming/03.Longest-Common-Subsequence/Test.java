// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

        // Assert that sizeLCS("ABCDGH", "AEDFHR") is 3.
        assert(longestCommonSubsequence.sizeLCS("ABCDGH", "AEDFHR") == 3): "Test Failed";

        // Assert that sizeLCS("AGGTAB", "GXTXAYB") is 4.
        assert(longestCommonSubsequence.sizeLCS("AGGTAB", "GXTXAYB") == 4): "Test Failed";

        // Assert that sizeLCS("abcabba", "cbabaca") is 4.
        assert(longestCommonSubsequence.sizeLCS("abcabba", "cbabaca") == 4): "Test Failed";

        // Assert that sizeLCS("abc", "abc") is 3.
        assert(longestCommonSubsequence.sizeLCS("abc", "abc") == 3): "Test Failed";

        // Assert that sizeLCS("abc", "abcabc") is 3.
        assert(longestCommonSubsequence.sizeLCS("abc", "abcabc") == 3): "Test Failed";

        System.out.println("Test Passed");
    }
}
