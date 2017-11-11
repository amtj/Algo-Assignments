// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        EggDroppingPuzzle eggDroppingPuzzle = new EggDroppingPuzzle();

        // Assert that find(2, 10) is 4.
        assert(eggDroppingPuzzle.find(2, 10) == 4): "Test Failed";

        // Assert that find(2, 36) is 8.
        assert(eggDroppingPuzzle.find(2, 36) == 8): "Test Failed";

        System.out.println("Test Passed");
    }
}
