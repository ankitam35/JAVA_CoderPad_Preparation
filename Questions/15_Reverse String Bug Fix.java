import java.io.*;
import java.util.*;

public class Solution{
  /**
   * public static String reverseStr( String str )
   * Example: reverseStr(str) where str is "abcd" returns "dcba".
   */
  public static String reverseStr( String str ){
    //your code goes here
	//ther will be some soultion with defect that would need to be identified
    return "Hello World";
  };

  
  public static void main(String[] args){
  
  String testString;
    String solution;
    boolean result = true;

    result = result && reverseStr("abcd").equals("dcba");
  
  if(result){
    System.out.println("All tests pass");
  }
  else{
    System.out.println("There are test failures");
  }

   }
}