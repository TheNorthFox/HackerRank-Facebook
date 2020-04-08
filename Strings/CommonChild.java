package com.afro.Strings;
;


// https://www.hackerrank.com/challenges/common-child/problem

public class CommonChild {



    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	int[][] grid = new int[s1.length() + 1][s2.length() + 1];
    	for (int i = 0; i <= s1.length(); i++) {
    		for (int j = 0; j <= s2.length(); j++) {
    			if (i == 0 || j == 0) {
    				grid[i][j] = 0;
    			}
    			else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
    				grid[i][j] = grid[i - 1][j - 1] + 1;
    			}
    			else {
    				grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
    			}
    		}
    	}
    	return grid[s1.length()][s2.length()];

    }
}