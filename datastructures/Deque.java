package datastructures;

public class Deque
{
	public static int capacity = 100;
	public static String[] deQue = new String[capacity];
	public static int front = -1, rear = -1;
	
	public boolean isEmpty()
	{
		if(front == -1 && rear == -1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFull()
	{
		if(rear == deQue.length)
		{
			return true;
		}
		return false;
	}
	
	public void addFront(String item)
	{
		if(isFull())
		{
			System.out.println("deque is full");
		}
		else
		{
			if(isEmpty())
			{
				front++;
				deQue[front] = item;
				rear++;
			}
			else
			{
				for(int i = rear+1; i >= front; i--)
				{
					deQue[i+1] = deQue[i];
				}
				deQue[front] = item;
				rear++;
			}
		}
	}
	
	public void addRear(String item)
	{
		if(isFull())
		{
			System.out.println("deque is full");
		}
		else
		{
			if(isEmpty())
			{
				front++;
				rear++;
				deQue[rear] = item;
			}
			else
			{
				rear++;
				deQue[rear] = item;	
			}
			
		}
	}
	
	public String removeRear()
	{
		if(isEmpty())
		{
			return "deque is empty";
		}
		else
		{
			String rearElement = deQue[rear];
			rear--;
			if(front > rear)
			{
				front = -1;
				rear = -1;
			}
			return rearElement;
		}
	}
	
	public String removeFront()
	{
		if(isEmpty())
		{
			return "deque is empty";
		}
		else
		{
			String frontElement = deQue[front];
			front++;
			if(front > rear)
			{
				front = -1;
				rear = -1;
			}
			
			return frontElement;
		}
	}
	
	public void show()
	{
		if(isEmpty())
		{
			System.out.println("deque is empty");
		}
		else
		{
			for(int i = front; i <= rear; i++)
			{
				System.out.println(deQue[i]);
			}
		}
	}
	
	public int size()
	{
		if(isEmpty())
		{
			return 0;	
		}
		else
		{
			int length = rear - front +1;
			
			return length;
		}
	}
	
	public String toString()
	{
		String result = "";
		result = "";
		for(int i = front; i <= rear; i++)
		{
			result = result + deQue[i];
		}
		
		return result;
	}
}
