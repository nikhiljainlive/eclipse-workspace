package algorithmprograms;

/**
 * @purpose class declaration of calculating monthly payment program
 * @author Nikhil Jain
 * @version 1.0
 */
public class MonthlyPayment 
{
	/**
	 * @purpose main method to print payment
	 * @param p, y and r / command line args
	 */
	public static void main(String[] args)										
	{
		try
		{
			double p = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			double r = Double.parseDouble(args[2]);
			
			if (p > 0 && y > 0 && r > 0 && args.length == 3 && p > y && p > r)
			{
				//System.out.println("in");
				System.out.println("Payment is " + calculatePayment(p, y, r));	
			}
			else
			{
				System.out.println("invalid input.. try again");
				System.out.println("value of p should be greater than y and r");
			}
		}
		catch(NumberFormatException e)														// if input is other than integer
		{
			System.out.println("only number input allowed.. try again");
		}
		catch(ArrayIndexOutOfBoundsException e)												// if input is other than integer
		{
			System.out.println("entered arguments should be 3.. try again");
		}
		catch(Exception e)																	// handles all other exceptions
		{
			System.out.println("in");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @purpose calculates payment
	 * @param loan (double)
	 * @param years (double)
	 * @param rate (double)
	 * @return payment (double)
	 */
	public static double calculatePayment(double loan, double years, double rate)
	{
		double n = 12 * years, r = (rate / (12 * 100)), power = Math.pow((1+ r), (-n));
		double payment = (loan * r) / (1 - power);
		
		payment = Math.round(payment * 1000);
		payment = payment / 1000;
		return payment;
	}
}
