package datastructuresinterface;

import datastructures.*;

public class LinkedList 
{
	Node root;
	
	// insert the new string to linked list
	public void insert(String data)
	{
		Node temp = new Node(data);
		if(root == null)
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
		Node p;
		p =root;
		while(p != null)
		{
			System.out.print(p.data + " ");
			p = p.link;
		}
		System.out.println();
	}
	
	public boolean isWordPresent(String key)
	{
		Node p;
		p = root;
		while(p.data.compareTo(key) != 0)
		{
			p = p.link;
			if(p.link == null)
			{
				break;
			}
		}
		if(p.data.compareTo(key) == 0)
		{
			return true;
		}
		return false;
	}
	
	public void delete(String key)
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
			System.out.println("Word found at node " + count );
			if(count == 1)
			{
				root = p.link;
				p.link = null;
				System.out.println("\nWord deleted: " + p.data);
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
				System.out.println("\nWord deleted: " + p.data);
				count--;
			}
		}
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
	
	//
	/*public void searchDeleteList(String key)
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
			System.out.println("Word found at node " + count );
			if(count == 1)
			{
				root = p.link;
				p.link = null;
				System.out.println("\nWord deleted: " + p.data);
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
				System.out.println("\nWord deleted: " + p.data);
				count--;
			}
		}
		else
		{
			count++;
			System.out.println("Word not found but added at node " + count);
			insert(key);
		}
	}*/
}
