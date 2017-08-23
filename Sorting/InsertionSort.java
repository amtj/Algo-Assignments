public class InsertionSort {

    public static void sort(Comparable[] inputArg) {
        int size = inputArg.length;

        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (isLessThan(inputArg[j], inputArg[j - 1])) {
                    swap(inputArg, j, j - 1);
                }
                else break;
            }
        }
    }

    public static boolean isLessThan(Comparable arg1, Comparable arg2) {
        return arg1.compareTo(arg2) < 0;
    }

    public static void swap(Comparable[] inputArg, int arg1, int arg2) {
        Comparable temp = inputArg[arg1];
        inputArg[arg1] = inputArg[arg2];
        inputArg[arg2] = temp;
    }
}
