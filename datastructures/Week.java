package datastructures;

import datastructures.QueueUsingLinkedList.Node;

public class Week 
{
	public static QueueUsingLinkedList linkL = new QueueUsingLinkedList();
	public static Node root = null;
	
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
		
		public String getDate()
		{
			return date;
		}
	}
}