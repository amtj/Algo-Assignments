public class MergeSortImproved {

    public static final int CUTOFF = 7;

    private static Comparable[] aux;

    public static void sort(Comparable[] inputArg) {

        aux = new Comparable[inputArg.length];
        sort(inputArg, aux, 0, inputArg.length - 1);
    }

    public static void sort(Comparable[] inputArg, Comparable[] inputAux, int start, int end) {

        if (start + CUTOFF - 1 >= end) {
            insertionSort(inputArg, start, end);
            return;
        }

        int mid = start + (end - start) / 2;

        sort(inputArg, inputAux, start, mid);
        sort(inputArg, inputAux, mid + 1, end);
        if (!isLessThan(inputArg[mid + 1], inputArg[mid])) return;
        merge(inputArg, inputAux, start, mid, end);
    }

    // Merging into single array
    public static void merge(Comparable[] inputArg, Comparable[] inputAux, int start, int mid, int end) {

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

    public static void swap(Comparable[] inputArg, int arg1, int arg2) {
        Comparable temp = inputArg[arg1];
        inputArg[arg1] = inputArg[arg2];
        inputArg[arg2] = temp;
    }

    public static void insertionSort(Comparable[] inputArg, int start, int end) {
        int size = end - start + 1;

        for (int i = start; i < start + size; i++) {
            for (int j = i; j > start; j--) {
                if (isLessThan(inputArg[j], inputArg[j - 1])) {
                    swap(inputArg, j, j - 1);
                }
                else break;
            }
        }
    }
}
