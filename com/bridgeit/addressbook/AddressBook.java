package com.bridgeit.addressbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utility.UtilityMethods;

public class AddressBook 
{
	private List<Person> newList = new ArrayList<Person>();
	private static File file;
	FileSystem fileSystem = new FileSystem();
	private static String fileName;
	
	public AddressBook() {}
	
	public void createAddressBook()
	{
		String fileName = UtilityMethods.stringInput("enter the file name: ");
		String fileExt = UtilityMethods.stringInput("enter the file extension: ");
		if(fileExt.equals(".json") || fileExt.equals(".txt"))
		{
			File newFile = FileSystem.createNewFile(fileName.trim(), fileExt);
			setFile(newFile);
			setFileName(fileName + fileExt);
			fileSystem.setList(newList);
			System.out.println("\nNew AddressBook Created!\n");
		}
		else
		{
			System.out.println("\nOnly .json and .txt files can be created!\n");
		}
	}
	
	public void openAddressBook()
	{
		String fileName = UtilityMethods.stringInput("enter the file name: ");
		String fileExt = UtilityMethods.stringInput("enter the file extension: ");
		if(fileExt.equals(".json") || fileExt.equals(".txt"))
		{
			File openFile = FileSystem.getPathOfFile(fileName.trim(), fileExt);
			fileSystem.readFile(openFile);
				setFile(openFile);
				setFileName(fileName + fileExt);
		}
		else
		{
			System.out.println("\nOnly .json and .txt files can be opened!\n");
		}
	}
	
	public void addPerson(String firstName, String lastName, String address,
			String city, String state, String zip, String phone)
	{
			Person newEntry = new Person(firstName, lastName, address, city, state, zip, phone);
			newList = fileSystem.getList();
			newList.add(newEntry);
			fileSystem.setList(newList);	
	}
	
	public void getFullNameOfPerson(String searchName)
	{
		int index = searchPersonbyFirstName(searchName);
		if(index >= 0)
		{
			System.out.println(fileSystem.getList().get(index).getFirstName() + " " + fileSystem.getList().get(index).getLastName());
		}
		else
		{
			System.out.println("Person not Found!");
		}
	}

	public void updatePerson(int index, String address,
			String city, String state, String zip, String phone)
	{
			fileSystem.getList().get(index).setAddress(address);
			fileSystem.getList().get(index).setCity(city);
			fileSystem.getList().get(index).setState(state);
			fileSystem.getList().get(index).setZip(zip);
			fileSystem.getList().get(index).setPhone(phone);
			
			System.out.println("\nPerson Details updated Successfully!\n");
	}
	
	public void removePerson(int index)
	{
			fileSystem.getList().remove(index);
	}
	
	public void sortByName()
	{
		newList = fileSystem.getList();
		NameComparator compareByName = new NameComparator();
		Collections.sort(newList, compareByName);
	}
	
	public void sortByZip()
	{
		newList = fileSystem.getList();
		ZIPComparator compareByZip = new ZIPComparator();
		Collections.sort(newList, compareByZip);
	}
	
	public void printAll()
	{
		newList = fileSystem.getList();
		for(Person p : newList)
		{
			System.out.println(p.toString());
		}
	}

	// getters and setters
	public List<Person> getPersonList()
	{
		return newList;
	}

	public void setPersonList(List<Person> personList) 
	{
		this.newList = personList;
	}

	public File getFile() 
	{
		return file;
	}

	public void setFile(File file)
	{
		AddressBook.file = file;
	}
	
	public int searchPersonbyFirstName(String keyFName)
	{
		int index = -1;
		for (int i = 0; i < fileSystem.getList().size(); i++ )
		{
			String personFirstName = fileSystem.getList().get(i).getFirstName();
			if(keyFName.equals(personFirstName))
			{
				index = i;
				break;
			}
		}

		return index;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		AddressBook.fileName = fileName;
	}
}

// comparator classes implementing comparator interface
class NameComparator implements Comparator<Person>
{

	@Override
	public int compare(Person personOne, Person personTwo) 
	{
		return(personOne.getFirstName().compareTo(personTwo.getFirstName()));
	}
	
}

class ZIPComparator implements Comparator<Person>
{

	@Override
	public int compare(Person personOne, Person personTwo) {
		
		int personOneZip = Integer.parseInt(personOne.getZip());
		int personTwoZip = Integer.parseInt(personTwo.getZip());
		if(personOneZip < personTwoZip)
		{
			return -1;
		}
		else if(personOneZip > personTwoZip)
		{
			return 1;
		}
		return 0;
	}
}
