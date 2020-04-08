package com.afro.Strings;


// https://www.hackerrank.com/challenges/special-palindrome-again/problem

public class SubStringCount {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        int len = n;
        long palinCount = 0;
        // all individual chars are palindromes
        // thus only look for palindromes of len >= 2
        // asasd - a s a s d asa sas
        // iterate through different start positions
        for (int i=0;i<len;i++) {
            char curr = s.charAt(i);
            boolean pivotFound = false;
            long halfCounter = 1;
            for (int j=i+1;j<len;j++) {
                if (s.charAt(j) == curr) { 
                    if (!pivotFound) { // found new s-palindrome
                        halfCounter++;
                        palinCount++;
                        // System.out.println(s.substring(i,j+1));
                    } else {
                        halfCounter--;
                        if (halfCounter == 0) {
                            palinCount++;
                            // System.out.println(s.substring(i,j+1));
                            break;
                        }
                    }
                } else if (!pivotFound) { // maybe a middle pivot
                    pivotFound = true;
                } else { // two wrong chars
                    break;
                }
            }
        }
        return palinCount + n;
    }
}