/*
Instructions to candidate.
  3) Implement getLowestPrices() correctly.

Question:
A popular online retailer allows vendors to specify different prices in advance
for the same item throughout the day. We now need to design an algorithm that
helps identify the lowest price for the item at any point of the day.

Assumptions:
1) For the algorithm, assume all vendors are selling the same product
and there is only one product being sold. Given a list that has
vendor information - ( startTime, endTime, price ) of the deal,
return a sorted list with different possible intervals and
the least price of the product during the interval.

2) The interval is inclusive of start and end time.

3) All the 3 values passed by the vendor are integers.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution
{
  private class Interval
  {
  int startTime;
  int endTime;
  int price;

  Interval( int startTime, int endTime, int price )
  {
    if ( startTime >= endTime )
    {
    throw new IllegalArgumentException( "startTime greater than or equal to endTime for an interval" );
    }
    else if ( startTime < 0 || endTime < 0 || price < 0 )
    {
    throw new IllegalArgumentException( "vendor information has negative values" );
    }

    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }

  public int getStartTime()
  {
    return startTime;
  }

  public int getEndTime()
  {
    return endTime;
  }

  public int getPrice()
  {
    return price;
  }

  @Override
  public boolean equals( Object o )
  {
    if ( this == o )
    {
    return true;
    }
    if ( !(o instanceof Interval) )
    {
    return false;
    }
    Interval interval = (Interval) o;
    return getStartTime() == interval.getStartTime() &&
       getEndTime() == interval.getEndTime() &&
       getPrice() == interval.getPrice();
  }

  @Override
  public int hashCode()
  {
    int result = getStartTime();
    result = 31 * result + getEndTime();
    result = 31 * result + getPrice();
    return result;
  }
  }

  private class BinaryTree
  {
  private Interval data;
  private BinaryTree left;
  private BinaryTree right;

  BinaryTree( Interval data )
  {
    this.data = data;
    left = null;
    right = null;
  }

  void addNode( Interval interval )
  {
    if ( interval.getStartTime() < data.getStartTime() )
    {
    Interval newInterval = new Interval( interval.getStartTime(),
                       Math.min( interval.getEndTime(), data.getStartTime() ),
                       interval.getPrice() );
    if ( this.left != null )
    {
      this.left.addNode( newInterval );
    }
    else
    {
      this.left = new BinaryTree( newInterval );
    }
    }

    if ( interval.getEndTime() > data.getEndTime() )
    {
    Interval newInterval = new Interval( Math.max( interval.getStartTime(), data.getEndTime() ),
                       interval.getEndTime(),
                       interval.getPrice() );
    if ( this.right != null )
    {
      this.right.addNode( newInterval );
    }
    else
    {
      this.right = new BinaryTree( newInterval );
    }
    }
  }

  private void traverse( List<Interval> results )
  {
    if ( this.left != null )
    {
    this.left.traverse( results );
    }
    results.add( this.data );
    if ( this.right != null )
    {
    this.right.traverse( results );
    }
  }

  List<Interval> inOrder()
  {
    List<Interval> results = new ArrayList<Interval>();
    this.traverse(results);
    return results;
  }
  }

  private List<Interval> getLowestPrices( List<Interval> inputIntervals ) throws IllegalArgumentException
  {
  if ( inputIntervals == null || inputIntervals.size() == 0 )
  {
    throw new IllegalArgumentException( "inputIntervals has 0 elements" );
  }
  for ( Interval inputInterval : inputIntervals )
  {
    if ( inputInterval == null )
    {
    throw new IllegalArgumentException( "inputIntervals has a NULL element" );
    }
  }

  /*New Feature in Java 8, this may not work if older version of java is used,
  sort the list on the price, so that you could identify the period for lowest price*/
  inputIntervals.sort( Comparator.comparing( Interval::getPrice ) );

  Interval root = inputIntervals.get( 0 );
  BinaryTree tree = new BinaryTree( root );
  for ( int i = 1; i < inputIntervals.size(); i++ )
  {
    tree.addNode( inputIntervals.get( i ) );
  }

  return tree.inOrder();
  }

  /**
   * Returns true if the tests pass. Otherwise, false.
   *
   * Additional Test Cases:
   *   Input : ( 1, 20 13 ), ( 7, 10, 8 ), ( 3, 8, 15 ), ( 1, 5, 20 )
   *   Output: ( 1, 7, 13 ), ( 7, 10, 8 ), ( 10, 20, 13 )
   *
   *   Input : ( 7, 10, 8 ), ( 3, 8, 15 ), ( 1, 5, 20 ), ( 1, 20, 4 )
   *   Output: ( 1, 20, 4 )
   *
   *   Input : ( 3, 6, 2 ), ( 1, 9, 3 ), ( 5, 8, 1 )
   *   Output: ( 1, 3, 3 ), ( 3, 5, 2 ), ( 5, 8, 1 ), ( 8, 9, 3 )
   */
  private boolean doTestsPass()
  {
  try
  {
    Interval[] sampleInput = { new Interval( 1, 5, 20 ), new Interval( 3, 8, 15 ), new Interval( 7, 10, 8 ) };
    Interval[] expectedOutput = { new Interval( 1, 3, 20 ), new Interval( 3, 7, 15 ), new Interval( 7, 10, 8 ) };

    List<Interval> inputList = new ArrayList<>( Arrays.asList( sampleInput ) );
    List<Interval> expectedList = new ArrayList<>( Arrays.asList( expectedOutput ) );

    return expectedList.equals( getLowestPrices( inputList ) );
  }
  catch ( IllegalArgumentException e )
  {
    System.out.println( e.getMessage() );
  }

  return false;
  }

  /**
   * Execution entry point.
   */
  public static void main( String[] args )
  {
  Solution solution = new Solution();
  if ( solution.doTestsPass() )
  {
    System.out.println( "All tests passed" );
  }
  else
  {
    System.out.println( "Tests failed" );
  }
  }
}
