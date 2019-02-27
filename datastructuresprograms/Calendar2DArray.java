package datastructuresprograms;

import utility.UtilityMethods;

public class Calendar2DArray
{
	public static void main(String[] args)
	{
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int days = 31;
		if(m == 2 && UtilityMethods.isLeapYear(y))
		{
			days = 29;
		}
		else if(m == 2)
		{
			days = 28;
		}
		
		if(m == 4 || m == 6 || m == 9 || m == 11)
		{
			days = 30;
		}
		
		String[][] cal = new String[6][7];
		int startDay = UtilityMethods.dayOfWeek(m, 1, y);
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
		
		String [] month = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		System.out.println("% java Calendar " + m + " " + y);
		System.out.println(month[m] + " " + y);
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
