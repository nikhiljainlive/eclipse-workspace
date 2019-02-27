package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration of finding day of week
 * @author Nikhil Jain
 * @version 1.0
 */
public class DayFinder 
{
	/**
	 * @purpose main method to display result
	 * @param month, date, year / 3 command line arguments 
	 */
	public static void main(String[] args)
	{
		try
		{
			int month = Integer.parseInt(args[0]);
			int date = Integer.parseInt(args[1]);
			int year = Integer.parseInt(args[2]);
			
			if(args.length == 3)
			{
				if(month > 0 && month <= 12 && date > 0 && date <=31 && UtilityMethods.digitsCount(year) == 4)
				{
					System.out.println(UtilityMethods.dayOfWeek(month, date, year));	
				}
				else
				{
					System.out.println("incorrect input.. try again");
				}
			}
			else
			{
				System.out.println("expected arguments are 3.. try again");
			}
		}
		catch (NumberFormatException e)													// if input is other than integer
		{
			System.out.println("only numeric input is allowed.. try again");
		}
		catch(ArrayIndexOutOfBoundsException e)											// if arguments entered are out of argument array index									
		{
			System.out.println("expected arguments are 3.. try again");
		}
		catch (Exception e)																// handles other exceptions
		{
			System.out.println(e.getMessage());
		}
		
	}
	
}
