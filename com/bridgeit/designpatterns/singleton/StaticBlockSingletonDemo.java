package com.bridgeit.designpatterns.singleton;

class StaticBlockSingletonDemo 
{
	public static void main(String[] args)
	{
		StaticBlockSingletonInstance firstInstance = StaticBlockSingletonInstance.getInstance();
		StaticBlockSingletonInstance secondInstance = StaticBlockSingletonInstance.getInstance();
	
		System.out.println("Singleton Object Creation using Static Block in Eager Initialization:\n");
		System.out.println("Hash Code of First Instance:  " + firstInstance.hashCode());
		System.out.println("Hash Code of Second Instance: " + secondInstance.hashCode());
	}
}

class StaticBlockSingletonInstance
{
	// declaration of instance
	private static StaticBlockSingletonInstance instance;
	
	// constructor is marked private to restrict object creation directly
	private StaticBlockSingletonInstance() { }
	
	// static block for instance creation and catching exceptions
	static {
		try {
			instance = new StaticBlockSingletonInstance();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Error in creation of Singleton Object");
		}
	}
	
	// public method to return instance of this class
	public static StaticBlockSingletonInstance getInstance()
	{
			return instance;
	}
	
}
