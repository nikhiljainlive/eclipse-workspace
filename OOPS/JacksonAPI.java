package OOPS;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.UtilityMethods;

public class JacksonAPI
{
	public static void main(String[] args)
	{
		String path = "/home/admin1/eclipse-workspace/nikhiljain/stock.json";
		File file = new File(path);
		ObjectMapper objM = new ObjectMapper();
		
		try 
		{
			JsonNode rootNode = objM.readTree(file);
			String stockName = UtilityMethods.stringInput("enter stock for details: ");
			
			JsonNode idNode = rootNode.path(stockName);
			ArrayList<JsonNode> list = new ArrayList<JsonNode>();
			Iterator<JsonNode> it = idNode.elements();
			while(it.hasNext())
			{
				list.add(it.next());
			}
			
			System.out.println("Shares information of " + stockName.toUpperCase() + "\n");
			int totalShares = 0, totalPrice = 0;
			for(int i = 0; i < list.size(); i++)
			{
				JsonNode element = list.get(i);
				String shareName = element.path("shareName").asText();
				int noOfShares = element.path("noOfShares").asInt();
				int sharePrice = element.path("sharePrice").asInt();
				
				totalShares = totalShares + noOfShares;
				totalPrice = totalPrice + (noOfShares * sharePrice);
				System.out.println("ShareName: " + shareName + "\t\tNo. of Shares: " + noOfShares + "\t\tSharePrice: " + sharePrice);
			}
			System.out.println("\nTotalShares :\t\t" + totalShares);
			System.out.println("Total Stock Price :\t" + totalPrice);
			
			
		//System.out.println(element);
		//System.out.println(idNode);
		//Stock stock1 = objM.readValue(file, Stock.class);
		
		//System.out.println(stock1.getNoOfShares());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class Food
	{
		public String name;
		public int weight;
		public int price;
		
		
	}
	
}
