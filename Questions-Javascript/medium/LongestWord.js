/* Longest Word  */

/**
 * Instructions to candidate.
 *  1) Given a a string of letters and a dictionary, the function longestWord should
 *     find the longest word or words in the dictionary that can be made from the letters
 *     Input: letters = "oet", dictionary = {"to","toe","toes"}
 *     Output: {"toe"}
 *     Only lowercase letters will occur in the dictionary and the letters
 *     The length of letters will be between 1 and 10 characters
 *     The solution should work well for a dictionary of over 100,000 words
 *  2) Run this code in the REPL to observe its behaviour.
 *  3) Consider adding some additional tests in doTestsPass().
 *  4) Implement the longestWord() method correctly.
 *  5) If time permits, introduce '?' which can represent any letter.  "to?" could match to "toe", "ton" etc
 */

var _ = require('underscore');

class Dictionary {
  constructor(words) {
    this.words = words
  }

  contains(word) {
    return _.contains(this.words, word);
  }
}

function longestWord(letters, dict) {
  return dict.contains(letters) ? [letters] : [];
}

function arraysEqual(arr1, arr2) {
  return _.difference(arr1, arr2).length == 0 && _.difference(arr2, arr1) == 0
}

function doTestsPass() {
  var words = ["to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"];
  let dict = new Dictionary(words);

  var result = arraysEqual(["toe"], longestWord("toe", dict));
  result = result && arraysEqual(["toes", "dogs"], longestWord("osetdg", dict));
  
  return result;
}

/**
 * Main execution entry.
 */
if(doTestsPass()) {
  console.log("All tests pass!");
} else {
  console.error("There are test failures.");
}