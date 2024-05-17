/* Search Tree  */

/*
 
  1) Run this code in the REPL to observe its behaviour. The
   execution entry point is main().
  2) Implement the "put" and "contains" methods.
  3) Fix the "inOrderTraversal" method.
  4) Add additional relevant tests
  5) If time permits, try to improve your implementation.
*/

var _ = require("underscore");

class Node
{

}


function put(node, value)
{
  // your code goes here
}


function contains(node, value)
{
  // your code goes here
}

function inOrderTraversal(node)
{
  return inOrderTraversalAcc(node, []);
}


function inOrderTraversalAcc(node, acc)
{
  if (!node.value)
  {
  return acc;
  }

  inOrderTraversalAcc(node.left, acc);
  acc.push(node.value);
  inOrderTraversalAcc(node.right, acc);
  return acc;

}


function assert(condition)
{
  if (! condition)
  throw new Error();
}

function testTree()
{
  var tree = new Node();
  put(tree, 3);
  put(tree, 1);
  put(tree, 2);
  put(tree, 5);
  assert(!contains(tree, 0));
  assert(contains(tree, 1));
  assert(contains(tree, 2));
  assert(contains(tree, 3));
  assert(!contains(tree, 4));
  assert(contains(tree, 5));
  assert(!contains(tree, 6));
  assert(_.isEqual(inOrderTraversal(tree), [1,2,3,5]));

}

function doTestsPass()
{
   testTree();
   // TODO add more tests
}


/**
 * Main execution entry.
 */
doTestsPass();
console.log("Success!");