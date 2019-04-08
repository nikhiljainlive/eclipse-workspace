package com.bridgeit.designpatterns.singleton;

public class LazyInitSingletonDemo 
{
	public static void main(String[] args) 
	{
		LazyInitSingletonInstance firstInstance = LazyInitSingletonInstance.getInstance();
		LazyInitSingletonInstance secondInstance = LazyInitSingletonInstance.getInstance();
		
		System.out.println("Hash Code of First Instance:  " + firstInstance.hashCode());
		System.out.println("Hash Code of Second Instance: " + secondInstance.hashCode());
	}
}

class LazyInitSingletonInstance
{
	private static LazyInitSingletonInstance instance;
	
	private LazyInitSingletonInstance() { }
	
	public static LazyInitSingletonInstance getInstance()
	{
		if(instance == null)
		{
			instance = new LazyInitSingletonInstance();
		}
		
		return instance;
	}
}