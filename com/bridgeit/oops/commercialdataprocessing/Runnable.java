package com.bridgeit.oops.commercialdataprocessing;

import utility.UtilityMethods;

public class Runnable 
{
	public static void main(String[] args) 
	{
		boolean value = true;
		while(value)
		{
			StockAccount stockA = new StockAccount();
			System.out.println("\n============================================");
			System.out.println("---------Commercial Data Processing---------");
			System.out.println("1. Add Stock Account");
			System.out.println("2. Get Total Value of Stock");
			System.out.println("3. Buy Shares");
			System.out.println("4. Sell Shares");
			System.out.println("5. Print Report");
			System.out.println("6. Exit");
			
			switch(UtilityMethods.inputInt("enter your choice: "))
			{
				case 1: @SuppressWarnings("unused") 
						StockAccount newStock = new StockAccount("Customer.json");
						break;
			
				case 2:	double totalValue = stockA.valueOf();
						if(totalValue >= 0)
						{
							System.out.println(totalValue);
						}
						break;
						
				case 3:  int shares = UtilityMethods.inputInt("enter shares: ");
						String symbol = UtilityMethods.stringInput("enter stock symbol : ").toUpperCase();
						stockA.buy(shares, symbol);
						break;
						
				case 4: shares = UtilityMethods.inputInt("enter shares: ");
						symbol = UtilityMethods.stringInput("enter stock symbol : ").toUpperCase();
						stockA.sell(shares, symbol);
						break;
						
				case 5: stockA.printReport();
						break;
						
				case 6: value = false;
						break;
						
				default: System.out.println("invalid choice");
			}			
	
		}
	}
}
