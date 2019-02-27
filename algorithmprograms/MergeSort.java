package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration for Merge Sort Algorithm
 * @author Nikhil Jain
 * @version 1.0
 */
public class MergeSort
{	
	/**
	 * @purpose displays sorted elements through Merge Sort
	 */
	public static void displayMergeSort()
	{
		try
		{	
			int length = UtilityMethods.input("enter number of elements: ");
			if(length > 0)
			{
				int[] intArray = new int[length];
				UtilityMethods.readIntArray(intArray, length);									// reads elements of array
				
				mergeSort(intArray);
				
				System.out.println("Elements sorted through Merge Sort Algorithm:");
				for(int i = 0; i < intArray.length; i++)
				{
					System.out.print(intArray[i] + " ");
				}
				System.out.println();	
			}
			else
			{
				System.out.println("number should be greater than zero.. try again");
			}
			
		}
		catch(NumberFormatException e)												// if the input is other than integer
		{
			System.out.println("only numeric input allowed.. try again");
		}
		catch(Exception e)															// handles other exceptions if any
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @purpose dividing array into sub-arrays namely left array and right array through recursion
	 * @param a / array
	 */
	public static void mergeSort(int[] a)
	{
		int n = a.length;
		
		if(n < 2)												// base condition to return from recursion
		{
			return;
		}
		else
		{
			int mid = n / 2;
			int[] leftA = new int[mid];
			int[] rightA = new int[n - mid];
			
			for(int i = 0; i < mid; i++)
			{
				leftA[i] = a[i];
			}
			for(int i = mid; i < n; i++)
			{
				rightA[i-mid] = a[i];
			}
			
			mergeSort(leftA);										// dividing the left sub-array by recursive	call						
			mergeSort(rightA);										//  then dividing the right sub-array by recursive call	
			mergeArray(leftA, rightA, a);							// sorting and merging left and right sub-array
		}
	}
	
	/**
	 * @purpose merging the elements after sorting the elements
	 * @param leftArray
	 * @param rightArray
	 * @param array
	 */
	public static void mergeArray(int[] leftArray, int[] rightArray,int[] array)
	{
		int nLeft = leftArray.length, nRight = rightArray.length;
		int i = 0, j = 0, k = 0;
		
		while(i < nLeft && j < nRight)								// comparing elements of left array and right sub-array
		{															// and inserting those into original array
			if(leftArray[i] < rightArray[j])
			{
				array[k] = leftArray[i];
				i++;
			}
			else
			{
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while(i < nLeft)
		{
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while(j < nRight)
		{
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
}
