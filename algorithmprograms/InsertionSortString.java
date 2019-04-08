package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration of insertion sort of strings
 * @author Nikhil Jain
 * @version 1.0
 */
public class InsertionSortString 
{
	/**
	 * @purpose displays sorted string by insertion sort algorithm
	 */
	public static void sortedString()
	{
		try 
		{
			int length = UtilityMethods.inputInt("number of elements you want to enter: ");
			if(length > 0)
			{
				String[] strArray = new String[length];
				UtilityMethods.readStringArray(strArray, length);						// reads array of strings
				UtilityMethods.insertionSortString(strArray);							// insertion sort method of utility class	
			}
			else
			{
				System.out.println("number of elements cannot be zero or less than zero..");
			}
		}
		catch(NumberFormatException e)											// if the user input is other than integer
		{
			System.out.println("only number input is allowed.. try again");
		}
		catch(Exception e)														// handles other exceptions
		{
			System.out.println(e.getMessage());
		}
	}
}
