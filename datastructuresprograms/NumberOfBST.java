package datastructuresprograms;

import utility.UtilityMethods;

public class NumberOfBST 
{
	public static void main(String[] args)
	{
		int noOfElements = UtilityMethods.input("enter the number of elements: ");
		System.out.println(numOfBST(noOfElements));
	}
	
	public static int numOfBST(int n)
	{
		int numerator = fact(2 * n);
		int denominator = (fact(n+1) * fact(n));
		int result = numerator / denominator;
		
		return result;
	}
	
	public static int fact(int n)
	{
		int factorial = 1;
		for(int i = 2; i <= n; i++)
		{
			factorial = factorial * i;
		}
		
		return factorial;
	}
}
