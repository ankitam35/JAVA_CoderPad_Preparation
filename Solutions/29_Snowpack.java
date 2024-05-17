package com.codepad.sapient.gs.box;

/**
 *                                XX
 *            XX  *   *   *   *   XX  *   *   XX
 *            XX  *   *   XX  *   XX  XX  *   XX
 *        XX  XX  *   XX  XX  *   XX  XX  *   XX
 *  --------------------------------------------------------
 *    0   1   3   0   1   2   0   4   2   0   3   0
 *
 *    https://www.geeksforgeeks.org/trapping-rain-water/
 *    It's like a bar chart with no spacing between adjacent bars.
 */
public class Snowpack_29 {

  public static void main(String[] args) {
    computeSnowpack(new int[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) ; //output = 13
    computeSnowpack(new int[]{2, 0, 2}) ;                           //output = 2
    computeSnowpack(new int[]{3, 0, 0, 2, 0, 4}) ;                  //output = 10
    computeSnowpack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) ; //output = 6
  }

  /**
   * Solution is to traverse every array element (can be pre computed) and find the highest bars from all on left, do same for right as well. Take the smaller of two heights.
   * The difference between the smaller height and height of the current element is the amount of water that can be stored in this array element.
   */
  static void computeSnowpack(int[] coordinates) {
    int waterUnits = 0;
    int[] leftMax = new int[coordinates.length];         // will contain height of tallest bar to the left of i'th bar including itself
    int[] rightMax = new int[coordinates.length];         // will contain height of tallest bar to the right of i'th bar including itself

    // preset for boundary co-ordinates
    leftMax[0] = coordinates[0];           // first element will not have anything on left, so initialize here
    rightMax[coordinates.length - 1] = coordinates[coordinates.length - 1];  //last element will not have anything on right, so initialize here


    for (int index = 1; index < coordinates.length; index++) {
      //  Note that 2nd argument is 'leftMax' for previous index, this takes care of max till prev index and before.
      leftMax[index] = Math.max(coordinates[index], leftMax[index - 1]);
    }

    for (int index = coordinates.length - 2; index >= 0; index--) {
      //  Note that 2nd argument is 'rightMax' for next index, this takes care of max next index onwards.
      rightMax[index] = Math.max(coordinates[index], rightMax[index + 1]);
    }

    // calculate accumulated water for each hill
    for (int index = 0; index < coordinates.length; index++) {
      int localUnits = Math.min(leftMax[index], rightMax[index]) - coordinates[index];
      waterUnits += localUnits;

    }

    System.out.println("Collected water units :: " + waterUnits);


  }

}
