package com.afro.stacks;

import java.util.Arrays;
import java.util.Stack;


// https://www.hackerrank.com/challenges/poisonous-plants/problem

public class PoisonousPlants {

	public static void main(String[] args) {

		System.out.println(poisonousPlants(new int[] { 4, 3, 7, 5, 6, 4, 2 }));

	}

	static int poisonousPlants(int[] p) {

		Arrays.stream(p).forEach(v -> System.out.printf(v + " "));
		Stack<Integer[]> stack = new Stack<>();
		int maxDay = 0;

		for (int i = 0; i < p.length ; i++) {
			int popMaxDay = 0;
			//System.out.print(i + ") num = " + p[i] + " popMaxDay = " + popMaxDay + ", maxDay = " + maxDay + ", stack = ");
			// stack.forEach(v -> System.out.print(v[0] + "," + v[1] + " "));
			// System.out.println();
			while (!stack.isEmpty() && stack.peek()[0] >= p[i]) {
				popMaxDay = Math.max(popMaxDay, stack.pop()[1]);
			}

			popMaxDay = stack.isEmpty() ? 0 : popMaxDay + 1;
			maxDay = Math.max(maxDay, popMaxDay);

			stack.push(new Integer[]{p[i], popMaxDay});

		}

		// System.out.println(maxDay);
		return maxDay;
	}

}