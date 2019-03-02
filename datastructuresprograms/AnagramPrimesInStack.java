package datastructuresprograms;

import datastructures.StackUsingLinkedList;

/**
 * @purpose class declaration of printing anagram prime numbers from stack
 * @author Nikhil Jain
 * @version 1.0
 */
public class AnagramPrimesInStack 
{
	/*
	 * declaring stack as static to use it in the whole class
	 */
	public static StackUsingLinkedList stack = new StackUsingLinkedList();
	
	/**
	 * @purpose prints the anagram prime numbers from stack
	 * @param args
	 */
	public static void main(String[] args)
	{
		String[] anagramPrimes = AnagramPrimes2DArray.anaPrimes.split(" ");
		
		for(int i = 1; i < anagramPrimes.length; i++)
		{
			stack.push(anagramPrimes[i]);
		}
		
		int stackLength = stack.size();
		System.out.println("Prime Anagrams printed from stack:");
		for(int i = 0; i < stackLength; i++)
		{															// printing elements by popping elements 
			System.out.print(stack.pop() + " ");					// from stack
		}
	}
}
