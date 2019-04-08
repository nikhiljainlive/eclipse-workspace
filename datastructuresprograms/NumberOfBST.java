package datastructuresprograms;

import utility.UtilityMethods;

public class NumberOfBST 
{
	public static void main(String[] args)
	{
		int noOfElements = UtilityMethods.inputInt("enter the number of elements: ");
		System.out.println(numOfBST(noOfElements));
	}
	
	public static long numOfBST(int n)
	{
		long numerator = fact(2 * n);
		long denominator = (fact(n+1) * fact(n));
		long result = numerator / denominator;
		
		return result;
	}
	
	public static long fact(int n)
	{
		long factorial = 1;
		for(long i = 2; i <= n; i++)
		{
			factorial = factorial * i;
		}
		
		return factorial;
	}
}
