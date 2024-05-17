/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/

import java.io.*;
import java.util.*;

public class Solution
{
  public static int subArrayExceedsSum(int arr[], int target )
  {
  int i = 0, j = 0, subArraySize = Integer.MAX_VALUE, arraySize = arr.length;
  
  if( target <= 0 )
    return 0;
  
  if( arraySize < 1 )
    return -1;
  
  int currentSum = arr[ 0 ];
  while( true )
  {
    if( currentSum >= target )
    if( i == j )
      return( 1 );
    else
    {
      if( j - i + 1 < subArraySize )
      subArraySize = j - i + 1;
      currentSum -= arr[ i ];
      i++;
    }
    else
    {
    j++;
    if( j == arraySize )
      break;
    else
      currentSum += arr[ j ];
    };
  };

  if(subArraySize == Integer.MAX_VALUE )
    return -1;

  return subArraySize;
  }

  public static void doTestsPass()
  {
  boolean result = true; 
  int[] arr = { 1, 2, 3, 4 };
  result = result && subArrayExceedsSum( arr, 6 ) == 2;
  result = result && subArrayExceedsSum( arr, 12 ) == -1;
  result = result && subArrayExceedsSum( arr, 10 ) == 4;
  result = result && subArrayExceedsSum( arr, 4 ) == 1;

  int[] arr2 = {};
  result = result && subArrayExceedsSum( arr2, 0 ) == 0;
  result = result && subArrayExceedsSum( arr2, 2 ) == -1;
  
  if( result )
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  };

  public static void main(String[] args)
  {
  doTestsPass();
  }
};
