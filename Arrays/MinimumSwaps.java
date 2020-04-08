package com.afro.Arrays;



// https://www.hackerrank.com/challenges/new-year-chaos/problem
class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static void minimumSwaps(int[] q) {
    	int i = 0;
        int swaps = 0;
        while (i < q.length) {
            int j = i;

            if (q[i] - (i + 1) > 2) {
//                System.out.println(String.format("currentValue: %d, currentIndex: %d", q[i], i));
                System.out.println("Too chaotic");
                return;
            }

            while (j > 0 && q[j] < q[j -1]) {
                // swap
                int tmp = q[j];
                q[j] = q[j - 1];
                q[j - 1] = tmp;
                j--;
                swaps++;
            }
            i++;
        }
        System.out.println(swaps);


    }

    


}