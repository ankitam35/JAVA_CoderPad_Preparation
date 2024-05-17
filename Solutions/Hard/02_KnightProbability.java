/*
 Instructions:

 Given an empty chessboard (8x8 grid), a knight is placed
 on one of the squares. The knight 'K' at position (3, 3)
 and it's possible movements 'X' are shown in the example
 below:

 * * * * * * * *
 * * X * X * * *
 * X * * * X * *
 * * * K * * * *
 * X * * * X * *
 * * X * X * * *
 * * * * * * * *
 * * * * * * * *

 Depending on the knight's position on the board, 0-6 of
 the 8 possible movements may cause the knight to leave
 the chess board.

 If the knight moves n times, each time choosing one of
 the 8 possible moves uniformly at random, determine the
 probability that the knight is still on the board after
 making n random moves. After the knight has left the
 board, it may not reenter.

 Please implement the method probability which given a
 start position x, y, and a number of moves n,
 returns the probability a knight remains on the board
 as described above.
 */
public class Solution {
  /**
   * TODO: Implement Me!
   */
  public static double probability(int x, int y, int n) {
    int boardSize = 8;
    // Define an 8x8 grid
    double[][] board = new double[boardSize][boardSize];
    // Set the starting position
    board[x][y] = 1.0;
    // Possible moves
    int[][] moves = new int[][] {
      { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 },
      { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 },
    };
    for (int i = 0; i < n; i++) {
      double[][] nextBoard = new double[boardSize][boardSize];
      // Fill in probabilities for every square on the previous board
      for (int currentX = 0; currentX < boardSize; currentX++) {
        for (int currentY = 0; currentY < boardSize; currentY++) {
          // Check all the board positions that could have lead here
          for (int[] move : moves) {
            int previousX = currentX + move[0];
            int previousY = currentY + move[1];
            if (0 <= previousX && previousX < boardSize && 0 <= previousY && previousY < boardSize) {
              // Probability of getting to x, y is 1/8 * probability it was on previous square
              if (board[previousX][previousY] > 0) {
                nextBoard[currentX][currentY] += board[previousX][previousY] / 8;
              }
            }
          }
        }
      }
      board = nextBoard;
    }

    // Return sum of probabilities from last board state
    double probability = 0.0;
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        probability += board[i][j];
      }
    }

    return probability;
  }

  public static boolean doTestsPass() {
    // TODO: please feel free to make testing more elegant
    boolean result = true;
    // Start in a corner, no moves
    result = result && probability(0, 0, 0) == 1.0;
    // Start in the middle, one move
    result = result && probability(3, 3, 1) == 1.0;
    // Start in a corner, one move
    result = result && probability(0, 0, 1) == 0.25;
    result = result && probability(0, 0, 2) == 0.1875;
    result = result && probability(1, 2, 10) == 0.0522148497402668;
    return result;
  }

  /**
   * Execution entry point
   */
  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }
  }
}