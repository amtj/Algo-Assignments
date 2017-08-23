public class SelectionSort {

    public static void sort(Comparable[] inputArg) {
        int size = inputArg.length;

        for (int i = 0; i < size; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (isLessThan(inputArg[j], inputArg[min])) min = j;
            }

            swap(inputArg, i, min);
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
