/*
Run following commands to test included test cases.
$ java Test test-cases/ten
$ java Test test-cases/hundred
$ java Test test-cases/thousand
$ java Test test-cases/ten_thousand
$ java Test test-cases/hundred_thousand
$ java Test test-cases/one_million
$ java Test test-cases/one_million_few_distinct
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
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem-beforeUsedMem;

        // RandomShuffle randomShuffle = new RandomShuffle();

        Stopwatch stopwatch1 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SelectionSort selectionSort = new SelectionSort();
        Integer[] inputArray1 = Arrays.copyOf(inputArray, length);
        stopwatch1.start();
        selectionSort.sort(inputArray1);
        stopwatch1.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray1);
        System.out.println("Time SelectionSort            = " + stopwatch1.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch2 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SelectionSortTwoThreaded selectionSortTwoThreaded = new SelectionSortTwoThreaded();
        Integer[] inputArray2 = Arrays.copyOf(inputArray, length);
        stopwatch2.start();
        selectionSortTwoThreaded.sort(inputArray2);
        stopwatch2.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray2);
        System.out.println("Time SelectionSortTwoThreaded = " + stopwatch2.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch3 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        InsertionSort insertionSort = new InsertionSort();
        Integer[] inputArray3 = Arrays.copyOf(inputArray, length);
        stopwatch3.start();
        insertionSort.sort(inputArray3);
        stopwatch3.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray3);
        System.out.println("Time InsertionSort            = " + stopwatch3.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch4 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        ShellSort shellSort = new ShellSort();
        Integer[] inputArray4 = Arrays.copyOf(inputArray, length);
        stopwatch4.start();
        shellSort.sort(inputArray4);
        stopwatch4.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray4);
        System.out.println("Time ShellSort                = " + stopwatch4.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch5 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        MergeSort mergeSort = new MergeSort();
        Integer[] inputArray5 = Arrays.copyOf(inputArray, length);
        stopwatch5.start();
        mergeSort.sort(inputArray5);
        stopwatch5.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray5);
        System.out.println("Time MergeSort                = " + stopwatch5.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch6 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        MergeSortImproved mergeSortImproved = new MergeSortImproved();
        Integer[] inputArray6 = Arrays.copyOf(inputArray, length);
        stopwatch6.start();
        mergeSortImproved.sort(inputArray6);
        stopwatch6.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray6);
        System.out.println("Time MergeSortImproved        = " + stopwatch6.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch7 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        MergeSortBottomUp mergeSortBottomUp = new MergeSortBottomUp();
        Integer[] inputArray7 = Arrays.copyOf(inputArray, length);
        stopwatch7.start();
        mergeSortBottomUp.sort(inputArray7);
        stopwatch7.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray7);
        System.out.println("Time MergeSortBottomUp        = " + stopwatch7.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch8 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        QuickSort quickSort = new QuickSort();
        Integer[] inputArray8 = Arrays.copyOf(inputArray, length);
        stopwatch8.start();
        quickSort.sort(inputArray8);
        stopwatch8.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray8);
        System.out.println("Time QuickSort                = " + stopwatch8.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch9 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        QuickSortImproved quickSortImproved = new QuickSortImproved();
        Integer[] inputArray9 = Arrays.copyOf(inputArray, length);
        stopwatch9.start();
        quickSortImproved.sort(inputArray9);
        stopwatch9.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray9);
        System.out.println("Time QuickSortImproved        = " + stopwatch9.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");
        System.out.println();

        Stopwatch stopwatch10 = new Stopwatch();
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        QuickSortThreeWay quickSortThreeWay = new QuickSortThreeWay();
        Integer[] inputArray10 = Arrays.copyOf(inputArray, length);
        stopwatch10.start();
        quickSortThreeWay.sort(inputArray10);
        stopwatch10.stop();
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem-beforeUsedMem;
        isSorted(inputArray10);
        System.out.println("Time QuickSortThreeWay        = " + stopwatch10.getTime() + "ms");
        // Dividing to convert Bytes into KB.
        System.out.println("Memory                        = " + actualMemUsed/1024 + "KB");

        // System.out.println(inputArray[i]);
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
