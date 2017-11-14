// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        UglyNumbers uglyNumbers = new UglyNumbers();

        // Assert that findUglyNumber(7) is 8.
        assert (uglyNumbers.findUglyNumber(7) == 8): "Test Failed";

        // Assert that findUglyNumber(10) is 12.
        assert (uglyNumbers.findUglyNumber(10) == 12): "Test Failed";

        // Assert that findUglyNumber(15) is 24.
        assert (uglyNumbers.findUglyNumber(15) == 24): "Test Failed";

        // Assert that findUglyNumber(150) is 5832.
        assert (uglyNumbers.findUglyNumber(150) == 5832): "Test Failed";

        System.out.println("Test Passed");
    }
}
