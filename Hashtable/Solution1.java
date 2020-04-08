package com.afro.Hashtable;


import java.util.*;


// https://www.hackerrank.com/challenges/frequency-queries/problem
// 4/15 test cases failed

public class Solution1 {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(List<Integer> query : queries) {

            Integer op = query.get(0);
            Integer value = query.get(1);
            if(op == 1) {
                map.put(value, map.getOrDefault(value, 0)+1);
            } else if(op == 2 ) {
                if(map.containsKey(value)) {
                    map.put(value, map.get(value)-1);
                }
            } else if (op == 3) {
                if(map.containsValue(value)) {
                    results.add(1);
                } else {
                    results.add(0);
                }
            }
        }

        return results;
    }
}