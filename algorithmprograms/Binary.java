package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose class declaration of swap nibbles in a  byte program
 * @author Nikhil Jain
 * @version 1.0
 */
public class Binary
{ 
	/**
	 * @purpose takes number from user and shifts the nibbles to opposite side by 4 digits
	 * @param x
	 * @return
	 */
	public static int swapNibbles(int x)
	{
		return((x & 0x0F) << 4 | (x & 0xF0) >> 4);							// 0x0F is 0000 1111 and 0xF0 is 1111 0000
	}
	
	/**
	 * @purpose displays swapped nibbles in a binary number
	 */
	public static void swapBinaryNum()
	{
		try 
		{
			int num = UtilityMethods.inputInt("enter number: ");
			if(num > 0)
			{
				int binnum = BinaryConversion.toBinary(num);
				System.out.println("To Binary: " + binnum);
				System.out.println("After swapping nibbles: " + swapNibbles(num));
				System.out.println("To Binary(swapped): " + BinaryConversion.toBinary(swapNibbles(num)));
			}
			else
			{
				System.out.println("number should be greater than zero.. try again");
			}
		}
		catch(NumberFormatException e)												// if user input is other than integer
		{
			System.out.println("only number input is allowed.. try again");
		}
		catch(Exception e)															// handles all other exceptions
		{
			System.out.println(e.getMessage());
		}
	}
}
