/*
Run following commands to test included test files one and ten_thousand.
$ java Test one
$ java Test ten_thousand
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        Integer[] inputArray = new Integer[input.size()];
        for (int i = 0; i < input.size(); i++) {
            String temp = input.get(i);
            inputArray[i] = Integer.parseInt(temp);
        }

        Stopwatch stopwatch = new Stopwatch();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        SelectionSort selectionSort = new SelectionSort();
        SelectionSortTwoThreaded selectionSortTwoThreaded = new SelectionSortTwoThreaded();
        InsertionSort insertionSort = new InsertionSort();
        ShellSort shellSort = new ShellSort();
        RandomShuffle randomShuffle = new RandomShuffle();
        MergeSort mergeSort = new MergeSort();
        MergeSortAux mergeSortAux = new MergeSortAux();
        MergeSortImproved mergeSortImproved = new MergeSortImproved();

        stopwatch.start();

        Integer[] inputArray1 = inputArray.clone();
        selectionSort.sort(inputArray1);
        isSorted(inputArray1);
        Integer[] inputArray2 = inputArray.clone();
        selectionSortTwoThreaded.sort(inputArray2);
        isSorted(inputArray2);
        Integer[] inputArray3 = inputArray.clone();
        insertionSort.sort(inputArray3);
        isSorted(inputArray3);
        Integer[] inputArray4 = inputArray.clone();
        shellSort.sort(inputArray4);
        isSorted(inputArray4);
        Integer[] inputArray5 = inputArray.clone();
        mergeSort.sort(inputArray5);
        isSorted(inputArray5);
        Integer[] inputArray6 = inputArray.clone();
        mergeSortAux.sort(inputArray6);
        isSorted(inputArray6);
        Integer[] inputArray7 = inputArray.clone();
        mergeSortImproved.sort(inputArray7);
        isSorted(inputArray7);

        stopwatch.stop();
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long actualMemUsed = afterUsedMem-beforeUsedMem;

        // System.out.println(inputArray[i]);

        System.out.println("Time   = " + stopwatch.getTime() + "ms");
        
        // Dividing to convert Bytes into KB.
        System.out.println("Memory = " + actualMemUsed/1024 + "KB");

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
