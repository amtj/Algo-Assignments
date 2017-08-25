public class MergeSortBottomUp {

    public static void sort(Comparable[] inputArg) {
        int size = inputArg.length;
        for (int i = 1; i < size; i += i) {
            for (int j = 0; j < size - i; j += i + i) {
                merge(inputArg, j, j + i - 1, Math.min(j + i + i - 1, size - 1));
            }
        }
    }

    // Merging into single array.
    public static void merge(Comparable[] inputArg, int start, int mid, int end) {

        Comparable[] input = inputArg.clone();
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid)                             inputArg[k] = input[j++];
            else if (j > end)                        inputArg[k] = input[i++];
            else if (isLessThan(input[j], input[i])) inputArg[k] = input[j++];
            else                                     inputArg[k] = input[i++];
        }
    }

    public static boolean isLessThan(Comparable arg1, Comparable arg2) {
        return arg1.compareTo(arg2) < 0;
    }
}
