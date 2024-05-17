/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 * 					******** IMPORTANT ********
 */

/**
 *  Implement power(base,exp) correctly. Assume exp is an integer.
 *
 */

public class Solution {

  /* Given base and integer exponent, compute value of base raised to the power of exponent.
   * Can you implement a solution faster than O(exp)?
   */
  public static double power(double base, int exp) {
    if(base==0) return 0;
    if(exp==0) return 1;
    if(exp==1) return base;
    int positiveExp =  (exp<0) ? exp*-1 : exp;
    double result= (positiveExp%2==0)? power(base*base,positiveExp/2):base*power(base*base,(positiveExp-1)/2);
    return exp<0 ? 1/result:result;
  }

  /* returns true if all tests pass, false otherwise */
  public static boolean doTestsPass() {
    double base[] = {2,2, 2.3, 0, 5.5,6.2};
    int exponent[] ={4,-3,20, 10, 0,  1};
    boolean doTestsPass = true;
    double tolerance = 0.0001;

    for (int i=0;i<base.length;++i) {
      double actual =power(base[i], exponent[i]);
      double expected = Math.pow(base[i], exponent[i]);
      boolean currentResult = Math.abs(actual-expected)<tolerance;
      doTestsPass =  doTestsPass && currentResult;
      if(!doTestsPass)
      System.out.println("power("+base[i]+","+exponent[i]+") failed. Actual:" + actual + " Expected:" + Math.pow(base[i], exponent[i]));
    }
    return  doTestsPass;
  }

  public static void main( String[] args ) {
    if (doTestsPass())
      System.out.println("All Tests Pass");
    else
      System.out.println("There are test failures");
  }
 }