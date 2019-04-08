package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration to print numbers which are palindromes and anagrams
 * @author Nikhil Jain
 * @version 1.0
 */
public class PAPrimeNumbers
{
	/**
	 * @purpose displays palindromic prime numbers and prime numbers which are anagrams
	 * @param void
	 * @return void
	 */
	public static void PalinAnagramPrimes()
	{
		try
		{
			int r1 = UtilityMethods.inputInt("Enter initial range: ");
			int r2 = UtilityMethods.inputInt("Enter final range: ");
			String primeStr = UtilityMethods.getPrimeNumbers(r1, r2);				// returns prime numbers
			
			System.out.println("The Palindromic Primes are:");
			UtilityMethods.palindromicPrime(primeStr);								// prints palindromic prime numbers through method of utility class
			System.out.println("The prime numbers which are Anagrams with given range:");
			System.out.print(UtilityMethods.anagramPrimes(primeStr) + "\n");								// prints prime numbers which are anagrams
		}
		catch(NumberFormatException e)
		{
			System.out.println("numbers are not allowed.. try again");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}
}
