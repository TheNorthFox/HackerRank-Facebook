package com.afro.Graphs;

import java.util.*;
/*
Task: Find the nearest node where had the same color as target. Given the color find the cloest two node where they are the same.
Input: int graphNodes = amount of node, a int array graphfrom and a int array graphTo => the edge from v1 to v2, a long [] ids for indicate the color of each node
       int val => the color id that we need to find the pair
Output: return shorestpath (value of each edge = 1), if not pair return -1;
 */

// https://www.hackerrank.com/challenges/find-the-nearest-clone/problem

public class FindShortest {

	// Complete the findShortest function below.

	/*
	 * For the unweighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes.
	 * 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] to <name>To[i].
	 *
	 */



	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
		//         solve here
		//         Brute Force solution

		int count = 0;
		for(int i=0; i<ids.length; i++){
			if(ids[i] == ids[val-1])
				count++;
		}
		if(count == 1){
			return -1;
		}

		// BFS:
		int[] distances = new int[graphNodes];
		Arrays.fill(distances, -1);
		distances[val-1] = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(val);

		while(!queue.isEmpty()){
			int node = queue.poll();
			for(int neighbor: findNeighbors(graphFrom, graphTo, node)){
				if(distances[neighbor-1] == -1){
					distances[neighbor-1] = distances[node-1]+1;
					queue.add(neighbor);
				}
				if(ids[neighbor-1] == ids[val-1] && neighbor != val)
					return distances[neighbor-1];
			}
		}
		return -1;
	}

	// Returns neighbors of a node:
	static ArrayList<Integer> findNeighbors(int[] graphFrom, int[] graphTo, int node){
		ArrayList<Integer> neighbors = new ArrayList<>();
		for(int i=0; i<graphFrom.length; i++){
			if(node == graphFrom[i])
				neighbors.add(graphTo[i]);
			if(node == graphTo[i])
				neighbors.add(graphFrom[i]);
		}
		return neighbors;
	}
}