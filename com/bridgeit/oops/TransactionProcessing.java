package com.bridgeit.oops;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import newprograms.TLinkedList;
import utility.OOPSUtility;
import utility.UtilityMethods;

public class TransactionProcessing 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		TLinkedList companyName = new TLinkedList();
		TLinkedList companyStock = new TLinkedList();
		TLinkedList companySharePrice = new TLinkedList();
		TLinkedList dateAndTimeList = new TLinkedList();
		TCompanies company1 = new TCompanies();
		ObjectMapper objectMapper = new ObjectMapper();
		File companyFileObject = new File("/home/admin1/eclipse-workspace/Programs/src/newprograms/Transactions.json");
		List<TCompanies> companyList = objectMapper.readValue(companyFileObject, new TypeReference<List<TCompanies>>() {
		});
		company1 = companyList.get(0);
		System.out.println(company1);
		companyName.insertAtLast(company1.getName());
		companyStock.insertAtLast(Integer.toString(company1.getShareStock()));
		companySharePrice.insertAtLast(Integer.toString(company1.getSharePrice()));
		String dateAndTime = dtf.format(now);
		dateAndTimeList.insertAtLast(dateAndTime);
		System.out.println("\n(**Items are pushed to Stack)");
		System.out.println("1.Buy shares");
		System.out.println("2.Sell Shares");
		
		int ch = UtilityMethods.inputInt("enter your choice: ");
		if (ch == 1) 
		{
			int numberOfShares = UtilityMethods.inputInt("shares you want to buy: ");
			if (numberOfShares > company1.shareStock) 
			{
				System.out.println(numberOfShares + " are not available in stock");
			} 
			else 
			{
				int shareStock = company1.getShareStock();
				shareStock = shareStock - numberOfShares;
				String str = Integer.toString(shareStock);
				company1.setShareStock(shareStock);

				System.out.println("Transaction is Completed on date:" + dateAndTimeList.deleteAtLast());
				OOPSUtility.writeObjectToJson(companyList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Transactions.json");
				System.out.println(companyList);
				companyName.insertAtLast(str);
				companyStock.deleteAtFirst();
				companySharePrice.insertAtLast(str);

				System.out.println("(**Items are popped from stack)");
			}
		} else if (ch == 2) 
		{
			int noOfShares = UtilityMethods.inputInt("shares want to sell: ");
			if (noOfShares > company1.shareStock) 
			{
				System.out.println(noOfShares + " are not available in stock");
			}
			else
			{
				int shareStock = company1.getShareStock();
				shareStock = shareStock + noOfShares;
				company1.setShareStock(shareStock);

				System.out.println("Transaction is Completed on date:" + dateAndTimeList.deleteAtLast());
				System.out.println(companyList);
				companyName.deleteAtFirst();
				companyStock.deleteAtFirst();
				companySharePrice.deleteAtFirst();
				System.out.println("(**Items are popped from stack)");
				OOPSUtility.writeObjectToJson(companyList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Transactions.json");
			}
			
		}
		else
		{
			System.out.println("Invalid choice..try again");
		}
	}
}
