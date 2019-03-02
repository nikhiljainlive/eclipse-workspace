package datastructuresprograms;

import datastructures.QueueUsingLinkedList;

/**
 * @purpose class declaration of printing Anagram primes from queue
 * @author Nikhil Jain
 * @version 1.0
 */
public class AnagramPrimesinQueue
{	
	/**
	 * @purpose prints the anagram prime numbers from queue
	 * @param args
	 */
	public static void main(String[] args)
	{
		String[] strA = AnagramPrimes2DArray.anaPrimes.split(" ");
		
		for(int i = 1; i < strA.length; i++)
		{
			QueueUsingLinkedList.enQueue(strA[i]);						// enqueueing elements in queue
		}
		System.out.println("Anagram Primes displayed through Queue:");
		int length = QueueUsingLinkedList.size();
		
		for(int i = 0; i < length; i++)									// showing anagram prime numbers 
		{																// by dequeueing elements from queue
			System.out.print(QueueUsingLinkedList.deQueue() + " ");
			
		}
	}
}
