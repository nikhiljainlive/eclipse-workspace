package datastructuresprograms;

import datastructures.QueueUsingLinkedList;
import datastructures.StackUsingLinkedList;
import datastructures.Week.WeekDay;
import utility.DataStructuresUtility;
import utility.UtilityMethods;

/**
 * @purpose class declaration of displaying calendar using stack and queue
 * @author Nikhil Jain
 * @version 1.0
 */
public class CalendarQueueNStack 
{
	public static QueueUsingLinkedList queue = new QueueUsingLinkedList();
	public static String [] monthString = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static String[] daysString = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	
	/**
	 * @purpose prints calendar through queue
	 * @param month
	 * @param year
	 * @param noOfDays
	 */
	public static void printViaQueue(int month, int year, int noOfDays)
	{
		int startDay = UtilityMethods.dayOfWeek(month, 1, year);
		int k = 1;
		for(int i = 0; i < 42; i++)
		{
			if(i < startDay)
			{
				WeekDay weekObj = new WeekDay(daysString[i], " ");
				queue.enQueueWeekDay(weekObj);
			}
			else if(i >= startDay && i < noOfDays+startDay)
			{
				String d = Integer.toString(k);
				WeekDay weekObj = new WeekDay(daysString[i%7], d);
				queue.enQueueWeekDay(weekObj);
				k++;
			}
			else
			{
				WeekDay weekObj = new WeekDay(daysString[i%7], " ");
				queue.enQueueWeekDay(weekObj);
			}
		}
		
		// printing calendar from queue
		System.out.println("__________________________\n\nCalendar using Queue!\n__________________________\n");
		System.out.println("\t" + monthString[month] + " " + year + "\n");
		System.out.println("S   M   T   W   Th  F   S");
		queue.showWeekDay();
	}
	
	/**
	 * @purpose prints the calendar through stack
	 * @param month
	 * @param year
	 */
	public static void printViaStack(int month, int year)
	{
		// creating 2 stacks
		StackUsingLinkedList stack1 = new StackUsingLinkedList();
		StackUsingLinkedList stack2 = new StackUsingLinkedList();
		
		// pushing elements into stack 1
		for(int i = 0; i < 42; i++)
		{
			stack1.push(queue.deQueueWeekDay());
		}

		// popping elements from stack 1 and pushing them into stack 2
		for(int i = 0; i < 42; i++)
		{
			stack2.push(stack1.pop());
		}
		
		// popping the elements and printing Calendar from stack
		System.out.println("__________________________\n\nCalendar using Stack!\n__________________________\n");
		System.out.println("\t" + monthString[month] + " " + year + "\n");
		System.out.println("S   M   T   W   Th  F   S");
		int count = 0;												
		for(int i = 0; i < 42; i++)									
		{
			count++;
			if(stack2.peek().hashCode() < "10".hashCode())
			{
				System.out.print(stack2.pop() + "   ");			
			}
			else
			{
				System.out.print(stack2.pop() + "  ");		
			}
			
			if(count % 7 == 0)
			{
				System.out.println();
			}
		}
	}
	
	/**
	 * @purpose main method to display calendar
	 * @param args
	 */
	public static void main(String[] args)
	{
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int noOfDays = DataStructuresUtility.getDays(m, y);
		
		printViaQueue(m, y, noOfDays);
		printViaStack(m, y);
	}
}