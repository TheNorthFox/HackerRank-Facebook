package com.afro.search;

import java.util.*;

// https://www.hackerrank.com/challenges/minimum-time-required/problem

public class MinTime {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long minDay = goal * Arrays.stream(machines).min().getAsLong() / machines.length;
        long maxDay = goal * Arrays.stream(machines).max().getAsLong() / machines.length;

        long day = 0;
        while (minDay < maxDay) {
            day = (maxDay + minDay) / 2;

            long produced = 0;
            for (long m : machines) {
                produced = produced + day / m;
            }

            if (produced == goal) {
                break;
            }
            if (minDay == maxDay) {
                day = minDay;
                break;
            }

            if (produced < goal) {
                minDay = day + 1;
            } else {
                maxDay = day;
            }
        }

        if (minDay == maxDay) {
            return minDay;
        } else {
            while (day >= minDay) {
                long produced = 0;
                for (long m : machines) {
                    produced = produced + (day - 1) / m;
                }
                if (produced != goal) {
                    break;
                } else {
                    day--;
                }
            }
        }

        return day;
    }
}