/*
Run following commands to test included test files one and ten_thousand.
$java Test one
$java Test ten_thousand
*/

// import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        int x = 2;
        int n = 12;

        int[][] a = {{1, 2}, {3, 4}};

        Power power = new Power();
        System.out.println("power1        = " + power.power1(x, n));
        System.out.println("power2        = " + power.power2(x, n));

        a = power.powerMatrix(a, n);
        System.out.println("powerMatrix   = " + a[0][0] + " " + a[0][1]);
        System.out.println("                " + a[1][0] + " " + a[1][1]);

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        int[] nArray = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            String temp = lines.get(i);
            nArray[i] = Integer.parseInt(temp);
        }

        Fib fib = new Fib();
        System.out.println("fib01         = " + fib.fib01(nArray, 100));
        System.out.println("fib02         = " + fib.fib02(nArray, 100));
        System.out.println("fib03         = " + fib.fib03(nArray, 100));
        System.out.println("fib04         = " + fib.fib04(nArray, 100));
        System.out.println("fib1          = " + fib.fib1(12345, 100));
        System.out.println("fib2          = " + fib.fib2(12345, 100));
        System.out.println("fib3          = " + fib.fib3(12345, 100));

    }
}
