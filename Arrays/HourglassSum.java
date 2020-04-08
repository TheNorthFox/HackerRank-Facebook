import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 

Given a 6x6 2D Array, arr:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's graphical representation:

a b c
  d
e f g
There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. 
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
We calculate the following 16 hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18
Our highest hourglass value is 28 from the hourglass:

0 4 3
  1
8 6 6
Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Function Description

Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.

hourglassSum has the following parameter(s):

arr: an array of integers
Input Format

Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].


Output Format

Print the largest (maximum) hourglass sum found in arr.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19

The hourglass with the maximum sum (19) is:

2 4 4
  2
1 2 4
 */
public class HourglassSum {



    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int n = arr.length;
        int[][] ps = new int[n][n];

        // initial value
        for (int i = 0; i < n; i++) {
            ps[i][0] = arr[i][0];
        }

        // row wise prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                ps[i][j] = ps[i][j-1] + arr[i][j];
            }
        }

        int maxSum = -Integer.MAX_VALUE;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                // top and bottom sum
                int ts = ps[i][j] + ps[i-2][j];

                // Correcting as its prefix sum
                if (j-3 >= 0) {
                    ts -= ps[i][j-3] + ps[i-2][j-3];
                }

                // add middle element
                ts += arr[i-1][j-1];
                maxSum = Math.max(maxSum, ts);
            }
        }

        return maxSum;

    }
}