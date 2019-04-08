package com.bridgeit.oops.stockreport;

import java.util.List;

public class StockPortfolioMain
{
	private List<Stock> stocks;

	public double getTotalStocks() 
	{
		long totalStocks = 0;
		for (int i = 0; i < stocks.size(); i++)
		{
			totalStocks += stocks.get(i).getNumberOfShares();
		}
		return totalStocks;
	}

	public double getTotalStockValue() 
	{
		long totalStockValue = 0;
		for (int i = 0; i < stocks.size(); i++) 
		{
			totalStockValue += stocks.get(i).getPrice() * stocks.get(i).getNumberOfShares();
		}
		return totalStockValue;
	}

	public List<Stock> getStocks()
	{
		return stocks;
	}

	public void setStocks(List<Stock> stocks) 
	{
		this.stocks = stocks;
	}
}
