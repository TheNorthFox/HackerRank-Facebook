package com.afro.search;

// https://www.hackerrank.com/challenges/making-candies/problem

public class MakingCandies {
    public static long minimumPasses(long m, long w, long p, long n) {

       
        if ((double) m * w > (double) n) return 1;

        long days = Long.MAX_VALUE;
        long currentDays = 0;
        long candies = 0;
        boolean loop = true;

        while (loop) {

            long remainCandies = n - candies;
            long makeCandies = m * w;
            long remainDays = remainCandies / makeCandies + (remainCandies % makeCandies == 0 ? 0 : 1);
            days = Math.min(days, currentDays + remainDays);

            if (remainDays == 1) loop = false;


            if ( p > candies) {
                long remainPurchase = p - candies;
                long extraDays = remainPurchase / makeCandies + (remainPurchase % makeCandies == 0 ? 0 : 1);
                currentDays += extraDays;
                candies += extraDays * makeCandies;

                if ( n < candies) {
                    days = Math.min(days, currentDays);
                    loop = false;
                }
            }

            if (m < w) {
                m++;
            } else {
                w++;
            }

            candies -= p;
        }

        return days;
    }

}