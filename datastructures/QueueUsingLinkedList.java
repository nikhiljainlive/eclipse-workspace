package datastructures;

import datastructures.LinkedList.Node;
import datastructures.Week.WeekDay;

/**
 * @purpose class declaration of Queue Abstract Data Type
 * 			implemented using linked list
 * @author Nikhil Jain
 * @version 1.0
 */
public class QueueUsingLinkedList
{
	
	
	// static node objects - front and rear assigned as null
	public static Node front = null;
	public static Node rear = null;
	
	/**
	 * @purpose returns true if queue is empty else returns false
	 * @return boolean
	 */
	public static boolean isEmpty()
	{
		if(front == null && rear == null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @purpose enqueues the element
	 * @param p	// String value
	 * @param a	// int value
	 */
	public static void enQueue(String p, int a)
	{
		Node temp = new Node(p, a);
		if(isEmpty())
		{
			front = temp;
			rear = temp;
		}
		else
		{
			rear.link = temp;
			rear = temp;
		}	
	}
	
	/**
	 * @purpose enqueues the element
	 * @param p // String
	 */
	public static void enQueue(String p)
	{
		Node temp = new Node(p);
		if(isEmpty())
		{
			front = temp;
			rear = temp;
		}
		else
		{
			rear.link = temp;
			rear = temp;
		}
	}
	
	/**
	 * @purpose dequeues the element
	 * @return String // element dequeued
	 */
	public static String deQueue()
	{
		if(isEmpty())
		{
			return "queue is empty";
		}
		else
		{
			String temp = front.element;
			front = front.link;
			
			if(front == rear.link)
			{
				front = null;
				rear = null;
			}
			return temp;
		}
	}
	
	/**
	 * @purpose displays the total elements in queue
	 * @return void
	 */
	public static void show()
	{
		if(isEmpty())
		{
			System.out.println("\nqueue is empty");
		}
		else
		{
			Node temp = front;
			while(temp != null)
			{
				System.out.println("\n" + temp.element);
				System.out.println(temp.getAmount());
				temp = temp.link;
			}	
		}
	}
	
	/**
	 * @purpose calculates the size of queue
	 * @return int
	 */
	public static int size()
	{
		Node temp;
		temp = front;
		int count = 0;
		while(temp != null)
		{
			count++;
			temp = temp.link;
		}
		
		return count;
	}
	
	/**
	 * @purpose displays the front element in the queue
	 * @return String
	 */
	public static String front()
	{
		if(isEmpty())
		{
			String s = "queue is empty!";
			return s;
		}
		return front.element;
	}
	
	/**
	 * @purpose enqueues the WeekDay object to queue
	 * @param wd // object of WeekDay class
	 */
	public void enQueueWeekDay(WeekDay wd)
	{
		Node temp = new Node(wd);
		if(isEmpty())
		{
			front = temp;
			rear = temp;
		}
		else
		{
			rear.link = temp;
			rear = temp;
		}
			
	}
	
	/**
	 * @purpose dequeues the WeekDay object
	 * @return String // date variable of WeekDay object
	 */
	public String deQueueWeekDay()
	{
		if(isEmpty())
		{
			return "queue is empty";
		}
		else
		{
			String weekd = front.weekday.getDate();
			front = front.link;
			
			if(front == rear.link)
			{
				front = null;
				rear = null;
			}
			return weekd;
		}
	}
	
	/**
	 * @purpose displays the Calendar
	 * @return void
	 */
	public void showWeekDay()
	{
		if(isEmpty())
		{
			System.out.println("\nqueue is empty");
		}
		else
		{
			int count = 0;
			Node p = front;
			while(p != rear)
			{
				count++;
				if(p.weekday.getDate().hashCode() < "10".hashCode())
				{
					System.out.print(p.weekday.getDate() + "   ");			
				}
				else
				{
					System.out.print(p.weekday.getDate() + "  ");		
				}
				
				if(count % 7 == 0)
				{
					System.out.println();
				}
				p = p.link;
			}
			
			System.out.println();
		}
	}
}
