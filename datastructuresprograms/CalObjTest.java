//package datastructuresprograms;
//
//import datastructures.QueueUsingLinkedList;
//import datastructures.WkClassTest;
//import datastructures.WkClassTest.WeekDay;
//import utility.UtilityMethods;
//
//public class CalObjTest 
//{
//	public static QueueUsingLinkedList queue = new QueueUsingLinkedList();
//	
//	public static void main(String[] args)
//	{
//		int m = Integer.parseInt(args[0]);
//		int y = Integer.parseInt(args[1]);
//		String [] monthString = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//		String[] daysString = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
//		int days = 31;
//		if(m == 2 && UtilityMethods.isLeapYear(y))
//		{
//			days = 29;
//		}
//		else if(m == 2)
//		{
//			days = 28;
//		}
//		
//		if(m == 4 || m == 6 || m == 9 || m == 11)
//		{
//			days = 30;
//		}
//		
//		WkClassTest week = new WkClassTest();
//		WeekDay weekObj = new WeekDay();
//		int startDay = UtilityMethods.dayOfWeek(m, 1, y);
//		int k = 1;
//		for(int i = 0; i < 42; i++)
//		{
//			if(i < startDay)
//			{
//				queue.enQueueObj(weekObj.addWeekDay(daysString[i], " "));
//			}
//			else if(i >= startDay && i < days+startDay)
//			{
//				String d = Integer.toString(k);
//				queue.enQueueObj(weekObj.addWeekDay(daysString[i%7], d));
//				k++;
//			}
//			else
//			{
//				queue.enQueueObj(weekObj.addWeekDay(daysString[i%7], " "));
//			}
//		}
//		
//		queue.enQueueObj(week);
//		System.out.println("Calendar using Queue!\n");
//		System.out.println(monthString[m] + " " + y);
//		System.out.println("S   M   T   W   Th  F   S");
//		week.displayWeekDay();
//
//	}
//}
