package datastructuresprograms;

import datastructures.StackUsingLinkedList;

public class AnagramPrimesInStack 
{
	public static StackUsingLinkedList stack = new StackUsingLinkedList();
	
	public static void main(String[] args)
	{
		String[] anagramPrimes = AnagramPrimes.anaPrimes.split(" ");
		
		for(int i = 1; i < anagramPrimes.length; i++)
		{
			stack.push(anagramPrimes[i]);
		}
		
		int stackLength = stack.size();
		System.out.println("Prime Anagrams printed from stack:");
		for(int i = 0; i < stackLength; i++)
		{
			System.out.print(stack.pop() + " ");
		}
	}
}
