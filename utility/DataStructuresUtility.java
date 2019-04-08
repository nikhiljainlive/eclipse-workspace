package utility;

import datastructures.QueueUsingLinkedList;
import datastructuresprograms.BankingCashCounter;

public class DataStructuresUtility
{
	public static String[][] primeNum = new String[10][30];
	
	public static String[][] primeNum()
	{
		for(int i = 0; i < 10; i++)
		{
			String s = UtilityMethods.getPrimeNumbers(multiply(i, 100), multiply(i+1, 100));
			String[] strA = s.split(" ");
			for(int j = 0; j < strA.length; j++)
			{
				primeNum[i][j] = strA[j];
			}																				
		}
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 30; j++)
			{
				if(primeNum[i][j] == null)
				{
					primeNum[i][j] = " ";
				}
			}
		}
		
		return primeNum;
	}
	
	public static int multiply(int num1, int num2)
	{
		return num1*num2;
	}
	
	public static void sortString(String[] sArray)
	{
		String temp;
		for(int i =0; i < sArray.length - 1; i++)
		{	
			for(int j = 0; j < sArray.length - 1; j++)
			{
				if (sArray[j].hashCode() > sArray[j + 1].hashCode())
				{
					temp = sArray[j];
					sArray[j] = sArray[j + 1];
					sArray[j + 1] = temp;
				}
			}
		}
	}
	
	public static void depositMoney()
	{
		String person = UtilityMethods.stringInput("enter person to queue: ");
		int amount = UtilityMethods.inputInt("enter amount: ");
		QueueUsingLinkedList.enQueue(person, amount);
		System.out.println("\n'" + person + "' added to queue");
	}
	
	public static void withdrawMoney()
	{
		String person = UtilityMethods.stringInput("enter person to queue: ");
		int amount = UtilityMethods.inputInt("enter amount: ");
		QueueUsingLinkedList.enQueue(person, -(amount));
		System.out.println("\n'" + person + "' added to queue");
	}
	
	public static void processAmount()
	{
		if(QueueUsingLinkedList.isEmpty())
		{
			System.out.println("\nqueue is empty\nenter a person to deposit or withdraw cash!");
		}
		else
		{
			BankingCashCounter.bankCash = BankingCashCounter.bankCash + QueueUsingLinkedList.front.getAmount();
			System.out.println("\nUpdated Banking Counter Cash: " + BankingCashCounter.bankCash);
			System.out.println("Person dequeued: " + QueueUsingLinkedList.deQueue());
			System.out.println("People in Queue: " + QueueUsingLinkedList.size());
		}
	}
	
	// returns the days in a specified month
	public static int getDays(int month, int year)
	{
		int days = 31;
		if(month == 2 && UtilityMethods.isLeapYear(year))
		{
			days = 29;
		}
		else if(month == 2)
		{
			days = 28;
		}
		
		if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			days = 30;
		}
		
		return days;
	}
}
