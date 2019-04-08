package com.bridgeit.oops.commercialdataprocessing;

import java.util.List;

public interface StockInterface 
{
	public double valueOf();
	public void buy(int amount, String symbol);
	public void sell(int amount, String symbol);
	public void save(String fileName, List<Customer> customerList);
	public void printReport();
	
}
