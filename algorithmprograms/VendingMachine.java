package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration for change returned by Vending Machine program
 * @author Nikhil Jain
 * @version 1.0
 */
public class VendingMachine 
{
	/**
	 * @purpose displays the fewest notes returned
	 */
	public static void fewNotes()
	{
		try
		{
			int change = UtilityMethods.inputInt("enter amount to change: ");
			if(change > 0)
			{
				int[] notes = new int[] {1, 2, 5, 10, 50, 100, 500, 1000, 2000};
				
				calculateChange(change, notes);		
			}
			else
			{
				System.out.println("amount should be greater than zero.. try again");
			}
		}
		catch(NumberFormatException e)											// if the user input is other than integer
		{
			System.out.println("invalid input.. only numbers are allowed");
		}
		catch(Exception e)														// handles all other exceptions 
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @purpose calculates the fewest notes
	 * @param change
	 * @param notes
	 */
	public static void calculateChange(int change, int[] notes)
	{
		int i = notes.length-1;
		int count = 0;
		while(change != 0 && i >= 0)
		{
			if(change >= notes[i])
			{	++count;
				change = change - notes[i];
			}
			else
			{	
				System.out.println("change: " + notes[i] + " (" + count + ")");
				count = 0;
				i--;
				
			}
		}
		System.out.println("change: " + notes[i] + " (" + count + ")");
	}
}
