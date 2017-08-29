// Partition the array three-way. left part contains lower entries, middle part
// has all entries equal to the pivot and right one has greater entries.
// Useful when there are many entries with same value.

public class QuickSortThreeWay {

    public static void sort(Comparable[] inputArg) {

        sort(inputArg, 0, inputArg.length - 1);
    }

    public static void sort(Comparable[] inputArg, int start, int end) {
        if (end <= start) return;

        int random = medianOfThreeRandom(start, end);
        swap(inputArg, start, random);

        int left = start;
        int right = end;
        Comparable pivot = inputArg[start];
        int i = start;

        while (i <= right) {
            int cmp = inputArg[i].compareTo(pivot);
            if      (cmp < 0) swap(inputArg, left++, i++);
            else if (cmp > 0) swap(inputArg, i, right--);
            else              i++;
        }

        sort(inputArg, start, left - 1);
        sort(inputArg, right + 1, end);
    }

    public static void swap(Comparable[] inputArg, int arg1, int arg2) {
        Comparable temp = inputArg[arg1];
        inputArg[arg1] = inputArg[arg2];
        inputArg[arg2] = temp;
    }

    public static int medianOfThreeRandom(int start, int end) {
        int random1 = (int) (Math.floor(Math.random() * (end - start + 1))) + start;
        int random2 = (int) (Math.floor(Math.random() * (end - start + 1))) + start;
        int random3 = (int) (Math.floor(Math.random() * (end - start + 1))) + start;

        return (random1 + random2 + random3) / 3;
    }
}
