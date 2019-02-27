package datastructures;

public class StackUsingArray 
{
	char[] stack = new char[10];
	int top = -1;
	
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFull()
	{
		if(top == stack.length-1 )
		{
			return true;
		}
		return false;
	}
	
	public void push(char item)
	{
		if(isFull())
		{
			System.out.println("Stack overflow");
		}
		else
		{
			top++;
			stack[top] = item;
		}
	}
	
	public void pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
		}
		else
		{
			//System.out.println("Element popped" + stack[top]);
			top--;
		}
	}
	
	public char peek()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			return stack[top];
		}
	}
	
	public int size()
	{
		int count = 0;
		
		for(int i = 0; i <= top; i++)
		{
			count++;
		}
		
		return count;
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("stack is empty.. no elements to display");
		}
		else
		{
			for(int i = 0; i < size(); i++)
			{
				System.out.println(stack[i] + " ");
			}
		}
	}
}
