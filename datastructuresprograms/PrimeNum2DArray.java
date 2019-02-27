package datastructuresprograms;

import utility.DataStructuresUtility;

public class PrimeNum2DArray 
{
	public static void main(String[] args)
	{
		String[][] primeNums = DataStructuresUtility.primeNum();
		System.out.println("Prime Numbers ranges from 0-1000 are:\n");
		for(int i = 0; i < primeNums.length; i++)
		{
			System.out.print("Range: " + DataStructuresUtility.multiply(i, 100) + "-" + DataStructuresUtility.multiply(i+1, 100) + " | " );
			for(int j = 0; j < 21; j++)
			{
				System.out.print(primeNums[i][j] + " ");
			}
			System.out.println();
		}
	}	
}
