package com.bridgeit.oops.stockreport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import utility.UtilityMethods;

public class Main 
{
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		List<Stock> stocks = new ArrayList<>();

		
		int numOfStocks = UtilityMethods.inputInt("enter no. of stocks: ");
		int count = 1;
		while (count <= numOfStocks) {
			String name = UtilityMethods.stringInput("enter stock name: ");
			int numOfShares = UtilityMethods.inputInt("enter no. of shares: ");
			double price = UtilityMethods.inputInt("enter price of each share: ");
			System.out.println();
			Stock stock = new Stock();
			stock.setName(name);
			stock.setNumberOfShares(numOfShares);
			stock.setPrice(price);
			name = name.toUpperCase();
			String str = name.substring(0, 3);
			if(name.length()<3)
			{
				name = name.substring(0, name.length());
			}

			stock.setSymbol(str);
			stocks.add(stock);

			count++;
		}
		writer.writeValue(new File("/home/admin1/eclipse-workspace/Programs/src/newprograms/Stock.json"), stocks);

		StockPortfolioMain portfolio = new StockPortfolioMain();
		portfolio.setStocks(stocks);
		// Print the stock portfolio
		System.out.println("SL No \t\t Name\t\t Total Stocks\t\tSymbol \t     Share Price\t\t Stock Value");
		System.out.println("========================================================================================================");
		count = 1;
		for (Stock s : portfolio.getStocks()) {
			System.out.printf("%2d\t %-15s\t\t %-4d\t\t%3s\t\t%-3f\t\t%-3f\n",count, s.getName(), s.getNumberOfShares(),  s.getSymbol(), s.getPrice(), s.getPrice() * s.getNumberOfShares());
			count++;
		}
		System.out.println("\n Total Stock Value = " + portfolio.getTotalStockValue());

	}
}
