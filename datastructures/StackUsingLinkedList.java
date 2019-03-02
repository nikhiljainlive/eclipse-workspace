package datastructures;

import datastructures.LinkedList.*;

/**
 * @purpose Class declaration of stack abstract data type implemented using Linked List
 * @author Nikhil Jain
 * @version 1.0
 */
public class StackUsingLinkedList
{
	Node root = null;
	Node top = root;
	public static LinkedList linkL = new LinkedList();
	
	/**
	 * @purpose returns true if stack is empty else returns false
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
	 * @purpose pushes the string
	 * @param item
	 */
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
	
	/**
	 * @purpose pops the string element
	 * @return String // element popped
	 */
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
			String topData = top.element;
			p.link = null;
			top = p;
			
			return topData;
		}
	}
	
	/**
	 * @purpose shows the element
	 * @return void 
	 */
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
				System.out.println(p.element);
				p = p.link;
			}
		}
	}
	
	/**
	 * @purpose returns the front element
	 * @return String
	 */
	public String peek()
	{
		return top.element;
	}
	
	/**
	 * @purpose returns the total number of elements in stack
	 * @return int
	 */
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
