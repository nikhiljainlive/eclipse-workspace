package datastructures;

import datastructures.LinkedList.*;

public class StackUsingLinkedList
{
	Node root = null;
	Node top = root;
	public static LinkedList linkL = new LinkedList();
	
	public boolean isEmpty()
	{
		if(root == null)
		{
			return true;
		}
		return false;
	}
	
	// pushes the string
	public void push(String item)
	{
		Node temp = new Node(item);
		if(isEmpty())
		{
			root = temp;
		}
		else
		{
			Node p = root;
			while(p.link != null)
			{
				p = p.link;
			}
			p.link = temp;
			top = p.link;
		}
	}
	
	// pops the string element
	public String pop()
	{
		if(isEmpty())
		{
			return "stack underflow";
		}
		else
		{
			Node p = root;
			while(p.link != top)
			{
				if(p.link == null)
				{
					break;
				}
				p = p.link;
			}
			String topData = top.data;
			p.link = null;
			top = p;
			
			return topData;
		}
	}
	
	// shows the element
	public void show()
	{
		if(isEmpty())
		{
			System.out.println("stack is underflow");
		}
		else
		{
			Node p = root;
			while(p != null)
			{
				System.out.println(p.data);
				p = p.link;
			}
		}
	}
	
	// shows the front data
	public String peek()
	{
		return top.data;
	}
	
	public int size()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			int length = 0;
			Node temp = root;
			while(temp.link != null)
			{
				length++;
				temp = temp.link;
			}
			
			return length;
		}
	}
}
