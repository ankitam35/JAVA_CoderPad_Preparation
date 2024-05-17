/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 * 					******** IMPORTANT ********
 */
import java.util.*;

public class Solution {

    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){
        int longStart = -1;
        int longLen = 0;
        int strIndex = 1;
        int length = input.length();
        while(strIndex < length) {
            int start = strIndex - 1;
            int currLen = 1;
            while(strIndex < length && input.charAt(strIndex) == input.charAt(strIndex - 1) ){
                strIndex++;
                currLen++;
            }
            if(currLen > longLen){
                longStart = start;
                longLen = currLen;
            }
            strIndex++;
        }
        return new int[]{ longStart, longLen };
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("All tests pass!");
        } else {
            System.out.println("At least one failure! :( ");
        }
    }
}