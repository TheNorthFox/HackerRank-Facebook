package com.afro.Recursion;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        int result = superDigit(n, k);
        System.out.println(result);
        in.close();
    }

    private static int superDigit(String n,  int k) {
        return Integer.parseInt(superDigit("" + sumOfDigits(n) * k));
    }

    private static String superDigit(String number) {
        return number.length() == 1 ? number : superDigit("" + sumOfDigits(number));
    }

    private static long sumOfDigits(String number) {
        long result = 0;
        char[] chars = number.toCharArray();
        for (char theChar : chars) {
            result += Long.parseLong(Character.toString(theChar));
        }
        return result;
    }
}