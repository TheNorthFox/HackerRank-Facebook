import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string , remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):

s: a string
Input Format

The first line contains an integer , the number of queries.
The next  lines each contain a string .

Constraints

Each string  will consist only of characters  and 
Output Format

For each query, print the minimum number of deletions required on a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that can be deleted so that the string doesn't have matching consecutive characters.

AAAA  ----> A(3 deletion)
BBBBB ----> B(4 deletion)
ABABABAB ---> ABABABAB(0 deletion)
BABABA -----> BABABA(0 deletion)
AAABBB -----> AB(4 deletion)
*/


public class AlternatingChar {



    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int deletions = 0;
        int currentCount = 1;
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) != s.charAt(i-1))
            {
                deletions += currentCount - 1;
                currentCount = 1;
                continue;
            }
            currentCount++;
        }
        deletions += currentCount - 1;

        return deletions;
    }

}