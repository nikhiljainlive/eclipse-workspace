package OOPS;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonAPI1
{
	public static void main(String[] args)
	{
		String path = "/home/admin1/eclipse-workspace/nikhiljain/stock.json";
		File file = new File(path);
		ObjectMapper objM = new ObjectMapper();
		Stock stock1 = new Stock();
		try {
			stock1 = objM.readValue(file, Stock.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		ArrayList<Stock> stock = objM.readValue(file, Stock.class);
	}

}
