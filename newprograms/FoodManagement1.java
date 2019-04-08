package newprograms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.UtilityMethods;

public class FoodManagement1 
{
	public static void main(String[] args)
	{
		String path = "/home/admin1/eclipse-workspace/nikhiljain/abc.json";
		File file = new File(path);
		ObjectMapper objM = new ObjectMapper();
		
		try {
			JsonNode rootNode = objM.readTree(file);
			String inventory = UtilityMethods.stringInput("enter the inventory name: ");
			
			JsonNode idNode = rootNode.path(inventory);
			if(idNode.isMissingNode())
			{
				System.out.println("\nInventory not Found!");
			}
			else
			{
				ArrayList<JsonNode> list = new ArrayList<JsonNode>();
				Iterator<JsonNode> it = idNode.elements();
				while(it.hasNext())
				{
					list.add(it.next());
				}
				
				int totalPrice = 0, totalWeight = 0;
				System.out.printf("\n%30s\t    %10s\t %10s\n", inventory.toUpperCase() + " TYPE","Weight(in kg)","Price(in Rs.)");
				System.out.println("\t\t===================================================");
				for(int i = 0; i < list.size(); i++)
				{
					String name = list.get(i).path("name").asText();
					int weight = list.get(i).path("weight").asInt();
					int price = list.get(i).path("price").asInt();
					totalPrice = totalPrice + (weight * price);
					totalWeight = totalWeight + weight;
					
					System.out.printf("%30s\t\t %3d\t\t %4d\n",name,weight,price);
				}
				System.out.println("\t\t===================================================");
				System.out.printf("%30s : %5d Kg.\n", "Total weight", totalWeight);
				System.out.printf("%30s : %5d Rs.", "Total Price", totalPrice);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
