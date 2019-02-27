package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration of decimal to binary number conversion method
 * @author Nikhil Jain
 * @version 1.0
 */
public class BinaryConversion 
{
	/**
	 * @purpose takes decimal number from user and displays binary number
	 */
	public static void findBinaryNum()
	{
		try
		{
			int n = UtilityMethods.input("enter the number: ");
			toBinary1(n);
		}
		catch(NumberFormatException e)
		{
			System.out.println("only numbers are allowed.. try again");
		}
		
		//System.out.println("The binary number is: " + toBinary(n));
		
	}
	
	/**
	 * @purpose converts decimal number to binary number
	 * @param num / decimal number
	 */
	public static void toBinary1(int num)
	{
		if(num > 0)
		{
			int count = 0, binnum = 0, temp = num, temp1 = num;
			while(temp != 0)
			{
				count = 0;
				while(temp != 1)
				{
					temp = temp / 2;
					count++;
				}
				
				binnum = (int) (binnum + Math.pow(10, count));
				temp = (int) (temp1 - Math.pow(2, count));
				temp1 = temp;
				
				//System.out.println("binnum: " + binnum + "\ntemp: " + temp + "\ntemp1:" + temp1);
			}
			System.out.println("The binary number is: " + binnum);
		}
		else
		{
			System.out.println("enter numbers greater than zero");
			int n = UtilityMethods.input("enter the number again: ");
			toBinary1(n);
		}
	}
	
	// another method to convert decimal to binary
	public static int toBinary(int num)
	{	
		String binary = "";
		while(num != 1)
		{
			if(num % 2 == 0)
			{
				binary = "0" + binary ;
			}
			else
			{
				binary = "1" + binary ;;
			}
			num = num / 2;
			//System.out.println(num);
		}
		
		binary = "1" + binary ;
		int binaryNum = Integer.parseInt(binary);
		
		return binaryNum;
	}
}
