package com.afro.Arrays;



// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

public class JumpingOnClouds {



    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int count = -1;
       
        for (int i = 0; i < c.length; i++, count++) {
            if (i<c.length-2 && c[i+2]==0) i++;
        }
        return count;

    }
}