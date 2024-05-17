
// find the median of the two sorted arrays.
 // ex. {1, 3} and {2} is 2


public class Solution
{

  public static double logic(int[] A, int[] B) {
  return -1.0;
  //your code
  }

  public static boolean pass()
  {
  boolean result = true;
  result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
  return result;
  };

  public static void main(String[] args)
  {
  if(pass())
  {
    System.out.println("pass");
  }
  else
  {
    System.out.println("some failures");
  }
  }
}