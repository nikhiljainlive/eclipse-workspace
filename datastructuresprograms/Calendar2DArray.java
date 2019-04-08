package datastructuresprograms;

import utility.DataStructuresUtility;
import utility.UtilityMethods;

/**
 * @purpose class declaration for printing calendar from 2D Array
 * @author Nikhil Jain
 * @version 1.0
 */
public class Calendar2DArray
{
	// declaring a 2D string array
	public static String[][] cal = new String[6][7];
	
	/**
	 * @purpose main method to display Calendar through 2D Array
	 * @param args
	 */
	public static void main(String[] args)
	{
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		fillDatesinArray(m, y);
		printCalendar2DArray(m, y);
	}
	
	/**
	 * @purpose fills the dates of calendar in 2D Array
	 * @param month
	 * @param year
	 */
	public static void fillDatesinArray(int month, int year)
	{	
		int days = DataStructuresUtility.getDays(month, year);
		int startDay = UtilityMethods.dayOfWeek(month, 1, year);
		int k = 1, i = 0;
		
		for(int j = 0; j < cal[0].length; j++)
		{
			if(j < startDay)
			{
				cal[i][j] = " ";
			}
			else
			{
				cal[i][j] = Integer.toString((k));
				k++;	
			}	
		}
		i++;
			
		while(i < cal.length)
		{
			for(int j = 0; j < cal[0].length; j++)
			{
				if(k <= days)
				{
					cal[i][j] = Integer.toString((k));
					k++;
				}
				else
				{
					cal[i][j] = " ";
				}
			}
			
			i++;
		}	
	}
	
	/**
	 * @purpose prints the calendar through 2D Array
	 * @param month
	 * @param year
	 */
	public static void printCalendar2DArray(int month, int year)
	{
		String [] monthArray = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		System.out.println("% java Calendar " + month + " " + year);
		System.out.println(monthArray[month] + " " + year);
		System.out.println("S   M   T   W   Th  F   S");
		for(int l = 0; l < cal.length; l++)
		{
			for(int n = 0; n < cal[0].length; n++)
			{
				if(Integer.parseInt(cal[l][n].replaceAll(" ", "0")) < 10)
				{
					System.out.print(cal[l][n] + "   ");
			
				}
				else
				{
					System.out.print(cal[l][n] + "  ");
				}
			}
			
			System.out.println();
		}
	}
}
