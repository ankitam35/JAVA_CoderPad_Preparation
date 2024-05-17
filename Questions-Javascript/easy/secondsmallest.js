/* Second Smallest  */

/**
 * 
 * 1) Run this code in the REPL to observe its behaviour. The
 *    execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement secondSmallest() correctly.
 * 4) If time permits, some possible follow-ups.
 */


/**
 * Returns the second smallest element in the array x.
 * Returns 0 if the array has fewer than 2 elements.
 */
function secondSmallest(x)
{
  // implement this function
  return 0;
}


function doTestsPass()
{
  // todo: add more test cases
  var testArrays  = [[0], [0, 1]];
  var testResults = [0, 1];
  
  // Run through the tests and make assertions
  for(var i = 0; i < testArrays.length; i++)
  {
  if(secondSmallest(testArrays[i]) != testResults[i])
  {
    return false;
  }
  }
  return true;
}


/**
 * Main execution entry.
 */
if(doTestsPass())
{
  console.log("All tests pass!");
}
else
{
  console.log("There are test failures.");
}