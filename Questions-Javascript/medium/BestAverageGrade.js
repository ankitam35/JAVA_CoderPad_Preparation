/* Best Average Grade  */

/*
**  Instructions:
**
**  Given a list of student test scores, find the best average grade.
**  Each student may have more than one test score in the list.
**
**  Complete the bestAverageGrade function in the editor below.
**  It has one parameter, scores, which is an array of student test scores.
**  Each element in the array is a two-element array of the form [student name, test score]
**  e.g. [ "Bobby", "87" ].
**  Test scores may be positive or negative integers.
**
**  If you end up with an average grade that is not an integer, you should
**  use a floor function to return the largest integer less than or equal to the average.
**  Return 0 for an empty input.
**
**  Example:
**
**  Input:
**  [ [ "Bobby", "87" ],
**    [ "Charles", "100" ],
**    [ "Eric", "64" ],
**    [ "Charles", "22" ] ].
**
**  Expected output: 87
**  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
**  respectively. 87 is the highest.
*/

function bestAverageGrade(scores) {

  // TODO: implement this function
  return 0;
}


function doTestsPass() {

  const tc1 = [
  [ 'Bobby', '87' ],
  [ 'Charles', '100' ],
  [ 'Eric', '64' ],
  [ 'Charles', '22' ]
  ];

  return bestAverageGrade(tc1) === 87;
}

if(doTestsPass()) {
  console.log("All tests pass!");
} else {
  console.error("There are test failures.");
}