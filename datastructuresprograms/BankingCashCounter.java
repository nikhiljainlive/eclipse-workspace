package datastructuresprograms;

import datastructures.QueueUsingLinkedList;
import utility.DataStructuresUtility;
import utility.UtilityMethods;

public class BankingCashCounter
{
	public static QueueUsingLinkedList queue = new QueueUsingLinkedList();
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
					case 1: DataStructuresUtility.depositMoney();
							break;
							
					case 2: DataStructuresUtility.withdrawMoney();
							break;
							
					case 3:	DataStructuresUtility.processAmount();
							break;
							
					case 4: queue.show();
							break;
							
					case 5: System.out.println("\nPerson at front: " + queue.front());
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
}
