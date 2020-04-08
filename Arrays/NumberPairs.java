import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * FB Q1:
 *
 * Given an array of integers, determine how many pairs of
 * matching integers there are.
 *
 * E.g. array of length 7, sampleArray = [1,2,1,2,1,3,2]
 * There is one pair of 1's and one pair of 2's.
 * There are three unpaired number left, a 1, a 2 and a 3.
 * The number of pairs is 2.
 *
 * Complete the numberPairs function, it must return the number of
 * matching pairs in the array.
 */

class NumberPairs {
    // Complete the numberPairs function below.
    public static int numberPairs(int n, int[] ar) {

        int result = 0;

        Arrays.sort(ar);
        for(int i =0; i<n-1; i++){
            if(ar[i] == ar[i+1]){
                result = result + 1;
                i= i+1;
            }
            
        }

        return result;


    }
}
public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = Result.numberPairs(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
