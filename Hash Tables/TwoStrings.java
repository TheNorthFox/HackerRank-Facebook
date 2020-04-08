import java.io.*;

public class Solution {



    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        if (s1 == null || s2 == null) return "NO";
    for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
      if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) {
        return "YES";
      }
    }
    
    return "NO";

    }

}
