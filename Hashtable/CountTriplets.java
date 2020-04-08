package com.afro.Hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/count-triplets-1/problem
public class CountTriplets {
	
	

	public static void main(String[] args) {
		long[] input1 = {1,2,2,4};
		List<Long> arr1 = Arrays.stream(input1).boxed().collect(Collectors.toList());
		
		long[] input2 = {1,3,9,9,27,81};
		List<Long> arr2 = Arrays.stream(input2).boxed().collect(Collectors.toList());
		System.out.println(countTriplets(arr1, input1[3]));
		System.out.println(countTriplets(arr2, input2[3]));
	}
	
	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	
    	long total = 0;
        Map<Long, Long> count = new HashMap<>(); // count of ints
        Map<Long, Long> triplets = new HashMap<>(); // map 2nd -> count of links
        
        for (int i = 0; i < arr.size(); ++i) {
            long value = arr.get(i);
            // incrementing total
            if (value % r == 0 && triplets.containsKey(value / r)) {
                total += triplets.get(value / r);
            }
            // create links/triplets
            if (triplets.containsKey(value)) {
                triplets.put(value, triplets.get(value) + count.get(value/r));
            } else if (value % r == 0 && count.containsKey(value / r)) {
                triplets.put(value, count.get(value / r));
            }

            // incrementing the counter
            if (count.containsKey(value))
                count.put(value, count.get(value)+1);
            else
                count.put(value, 1L);
        }

        return total;
    }
}