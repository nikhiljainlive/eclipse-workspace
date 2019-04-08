package testprograms;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainProgram {
	static ObjectMapper objM = new ObjectMapper();
	static Inventory inventory;
	
	public static void main(String[] args) {
		
		String path = "/home/admin1/eclipse-workspace/Programs/src/testprograms/Inventory.json";
		File file = new File(path);
		try {
			inventory = objM.readValue(file, Inventory.class);
	
			for(int i = 0; i < inventory.getRice().size(); i++)
			{
				System.out.println(inventory.getRice().get(i));
				System.out.println("Total: " + inventory.getRice().get(i).getTotal());
				System.out.println();
			}
			
			for(int i = 0; i < inventory.getPulses().size(); i++)
			{
				System.out.println(inventory.getPulses().get(i));
				System.out.println("Total: " + inventory.getPulses().get(i).getTotal());
				System.out.println();
			}
			
			for(int i = 0; i < inventory.getWheat().size(); i++)
			{
				System.out.println(inventory.getWheat().get(i));
				System.out.println("Total: " + inventory.getWheat().get(i).getTotal());
				System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
