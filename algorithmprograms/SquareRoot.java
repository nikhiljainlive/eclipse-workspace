package algorithmprograms;

import utility.UtilityMethods;

/**
 * @purpose calss declaration for finding square root by Newton method
 * @author Nikhil Jain
 * @version 1.0
 */
public class SquareRoot 
{
	/**
	 * @purpose calculates square root by Newton method
	 */
	public static void sqrt()
	{
		double c = UtilityMethods.input("enter num: ");
		double epsilon = 3.05902321E-7 ;
		double t = -c;
		
		while((Math.abs(t - (c/t))) > (epsilon*t))
		{
			t = (t - (c/ t)) / 2.0;
		}
		
		System.out.println(t);
	}
}
