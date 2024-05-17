/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/

import java.util.*;
 
class Dictionary {
  private String[] entries;
 
  public Dictionary(String[] entries) {
    this.entries = entries;
  }
 
  public boolean contains(String word) {
    return Arrays.asList(entries).contains(word);
  }
}
 
public class Solution {
  public static Set<String> longestWord(String letters, Dictionary dict) {
    Set<String> result = new HashSet<String>();
    int longest = 0;
    char[] arr = letters.toCharArray();
    
    //Permute and combination
    Set<String> words = new HashSet<String>();
    permute(arr, 0, dict, words);
    
    for(String word: words) {
      //System.out.println(word);
      if(word.length() > longest) {
        result.clear();
        result.add(word);
        longest = word.length();
      } else if (word.length() == longest) {
        result.add(word);
      }
    }
    
    System.out.println(result);
    return result;
  }
  
  private static void permute(char[] arr, int index, Dictionary dict, Set<String> words) {
    
    if(arr.length == index) {
      combinations(arr, dict, words);
      //System.out.println(String.valueOf(arr));
    } else {
      for(int i = index; i < arr.length; i++) {
        arr = swap(arr,i, index);
        permute(arr, index + 1, dict, words);
        arr = swap(arr,i, index);
      }
      
    }
  }
  
  private static void combinations(char[] arr, Dictionary dict, Set<String> words) {
    StringBuffer buff = new StringBuffer();
    for(int i = 0; i < arr.length; i++) {
      buff.append(arr[i]);
      
      if(dict.contains(buff.toString())) {
        //System.out.println("--" + buff.toString());
        words.add(buff.toString());
      }
    }
  }
  
  private static char[] swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    
    return arr;
  }
 
 
  public static boolean doTestsPass() {
    Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
    
    boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
    result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));
 
    return result;
  }
 
  /**
   * Execution entry point.
   */
  public static void main(String[] args) {
    if(doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.err.println("There are test failures");
    }
  }
}
