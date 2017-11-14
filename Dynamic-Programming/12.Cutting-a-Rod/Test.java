// Run the following commands to test
// $ javac Test
// $ java -ea Test
//
// Here we are using assertion, It will not run simply because assertion is
// disabled by default. To enable the assertion, -ea or -enableassertions option
// of java must be used.

public class Test {
    public static void main(String[] args) {

        CuttingARod cuttingARod = new CuttingARod();

        int arr1[] = {1, 5, 8, 9, 10, 17, 17, 20};
        // Assert that find(arr1, 8) is 22.
        assert(cuttingARod.find(arr1, 8) == 22): "Test Failed";

        int arr2[] = {3, 5, 8, 9, 10, 17, 17, 20};
        // Assert that find(arr2, 8) is 24.
        assert(cuttingARod.find(arr2, 8) == 24): "Test Failed";

        System.out.println("Test Passed");
    }
}
