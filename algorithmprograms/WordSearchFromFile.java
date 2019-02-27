package algorithmprograms;

/**
 * @purpose importing BufferedReader class from java.io package
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utility.UtilityMethods;

/**
 * @purpose class declaration for Word Search from file method
 * @author Nikhil Jain
 * @version 1.0
 */
public class WordSearchFromFile
{
	/**
	 * @purpose searches, sorts and displays the strings after reading from a file 
	 * @throws FileNotFoundException
	 */
	public static void searchWord() throws FileNotFoundException
	{
		String text = "/home/admin1/eclipse-workspace/nikhiljain/nikhil.txt";
		BufferedReader file = new BufferedReader(new FileReader (text));
		String line = "";
		String[] strings = null;
		
		try 
		{
			while((line = file.readLine()) != null)
			{
				strings = line.split(" ");
			}
			
			System.out.println("Data received from file:\n");
			for(String s : strings)
			{
				System.out.print(s + " ");
			}
			System.out.println();
			
			UtilityMethods.bubbleSortString(strings);
			String key = UtilityMethods.stringInput("enter word to search: ");
			UtilityMethods.binarySearchString(strings, key);
			file.close();
		} 
		catch (IOException e) 
		{													// handles IO exceptions
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()); 			// handles other exceptions
		}
	}
}
