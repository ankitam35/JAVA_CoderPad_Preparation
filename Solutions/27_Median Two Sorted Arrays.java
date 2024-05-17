/*
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES, PREFERABLY USE YOUR OWN SOLUTION
*
*/

public class Solution
{

	public static double findMedianSortedArrays(int[] A, int[] B) {
		int[] newSortedArray = new int [A.length+B.length];
		mergeArrays(A, B, A.length, B.length,newSortedArray);
		return findMedian(newSortedArray);
	}

	public static void  mergeArrays(int[] arr1, int[] arr2, int n1,
			int n2, int[] arr3)
	{
		int i = 0, j = 0, k = 0;
		while (i<n1 && j <n2)
		{
			if (arr1[i] < arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}
		while (i < n1)
			arr3[k++] = arr1[i++];
		while (j < n2)
			arr3[k++] = arr2[j++];

	}

	public static double  findMedian(int[] newSortedArray)
	{
		double median ;
		if (newSortedArray.length % 2 == 0)
		    median = ((double)newSortedArray[newSortedArray.length/2] + (double)newSortedArray[newSortedArray.length/2 - 1])/2;
		else
		    median = (double) newSortedArray[newSortedArray.length/2];

		return median;
	}

	/**
	 * boolean doTestsPass()
	 * Returns true if all tests pass. Otherwise returns false.
	 */
	public static boolean doTestsPass()
	{
		// todo: implement more tests, please
		// feel free to make testing more elegant
		boolean result = true;
		result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
		result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
		return result;
	};


	/**
	 * Execution entry point.
	 */
	public static void main(String[] args)
	{
		if(doTestsPass())
		{
			System.out.println("All tests pass");
		}
		else
		{
			System.out.println("There are test failures");
		}
	}
}