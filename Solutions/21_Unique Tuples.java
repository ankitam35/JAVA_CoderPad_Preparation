/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static HashSet<String> uniqueTuples(String inputString, int length) throws IllegalArgumentException {
        HashSet<String> hs = new HashSet<String>();
        int inputStringLen = 0;

        if (inputString == null || inputStringLen == 0 || length <= 0 || length > inputStringLen) {
            if(inputString == null) {
                throw new IllegalArgumentException("Input string cannot be null.");
            } else {
                inputStringLen = inputString.length();
            }
            if(inputStringLen == 0) {
                throw new IllegalArgumentException("Input string cannot be of zero length.");
            }
            if (length <= 0) {
                throw new IllegalArgumentException("Length of tuples has to be greater than zero.");
            }
            if (length > inputStringLen) {
                throw new IllegalArgumentException(
                        "Length of the tuple cannot be more than the length of the input string.");
            }
        }

        for (int i = 0; i < (inputStringLen - length + 1); i++) {
            hs.add(inputString.substring(i, (i + length)));
        }

        return hs;
    }

    public static void main(String[] args) {

        String input = "aab";
        String input1 = "abbccde";

        HashSet<String> result = uniqueTuples(input, 2);
        HashSet<String> result1 = uniqueTuples(input1, 2);

        if ((result.contains("aa") && result.contains("ab"))
                && (result1.containsAll(Arrays.asList("ab", "bb", "bc", "cc", "cd", "de")) && result1.size() == 6)) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }

    }
}