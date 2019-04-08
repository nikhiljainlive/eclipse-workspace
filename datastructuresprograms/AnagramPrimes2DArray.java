package datastructuresprograms;

import utility.DataStructuresUtility;
import utility.UtilityMethods;

/**
 * @purpose class declaration for displaying Anagram prime numbers from 2D Array
 * @author Nikhil Jain
 * @version 2.0
 */
public class AnagramPrimes2DArray
{
	public static String primes = UtilityMethods.getPrimeNumbers(0, 1000);
	public static String anaPrimes = UtilityMethods.anagramPrimes(primes);
	public static String[] anaPrimesStr = anaPrimes.split(" ");
	public static String[][] str2DArray = new String[10][20];
	
	/**
	 * @purpose main method to display Anagram primes using 2D array
	 * @param args
	 */
	public static void main(String[] args) 
	{
		readAnaPrimes2DArray();
		printAnaPrimes();
	}
	
	/**
	 * @purpose reads anagram primes in 2D Array
	 * @return void
	 */
	public static void readAnaPrimes2DArray()
	{
		int i = 0, k = 0;
		while(i < str2DArray.length)
		{	
			for(int j = 0; j < str2DArray[0].length; j++)
			{
				if(anaPrimesStr[k].hashCode() < Integer.toString(DataStructuresUtility.multiply(i+1, 100)).hashCode() 
						&& k < anaPrimesStr.length-1)
				{
					str2DArray[i][j] = anaPrimesStr[k];
					++k;
				}
				else
				{
					i++;
					break;
				}
			}
		}
		
		// replacing null values with empty string in string array
		for(i = 0; i < str2DArray.length; i++)
		{
			for(int j = 0; j < str2DArray[0].length; j++)
			{
				if(str2DArray[i][j] == null)
				{
					str2DArray[i][j] = " ";
				}
			}
		}
	}
	
	/**
	 * @purpose prints the Anagram Primes from 2D Array
	 * @return void
	 */
	public static void printAnaPrimes()
	{
		System.out.println("Prime Anagrams ranges from 0-1000 are:\n");
		for(int i = 0; i < str2DArray.length; i++)
		{
			System.out.print("Range: " + DataStructuresUtility.multiply(i, 100) + "-" + DataStructuresUtility.multiply(i+1, 100) + " | " );
			for(int j = 0; j < str2DArray[0].length; j++)
			{
				System.out.print(str2DArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
