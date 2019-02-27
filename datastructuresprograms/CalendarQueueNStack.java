package datastructuresprograms;

import datastructures.QueueUsingLinkedList;
import datastructures.StackUsingLinkedList;
import datastructures.Week.WeekDay;
import utility.UtilityMethods;

public class CalendarQueueNStack 
{
	public static QueueUsingLinkedList queue = new QueueUsingLinkedList();
	public static String [] monthString = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static String[] daysString = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	
	public static int getDays(int month, int year)
	{
		int days = 31;
		if(month == 2 && UtilityMethods.isLeapYear(year))
		{
			days = 29;
		}
		else if(month == 2)
		{
			days = 28;
		}
		
		if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			days = 30;
		}
		
		return days;
	}
	
	// prints calendar through queue
	public static void printViaQueue(int m, int y, int noOfDays)
	{
		int startDay = UtilityMethods.dayOfWeek(m, 1, y);
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
		System.out.println("\t" + monthString[m] + " " + y + "\n");
		System.out.println("S   M   T   W   Th  F   S");
		queue.showWeekDay();
	}
	
	// prints calendar through stack
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
	
	// main method
	public static void main(String[] args)
	{
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int noOfDays = getDays(m, y);
		
		printViaQueue(m, y, noOfDays);
		printViaStack(m, y);
	}
		
}

