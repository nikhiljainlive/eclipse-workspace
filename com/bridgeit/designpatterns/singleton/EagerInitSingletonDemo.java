package com.bridgeit.designpatterns.singleton;

public class EagerInitSingletonDemo 
{
	public static void main(String[] args)
	{
		EagerInitSingletonInstance firstInstance = EagerInitSingletonInstance.getInstance();
		EagerInitSingletonInstance secondInstance = EagerInitSingletonInstance.getInstance();
		
		System.out.println("Eager Initaialized Singleton Object:\n");
		System.out.println("Hash Code of First Instance:  " + firstInstance.hashCode());
		System.out.println("Hash Code of Second Instance: " + secondInstance.hashCode());
	}
}

class EagerInitSingletonInstance
{
	// this instance will get created whenever this class will be loaded
		private static final EagerInitSingletonInstance instance = new EagerInitSingletonInstance();

		// constructor is marked as private to restrict the object initailization of this calss
		private EagerInitSingletonInstance() { }
		
		public static EagerInitSingletonInstance getInstance()
		{
			return instance;
		}
	
}