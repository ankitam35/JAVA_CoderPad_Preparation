/**
 * Instructions to candidate.
 *  Implement MyHashMap correctly.
 */

import java.util.*;

public class Solution
{
  /**
   * class MyHashMap
   *
   * Associates a key-value pair in memory such that lookups
   * and inserts can be performed in O(1) time for a reasonably
   * small set of data, and scales linearly (at worst) for larger
   * sets of key-value pairs.
   *
   * Each unique key is associated with one single value.
   */
  private static class MyHashMap<K,V>
  {
  private static class Entry<K, V>
  {
    private final K key;
    private V value;

    Entry(K key, V value)
    {
      this.key = key;
      this.value = value;
    }
  }

  ArrayList<List<Entry<K,V>>> entries;

  MyHashMap()
  {
    this.entries = new ArrayList<>();
    // start with 10
    for (int i = 0; i < 10; ++i) {
    // pre-populate the list
    this.entries.add(new ArrayList<>());
    }
  }

  void put(K key, V value)
  {
    if (key == null || value == null)
    {
    return;
    }
    int idx = key.hashCode() % entries.size();

    List<Entry<K,V>> list = this.entries.get(idx);

    for (Entry<K,V> i : list) {
    if (key.equals(i.key)) {
      i.value = value;
      return;
    }
    }

    list.add(new Entry<>(key, value));
  }

  V get(K key)
  {
    if (key == null) {
    return null;
    }
    int idx = key.hashCode() % entries.size();
    List<Entry<K,V>> list = this.entries.get(idx);

    for (Entry<K,V> i : list) {
    if (key.equals(i.key)) {
      return i.value;
    }
    }

    return null;
  }
  }

  /**
   * bool doTestsPass()
   * Runs various tests.
   */
  public void doTestsPass()
  {
  // todo: implement more tests, please
  // feel free to make testing more elegant
  int[][] testCases = {{1, 2}, {3, 4}, {5, 6}, {1, 7}, {1, 8}};
  boolean passed = true;

  MyHashMap<Integer, Integer> map = new MyHashMap<>();

  for(int[] test : testCases)
  {
    Integer key = test[0];
    Integer value = test[1];
    map.put(key, value);

    if(!value.equals(map.get(key)))
    {
    System.out.println("Test failed [" + key + "," + value + "]");
    passed = false;
    }
  }

  MyHashMap<String, String> strMap = new MyHashMap<>();
  String strTestCases[][] = {{"one", "two"}, {"three", "four"}, {"one", "five"}};

  for (String[] test : strTestCases)
  {
    String key = test[0];
    String value = test[1];
    strMap.put(key, value);
    if (!value.equals(strMap.get(key)))
    {
    System.out.println("Test failed [" + key + "," + value + "]");
    passed = false;
    }
  }

  if (passed)
  {
    System.out.println("All tested passed");
  }

  };


  /**
   * Execution entry point.
   */
  public static void main(String args[])
  {
  new Solution().doTestsPass();
  }
}