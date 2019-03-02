package datastructures;

/**
 * @purpose class declaration of Stack Abstract data type implemented using array
 * @author Nikhil Jain
 * @version 1.0
 */
public class StackUsingArray 
{
	char[] stack = new char[10];						// declaring array
	int top = -1;			
	
	/**
	 * @purpose returns true if stack is empty else returns false
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @purpose returns true if stack is full else returns false
	 * @return boolean
	 */
	public boolean isFull()
	{
		if(top == stack.length-1 )
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @purpose pushes the element to stack
	 * @param item
	 */
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
	
	/**
	 * @purpose pops the element from the queue
	 * @return void
	 */
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
	
	/**
	 * @purpose returns the top element in the queue
	 * @return char
	 */
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
	
	/**
	 * @purpose returns the total number of elements in stack
	 * @return int
	 */
	public int size()
	{
		int count = 0;
		
		for(int i = 0; i <= top; i++)
		{
			count++;
		}
		
		return count;
	}
	
	/**
	 * @purpose displays the elements in stack
	 * @return void
	 */
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
