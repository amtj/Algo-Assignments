/*
Run following commands to test included test files one and ten_thousand.
$ java Test ten_thousand
$ java Test hundred_thousand
$ java Test one_million
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> input = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            input.add(line);
        }
        bufferedReader.close();

        int length = input.size();
        Integer[] inputArray = new Integer[length];
        for (int i = 0; i < input.size(); i++) {
            String temp = input.get(i);
            inputArray[i] = Integer.parseInt(temp);
        }

        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // RandomShuffle randomShuffle = new RandomShuffle();

        SelectionSort selectionSort = new SelectionSort();
        Integer[] inputArray1 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch1 = new Stopwatch();
        stopwatch1.start();
        selectionSort.sort(inputArray1);
        stopwatch1.stop();
        System.out.println("Time SelectionSort            = " + stopwatch1.getTime() + "ms");
        isSorted(inputArray1);

        SelectionSortTwoThreaded selectionSortTwoThreaded = new SelectionSortTwoThreaded();
        Integer[] inputArray2 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch2 = new Stopwatch();
        stopwatch2.start();
        selectionSortTwoThreaded.sort(inputArray2);
        stopwatch2.stop();
        System.out.println("Time SelectionSortTwoThreaded = " + stopwatch2.getTime() + "ms");
        isSorted(inputArray2);

        InsertionSort insertionSort = new InsertionSort();
        Integer[] inputArray3 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch3 = new Stopwatch();
        stopwatch3.start();
        insertionSort.sort(inputArray3);
        stopwatch3.stop();
        System.out.println("Time InsertionSort            = " + stopwatch3.getTime() + "ms");
        isSorted(inputArray3);

        ShellSort shellSort = new ShellSort();
        Integer[] inputArray4 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch4 = new Stopwatch();
        stopwatch4.start();
        shellSort.sort(inputArray4);
        stopwatch4.stop();
        System.out.println("Time ShellSort                = " + stopwatch4.getTime() + "ms");
        isSorted(inputArray4);

        MergeSort mergeSort = new MergeSort();
        Integer[] inputArray5 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch5 = new Stopwatch();
        stopwatch5.start();
        mergeSort.sort(inputArray5);
        stopwatch5.stop();
        System.out.println("Time MergeSort                = " + stopwatch5.getTime() + "ms");
        isSorted(inputArray5);

        MergeSortImproved mergeSortImproved = new MergeSortImproved();
        Integer[] inputArray6 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch6 = new Stopwatch();
        stopwatch6.start();
        mergeSortImproved.sort(inputArray6);
        stopwatch6.stop();
        System.out.println("Time MergeSortImproved        = " + stopwatch6.getTime() + "ms");
        isSorted(inputArray6);

        MergeSortBottomUp mergeSortBottomUp = new MergeSortBottomUp();
        Integer[] inputArray7 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch7 = new Stopwatch();
        stopwatch7.start();
        mergeSortBottomUp.sort(inputArray7);
        stopwatch7.stop();
        System.out.println("Time MergeSortBottomUp        = " + stopwatch7.getTime() + "ms");
        isSorted(inputArray7);

        QuickSort quickSort = new QuickSort();
        Integer[] inputArray8 = Arrays.copyOf(inputArray, length);
        Stopwatch stopwatch8 = new Stopwatch();
        stopwatch8.start();
        quickSort.sort(inputArray8);
        stopwatch8.stop();
        System.out.println("Time QuickSort                = " + stopwatch8.getTime() + "ms");
        isSorted(inputArray8);

        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem-beforeUsedMem;

        // System.out.println(inputArray[i]);

        // Dividing to convert Bytes into KB.
        System.out.println("Total Memory Used             = " + actualMemUsed/1024 + "KB");

    }

    public static void isSorted(Integer[] inputArg) {
        int previous = inputArg[0];
        for (int i = 0; i < inputArg.length; i++) {
            if (previous > inputArg[i]) {
                System.out.println("ERROR: sort failed");
                break;
            }
            previous = inputArg[i];
        }
    }
}
