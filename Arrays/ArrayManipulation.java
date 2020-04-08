package com.afro.Arrays;
/**
 *
 */

public class ArrayManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] queries = new int[][] {{1,5,3},{4,8,7},{6,9,1}};
		System.out.println("main.maxVal : " + arrayManipulation(10, queries));
		
		queries = new int[][] {{1,2,100},{2,5,100},{3,4,100}};
		System.out.println("main.maxVal : " + arrayManipulation(5, queries));
		
		queries = new int[][] {{2, 6, 8},{3,5,7}, {1,8,1}, {5,9,15}};
		System.out.println("main.maxVal : " + arrayManipulation(10, queries));
	}
	
	static long arrayManipulation(int n, int[][] queries) {
		if(n < 1)
		{
			return 0;
		}
		
		long ar[] = new long[n];
		for(int i = 0; i < queries.length; i ++)
		{
			ar[queries[i][0]-1] += queries[i][2];
			if(queries[i][1] < n)
			{
				ar[queries[i][1]] -= queries[i][2];
			}
		}
		
		long max = -1;
		long sum = 0; 
		for (int i = 0; i < n; i++) {
			sum += ar[i];
			if(sum > max)
			{
				max = sum;
			}
		}
		
		return max;
    }

}