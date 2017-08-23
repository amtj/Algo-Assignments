public class SelectionSortTwoThreaded implements Runnable {

    private static Comparable[] input;
    private static int size;

    public void run() {
        // Sorting first half
        sort(input, 0, size / 2 - 1);
    }

    public static void sort(Comparable[] inputArg) throws InterruptedException {
        input = inputArg.clone();
        size = input.length;

        Thread thread = new Thread(new SelectionSortTwoThreaded());
        thread.start();

        // Sorting second half
        sort(input, size / 2, size - 1);

        thread.join();

        // Merging into single array
        int pointerFirst = 0;
        int pointerSecond = size / 2;
        for (int i = 0; i <  size; i++) {
            if (pointerFirst < size / 2) {
                if (pointerSecond < size) {
                    if (isLessThan(input[pointerSecond], input[pointerFirst])) {
                        inputArg[i] = input[pointerSecond++];
                    }
                    else {
                        inputArg[i] = input[pointerFirst++];
                    }
                }
                else {
                    // Reached end of second half, copy first.
                    inputArg[i] = input[pointerFirst++];
                }
            }
            else {
                // Reached end of first half, copy second.
                inputArg[i] = input[pointerSecond++];
            }
        }
    }

    public static void sort(Comparable[] inputArg, int start, int end) {

        for (int i = start; i < end + 1; i++) {
            int min = i;

            for (int j = i + 1; j < end + 1; j++) {
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
