package com.afro.Strings;

import java.util.ArrayList;
import java.util.HashSet;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

public class SherlockValidString {



    // Complete the isValid function below.
    static String isValid(String s) {
        ArrayList<HashSet<String>> frequencies = new ArrayList<>();
        frequencies.add(new HashSet<String>());
        int minFreq = 1;
        int maxFreq = 1;
        int numDifferentFreqs = 0;

        for (int i=0; i<s.length(); i++) {
            String character = ""+s.charAt(i);
      
            for (int j=frequencies.size()-1; j>=0; j--) {
                HashSet<String> frequency = frequencies.get(j);

                if (frequency.contains(character)) {
                    // move up
                    frequency.remove(character);
                    if (frequency.isEmpty()) 
                        numDifferentFreqs--;
                    
                    // check if min
                    if (j+1 == minFreq && frequency.isEmpty())
                        minFreq = j+2;

                    if (j+1 == frequencies.size()) {
                        frequencies.add(new HashSet<String>());
                        maxFreq = j+2;
                    }
                    
                    HashSet<String> next = frequencies.get(j+1);
                    if (next.isEmpty())
                        numDifferentFreqs++;

                    next.add(character);
                    break;
                }

                if (j == 0) {
                    if (frequency.isEmpty())
                        numDifferentFreqs++;
                    frequency.add(character);
                    minFreq = 1;
                }

            }
        }
        // Case: All same freq
        if (numDifferentFreqs < 2)
            return "YES";
        // Case: 1 higher freq, only minFreq+1
        if (maxFreq == minFreq+1 && frequencies.get(maxFreq-1).size() == 1)
            return "YES";
        // Case: All same freq apart from 1 minFreq at 1
        if (numDifferentFreqs == 2 && frequencies.get(0).size() == 1)
            return "YES";
      
        return "NO";

    }
}