package com.bridgeit.oops.inventorydatamanagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryDataManagement 
{
	public static void main(String[] args)
	{
		getDetails();
	}
	
	public static void getDetails()
	{
		String path = "/home/admin1/eclipse-workspace/Programs/src/com/bridgeit/oops/inventorydatamanagement/Inventory.json";
		ObjectMapper objM = new ObjectMapper();
		List<Inventory> inventoryList;
		try 
		{
			inventoryList = objM.readValue(new File(path), new TypeReference<List<Inventory>>() {});
			System.out.printf("%-20s  %-10s  %-10s  %-10s\n", "Inventory Name", "Weight", "Price", "Total Value");
			System.out.println("==============================================================");
			for(int i = 0; i < inventoryList.size(); i++)
			{
				Inventory elements = inventoryList.get(i);
				System.out.println(elements.toString());
			}
			System.out.println("==============================================================");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
