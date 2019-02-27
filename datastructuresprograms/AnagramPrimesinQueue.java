package datastructuresprograms;

import datastructures.QueueUsingLinkedList;

public class AnagramPrimesinQueue
{
	public static QueueUsingLinkedList queue = new QueueUsingLinkedList();
	
	public static void main(String[] args)
	{
		String[] strA = AnagramPrimes.anaPrimes.split(" ");
		
		for(int i = 1; i < strA.length; i++)
		{
			queue.enQueue(strA[i]);
		}
		System.out.println("Anagrams displayed through Queue:");
		int length = queue.size();
		
		for(int i = 0; i < length; i++)
		{
			System.out.print(queue.deQueue() + " ");
			
		}
	}
}
