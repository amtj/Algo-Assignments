public class MergeSortBottomUp {

    private static Comparable[] inputAux;

    public static void sort(Comparable[] inputArg) {

        int length = inputArg.length;
        inputAux = new Comparable[length];

        for (int i = 1; i < length; i += i) {
            for (int j = 0; j < length - i; j += i + i) {
                merge(inputArg, j, j + i - 1, Math.min(j + i + i - 1, length - 1));
            }
        }
    }

    // Merging into single array
    public static void merge(Comparable[] inputArg, int start, int mid, int end) {

        for (int k = start; k <= end; k++) {
            inputAux[k] = inputArg[k];
        }

        int i = start;
        int j = mid + 1;

        for (int k = start; k <= end; k++) {
            if      (i > mid)                              inputArg[k] = inputAux[j++];
            else if (j > end)                              inputArg[k] = inputAux[i++];
            else if (isLessThan(inputAux[j], inputAux[i])) inputArg[k] = inputAux[j++];
            else                                           inputArg[k] = inputAux[i++];
        }
    }

    public static boolean isLessThan(Comparable arg1, Comparable arg2) {
        return arg1.compareTo(arg2) < 0;
    }
}
