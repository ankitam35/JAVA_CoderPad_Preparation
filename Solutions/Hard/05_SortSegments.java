/**
 **  Instructions to candidate.
 **  Implement sortSegments() correctly.
 **
 */
import static org.junit.Assert.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import org.apache.commons.lang3.tuple.*;

import org.junit.*;
import org.junit.runner.*;

public class Solution {

  /**
   * Given a jumbled collection of segments, each of which is represented as
   * a Pair(startPoint, endPoint), this function sorts the segments to
   * make a continuous path.
   *
   * A few assumptions you can make:
   * 1. Each particular segment goes in one direction only, i.e.: if you
   * see (1, 2), you will not see (2, 1).
   * 2. Each starting point only have one way to the end point, i.e.: if
   * you see (6, 5), you will not see (6, 10), (6, 3), etc.
   *
   * For example, if you're passed a list containing the following int arrays:
   *      [(4, 5), (9, 4), (5, 1), (11, 9)]
   * Then your implementation should sort it such:
   *      [(11, 9), (9, 4), (4, 5), (5, 1)]
   *
   * @param segments collection of segments, each represented by a Pair(startPoint, endPoint).
   * @return The sorted segments such that they form a continuous path.
   * @throws Exception if there is no way to create one continuous path from
   *          all the segments passed into this function. Feel free to change the
   *          Exception type as you think appropriate.
   */
  public static List<Pair<Integer, Integer>> sortSegments(final List<Pair<Integer, Integer>> segments)
      throws Exception {
    // Naive solution, starts breaking in CoderPad around 120_000 segments
    /*
    if(segments == null || segments.isEmpty()) {
      return Collections.emptyList();
    }

    // make defensive copy
    List<Pair<Integer, Integer>> copiedSegments = new ArrayList<>(segments);

    Deque<Pair<Integer, Integer>> sortedSegments = new ArrayDeque<>();
    sortedSegments.addLast(copiedSegments.remove(0));

    int segSize = 0;
    while((segSize = copiedSegments.size()) > 0) {
      Iterator<Pair<Integer, Integer>> iter = copiedSegments.iterator();
      while(iter.hasNext()) {
        Pair<Integer, Integer> startPoint = sortedSegments.peekFirst();
        Pair<Integer, Integer> endPoint = sortedSegments.peekLast();
        Pair<Integer, Integer> segment = iter.next();
        if(startPoint.getLeft() == segment.getRight()) {
          sortedSegments.offerFirst(segment);
          iter.remove();
        } else if(endPoint.getRight() == segment.getLeft()) {
          sortedSegments.offerLast(segment);
          iter.remove();
        }
      }
      if(segSize == copiedSegments.size()) {
        throw new Exception("Could not use all segments to form a continuous path");
      }
    }
    */

    // much faster solution - scales up to millions of segments and only capped
    // by CoderPad limitation.
    if(segments == null || segments.isEmpty()) {
      return Collections.emptyList();
    }

    Map<Integer, Pair<Integer, Integer>> startMap = segments.stream()
        .collect(Collectors.toMap(pair -> pair.getLeft(), Function.identity()));
    Map<Integer, Pair<Integer, Integer>> endMap = segments.stream()
        .collect(Collectors.toMap(pair -> pair.getRight(), Function.identity()));

    Deque<Pair<Integer, Integer>> sortedSegments = new ArrayDeque<>();

    Pair<Integer, Integer> segment = segments.get(0);
    sortedSegments.addLast(segment);
    Integer startPoint = segment.getLeft();
    Integer endPoint = segment.getRight();

    Pair<Integer, Integer> nextSegment = null;
    Pair<Integer, Integer> prevSegment = null;
    while(true) {
      nextSegment = startMap.get(endPoint);
      if(nextSegment != null) {
        sortedSegments.addLast(nextSegment);
      }

      prevSegment = endMap.get(startPoint);
      if(prevSegment != null) {
        sortedSegments.addFirst(prevSegment);
      }

      if(nextSegment == null && prevSegment == null) {
        break;
      }

      startPoint = sortedSegments.getFirst().getLeft();
      endPoint = sortedSegments.getLast().getRight();
    };

    if(segments.size() != sortedSegments.size()) {
      throw new Exception("Could not use all segments to form a continuous path");
    }

    return new ArrayList<Pair<Integer, Integer>>(sortedSegments);
  }

  private static List<Pair<Integer, Integer>> generateContinuousSegments(int n) {
    List<Integer> points = IntStream.rangeClosed(0, n).boxed().collect(Collectors.toList());
    Collections.shuffle(points);
    List<Pair<Integer, Integer>> continuousSegments = new ArrayList<>();
    for(int i = 0; i < points.size() - 1; i++) {
      continuousSegments.add(new ImmutablePair<Integer, Integer>(points.get(i), points.get(i + 1)));
    }
    return continuousSegments;
  }

  @Test
  public void testBasicSort() throws Exception {
    List<Pair<Integer, Integer>> jumbledSegments = new ArrayList<>();
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(4, 5));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(9, 4));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(5, 1));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(11, 9));

    List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(jumbledSegments);

    List<Pair<Integer, Integer>> expectedContinuousPath = new ArrayList<>();
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(11, 9));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(9, 4));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(4, 5));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(5, 1));

    assertEquals(expectedContinuousPath, actualContinuousPath);
  }

  @Test
  public void testSortComplexity() throws Exception {
    // this test won't run to completion in CoderPad for the naive solution
    List<Pair<Integer, Integer>> continuousSegments = generateContinuousSegments(1_000_000);
    List<Pair<Integer, Integer>> randomSegments = new ArrayList<>(continuousSegments);
    Collections.shuffle(randomSegments);
    List<Pair<Integer, Integer>> sortedSegments = sortSegments(randomSegments);

    assertEquals(continuousSegments, sortedSegments);
  }

  @Test
  public void testEmpty() throws Exception {
    List<Pair<Integer, Integer>> result = sortSegments(null);
    assertEquals(Collections.emptyList(), result);
    result = sortSegments(Collections.emptyList());
    assertEquals(Collections.emptyList(), result);
  }

  @Test(expected=Exception.class)
  public void testMissingSegment() throws Exception {
    List<Pair<Integer, Integer>> pathWithMissingSegments = new ArrayList<>();
    pathWithMissingSegments.add(new ImmutablePair<Integer, Integer>(11, 9));
    pathWithMissingSegments.add(new ImmutablePair<Integer, Integer>(5, 1));
    sortSegments(pathWithMissingSegments);
  }

  @Test(expected=Exception.class)
  public void testDuplicate() throws Exception {
    List<Pair<Integer, Integer>> duplicateSegments = new ArrayList<>();
    duplicateSegments.add(new ImmutablePair<Integer, Integer>(11, 9));
    duplicateSegments.add(new ImmutablePair<Integer, Integer>(9, 4));
    duplicateSegments.add(new ImmutablePair<Integer, Integer>(9, 4));
    duplicateSegments.add(new ImmutablePair<Integer, Integer>(4, 5));
    duplicateSegments.add(new ImmutablePair<Integer, Integer>(5, 1));
    sortSegments(duplicateSegments);
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
