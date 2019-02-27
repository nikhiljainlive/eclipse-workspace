package datastructuresprograms;

import utility.DataStructuresUtility;
import utility.UtilityMethods;

public class AnagramPrimes
{
	public static String primes = UtilityMethods.getPrimeNumbers(0, 1000);
	public static String anaPrimes = UtilityMethods.anagramPrimes(primes);
	public static void main(String[] args) 
	{
		String[] anaPrimesStr = anaPrimes.split(" ");
		String[][] str2DArray = new String[10][20];
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
		
		// prints the 2D array
		System.out.println("Prime Anagrams ranges from 0-1000 are:\n");
		for(i = 0; i < str2DArray.length; i++)
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
