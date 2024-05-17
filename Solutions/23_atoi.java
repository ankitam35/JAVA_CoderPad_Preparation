/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

public class Solution
{
    public static int atoi(String inputString)
    {
        int res = 0;
        int k = 0;
        int strLength = inputString.length();
        int multiplyBy = 1;

        if (strLength != 0 && inputString.charAt(0) == '-')
        {
            multiplyBy = -1;
            k++;
        }

        for(; k < strLength; k++)
        {
            char c = inputString.charAt(k);

            if (c < '0' || c > '9')
            {
                break;
            }

            res = res * 10 + c - '0';
        }

        return res * multiplyBy;
    };


    public static boolean doTestsPass()
    {
        boolean result = true;
        result = result && atoi("0") == 0;
        result = result && atoi("1") == 1;
        result = result && atoi("123") == 123;
        result = result && atoi("-1") == -1;
        result = result && atoi("-123") == -123;
        result = result && atoi("123a") == 123;
        result = result && atoi("a") == 0;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atoi(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atoi(intMin) == Integer.MIN_VALUE;

        return result;
    };


    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }
}