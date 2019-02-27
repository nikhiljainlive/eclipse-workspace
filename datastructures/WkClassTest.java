//package datastructures;
//
//import datastructures.QueueUsingLinkedList.Node;
//
//public class WkClassTest 
//{
//	public static QueueUsingLinkedList linkL = new QueueUsingLinkedList();
//	public static Node root = null;
//	
//	public static class WeekDay
//	{
//		String day;
//		String date;
//		Node link;
//		
//		// constructor with arguments
//		public WeekDay(String dy, String dt)
//		{
//			day = dy;
//			date = dt;
//			link = null;
//		}
//		
//		// empty constructor 
//		public WeekDay()
//		{
//			link = null;
//		}
//		
//		public static boolean isEmpty()
//		{
//			if(root == null)
//			{
//				return true;
//			}
//			
//			return false;
//		}
//		
//		public Object addWeekDay(String day, String date)
//		{
//			Node temp = new Node(day,date);
//			if(isEmpty())
//			{
//				root = temp;
//			}
//			else
//			{
//				Node p = root;
//				while(p.link != null)
//				{
//					p = p.link;
//				}
//				p.link = temp;
//			}
//			return temp;
//		}
//		
//		public int size()
//		{
//			if(isEmpty())
//			{
//				return 0;
//			}
//			else
//			{
//				Node p = root;
//				int count = 0;
//				while(p.link != null)
//				{
//					count++;
//					p = p.link;
//				}
//				return count;
//			}
//			
//		}
//		
//		public String removeWeekDay()
//		{
//			if(isEmpty())
//			{
//				return "no week days added";
//			}
//			else
//			{
//				Node p = root;
//				while(p.link != null)
//				{
//					p = p.link;
//				}
//				String day = p.date;
//				p = root;
//				for(int i = 1; i < size(); i++)
//				{
//					p = p.link;
//				}
//				p.link = null;
//				
//				return day;
//			}
//		}
//	}
//	
//	public void displayWeekDay()
//	{
//		if(WeekDay.isEmpty())
//		{
//			System.out.println("weekdays list is empty");
//		}
//		else
//		{
//			int count = 0;
//			Node p = root;
//			while(p != null)
//			{
//				count++;
//				if(p.date.hashCode() < "10".hashCode())
//				{
//					System.out.print(p.date + "   ");			// + "(" + p.day + ")"
//				}
//				else
//				{
//					System.out.print(p.date + "  ");			// + "(" + p.day + ")"
//				}
//				
//				if(count % 7 == 0)
//				{
//					System.out.println();
//				}
//				p = p.link;
//			}
//		}
//	}
//}


// methods which can be added in queue for this program

		//	Object wk;
//		public Node(Object w) //constructor
//		{
//			wk = w;
//		}

	
//	public void enQueueObj(Object w)
//	{
//		Node temp = new Node(w);
//		if(isEmpty())
//		{
//			front = temp;
//			rear = temp;
//		}
//		else
//		{
//			rear.link = temp;
//			rear = temp;
//		}	
//	}

	
//	public void deQueueWeek()
//	{
//		if(isEmpty())
//		{
//			System.out.println("queue is empty");
//		}
//		else
//		{
//			front = front.link;
//			
//			if(front == rear.link)
//			{
//				front = null;
//				rear = null;
//			}
//		}
//	}

//	public void showWeekObj()
//	{
//		if(isEmpty())
//		{
//			System.out.println("\nqueue is empty");
//		}
//		else
//		{
//			Node temp = front;
//			while(temp != null)
//			{
//				System.out.println("\n" + temp.wk);
//				//System.out.println(temp.date);
//				temp = temp.link;
//			}	
//		}
//	}
	
