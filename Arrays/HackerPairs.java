package com.afro.Arrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


// https://www.hackerrank.com/challenges/pairs/problem

public class HackerPairs {

	static int pairs(int k, int[] arr) {
		int ans = 0;
		
		Set<Integer> set = new HashSet<>();
		
        for(int i=0; i<arr.length;i++){
            set.add(arr[i]);
        }

        for(int i=0; i<arr.length;i++){
            if(set.contains(arr[i] + k )){
                ans++;
            }
            
           
        }
        
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(pairs(1, new int[]{1, 2, 3, 4}));
		System.out.println(pairs(2, new int[]{1, 5, 3, 4, 2}));
	}
}
