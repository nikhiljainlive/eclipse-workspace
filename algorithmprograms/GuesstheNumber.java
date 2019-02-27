package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration for guess the number program
 * @author Nikhil Jain
 * @version 1.0
 */
public class GuesstheNumber
{
	/**
	 * @purpose main method to guessing number 
	 * @param args / command line argument
	 * @return void
	 */
	public static void main(String[] args)
	{
		try 
		{
			int power = Integer.parseInt(args[0]);
			if (args.length == 1)
			{
				if(power > 0)
				{
					int n = (int) Math.pow(2, power);
					
					guessNum(n, power);	
				}
				else
				{
					System.out.println("entered number should be greater than zero");
				}
			}
			else
			{
				System.out.println("only one argument is allowed..");
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("only numbers allowed as input.. try again");
		}
		catch(ArrayIndexOutOfBoundsException e)												// if input is other than integer
		{
			System.out.println("entered arguments should be 1.. try again");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @purpose finds the number by binary search
	 * @param n / number range
	 * @param p / power
	 */
	public static void guessNum(int n, int p)
	{
		int li = 0, hi = n - 1, mid = (li + hi) / 2;
		for(int i = 0; i < p; i++)
		{
			try 
			{
				System.out.println("Is your number less than " + mid + " ?");
				String value = UtilityMethods.stringInput("say 'true' or 'false' : ");
				int isTrue = value.compareTo("true");
				int isFalse = value.compareTo("false");
				if(isTrue == 0 || isFalse == 0)
				{
					if(isTrue == 0)
					{
						hi = mid - 1;
					}
					else if(isFalse == 0)
					{
						li = mid + 1;
					}
					mid = (li + hi) / 2;
					
					if(li > hi)
					{
						System.out.println("Your number is: " + mid);
					}
				}
				else
				{
					System.out.println("only answer with 'true' or 'false'... Try again");
				}
			}
			catch(Exception e)														// handles exceptions
			{
				System.out.println(e.getMessage());
			}
		}
	
	}
	
}
