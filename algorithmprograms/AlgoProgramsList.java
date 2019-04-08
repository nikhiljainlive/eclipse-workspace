package algorithmprograms;

import functionalprograms.EntryPoint;
import utility.UtilityMethods;

/**
 * @purpose Class declaration of Algorithm programs List
 * @author Nikhil Jain
 * @version 1.0
 */
public class AlgoProgramsList
{
	
	/**
	 * @purpose displays programs list
	 * @param void
	 * @return void
	 */
	public static void programList()
	{
		System.out.println("\n===============================================================================================");
		System.out.println("----Algorithm Programs----");
		System.out.println("Choose from the following:");
		System.out.println("1. Anagram");
		System.out.println("2. Prime Numbers");
		System.out.println("3. Prime Numbers (that are Palindrome and Anagrams)");
		System.out.println("4. Searching and Sorting (**separate program)");
		System.out.println("5. Question to find your number(**cmd line args)");
		System.out.println("6. Search the Word from Word-List");
		System.out.println("7. Insertion Sort of String");
		System.out.println("8. Bubble Sort of Integers");
		System.out.println("9. Merge Sort");
		System.out.println("10. Fewest notes returned for Vending machine");
		System.out.println("11. day Of Week(cmd line args)");
		System.out.println("12. Temperature Conversion");
		System.out.println("13. monthlyPayment (cmd line args)");
		System.out.println("14. Square Root");
		System.out.println("15. Binary Conversion");
		System.out.println("16. Binary.java");
		System.out.println("===============================================================================================");
	
		algoMenu();						// calling method which performs list
	}
	
	/**
	 * @purpose performs switch case statements 
	 * @param void
	 * @return void
	 */
	public static void algoMenu()
	{
		boolean value = true;
		while(value) 
		{
			try
			{
				switch(UtilityMethods.inputInt("===============================================================================================\n(enter 0 for Main Menu or -1 to re-display current menu)\n\nenter choice (Alogirthm Programs menu): "))
				{
					case -1: programList();									// prints the program list again
							break;
				
					case 0: EntryPoint.programList();						// returns to the main method
							return;							
					
				 	case 1: Anagram.findAnagram();							// method for finding anagrams
				 			break;
				 			
				 	case 2: PrimeNumbers.printPrimeNum();					// method which prints prime numbers
			 				break;
			 			
				 	case 3: PAPrimeNumbers.PalinAnagramPrimes();			// print prime numbers(which are anagrams and palindromes)
			 				break;
			 			
				 	//case 4: DisplaySearching										// separate program for searching and Sorting
			 			//	break;
			 			
				 	//case 5: GuesstheNumber						// command line arguments - guess the number
			 		//		break;
			 			
				 	case 6: WordSearchFromFile.searchWord();				// search the word from wordlist of a file
			 				break;
			 			
				 	case 7: InsertionSortString.sortedString();				// insertion sort method for String Array
			 				break;
			 			
				 	case 8: BubbleSort.sortNumbers();						// bubble sort method
			 				break;
			 			
				 	case 9: MergeSort.displayMergeSort();					// merge sort algorithm
			 				break;
			 			
				 	case 10: VendingMachine.fewNotes();						// calculate the fewest notes returned by a vending machine
			 				break;
			 			
				 	//case 11: DayFinder							// command line arguments - day of week
				 	//		break;
				 			
				 	case 12: UtilityMethods.temperatureConversion();				// Temperature conversion program
		 					break;
		 					
				 	//case 13: MonthlyPayment						// command line - monthly payment
		 			//		break;
		 					
				 	case 14: SquareRoot.sqrt();								// method which finds square root
		 					break;
				 			
				 	case 15: BinaryConversion.findBinaryNum();				// Decimal to Binary conversion method
							break;
				 			
				 	case 16: Binary.swapBinaryNum();						// swap the nibbles in a binary number and returns its decimal number
		 					break;
		 					
				 					
		 			default: System.out.println("Invalid Option! Try Again...");
				}
			}
			catch(NumberFormatException e)												// if user-input is other than integer 
			{
				System.out.println("Invalid Command.. Try again!\n");
				algoMenu();
			}
			catch(Exception e)															// handles other exceptions
			{
				System.out.println(e.getMessage());										
			}
		}
	}
}