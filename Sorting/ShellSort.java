public class ShellSort {

    public static void sort(Comparable[] input) {
        int size = input.length;

        // Sedgewick series
        int[]  h = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001,
                    36289, 64769, 146305, 260609, 587521, 1045505, 2354689,
                    4188161, 9427969, 16764929, 37730305, 67084289, 150958081,
                    268386305, 603906049, 1073643521};

        int pointer = 0;
        while (h[pointer] < size / 3) {
            pointer++;
        }

        while (pointer >= 0) {
            // h-sort the array.
            for (int i = h[pointer]; i < size; i++) {
                for (int j = i; j >= h[pointer] && isLessThan(input[j], input[j - h[pointer]]); j -= h[pointer]) {
                    swap(input, j, j - h[pointer]);
                }
            }

            pointer--;
        }
    }

    public static boolean isLessThan(Comparable arg1, Comparable arg2) {
        return arg1.compareTo(arg2) < 0;
    }

    public static void swap(Comparable[] input, int arg1, int arg2) {
        Comparable temp = input[arg1];
        input[arg1] = input[arg2];
        input[arg2] = temp;
    }
}
