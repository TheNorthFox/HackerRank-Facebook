package com.afro.Sorting;

import java.util.Arrays;


// https://www.hackerrank.com/challenges/mark-and-toys/problem

public class MaximumToys {



    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {

        int count = 0, sum = 0;
        
        Arrays.sort(prices);
        for (int i : prices) {
            if (sum + i <= k) {
                sum += i;
                count++;
            }
        }
        return count;
    }
}