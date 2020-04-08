package com.afro.Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/balanced-forest
 * [Balanced Forest]
 * [HARD]
 *
 */
public class BalancedForest {

	public static int balancedForest(int[] c, int[][] edges) {

		if(edges.length < 2 || c.length < 4) return -1;

		//sum sub trees
		//check if two sums are equal - add root & remainder to last sum
		//add root to sum so it matches the max, add difference from max to last sum
		Map<Integer, Integer> childToSum = new HashMap<>();

		for(int[] edge : edges) {

			Arrays.sort(edge);

			int fromNode = edge[0];
			int newNode = edge[1];


			if(fromNode == 1) { // only captures first "generation" of children
				childToSum.put(newNode, c[newNode-1]);
				continue;
			}

			int currentSum = 0;

			if(childToSum.get(fromNode) != null)
				currentSum = childToSum.get(fromNode);

			childToSum.put(newNode, currentSum+c[newNode -1]);
			childToSum.remove(fromNode);
		}

		if(childToSum.size() == 2) {
			childToSum.put(c.length+1, 0);
		}

		return getRemainder(childToSum.values().toArray(new Integer[]{}), c[0]);
	}

	private static int getRemainder(Integer[] nodeSums, int root) {
		Arrays.sort(nodeSums);

		if(nodeSums[1] == nodeSums[2]){
			return nodeSums[2] - root - nodeSums[0];
		}

		return nodeSums[2] - nodeSums[0];
	}

}