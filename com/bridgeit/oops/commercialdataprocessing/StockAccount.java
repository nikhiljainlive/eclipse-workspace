package com.bridgeit.oops.commercialdataprocessing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.UtilityMethods;

public class StockAccount implements StockInterface
{
	private Customer customer;
	private CompanyShares companyShares;
	
	public static ObjectMapper objM = new ObjectMapper();
	File customerFile = new File("/home/admin1/eclipse-workspace/Programs/src/com/bridgeit/oops/commercialdataprocessing/Customer.json");
	File compSharesFile = new File("/home/admin1/eclipse-workspace/Programs/src/com/bridgeit/oops/commercialdataprocessing/CompanyShares.json");
	
	public StockAccount()
	{
		
	}
	
	// constructor having argument
	public StockAccount(String fileName)
	{
		StockUtility.addAccount(fileName);
	}
	
	@Override
	public double valueOf() 
	{
		try 
		{
			List<Customer> customerList = objM.readValue(customerFile, new TypeReference <List<Customer>>(){});
			List<CompanyShares> companySharesList = objM.readValue(compSharesFile, new TypeReference <List<CompanyShares>>(){});
		
			String searchName = UtilityMethods.stringInput("enter person's name: ").toUpperCase();
			int index = StockUtility.searchCustomerIndex(searchName, customerList);
			if(index != -1)
			{
				Customer customer = new Customer();
				customer = customerList.get(index);
				
				int relianceShares = companySharesList.get(0).getPrice() * customer.getRelianceShares();
				int hdfcShares = companySharesList.get(1).getPrice() * customer.getHdfcShares();
				int iciciShares = companySharesList.get(2).getPrice() * customer.getIciciShares();
				
				int totalValue = relianceShares + hdfcShares + iciciShares;
				
				System.out.print("\nTotal Value of Stock: ");
				
				return (double)totalValue;	
			}
			else
			{
				return -1;
			}
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void buy(int amount, String symbol) 
	{
		try 
		{
			List<CompanyShares> companySharesList = objM.readValue(compSharesFile, new TypeReference <List<CompanyShares>>(){});
			List<Customer> customerList = objM.readValue(customerFile, new TypeReference <List<Customer>>(){});
		
			String searchName = UtilityMethods.stringInput("enter person's name: ").toUpperCase();
			int custIndex = StockUtility.searchCustomerIndex(searchName, customerList);
			int stockIndex = StockUtility.searchSharesBySymbol(symbol, companySharesList);
			if(custIndex != -1)
			{
				CompanyShares companyShares = companySharesList.get(stockIndex);
				int noOfShares = companyShares.getNoOfShares();
				companyShares.setNoOfShares(noOfShares - amount);
				
				//System.out.println(stockIndex);
				Customer customer = customerList.get(custIndex);
				if(stockIndex == 0)
				{
					int value = customer.getRelianceShares();
					customer.setRelianceShares(value + amount);
				}
				if(stockIndex == 1)
				{
					int value = customer.getHdfcShares();
					customer.setHdfcShares(value + amount);
				}
				if(stockIndex == 2)
				{
					int value = customer.getIciciShares();
					customer.setIciciShares(value + amount);
				}	
			}
			else
			{
				System.out.println("stock not found!");
			}
			
			objM.writerWithDefaultPrettyPrinter().writeValue(compSharesFile, companySharesList);
			objM.writerWithDefaultPrettyPrinter().writeValue(customerFile, customerList);
			
			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
			System.out.println("=======================================================================");
			System.out.println(companySharesList.get(stockIndex).toString());
			
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Reliance(Shares)", "HDFC(Shares)", "ICICI(Shares)");
			System.out.println("=======================================================================");
			System.out.println(customerList.get(custIndex).toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void sell(int amount, String symbol)
	{
		try 
		{
			List<CompanyShares> companySharesList = objM.readValue(compSharesFile, new TypeReference <List<CompanyShares>>(){});
			List<Customer> customerList = objM.readValue(customerFile, new TypeReference <List<Customer>>(){});
			
			int stockIndex = StockUtility.searchSharesBySymbol(symbol, companySharesList);
			
			String searchName = UtilityMethods.stringInput("enter person's name: ").toUpperCase();
			int custIndex = StockUtility.searchCustomerIndex(searchName, customerList);
			if(custIndex != -1)
			{
				CompanyShares companyShares = companySharesList.get(stockIndex);
				int noOfShares = companyShares.getNoOfShares();
				companyShares.setNoOfShares(noOfShares + amount);
				
				//System.out.println(stockIndex);
				Customer customer = customerList.get(custIndex);
				if(stockIndex == 0)
				{
					int value = customer.getRelianceShares();
					customer.setRelianceShares(value - amount);
				}
				if(stockIndex == 1)
				{
					int value = customer.getHdfcShares();
					customer.setHdfcShares(value - amount);
				}
				if(stockIndex == 2)
				{
					int value = customer.getIciciShares();
					customer.setIciciShares(value - amount);
				}	
			}
			else
			{
				System.out.println("stock not found!");
			}
			
			objM.writerWithDefaultPrettyPrinter().writeValue(compSharesFile, companySharesList);
			objM.writerWithDefaultPrettyPrinter().writeValue(customerFile, customerList);
			
			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
			System.out.println("=======================================================================");
			System.out.println(companySharesList.get(stockIndex).toString());
			
			System.out.println("\n----------Customer Details----------");
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Reliance(Shares)", "HDFC(Shares)", "ICICI(Shares)");
			System.out.println("=======================================================================");
			System.out.println(customerList.get(custIndex).toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(String fileName, List<Customer> customerList)
	{
		try 
		{
			objM.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), customerList);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void printReport() 
	{
		try 
		{
			List<CompanyShares> companySharesList = objM.readValue(compSharesFile, new TypeReference <List<CompanyShares>>(){});
			List<Customer> customerList = objM.readValue(customerFile, new TypeReference <List<Customer>>(){});
		
			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
			System.out.println("=======================================================================");
			for(int i = 0; i < companySharesList.size(); i++)
			{
				System.out.println(companySharesList.get(i).toString());	
			}
			
			System.out.println("\n----------Customer Details----------");
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Reliance(Shares)", "HDFC(Shares)", "ICICI(Shares)");
			System.out.println("=======================================================================");
			for(int i = 0; i < customerList.size(); i++)
			{
				System.out.println(customerList.get(i).toString());	
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CompanyShares getCompanyShares() {
		return companyShares;
	}

	public void setCompanyShares(CompanyShares companyShares) {
		this.companyShares = companyShares;
	}

}
