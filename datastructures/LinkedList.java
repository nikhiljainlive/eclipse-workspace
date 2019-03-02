package datastructures;

import datastructures.Week.WeekDay;

/**
 * @purpose class declaration of Linked List Abstract data type
 * @author Nikhil Jain
 * @version 1.0
 */
public class LinkedList 
{
	/**
	 * @purpose creating node structure of linked list
	 * @author Nikhil Jain
	 * @version 1.0
	 */
	
	public static class Node
	{
		public WeekDay weekday;
		public String element;
		private int amount;
		public String day;
		public String date;
		public Node link;
		
		public Node(String p, int a)
		{
			element = p;
			amount = a;
			link = null;
		}
		
		public Node(String p)
		{
			element = p;
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
	
	// creating root node
	public Node root;
	
	/**
	 * @purpose returns true if linked list is empty else returns false
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if(root == null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @purpose adds new node to the linked list
	 * @param data  // element to be inserted in the node
	 * @return void
	 */
	public void add(String data)
	{
		Node temp = new Node(data);
		if(isEmpty())
		{
			root = temp;
		}
		else
		{
			Node p;
			p = root;
			while(p.link != null)
			{
				p = p.link;
			}
			p.link = temp;
		}
	}
	
	/**
	 * @purpose displays the list
	 * @return void
	 */
	public void displayList()
	{
		if(isEmpty())
		{
			System.out.println("None");
		}
		else
		{
			Node p;
			p =root;
			while(p != null)
			{
				System.out.print(p.element + " ");
				p = p.link;
			}
			System.out.println();
		}
	}
	
	/**
	 * @purpose searches the specified element
	 * 			returns true if element is found else returns false
	 * @param key
	 * @return boolean
	 */
	public boolean search(String key)
	{
		if(isEmpty())
		{
			return false;
		}
		else
		{
			Node p;
			p = root;
			while(p.element.compareTo(key) != 0)
			{
				if(p.link == null)
				{
					break;
				}
				p = p.link;
			}
			if(p.element.compareTo(key) == 0)
			{
				return true;
			}	
		}
		return false;
	}
	
	/**
	 * @purpose removes the specified element from the linked list
	 * @param key
	 * @return void
	 */
	public void remove(String key)
	{
		if(isEmpty())
		{
			System.out.println("can not delete empty list");
		}
		else
		{
			Node p,q;
			p = root; q = root;
			int count = 1;
			while(p.element.compareTo(key) != 0)
			{
				p = p.link;
				count++;
				if(p.link == null)
				{
					break;
				}
			}
			
			if(p.element.compareTo(key) == 0)
			{
				System.out.println("Element found at node " + count );
				if(count == 1)
				{
					root = p.link;
					p.link = null;
					System.out.println("Element deleted: " + p.element);
					count--;
				}
				else
				{
					while(q.link != p)
					{
						q = q.link;
					}
					q.link = p.link;
					p.link = null;
					System.out.println("\nElement deleted: " + p.element);
					count--;
				}//end of inner-most if-else
			}//end of inner if block
		}//end of outer if-else
	}
	
	/**
	 * @purpose appends the elements of linked list to string
	 * @return String
	 */
	public String toString()
	{
		Node p;
		p = root;
		String s = "";
		while(p != null)
		{
			s = s + p.element + " ";
			p = p.link;
		}
		return s;
	}
	
	/**
	 * @purpose sorts the elements of linked list and makes list ordered
	 * @return void
	 */
	public void sortElements()
	{
		if(isEmpty())
		{
			System.out.println("can not sort empty list");
		}
		else
		{
			Node i, j;
			i = root;
			while(i != null)
			{
				 j = root;
				while(j.link != null)
				{
					int jNum = Integer.parseInt(j.element);
					int jNextNum = Integer.parseInt(j.link.element), temp;
					if(jNum > jNextNum)						
					{
						temp = jNum;					
						jNum = jNextNum;					
						jNextNum = temp;								
					}
					j.element = String.valueOf(jNum);
					j.link.element = String.valueOf(jNextNum);
					
					j = j.link;
				}//end of inner while loop
				i = i.link;
				
				if(i == null)
				{
					break;
				}
			}//end of outer while loop
		}//end of outer if-else
	}
}
