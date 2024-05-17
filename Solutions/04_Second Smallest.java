/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */
public class Solution {
    public static int secondSmallest(int[] x) {

        if (x.length < 2) {
            return (0);
        }

        int smallestInt = Integer.MAX_VALUE;
        int secondSmallestInt = Integer.MAX_VALUE;
        int element;
        for (int i = 0; i < x.length; i++) {
            element = x[i];
            if (element < smallestInt) {
                secondSmallestInt = smallestInt;
                smallestInt = element;
            } else if (element < secondSmallestInt) {
                secondSmallestInt = element;
            }
        }
        return (secondSmallestInt);
    }

    public static void main(String args[]) {

        int[] a = { 0 };
        int[] b = { 0, 1 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}
