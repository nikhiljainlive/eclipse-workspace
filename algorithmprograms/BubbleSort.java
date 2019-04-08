package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose Class Declaration for Bubble Sort
 * @author Nikhil Jain
 * @version 1.0
 */
public class BubbleSort
{
	/**
	 * @purpose displays sorted array
	 */
	public static void sortNumbers()
	{
		try 
		{
			int arrLength = UtilityMethods.inputInt("enter no. of elements: ");
			if( arrLength > 0)
			{
				int[] a = new int[arrLength];
			
				UtilityMethods.readIntArray(a, arrLength);								// reads array elements
				UtilityMethods.bubbleSortInt(a);										// sorts array elements
			}
			else
			{
				System.out.println("size of array should be greater than 0");
			}
		}
		catch(NumberFormatException e)											// if user inputs other than integer
		{
			System.out.println("numeric input expected.. try again");
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input.. Try again!");					// handles exceptions
			sortNumbers();
		}
	}
}
