package datastructures;

import datastructures.Week.WeekDay;

public class QueueUsingLinkedList
{
	public static class Node
	{
		WeekDay weekday;
		String person;
		private int amount;
		String day;
		String date;
		Node link;
		
		public Node(String p, int a)
		{
			person = p;
			amount = a;
			link = null;
		}
		
		public Node(String p)
		{
			person = p;
			link = null;
		}
				
		public Node (String d1, String d2)
		{
			day = d1;
			date = d2;
			link = null;
		}
		
		public Node(WeekDay wd)
		{
			weekday = wd;
		}
		
		public int getAmount()
		{
			return amount;
		}
	}
	
	public Node front = null;
	public Node rear = null;
	
	public boolean isEmpty()
	{
		if(front == null && rear == null)
		{
			return true;
		}
		return false;
	}
	
	public void enQueue(String p, int a)
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
	
	public void enQueue(String p)
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
	
	public String deQueue()
	{
		if(isEmpty())
		{
			return "queue is empty";
		}
		else
		{
			String temp = front.person;
			front = front.link;
			
			if(front == rear.link)
			{
				front = null;
				rear = null;
			}
			return temp;
		}
	}
	
	public void show()
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
				System.out.println("\n" + temp.person);
				System.out.println(temp.amount);
				temp = temp.link;
			}	
		}
	}
	
	public int size()
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
	
	public String front()
	{
		if(isEmpty())
		{
			String s = "queue is empty!";
			return s;
		}
		return front.person;
	}
	
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
