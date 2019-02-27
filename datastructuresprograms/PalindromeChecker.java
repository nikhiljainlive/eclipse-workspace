package datastructuresprograms;

import datastructures.Deque;
import utility.UtilityMethods;

public class PalindromeChecker 
{
	public static Deque deQue = new Deque();
	
	public static void main(String[] args) 
	{
		String input = UtilityMethods.stringInput("enter the word to check for palindrome: ");
		char[] charA = input.toCharArray();
		
		for(int i = 0; i < charA.length; i++)
		{
			deQue.addRear(Character.toString(charA[i]));
		}
		String reverse = "";
		
		int length = deQue.size();
		for(int i = 0; i < length; i++)
		{
			reverse = reverse + deQue.removeRear();
		}

		if(input.compareTo(reverse) == 0)
		{
			System.out.println("True! entered word is a palindrome");
		}
		else
		{
			System.out.println("False! entered word is not a palindrome");
		}
	}
}
