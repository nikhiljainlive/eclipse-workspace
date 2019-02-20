package datastructuresprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import datastructuresinterface.LinkedList;
import functionalprograms.Utility;

public class UnorderedList 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		LinkedList linkL = new LinkedList();
		String path = "/home/admin1/eclipse-workspace/nikhiljain/nikhil.txt";
		BufferedReader buffer = new BufferedReader(new FileReader(path));
		String s ="";
		try 
		{
			s = buffer.readLine();
			String[] str = s.split(" ");
			
			for(int i = 0; i < str.length; i++)
			{
				linkL.insert(str[i]);
			}
			
			System.out.println("Word-List from file:");
			linkL.displayList();
			String key = Utility.stringInput("\nEnter word to find: ");
			boolean value = linkL.isWordPresent(key);
			if(value)
			{
				System.out.println("element found and deleted!");
				linkL.delete(key);
			}
			else
			{
				System.out.println("element not found but added");
				linkL.insert(key);
			}
			
			System.out.println("\nNew Word-List:");
			linkL.displayList();
			
			String newString = linkL.toString();
			BufferedWriter bfw = new BufferedWriter(new FileWriter(path));
			bfw.write(newString);
			
			bfw.close();
			buffer.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}																																						
	}
}
