public class QuickSortImproved {

    public static final int CUTOFF = 10;

    public static void sort(Comparable[] inputArg) {

        sort(inputArg, 0, inputArg.length - 1);
    }

    public static void sort(Comparable[] inputArg, int start, int end) {

        if (end <= start + CUTOFF - 1) {
            insertionSort(inputArg, start, end);
            return;
        }

        int randomInt = medianOfThree(start, end);
        swap(inputArg, start, randomInt);

        int j = partition(inputArg, start, end);
        sort(inputArg, start, j - 1);
        sort(inputArg, j + 1, end);
    }

    public static int partition(Comparable[] inputArg, int start, int end) {

        // First element is the partitioning element.
        int i = start;
        int j = end + 1;

        while (true) {

            // Find item on left to swap.
            while (isLessThan(inputArg[++i], inputArg[start])) {
                if (i == end) break;
            }

            // Find item on right to swap.
            while (isLessThan(inputArg[start], inputArg[--j])) {
                if (j == start) break;
            }

            // Check if pointers cross.
            if (i >= j) break;
            swap(inputArg, i, j);
        }

        // Swap with partitioning item.
        swap(inputArg, start, j);

        // Return index of item now known to be in place.
        return j;
    }

    public static boolean isLessThan(Comparable arg1, Comparable arg2) {
        return arg1.compareTo(arg2) < 0;
    }

    public static void swap(Comparable[] inputArg, int arg1, int arg2) {
        Comparable temp = inputArg[arg1];
        inputArg[arg1] = inputArg[arg2];
        inputArg[arg2] = temp;
    }

    public static int medianOfThree(int start, int end) {
        int random1 = (int) (Math.floor(Math.random() * (end - start + 1))) + start;
        int random2 = (int) (Math.floor(Math.random() * (end - start + 1))) + start;
        int random3 = (int) (Math.floor(Math.random() * (end - start + 1))) + start;
        
        return (random1 + random2 + random3) / 3;
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
