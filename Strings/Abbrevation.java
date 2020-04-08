import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming

public class Abbreviation {



    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        boolean[][] matrixChain = new boolean[b.length() + 1][a.length() + 1];
        matrixChain[0][0] = true;

        for (int i = 0; i < a.length(); i++) {
            matrixChain[0][i + 1] = !Character.isUpperCase(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                char ca = a.charAt(j); char cb = b.charAt(i);

                if (ca == cb) {
                    matrixChain[i + 1][j + 1] = matrixChain[i][j];
                } else if (Character.toUpperCase(ca) == cb) {
                    matrixChain[i + 1][j + 1] = matrixChain[i][j] || matrixChain[i + 1][j];
                } else if (Character.isUpperCase(ca)) {
                    matrixChain[i + 1][j + 1] = false;
                } else {
                    matrixChain[i + 1][j + 1] = matrixChain[i + 1][j];
                }
            }
        }

        return matrixChain[b.length()][a.length()] ? "YES" : "NO";
    }

}