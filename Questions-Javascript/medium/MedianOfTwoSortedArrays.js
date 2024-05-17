/* Median Two Sorted Arrays */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour.
 *  2) Find the median of the two sorted arrays.
 */

function findMedianSortedArrays(A, B) {
  return -1;
  //todo
}


function doTestsPass(testCases)
{
  // add more test cases
  return testCases.reduce((result, testCase) => {
    const answer = findMedianSortedArrays(testCase.inputs[0], testCase.inputs[1]);
    console.info("expected: ", testCase.expected, ", answer: ", answer);
    return result && (answer === testCase.expected);
  }, true);
}


const testCases = [
  { expected: 2.5, inputs: [[1, 3], [2, 4]] },
  { expected: 2.0, inputs: [[1, 3], [2]] },
];

/**
 * Main execution entry.
 */
if(doTestsPass(testCases))
{
  console.log("All tests pass!");
}
else
{
  console.log("There are test failures.");
}