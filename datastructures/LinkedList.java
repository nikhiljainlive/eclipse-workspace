package datastructures;

import datastructures.Week.WeekDay;

public class LinkedList 
{
	public static class Node 
	{
		public String data;
		public Node link;
		WeekDay weekday;
		
		// constructor
		public Node (String d)
		{
			data = d;
			link = null; 								// link of node will be null by default
		}

		public Node(WeekDay wd)
		{
			weekday = wd;
		}
		
	}
	
	public Node root;
	
	public boolean isEmpty()
	{
		if(root == null)
		{
			return true;
		}
		return false;
	}
	
	// insert the new string to linked list
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
	
	// displays the list
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
				System.out.print(p.data + " ");
				p = p.link;
			}
			System.out.println();
		}
	}
	
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
			while(p.data.compareTo(key) != 0)
			{
				if(p.link == null)
				{
					break;
				}
				p = p.link;
			}
			if(p.data.compareTo(key) == 0)
			{
				return true;
			}	
		}
		return false;
	}
	
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
			while(p.data.compareTo(key) != 0)
			{
				p = p.link;
				count++;
				if(p.link == null)
				{
					break;
				}
			}
			
			if(p.data.compareTo(key) == 0)
			{
				System.out.println("Element found at node " + count );
				if(count == 1)
				{
					root = p.link;
					p.link = null;
					System.out.println("Element deleted: " + p.data);
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
					System.out.println("\nElement deleted: " + p.data);
					count--;
				}//end of inner-most if-else
			}//end of inner if block
		}//end of outer if-else
	}
	
	public String toString()
	{
		Node p;
		p = root;
		String s = "";
		while(p != null)
		{
			s = s + p.data + " ";
			p = p.link;
		}
		return s;
	}
	
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
					int jNum = Integer.parseInt(j.data);
					int jNextNum = Integer.parseInt(j.link.data), temp;
					if(jNum > jNextNum)						
					{
						temp = jNum;					
						jNum = jNextNum;					
						jNextNum = temp;								
					}
					j.data = String.valueOf(jNum);
					j.link.data = String.valueOf(jNextNum);
					
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
