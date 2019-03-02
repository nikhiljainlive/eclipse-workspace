package datastructures;

/**
 * @purpose class declaration for Deque Abstract data Type
 * @author Nikhil Jain
 * @version 1.0
 */
public class Deque
{
	/* static variables - capacity of queue
	 * 					- declaration of String array for deque
	 * 					- defining value of front and rear of deque as -1
	 */ 
	public static int capacity = 100;
	public static String[] deQue = new String[capacity];
	public static int front = -1, rear = -1;
	
	/**
	 * @purpose returns true if deque is empty else returns false
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if(front == -1 && rear == -1)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @purpose returns true if queue is full else returns false
	 * @return boolean
	 */
	public boolean isFull()
	{
		if(rear == deQue.length)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @purpose adds the element from front
	 * @param item
	 * @return void
	 */
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
	
	/**
	 * @purpose adds the element from rear
	 * @param item
	 * @return void
	 */
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
	
	/**
	 * @purpose remove the element from rear
	 * @param void
	 * @return String  	// element removed
	 */
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
	
	/**
	 * @purpose remove the element from rear
	 * @param void
	 * @return String 	// element removed
	 */
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
	
	/**
	 * @purpose displays the deque
	 * @return void
	 */
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
	
	/**
	 * @purpose calculates the elements present in deque
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
			int length = rear - front +1;
			
			return length;
		}
	}
	
	/**
	 * @purpose appends the elements to String
	 * @return String
	 */
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
