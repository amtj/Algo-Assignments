// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        LPS lps = new LPS();

        // Assert that sizeLPS("BBABCBCAB") is 7.
        assert(lps.sizeLPS("BBABCBCAB") == 7): "Test Failed";

        // Assert that sizeLPS("foobarfoo") is 5.
        assert(lps.sizeLPS("foobarfoo") == 5): "Test Failed";

        // Assert that sizeLPS("barfoobar") is 4.
        assert(lps.sizeLPS("barfoobar") == 4): "Test Failed";

        System.out.println("Test Passed");
    }
}
