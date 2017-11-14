// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();

        int[] value1 = {60, 100, 120};
        int[] weight1 = {10, 20, 30};
        // Assert that find(value1, weight1, 50) is 220.
        assert(zeroOneKnapsack.find(value1, weight1, 50) == 220): "Test Failed";

        System.out.println("Test Passed");
    }
}
