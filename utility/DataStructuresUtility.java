package utility;

public class DataStructuresUtility
{
	public static String[][] primeNum = new String[10][30];
	//public static QueueUsingLinkedList queue = new QueueUsingLinkedList();
	
	public static String[][] primeNum()
	{
		for(int i = 0; i < 10; i++)
		{
			String s = UtilityMethods.getPrimeNumbers(multiply(i, 100), multiply(i+1, 100));
			String[] strA = s.split(" ");
			for(int j = 0; j < strA.length; j++)
			{
				primeNum[i][j] = strA[j];
			}																				
		}
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 30; j++)
			{
				if(primeNum[i][j] == null)
				{
					primeNum[i][j] = " ";
				}
			}
		}
		
		return primeNum;
	}
	
	public static int multiply(int num1, int num2)
	{
		return num1*num2;
	}
	
	public static void sortString(String[] sArray)
	{
		String temp;
		for(int i =0; i < sArray.length - 1; i++)
		{	
			for(int j = 0; j < sArray.length - 1; j++)
			{
				if (sArray[j].hashCode() > sArray[j + 1].hashCode())
				{
					temp = sArray[j];
					sArray[j] = sArray[j + 1];
					sArray[j + 1] = temp;
				}
			}
		}
	}
}
