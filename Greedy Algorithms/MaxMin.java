package com.afro.greedyAlgorithms;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/angry-children/problem

public class MaxMin {

	public static void main(String[] args) {
		System.out.println(maxMin(3, new int[] { 10, 100, 300, 200, 1000, 20, 30 }));
		System.out.println(maxMin(4, new int[] { 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 }));
		System.out.println(maxMin(2, new int[] { 1, 2, 1, 2, 1}));
	}

	static int maxMin(int k, int[] arr) {
		Arrays.sort(arr);
		int minUnfairness = Integer.MAX_VALUE;
		for(int i =0;i+k<=arr.length;i++) {
			int min = findMinUnfairness(Arrays.copyOfRange(arr,i, i+k));
			if(minUnfairness>min) minUnfairness = min;
		}
		return minUnfairness;
	}

	private static int findMinUnfairness(int[] subArr) {
		int min = subArr[0];
		int max = subArr[subArr.length-1];
		return max - min;
	}
}