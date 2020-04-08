package com.afro.Hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

public class AnagramPairs {
	public static int anagramPairs(String s) {
		Map<String, Integer> ssCounts = new HashMap<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				String subStr = s.substring(i, j + 1);
				char[] ssChars = subStr.toCharArray();
				Arrays.sort(ssChars);
				String sortedSubStr = new String(ssChars);
				ssCounts.put(sortedSubStr, ssCounts.getOrDefault(sortedSubStr, 0) + 1);
			}
		}

		int total = 0;
		for (int count : ssCounts.values()) {
			if (count > 1) {
				// n*(n-1)/2
				total += count * (count - 1) /2;
			}
		}
		return total;
	}
}

