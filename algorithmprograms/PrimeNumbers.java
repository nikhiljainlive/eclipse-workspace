package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose Class Declaration of PrimeNumbers Program
 * @author Nikhil Jain
 * @version 1.0
 */
public class PrimeNumbers
{
	/**
	 * @purpose prints the prime numbers by calling Utility Class method
	 * @param void
	 * @return void
	 */
	public static void printPrimeNum()
	{	
		try
		{
			int r1 = UtilityMethods.input("Enter initial range: ");
			if(r1 >= 0 && r1 <= 1000)
			{
				int r2 = UtilityMethods.input("Enter final range: ");
				if(r2 <= 1000 && r2 > r1)
				{
					System.out.println("Prime numbers within the given range are :");
					System.out.println(UtilityMethods.getPrimeNumbers(r1, r2));						// calling method of utility class
				}
				else
				{
					System.out.println("final range cannot be greater than 1000\nor less than initial range\n");
				}//end of inner if-else block
			}
			else
			{
				System.out.println("initial range cannot be less than 0 or greater than 1000");
			}//end of outer if-else block
		}
		catch(NumberFormatException e)											// if input is other than integer
		{
			System.out.println("invalid input.. try again");
		}
		catch(Exception e)														// handles exceptions
		{
			System.out.println(e.getMessage());
			printPrimeNum();
		}
   }

}

