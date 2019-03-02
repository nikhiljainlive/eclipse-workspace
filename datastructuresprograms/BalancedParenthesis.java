package datastructuresprograms;

import datastructures.StackUsingArray;
import utility.UtilityMethods;

/**
 * @purpose class declaration of Balanced Parenthesis Program
 * @author Nikhil Jain
 * @version 1.0
 */
public class BalancedParenthesis
{
	public static StackUsingArray stack = new StackUsingArray();
	public static int count = 0;
	
	/**
	 * @purpose shows if parenthesis are balnced or not
	 * @param args
	 */
	public static void main(String[] args)
	{
		String exp = UtilityMethods.stringInput("enter the expression: ");
		char[] chArray = exp.toCharArray();
		for(int i = 0; i < chArray.length; i++)
		{
			char peek = stack.peek();
			if(chArray[i] == '[' || chArray[i] == '{' || chArray[i] == '(')
			{
				stack.push(chArray[i]);
				count++;
				
			}
			if(chArray[i] == ']' && isMatched(peek, chArray[i]))
			{
				stack.pop();
			}
			if(chArray[i] == '}' && isMatched(peek, chArray[i]))
			{
				stack.pop();
			}
			if(chArray[i] == ')' && isMatched(peek, chArray[i]))
			{
				stack.pop();
			}
			if(chArray[i] == ']' || chArray[i] == '}' || chArray[i] == ')')
			{
				count--;
			}
		}
		
		System.out.println(areParenthesesBalanced());
	}
	
	/**
	 * @purpose returns true if the pairs are matched else returns false
	 * @param a
	 * @param b
	 * @return boolean
	 */
	public static boolean isMatched(char a, char b)
	{
		if(a == '[' && b == ']')
		{
			return true;
		}
		if(a == '{' && b == '}')
		{
			return true;
		}
		if(a == '(' && b == ')')
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * @purpose returns true if parenthesis are balanced else returns false
	 * @return boolean
	 */
	public static boolean areParenthesesBalanced()
	{
		if(stack.isEmpty() && count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
