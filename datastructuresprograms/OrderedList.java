package datastructuresprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import datastructures.LinkedList;
import utility.UtilityMethods;


public class OrderedList 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		LinkedList linkL = new LinkedList();
		String path = "/home/admin1/eclipse-workspace/nikhiljain/orderedlist.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String s = "";
		try {
			s = br.readLine();
			String[] strA = s.split(" ");
			for(int i = 0; i < strA.length; i++)
			{
				linkL.add(strA[i]);
			}
			
			System.out.println("Elements read from File:");
			linkL.displayList();
			System.out.println("\nSorted List:");
			linkL.sortElements();
			linkL.displayList();
			String key = UtilityMethods.stringInput("enter the element to search: ");
			boolean value = linkL.search(key);
			if(value)
			{
				System.out.println("Element found and deleted: " + key);
				linkL.remove(key);
			}
			else
			{
				System.out.println("Element not found but added: " + key);
				linkL.add(key);
				linkL.sortElements();
			}
			
			linkL.displayList();
			String resultString = linkL.toString();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write(resultString);
			
			bw.close();
			br.close();
			//System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
