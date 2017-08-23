public class MergeSort {

    public static void sort(Comparable[] inputArg) {
        sort(inputArg, 0, inputArg.length - 1);
    }

    public static void sort(Comparable[] inputArg, int start, int end) {

        if (start >= end) return;

        int mid = start + (end - start) / 2;

        sort(inputArg, start, mid);
        sort(inputArg, mid + 1, end);
        merge(inputArg, start, mid, end);
    }

    // Merging into single array
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
