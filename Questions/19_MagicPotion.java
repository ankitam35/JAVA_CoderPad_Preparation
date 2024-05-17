/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

*/

public class Solution
{
  private int minimalSteps( String ingredients )
  {
  return 0;
  }

  private boolean doTestsPass()
  {

  }

  public static void main( String[] args )
  {
 
  if (   return minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5 )
  {
    System.out.println( "Pass" );
  }
  else
  {
    System.out.println( "Fail" );
  }
  }
}