package utility;

/**
 * @purpose importing Arrays class of java.util package
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @purpose class declaration of Utility Class for functional and algorithm methods
 * @author Nikhil Jain
 * @version 1.0
 */
public class UtilityMethods 
{
	// declaring object of Scanner class as static
	public   static Scanner scan =new Scanner(System.in);
	
	// declaring object of Random class as static
	public static Random rand = new Random();
	
	// takes the input from user 
	//and checks if it is not other than integer
	public static int inputInt(String s)
	{
		try
		{
			System.out.print(s);
			String strInput = scan.nextLine();
			int intinput = Integer.parseInt(strInput);
			
			return intinput;
		}
		catch(NumberFormatException e)
		{
			System.out.println("invalid input..try again");
			return 0;
		}
	}
	
	// takes the Long input
	public static long inputLong(String s)
	{
		System.out.print(s);
		long longNum = scan.nextLong();
		
		return longNum;
	} 
		
	// takes the string input
	public static String stringInput(String s)
	{
		System.out.print(s);
		String string = scan.nextLine();
		
		return string;
	} 
	
	// returns true if input string is integer otherwise returns false
	public static boolean isInteger(String s)
	{
		int i = 0, count = 0;
		char ch = s.charAt(i);
		for ( ; i < s.length()-1; i++)
		{
			if(!Character.isDigit(ch))
			{
				count++;
			}
		}
		if(count == 0)
		{
			return true;
		}
		
		return false;
	}
	
	// checks if input value is less than a specified number
	public static boolean isLessthan(int input, int num) 
	{
		if(input < num)
		{
			return true;
		}
		
		return false;
	}
	
	// this method checks if input string contains spaces, digits and special characters
	public static boolean isString(String s)
	{
		
		if(s.length() == 0)										// returns false if the length of string is zero
		{
			return false;
		}
		else if(s.contains(" "))								// checks for white-spaces and spaces in between
		{
				return false;
		}
		else
		{
			int count = 0;
			for(int i = 0; i < s.length(); i++)					// checks for each character in the string
			{													// if there is any character other than letters 
				char ch = s.charAt(i);
				if(!Character.isLetter(ch))
				{
					count++;									// increases the count if the character is not letter
				}
			}
			if(count != 0)
			{
				return false;
			}
		}//end of outer nested if-else block
		
		return true;											// returns true if all above conditions fails
	}
	
	// returns true if entered year is leap year else returns false
	public static boolean isLeapYear(int year)
	{
		if(year % 4 == 0 || year % 400 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}//end of inner if-else block
	}
	
	/**
	 * @purpose calculates day of week
	 * @param m / month
	 * @param d / date
	 * @param y / year
	 * @return d0 / day of week and week starts from Sunday(0)
	 */
	public static int dayOfWeek(int m, int d, int y)
	{
		
		int y0 = y - ((14 - m ) / 12);
		int x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		int m0 = m + (12 * ((14 - m ) / 12)) - 2;
		int d0 = (d + x + ((31 * m0) / 12)) % 7;
		
		return d0;
	}
	
	// calculates random number
	public static double randomnum()
	{
		double random = rand.nextDouble();
		
		return random;
	}
	
	// calculates percentage of a specified value
	public static int percent(int num, int total)
	{
		int percent = (num * 100) / total;
		
		return percent;
	}

	// reads integer array elements
	public static void readIntArray(int[] a, int capacity)
	{
		try 
		{
			for (int i = 0; i < capacity; i++)
			{
				a[i] = inputInt("Enter element (" + (i+1) + ") : ");
			}	
		}
		catch(NumberFormatException e)											// handles exception if user input is other than integer
		{
			System.out.println("enter elements in integers... Try again!\n");
			readIntArray(a, capacity);
		}
		catch(Exception e)														// handles other exception
		{
			System.out.println(e.getMessage());
		}
	}
	
	// reads String array elements
		public static void readStringArray(String[] a, int capacity)
		{
			try 
			{
				for (int i = 0; i < capacity; i++)
				{
					a[i] = stringInput("enter string(" + (i+1) + "): ");
				}	
			}
			catch(Exception e)														// handles other exception
			{
				System.out.println(e.getMessage());
			}
		}
	
	// creating Stop-watch Timer using time class method
	public static String stopWatchTimer(int startTime)
	{	
		int stopTime = (int) System.currentTimeMillis();							// stopping timer after any key entered
		int ms = (stopTime - startTime);
		int s = ms / 1000;													
		int m = s / 60;
		int h = m / 60;
		
		//formats the string
		String displayTimer = String.format("%02d h: %02d m: %02d s: %02d ms", h , ((m>=0 && m<60) ? m : m % 60), ((s>=0 && s<60) ? s : s % 60), ((ms>=0 && ms<100) ? ms : ms % 100));

		return displayTimer;
	}
	
	// calculates the digits in a number
		public static int digitsCount(int num)
		{
			int count = 0;
			while(num != 0)
			{
				num = num / 10;
				count++;
			}
			return count;														// returns the digits in entered input
		}
	
//----------------------------------------------------------------------------------------------------------------------------------------------
	
	// Algorithm programs
	
//----------------------------------------------------------------------------------------------------------------------------------------------	
	
	//checks if two strings are anagrams
	public static boolean isAnagram(String s1, String s2)
	{
		if (s1.length() != s2.length())
		{
			return false;
		}
		else
		{
			char[] a1 = s1.toCharArray();
			char[] a2 = s2.toCharArray();
			Arrays.sort(a1);
			Arrays.sort(a2);
			String s3 = new String(a1);
			String s4 = new String(a2);
			if (s3.equals(s4))
			{
				return true;
			}
			
			return false;
		}
	}
	
	// checks if a number is palindrome
	public static boolean isPalindrome(int num)
	{
		int count = digitsCount(num), tempNum = num;
		int res = 0;
		for(int i = 1; i <= count; i++)
		{
			int rem = tempNum % 10;
			res = res * 10 + rem;
			tempNum = tempNum / 10;
		}
		
		if(res == num)
		{
			return true;
		}
		else
		{
			return false;	
		}
	}
	
	// calculates prime numbers within a given range
	public static String getPrimeNumbers(int range1, int range2)
	{
		int i = 0;														
		int num = 0;
		//Empty String
		String  primeNumbers = "";
		for (i = range1; i <= range2; i++)         
		{ 		  	  
			int counter = 0;	  
			for (num = i; num >= 1; num--)
			{
				if (i%num==0)
				{
					counter = counter + 1;
				}
			}// end of inner loop
			
			if (counter == 2)
			{
				//Appended the Prime number to the Array
				primeNumbers = primeNumbers + i + " ";
			}	
		}// end of outer loop	
		
		return primeNumbers;
	}
	
	// prints the prime numbers which are palindrome
	public static void palindromicPrime(String primeNums)
	{
		String[] primeStr = primeNums.split(" ");
		int count = 0;
		for(int i = 0; i < primeStr.length; i++)
		{
			int num = Integer.parseInt(primeStr[i]);
			if(isPalindrome(num) == true)
			{
				System.out.print(num + " ");
				count++;
			}
		}//end of loop
		
		if(count == 0)
		{
			System.out.println("No palindromic primes are found!");
		}
		else
		{
			System.out.println("\nTotal numbers: " + count);
		}
		System.out.println();
	}
	
	// prints prime numbers which are anagrams
	public static String anagramPrimes(String primeNums)
	{
		String[] primes = primeNums.split(" ");
		int count = 0;
		String anaPrimes = "";
		for(int i = 0; i < primes.length; i++)
		{
			for(int j = 1 + i; j < primes.length; j++)
			{
				if(UtilityMethods.isAnagram(primes[i], primes[j]) == true)
				{
					count++;
					anaPrimes = anaPrimes +  " " + primes[i] + " " + primes[j] + " ";
				}
			}
		}
		
		String[] anaPrimesStr = anaPrimes.split("  |\\ ");
		DataStructuresUtility.sortString(anaPrimesStr);
		anaPrimes = "";
		for(int i = 0; i < anaPrimesStr.length; i++)
		{
			anaPrimes = anaPrimes + anaPrimesStr[i] + " ";
		}
		
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(anaPrimes);
		while(m.find())
		{
			anaPrimes = anaPrimes.replaceAll(m.group(), m.group(1));
		}
		
		if(count == 0)
		{
			return ("No Prime numbers(which are Anagrams) found\n");
		}
		else
		{
			return anaPrimes;
		}
	}
	
	// 4. (i) method for binary search operation on integers
	public static void binarySearchInt(int[] a, int key)
	{
		int li =0, hi = a.length, mi = (li + hi) / 2;
		
		while (li != hi)
		{
			if (a[mi] == key)
			{
				System.out.println("Element found at " + (mi+1) + " position.");
				break;
			}
			else if (key < a[mi])
			{
				hi = mi - 1;
			}
			else
			{
				li = mi + 1;
			}// end of nested if-else
			
			mi = (li + hi) / 2;
		}//end of while loop
		if(li >= hi && a[mi] != key)
		{
			System.out.println("Element not found!");
		}
	}
	
	// 4. (ii) method for binary search operation on strings 
	public static void binarySearchString(String[] s, String key)
	{
		int li = 0, hi = s.length - 1, mi = (li + hi) / 2;
		
		while (li <= hi)
		{
			int value = key.compareTo(s[mi]);
			if (value == 0)
			{
				System.out.println("entered string found at " + (mi+1) + " position in array");
				break;
			}
			else if (value < 0)
			{
				hi = mi - 1;
			}
			else if (value > 0)
			{
				li = mi +1 ;
			}//end of nested if-else condition
			
			mi = (li + hi) / 2;
		}//end of while loop
		if(li >= hi)
		{
			System.out.println("String not found!");
		}
	}
	
	// 4. (iii) insertion sort method for integers
	public static void insertionSortInt(int[] a)
	{
		for(int i = 1; i < a.length; i++)
		{
			int hole = i, value = a[hole];
			while(hole > 0 && a[hole - 1] > value)
			{
				a[hole] = a[hole -1];
				hole = hole - 1;
			}
			a[hole] = value;
		}
		
		System.out.println("Sorting through Insertion Sort Algorithm:\n");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		System.out.print("\n");	
	}
	
	// 4. (iv) insertion sort method for strings
	public static void insertionSortString(String[] s)
	{
		for(int i = 0; i < s.length; i++)
		{
			int hole = i;
			String value = s[i];
			while(hole > 0 && s[hole - 1].compareTo(value) > 0)
			{
				s[hole] = s[hole -1];
				hole = hole - 1;
			}
			
			s[hole] = value;
		}
		
		System.out.println("Sorting through Insertion Sort Algorithm:\n");
		for(int i = 0; i < s.length; i++)
		{
			System.out.print(s[i] + " ");
		}
		
		System.out.print("\n");
	}
	
	// 4. (v) bubble sort algorithm implementation on integers
	public static void bubbleSortInt(int[] a)
	{
		int temp;
		for(int i =0; i < a.length-1; i++)
		{
			for(int j = 0; j < a.length-1; j++)
			{
				if(a[j+1] < a[j])
				{
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		System.out.println("Sorting through Bubble Sort Algorithm:\n");
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
		System.out.print("\n");	
	}
		
	// 4. (vi) bubble sort algorithm implementation on strings
	public static void bubbleSortString(String[] sArray)
	{
		String temp;
		for(int i =0; i < sArray.length - 1; i++)
		{	
			for(int j = 0; j < sArray.length - 1; j++)
			{
				if (sArray[j].compareTo(sArray[j + 1]) > 0)
				{
					temp = sArray[j];
					sArray[j] = sArray[j + 1];
					sArray[j + 1] = temp;
				}
			}
		}
		
		System.out.println("Sorting through Bubble Sort Algorithm:\n");
		for(int i = 0; i < sArray.length; i++)
		{
			System.out.print(sArray[i] + " ");
		}
		
		System.out.print("\n");
	}
	
	// takes temperature as input and displays the temperature conversion
	public static void temperatureConversion()
	{
		String s = UtilityMethods.stringInput("Temperature(with f or c at last) :");
		String str = s.toLowerCase();
		if(str.endsWith("f") || str.endsWith("c"))
		{
			String s1 = s.substring(0, s.length()-1);
			
			if(str.endsWith("f"))
			{
				if(isInteger(s1))
				{
					float f = Float.parseFloat(s1);
					float c = (float) ((f - 32.0) * (5 / 9.0));
					
					System.out.println(c + " �C");
				}
				else
				{
					System.out.println("enter value of f in integers\n");
					temperatureConversion();
				}
				
			}
			else if(str.endsWith("c"))
			{
				if(isInteger(s1))
				{
					float c = Float.parseFloat(s1);
					float f = (float) (c * (9 / 5.0)) + 32;
					
					System.out.println(f + " �F");
				}
				else
				{
					System.out.println("enter value of f in integers\n");
					temperatureConversion();
				}
			}	
		}
		else
		{
			System.out.println("Wrong input! Try again");
			temperatureConversion();
		}
	}
}
