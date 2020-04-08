import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// https://www.hackerrank.com/challenges/new-year-chaos/problem
class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static void minimumSwaps(int[] q) {
        for(int i=0;i<q.length;i++){
            if((q[i] - (i+1)) > 2){
                System.out.println("Too chaotic");
                return; 
            }
        }
               
        //now we just need to count number of Swaps
        int swaps=0;
        for(int i=0;i< q.length;i++){
            for(int j=i+1;j<q.length;j++){
                if(q[i] > q[j]){ 
                    int tmp=q[j];
                    q[j]=q[i];
                    q[i]=tmp;
                    swaps++;
                }
            }
        }
        
        System.out.println(swaps);

    }

    


}