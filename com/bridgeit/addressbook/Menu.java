package com.bridgeit.addressbook;

import utility.UtilityMethods;

public class Menu 
{
	static AddressBook addressBook = new AddressBook();
	public static void addressMenu(boolean value)
	{
		try {
			while(value)
			{
				System.out.println("=====================================");
				System.out.println("-------Address Book Application------|");
				System.out.println("=====================================|");
				System.out.println("                                     |");
				System.out.println("1. Create New Address Book           |");
				System.out.println("2. Open existing Address Book        |");
				System.out.println("3. Add Person                        |");
				System.out.println("4. Edit Person                       |");
				System.out.println("5. Remove Person                     |");
				System.out.println("6. Sort entries by name              |");
				System.out.println("7. Sort entries by zip               |");
				System.out.println("8. Print entries                     |");
				System.out.println("9. Save Address Book                 |");
				System.out.println("10.Save As Address Book              |");
				System.out.println("11.Quit Program                      |");
				System.out.println("                                     |");
				System.out.println("=====================================");
				
				switch(UtilityMethods.inputInt("enter your choice: "))
				{
					case 1:	AddressBookController.createnewAddressBook();
							break;
							
					case 2: AddressBookController.openExistingAddressBook();						
							break;
						
					case 3: AddressBookController.addPersonInAddressBook();
							break;
							
					case 4:	AddressBookController.updatePersonInAddressBook();
							break;						
							
					case 5: AddressBookController.removePersonInAddressBook();
							break;
						
					case 6:	AddressBookController.sortAddressBookByName();
							break;
							
					case 7: AddressBookController.sortAddressBookByZip();
							break;
						
					case 8: AddressBookController.printAddressBook();
							break;
						
					case 9: AddressBookController.saveAddressBook();
							break;
							
					case 10: AddressBookController.saveAsAnotherAddressBook();		
							break;
							
					case 11: System.out.println("\nApplication stopped!\n"); 
							value = false;
							break;
							
							
					default: System.out.println("invalid choice... try again");
							
				}	
			}	
		}
		catch(NullPointerException e)
		{
			System.out.println("\nNo AddressBook opened currently!");
		}
		
	}
	
}
