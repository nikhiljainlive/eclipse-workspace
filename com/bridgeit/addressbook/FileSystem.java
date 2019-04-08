package com.bridgeit.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSystem 
{
	public static List<Person> personList = null;
	public static ObjectMapper objM = new ObjectMapper();
	
	public void readFile(File file)
	{
		try 
		{
			setList(objM.readValue(file, new TypeReference<List<Person>>() {}));
		} 
		catch (IOException e) 
		{
			System.out.println("\nFile Not Found!\n");
		}
	}
	
	public void saveFile(File file)
	{
		List<Person> updatedList = getList();
		try {
			objM.writerWithDefaultPrettyPrinter().writeValue(file, updatedList);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setList(List<Person> personList)
	{
		FileSystem.personList = personList;
	}
	
	public List<Person> getList()
	{
		return personList;
	}
	
	public static File getPathOfFile(String fileName, String fileExtension)
	{
		fileName = "/home/admin1/eclipse-workspace/Programs/src/com/bridgeit/addressbook/"
				+ fileName + fileExtension;
		
		File file = new File(fileName);
		
		return file;
	}
	
	public static File createNewFile(String fileName, String fileExtension)
	{
		File file = FileSystem.getPathOfFile(fileName, fileExtension);
		try {
			@SuppressWarnings({ "unused", "resource" })
			FileWriter newFileWritten = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}
}
