import java.io.*;

/* 
   Given that integers are read from a data stream. Find median of elements read so 
   for in an efficient way. For simplicity assume, there are no duplicates. For example, 
   let us consider the stream 5, 15, 1, 3 … 

   After reading 1st element of stream - 5 -> median - 5
   After reading 2nd element of stream - 5, 15 -> median - 10
   After reading 3rd element of stream - 5, 15, 1 -> median - 5
   After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...  
 */

public class Median_In_Stream_Of_Int {
	
	public static void printMedian(int arr[]){
		
		int[] temp = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			
			temp[i] = arr[i];
			//write your code to display median for every time element gets added into temp array
			// try to solve in O(n)
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		printMedian(arr);
	}

}
