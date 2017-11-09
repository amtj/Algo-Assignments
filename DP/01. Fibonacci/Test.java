// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        // Assert that fib(9) is 34.
        assert (fibonacci.fib(9) == 34): "Test Failed";

        // Assert that fib(19) is 4181.
        assert (fibonacci.fib(19) == 4181): "Test Failed";

        // Assert that fib(29) is 514229.
        assert (fibonacci.fib(29) == 514229): "Test Failed";

        System.out.println("Test Passed");
    }
}
