package com.bridgeit.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.OOPSUtility;
import utility.UtilityMethods;

public class CommercialDataProcessing
{
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		CPerson person1 = new CPerson();
		TCompanies company1 = new TCompanies();
		// creating mapper object
		ObjectMapper objectMapper = new ObjectMapper();
		// creating file objects
		File personFileObject = new File("/home/admin1/eclipse-workspace/Programs/src/newprograms/Person.json");
		File companyFileObject = new File("/home/admin1/eclipse-workspace/Programs/src/newprograms/Companies.json");
		List<CPerson> personList = objectMapper.readValue(personFileObject, new TypeReference<List<CPerson>>(){});
		person1 = personList.get(0);
		System.out.println("***User Details***");
		System.out.println(person1);

		List<TCompanies> companyList = objectMapper.readValue(companyFileObject, new TypeReference<List<TCompanies>>() {
		});
		company1 = companyList.get(0);
		
		System.out.println("\n***Company Details***");
		System.out.println(company1.toString());
		System.out.println("\n***Commercial Data processing***");
		System.out.println("1.Buy Shares");
		System.out.println("2.Sell Shares");
		System.out.println("3.Display Shares of Person");
		System.out.println("4.Available Shares in Stock");
		System.out.println("=================================");
		
		int ch = UtilityMethods.inputInt("enter your choice: ");
		int noOfShares;
		switch (ch) 
		{
			case 1:
					noOfShares = UtilityMethods.inputInt("shares you want to buy: ");
					if (noOfShares > company1.shareStock)
					{
						System.out.println(noOfShares + " shares are not available in stock");
					}
					else 
					{
						int amnt = buyShares(person1.cash, company1.sharePrice, noOfShares);
						company1.shareStock = company1.shareStock - noOfShares;
						person1.setCash(amnt);
						person1.availableShares = person1.availableShares + noOfShares;
						
						System.out.println("\nShares bought: " + noOfShares);
						System.out.println("Person's available shares: " + person1.availableShares);
						System.out.println("Company's available stock: " + company1.shareStock);
						OOPSUtility.writeObjectToJson(personList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Person.json");
						OOPSUtility.writeObjectToJson(companyList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Companies.json");
					}
					break;
					
			case 2:
					noOfShares = UtilityMethods.inputInt("shares you want to sell: ");
					if (noOfShares > person1.availableShares) 
					{
						System.out.println(noOfShares + " shares are not available in stock");
					}
					else
					{
						int amnt = sellShares(person1.cash, company1.sharePrice, noOfShares);
						company1.shareStock = company1.shareStock + noOfShares;
						person1.setCash(amnt);
						person1.availableShares = person1.availableShares - noOfShares;
						person1.setAvailableShares(person1.availableShares);
						System.out.println(person1);
						System.out.println("Person's available shares:" + person1.availableShares);
						System.out.println("Company's available stock: " + company1.shareStock);
						OOPSUtility.writeObjectToJson(personList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Person.json");
					}
					break;
	
			case 3:
					OOPSUtility.writeObjectToJson(personList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Person.json");
					System.out.println("\n"+ personList);
					System.out.println("Total shares of Person : " + person1.availableShares);
					OOPSUtility.writeObjectToJson(companyList, "/home/admin1/eclipse-workspace/Programs/src/newprograms/Companies.json");
					break;
			
			case 4:
					System.out.println("The total Shares in stock is :");
					System.out.println(company1.getShareStock());
					System.out.println("Price of each stock :");
					System.out.println(company1.getSharePrice());
					break;
	
			default: System.out.println("enter valid choice");
					break;
		}
	}
	
	public static int buyShares(int personCashAmount, int priceOfShares, int numberOfShares) {

		int total = priceOfShares * numberOfShares;
		System.out.println("\nPerson has to pay Rs." + total);
		return (personCashAmount - total);
	}

	public static int sellShares(int personCashAmount, int priceOfShares, int numberOfShares) {
		int cost = priceOfShares * numberOfShares;
		System.out.println("\nTotal cost of shares: " + (cost));
		return (personCashAmount + cost);
	}

}
