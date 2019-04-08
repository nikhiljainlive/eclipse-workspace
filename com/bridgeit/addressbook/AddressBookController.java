package com.bridgeit.addressbook;

import utility.UtilityMethods;

public class AddressBookController
{
	static AddressBook addressBook = new AddressBook();
	
	public static void createnewAddressBook()
	{
		String response = null;
		if(addressBook.getFile() != null)
		{
			response = UtilityMethods.stringInput("\nAn existing AddressBook is already opened!"
					+ "\n Do you really wish to exit? \n (**reply with 'yes' or 'no'): ").toLowerCase();
		}
		if(addressBook.getFile() == null || response.equals("yes"))
		{
			addressBook.createAddressBook();
		}
		else if(response.equals("no"))
		{
			System.out.println("\nThank you! continue with existing file... \n"
					+ "(**don't forget to save the changes!)\n");
		}
		else
		{
			System.out.println("\ninvalid response!\n");
		}
	}
	
	public static void openExistingAddressBook()
	{
		String response = null;
		if(addressBook.getFile() != null)
		{
			response = UtilityMethods.stringInput("\nAn existing AddressBook is already opened!"
					+ "\n Do you really wish to exit? \n (**reply with 'yes' or 'no'): ").toLowerCase();
		}
		if(addressBook.getFile() == null || response.equals("yes"))
		{
			addressBook.openAddressBook();
			System.out.println();
		}
		else if(response.equals("no"))
		{
			System.out.println("\nThank you! continue with existing file... \n"
					+ "(**don't forget to save the changes!)\n");
		}
		else
		{
			System.out.println("\ninvalid response!\n");
		}
	}
	
	public static void addPersonInAddressBook()
	{
		if(addressBook.getFile() != null)
		{
			String firstName = UtilityMethods.stringInput("enter first name: ").toUpperCase();
			String lastName = UtilityMethods.stringInput("enter last name: ").toUpperCase();
			String address = UtilityMethods.stringInput("enter address: ").toUpperCase();
			String city = UtilityMethods.stringInput("enter city: ").toUpperCase();
			String state = UtilityMethods.stringInput("enter state: ").toUpperCase();
			String zip = UtilityMethods.stringInput("enter zip: ");
			String phone = UtilityMethods.stringInput("enter phone: ");

			addressBook.addPerson(firstName, lastName, address, city, state, zip, phone);	
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}
	
	public static void updatePersonInAddressBook()
	{
		if(addressBook.getFile() != null)
		{
			String searchName = UtilityMethods.stringInput("search person by first name: ").toUpperCase();
			int index = addressBook.searchPersonbyFirstName(searchName);
			if(index >= 0)
			{
				String address = UtilityMethods.stringInput("enter address: ").toUpperCase();
				String city = UtilityMethods.stringInput("enter city: ").toUpperCase();
				String state = UtilityMethods.stringInput("enter state: ").toUpperCase();
				String zip = UtilityMethods.stringInput("enter zip: ");
				String phone = UtilityMethods.stringInput("enter phone: ");
			
				addressBook.updatePerson(index, address, city, state, zip, phone);
			}
			else
			{
				System.out.println("\nPerson not found!\n");
			}
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}
	
	public static void removePersonInAddressBook()
	{
		if(addressBook.getFile() != null)
		{
			String searchName = UtilityMethods.stringInput("search person by first name: ").toUpperCase();
			int index = addressBook.searchPersonbyFirstName(searchName);
			if(index >= 0)
			{
				addressBook.removePerson(index);
			}
			else
			{
				System.out.println("\nPerson not Found!\n");
			}
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}
	}
	
	public static void sortAddressBookByName()
	{
		if(addressBook.getFile() != null)
		{
			addressBook.sortByName();
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}	
	}
	
	public static void sortAddressBookByZip()
	{
		if(addressBook.getFile() != null)
		{
			addressBook.sortByZip();
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}	
	}
	
	public static void printAddressBook()
	{
		if(addressBook.getFile() != null)
		{
			System.out.println("\n===================> " + "File Name: "+ addressBook.getFileName() + " <===================\n");
			addressBook.printAll();
			System.out.println("==================x End of this AddressBook x==================\n" );
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}	
	}
	
	public static void saveAddressBook()
	{
		if(addressBook.getFile() != null)
		{
			addressBook.fileSystem.saveFile(addressBook.getFile());
			System.out.println("\nAddressBook Saved Successfully!\n");
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}	
	}
	
	public static void saveAsAnotherAddressBook()
	{
		if(addressBook.getFile() != null)
		{
			String fileName = UtilityMethods.stringInput("enter the file name: ");
			String fileExt = UtilityMethods.stringInput("enter the file extension: ");
			if(fileExt.equals(".json") || fileExt.equals(".txt"))
			{
				addressBook.fileSystem.saveFile(FileSystem.createNewFile(fileName, fileExt));
				System.out.println("\nAddressBook Saved to another file successfully!\n");
			}
		}
		else
		{
			System.out.println("\nNo Address Book linked! Create one or open existing..\n");
		}	
	}
}
