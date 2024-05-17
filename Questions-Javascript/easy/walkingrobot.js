/* Walking Robot  */


//
// 1. Run this code in the REPL to observe its behaviour. The
//    execution entry point is main().
// 2. Implement the 'walk' method. This method takes in a string, path,
//    where each character in the string corresponds to a potential movement
//    of the robot. The robot can move up, down, left, and right represented
//    by the characters 'U', 'D', 'L', and 'R' respectively. All other
//    characters may be ignored. Assume the robot's initial position
//    is at (0,0). The output of this method is the robot's final x and y
//    coordinates relative to the initial position.
// 3. Consider adding more test cases

'use strict';

var chai = require('chai');
var Mocha = require('mocha');
var mocha = new Mocha({ui: 'bdd'});
var assert = chai.assert;

function walk(path) {
  //Implement walk function
  return undefined;
}

// Start CoderPad testing bootstrap 
mocha.suite.emit('pre-require', this, 'solution', mocha);
// End CoderPad testing bootstrap

describe('"walk" Test Suite', function() {

  it('go 3 times up', function() {
  var input = 'UUU';
  var result = walk(input);
  assert.deepEqual(result, [0, 3], '');
  });

  it('simple test', function() {
  var input = 'ULDR';
  var result = walk(input);
  assert.deepEqual(result, [0, 0], 'simple test');
  });

  it('extensive test', function() {
  var input = 'ULLLDUDUURLRLR';
  var result = walk(input);
  assert.deepEqual(result, [-2, 2], 'extensive test');
  });

  it('another input', function() {
  var input = 'UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP';
  var result = walk(input);
  assert.deepEqual(result, [1, 1], 'another input');
  });
});


mocha.run(function() {});