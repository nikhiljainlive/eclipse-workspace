package datastructuresprograms;

import datastructures.QueueUsingLinkedList;
import utility.UtilityMethods;

public class BankingCashCounter
{
	public static int bankCash = UtilityMethods.input("enter banking counter cash : ");
	
	public static void main(String[] args) 
	{
		try
		{
			while(bankCash != 0) 
			{
				System.out.println("\n********Banking Cash Counter Welcomes You!*******\n");
				System.out.println("choose the options:\n");
				System.out.println("1. Deposit Cash");
				System.out.println("2. Withdraw Cash");
				System.out.println("3. Process Transaction");
				System.out.println("4. See the queue!");
				System.out.println("5. See the person at front!");
				System.out.println("\n*************************************************");
				switch(UtilityMethods.input("\nenter choice: "))
				{
					case 1: depositMoney();
							break;
							
					case 2: withdrawMoney();
							break;
							
					case 3:	processAmount();
							break;
							
					case 4: QueueUsingLinkedList.show();
							break;
							
					case 5: System.out.println("\nPerson at front: " + QueueUsingLinkedList.front());
							break;
							
					default: System.out.println("\ninvalid option.. try again");
				}	
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void depositMoney()
	{
		String person = UtilityMethods.stringInput("enter person to queue: ");
		int amount = UtilityMethods.input("enter amount: ");
		QueueUsingLinkedList.enQueue(person, amount);
		System.out.println("\n'" + person + "' added to queue");
	}
	
	public static void withdrawMoney()
	{
		String person = UtilityMethods.stringInput("enter person to queue: ");
		int amount = UtilityMethods.input("enter amount: ");
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
}
