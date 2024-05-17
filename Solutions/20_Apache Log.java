/*
 *						**** IMPORTANT ****
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static String findTopIpaddress(String[] inputs) {

    }



    public static void main(String[] args) {

        String input[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(input);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }


    }

}