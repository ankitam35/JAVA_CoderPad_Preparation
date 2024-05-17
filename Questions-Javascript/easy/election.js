/*  Election  */

var _ = require('underscore');
/**
 * 
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement whoIsElected() correctly.
 * 4) If time permits, try to improve your implementation.
 */
var solution = (function(){

  /**
   * A group of students are sitting in a circle. The teacher is electing a new class president. 
   * The teacher does this by singing a song while walking around the circle. After the song is 
   * finished the student at which the teacher stopped is removed from the circle. 
   * 
   * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
   * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left. 
   *
   * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
   * 
   * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first 
   * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
   *
   * @param n the number of students sitting in a circle.
   * @param k the length (in students) of each song.
   * @return the number of the student that is elected.
   */
  function whoIsElected(n, k) {
    return -1;
  }
  
  
  function doTestsPass(testCases) {
    var passes = true;
    for(var i=0; i<testCases.length; i++){
    const testCase = testCases[i];
    const expectedResult = testCase[2];
    const actualResult = whoIsElected(testCase[0], testCase[1]);
    passes = passes && (expectedResult === actualResult);
    }
    return passes;
  }
  
  return {
    doTestsPass: doTestsPass,
    whoIsElected: whoIsElected
  };

})();

/*
  todo: add more test cases please!
*/
const testCases = [
  [1, 1, 1],
  [2, 2, 1],
  [4, 2, 1],
  [100, 2, 73]
]

if(solution.doTestsPass(testCases)){
  console.log("All tests pass!");
} else {
  console.error("Not all tests pass :(");
}