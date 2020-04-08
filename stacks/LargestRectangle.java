package com.afro.stacks;

import java.util.Stack;


// https://www.hackerrank.com/challenges/largest-rectangle/problem

public class LargestRectangle {

	// Complete the largestRectangle function below.
    static long largestRectangle(int[] h)  {
    	Stack<Integer> indexStack = new Stack<>();
        long largestRectangle = Long.MIN_VALUE;

        int i = 0;
        while (i < h.length) {

            if (indexStack.isEmpty() || h[indexStack.peek()] <= h[i]) {
                indexStack.push(i);
                i++;
                continue;
            }

            long area = 0;
            int index = indexStack.pop();

            if (indexStack.isEmpty()) {
                area = h[index] * i;
            } else {
                area = h[index] * (i - indexStack.peek() - 1);
            }

            largestRectangle = Math.max(largestRectangle, area);
        }

        while (!indexStack.isEmpty()) {

            int index = indexStack.pop();
            long area = 0;

            if (indexStack.isEmpty()) {
                area = h[index] * h.length;
            } else {
                area = h[index] * (h.length - indexStack.peek() - 1);
            }

            largestRectangle = Math.max(largestRectangle, area);
        }

        return largestRectangle;
    }
    
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 5, 9, 11};
		System.out.println(largestRectangle(arr));
	}

}