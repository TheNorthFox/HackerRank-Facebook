import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// https://www.hackerrank.com/challenges/repeated-string/problem

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        long rem = n % s.length();

        count *= (n / s.length());

        for (int i = 0; i < rem; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;

    }

    static long repeatedStringV2(String s, long n) {
        int A  = 0, remA = 0; 
         for (int i = 0 ; i <= s.length()-1; i++) {
             A = s.charAt(i) == 'a' ? A+1 : A;
             if (i < n % s.length() && s.charAt(i) == 'a') {
                 remA++;
             }
         }
         return A * (n / s.length()) + remA;
     }
}
