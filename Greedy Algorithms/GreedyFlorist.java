package com.afro.greedyAlgorithms;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/greedy-florist/problem

public class GreedyFlorist {

	public static void main(String[] args) {
		System.out.println(getMinimumCost(3, new int[] { 2, 5, 6 }));
		System.out.println(getMinimumCost(2, new int[] { 2, 5, 6 }));
		System.out.println(getMinimumCost(3, new int[] { 1, 3, 5, 7, 9}));
	}

	static int getMinimumCost(int k, int[] c) {
		int minimumCost = 0;
		Arrays.sort(c);
		int[] customerArray = new int[k];
		for (int priceIndex = c.length - 1; priceIndex >= 0;) {
			for (int i = 0; priceIndex >= 0 && i < customerArray.length; i++) {
				minimumCost = minimumCost + ((customerArray[i] + 1) * c[priceIndex]);
				customerArray[i]++;
				priceIndex--;
			}
		}
		return minimumCost;
	}
}