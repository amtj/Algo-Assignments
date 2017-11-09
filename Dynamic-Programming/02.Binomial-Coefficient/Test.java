// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {
        BinomialCoefficient binomialCoefficient = new BinomialCoefficient();

        // Assert that binomialCoefficient.find(4, 2) is 6.
        assert(binomialCoefficient.find(4, 2) == 6): "Test Failed";

        // Assert that binomialCoefficient.find(5, 2) is 10.
        assert(binomialCoefficient.find(5, 2) == 10): "Test Failed";

        System.out.println("Test Passed");
    }
}
