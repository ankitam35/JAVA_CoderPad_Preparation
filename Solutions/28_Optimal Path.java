/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/

import java.io.*;
import java.util.*;

class Solution
{
  public static Integer optimalPath(Integer[][] grid)
  {
	  int rowCount = grid.length;
	  int colCount = grid[0].length;
	  
	  if(rowCount == 0 || colCount == 0)	  
		  return 0;	  

	  for(Integer row = rowCount-1; row >= 0; row--)
	  {
		  for(Integer col = 0; col < colCount; col++)
		  {
			  if(row < rowCount-1 && col > 0)
				  grid[row][col] += Math.max(grid[row+1][col], grid[row][col-1]);
			  else if(row < rowCount-1)
				  grid[row][col] += grid[row+1][col];
			  else if(col > 0)
				  grid[row][col] += grid[row][col-1];
		  }
	  }
	  Integer rockCount = grid[0][colCount-1];
	  System.out.println(rockCount);
	  return rockCount;
  }

  public static boolean doTestsPass()
  {
  boolean result = true;
  // Base test case
  result &= optimalPath(new Integer[][]{{0,0,0,0,5},
                      {0,1,1,1,0},
                      {2,0,0,0,0}}) == 10;
  // Random numbers
  result &= optimalPath(new Integer[][]{{1,3,2,0,2,1,8},
                      {3,4,1,2,0,1,1},
                      {1,1,1,2,3,2,1},
                      {1,0,1,1,4,2,1}}) == 25;
  // All 0's
  result &= optimalPath(new Integer[][]{{0,0,0,0,0},
                      {0,0,0,0,0},
                      {0,0,0,0,0},
                      {0,0,0,0,0}}) == 0;
  // Many optimal paths
  result &= optimalPath(new Integer[][]{{1,1,1,1,1},
                      {1,0,1,0,1},
                      {1,0,1,0,1},
                      {1,1,1,1,1}}) == 8;
  // Empty grid
  result &= optimalPath(new Integer[][]{{}}) == 0;
  
  return result;
  }

  public static void main(String[] args)
  {
  if(doTestsPass())
  {
    System.out.println("All tests pass");
  }
  else
  {
    System.out.println("Tests fail.");
  }
  }
}