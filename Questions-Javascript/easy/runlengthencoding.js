/*  Run Length Encoding  */

/**
 * 
 *  1) Run this code in the REPL to observe its behaviour.
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement rle() correctly.
 *  4) If time permits, try to improve your implementation.
 */


/**
 * rle ( testString )
 *
 * Implement a run length encoding function.
 *
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaa" -> "a2b3a2"
 * ""      -> ""
 *
 */

const _ = require("underscore");

const rle = ( input ) => {
  // your code
}

const doTestsPass = () => {

  const VALID_COMBOS = {"aaa": "a3", "aaabbc":"a3b2c1"};

  let testPassed = true;

  _.forEach(VALID_COMBOS, function(value, key) {
  console.log(key, rle(key));
  if (value !== rle(key)) {
    testPassed = false;
  }
  });

  return testPassed;
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
