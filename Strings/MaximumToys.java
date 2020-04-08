package com.afro.Strings;

import java.util.Arrays;

//sort an array and determine how many toys can be purchased for a given budget

public class MaximumToys {


    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int result = 0, counter = 0;
        if (prices[counter] > k) return 0;
        if (prices[counter] == k) return 1;
        while (result + (prices[counter]) < k) {
            result += prices[counter];
            counter++;
            if (counter == prices.length) return counter;
        }
        return counter;
    }

    public static void main(String[] args) {

        //test case
        int[] prices = {1,12,5,111,200,1000,10};
        int budget = 50;
        System.out.println(maximumToys(prices, budget));


    }

}
