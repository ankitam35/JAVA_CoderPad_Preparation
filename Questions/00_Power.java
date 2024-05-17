
/**
 *  Implement power(base,exp) correctly. Assume exp is an integer.
 *
 */

public class Solution {

  /* Given base and integer exponent, compute value of base raised to the power of exponent.
   * Can you implement a solution faster than O(exp)?
   */
  public static double power(double base, int exp) {
	//your code
    return 8;
  }

  /* returns true if all tests pass, false otherwise */
  public static boolean doTestsPass() {
    boolean doTestsPass = true;
	double result = power(2,2);
    return  doTestsPass;
  }

  public static void main( String[] args ) {
    if (doTestsPass())
      System.out.println("All Tests Pass");
    else
      System.out.println("There are test failures");
  }
 }