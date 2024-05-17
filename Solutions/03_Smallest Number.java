/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */
import java.util.*;

public class Solution {

    public static int FindMin(int a[]) {
        if (a == null)
            throw new IllegalArgumentException("Invalid input");

        return FindMinInArray(a, 0, a.length - 1);
    }

    private static int FindMinInArray(int arr[], int left, int right) {

        if (left == right)
            return arr[left];

        if (left > right)
            return arr[0];

        int middle = (left + right) / 2;

        if (middle < right && arr[middle] > arr[middle + 1])
            return arr[middle + 1];
        if (middle > left && arr[middle - 1] > arr[middle])
            return arr[middle];

        if (arr[right] > arr[middle])
            return FindMinInArray(arr, left, middle - 1);

        return FindMinInArray(arr, middle + 1, right);
    }

    public static void main(String args[]) {
        boolean result = true;
        result = result && FindMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
        result = result && FindMin(new int[] { 2, 1 }) == 1;
        result = result && FindMin(new int[] { 1 }) == 1;

        try {
            FindMin(null);
            result = false;
        } catch (Exception e) {
            result = result && true;
        }

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}