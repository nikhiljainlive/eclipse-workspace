package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration of displaying searching and sorting for integers and strings
 * @author Nikhil Jain
 * @version 1.0
 */
public class DisplaySearching
{
	/**
	 * @purpose main method to display Searching and Sorting methods on Integers and Strings
	 * @param args
	 * @return void
	 */
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Select the operations on");
			System.out.println("1. Searching & Sorting on Integers");
			System.out.println("2. Searching & Sorting on Strings");
			
			int ch = UtilityMethods.input("choose option: ");
			
			switch(ch)
			{
				
				case 1:	IntegerSearchNSort.operateInt();			// searching and sorting for integers
						break;
						
				case 2: StringSearchnSort.operateString();			// searching and sorting for strings
						break;
						
				default: System.out.println("invalid selection.. try again");
			
			}	
		}
		catch(NumberFormatException e)								//	if user input is other than integer
		{
			System.out.println("invalid input.. try again");
		}
		catch(Exception e)											// handles other exceptions
		{
			System.out.println(e.getMessage());
		}
	}
	 
	/**
	 * @purpose calculates elapsed time in nanoseconds
	 * @param startTime
	 * @return elapsedTime
	 */
	public static int elapsedTime(int startTime)
	{
		int stopTime = (int) System.nanoTime();
		int elapsedTime = (stopTime - startTime);
		
		return elapsedTime;
	}
	
	/**
	 * @purpose separate class declaration for Integer Sorting and searching operations
	 */
	public static class IntegerSearchNSort
	{	
		// size of array
		public static int length = UtilityMethods.input("enter number of elements: ");
		// creating integer array
		public static int[] intArray = new int[length];
		
		// displaying elements of integer array
		public static void displayArray()
		{
			System.out.println("The entered array is : ");
			for(int i = 0; i < intArray.length; i++)
			{
				System.out.print(intArray[i] + " ");
			}
			System.out.println();
		}
		
		/**
		 * @purpose displays bubble sort, insertion sort and binary search operations
		 * @param void
		 * @return void
		 */
		public static void operateInt()
		{
			try 
			{
				UtilityMethods.readIntArray(intArray, length);								// reads integer array
				int temp[] = intArray;
				displayArray();
				
				int startTime1 = (int) System.nanoTime();
				UtilityMethods.insertionSortInt(intArray);
				int timeInsertion = elapsedTime(startTime1);
				System.out.println("Elapsed Time: " + timeInsertion + " ns");		// showing elapsed time for insertion sort
				
				int startTime2 = (int) System.nanoTime();
				UtilityMethods.bubbleSortInt(temp);
				int timeBubble = elapsedTime(startTime2);
				System.out.println("Elapsed Time: " + timeBubble + " ns");			// showing elapsed time for bubble sort
				
				if(timeInsertion > timeBubble)
				{
					System.out.println("Insertion Sort > Bubble Sort");				// comparing elapsed time of both sorting algorithms
				}
				else
				{
					System.out.println("Bubble Sort > Insertion Sort");
				}
				
				int key = UtilityMethods.input("enter element to find: ");
				UtilityMethods.binarySearchInt(intArray, key);	
			}
			catch(NumberFormatException e)
			{
				System.out.println("only number input is allowed.. try again");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * @purpose separate class declaration for searching and sorting operations on strings
	 */
	public static class StringSearchnSort
	{
		// size of string array
		public static int length = UtilityMethods.input("enter number of elements: ");
		//creating string array
		public static String[] strArray = new String[length];
		
		/**
		 * @purpose displays searching and sorting opereations on strings
		 * @param void
		 * @return void
		 */
		public static void operateString()
		{
			try 
			{
				UtilityMethods.readStringArray(strArray, length);							// reads array of strings
				
				String temp[] = strArray;
				displayArray();
				
				int startTime1 = (int) System.nanoTime();							
				UtilityMethods.insertionSortString(strArray);
				int timeInsertion = elapsedTime(startTime1);
				System.out.println("Elapsed Time: " + timeInsertion + " ns");		// showing elapsed time for insertion sort
				
				int startTime2 = (int) System.nanoTime();
				UtilityMethods.bubbleSortString(temp);
				int timeBubble = elapsedTime(startTime2);
				System.out.println("Elapsed Time: " + timeBubble + " ns");			// showing elapsed time for bubble sort
				
				if(timeInsertion > timeBubble)										// comparing elapsed time of both sorting algorithms
				{
					System.out.println("Insertion Sort > Bubble Sort");
				}
				else
				{
					System.out.println("Bubble Sort > Insertion Sort");
				}
				
				String key = UtilityMethods.stringInput("enter string to find: ");
				UtilityMethods.binarySearchString(strArray, key);	
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		/**
		 * @purpose displays the elements of string array
		 * @param void 
		 * @return void
		 */
		public static void displayArray()
		{
			System.out.println("The entered array is : ");
			for(int i = 0; i < strArray.length; i++)
			{
				System.out.print(strArray[i] + " ");
			}
			System.out.println();
		}
	}
}	

