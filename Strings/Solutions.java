import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int mou=0, valley =0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch=='U'){
                ++mou;
            }

            else if(ch=='D'){
                --mou;
            }
            if(mou == 0 && ch == 'U'){
                ++valley;
            }
        }

        return valley;

    }
}