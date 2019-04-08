package com.bridgeit.designpatterns.singleton;

public class ThreadSafeSingletonDemo 
{	
	public static void main(String[] args)
	{
		
	}
}

class ThreadSafeInstance
{
	private static ThreadSafeInstance instance;
	
	private ThreadSafeInstance() { }
	
	// only one thread can access this method at a time
	public static synchronized ThreadSafeInstance getInstance() 
	{
		if(instance == null)
		{
			instance = new ThreadSafeInstance();
		}
		
		return instance;
	}
	
	public static ThreadSafeInstance getDoubleCheckedInstance()
	{
		// first checking if the object is created by any thread or not
		if (instance == null)
		{
			// synchronized block to restrict access to more than one thread at a time
			synchronized (ThreadSafeInstance.class)
			{
				// double checking if any thread is inside this block
				if(instance == null)
				{
					instance = new ThreadSafeInstance();
				}
			}	
		}
		return instance;
	}
}