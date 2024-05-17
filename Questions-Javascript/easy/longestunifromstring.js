/* Longest Uniform Substring  */

/**
 * 
 * 
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *
 *  2) Your task is to implement the following function ('longestUniformSubstring')
 *   
 *  This function should return an array with exactly two elements that describe the location of the longest
 *  uniform substring of a string input. The first element of the array should be the start index and the second 
 *  element is the length
 *  
 *  e.g.
 *      
 *      for the input: "abbbccda" the longest uniform substring is "bbb" 
 *      (which starts at index 1 and is 3 characters long).
 *      
 *      Therefore the return value would be the array: [1, 3]
 *  
 *  3) If time permits, consider adding additional test cases.
 */
var solution = (function(){

  function longestUniformSubstring(input){
    return [ -1, 0 ];
  }
  
  
  function doTestsPass(testCases) {
    var passes = true;
    for(var testCase in testCases){
    if(testCases.hasOwnProperty(testCase)){
      var expectedResult = testCases[testCase];
      var actualResult = longestUniformSubstring(testCase);
      passes = passes && (expectedResult[0] == actualResult[0] && expectedResult[1] == actualResult[1]);
    }
    }
    return passes;
  }
  
  return {
    doTestsPass: doTestsPass,
    longestUniformSubstring: longestUniformSubstring
  };

})();

/*
  todo: add more test cases please!
*/
var testCases = {
  "":             [ -1, 0  ],
  "10000111":     [  1, 4  ],
  "aabbbbbCdAA":  [  2, 5  ],
}

if(solution.doTestsPass(testCases)){
  console.log("All tests pass!");
} else {
  console.error("Not all tests pass :(");
}