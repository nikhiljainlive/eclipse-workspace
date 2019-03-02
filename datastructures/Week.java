package datastructures;

import datastructures.LinkedList.Node;

/**
 * @purpose class declaration of week class for displaying calendar through stack and queue
 * @author Nikhil Jain
 * @version 1.0
 */
public class Week 
{
	public static QueueUsingLinkedList linkL = new QueueUsingLinkedList();
	public static datastructures.LinkedList.Node root = null;
	
	/**
	 * @purpose WeekDay class structure for calendar
	 * @author Nikhil Jain
	 * @version 1.0
	 */
	public static class WeekDay
	{
		String day;
		String date;
		Node link;
		
		// constructor with arguments
		public WeekDay(String dy, String dt)
		{
			day = dy;
			date = dt;
			link = null;
		}
		
		// getter method to return date
		public String getDate()
		{
			return date;
		}
	}
}