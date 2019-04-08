package com.bridgeit.designpatterns.singleton;

public class BillPughSingletonDemo 
{
	public static void main(String[] args) 
	{
		BillPughSingletonInstance firstInstance = BillPughSingletonInstance.getInstance();
		BillPughSingletonInstance secondInstance = BillPughSingletonInstance.getInstance();
		
		System.out.println("Singleton Object Creation using Bill Pugh Method\n");
		System.out.println("HashCode of first Instance:  " + firstInstance.hashCode());
		System.out.println("HashCode of second Instance: " + secondInstance.hashCode());
	}
}

class BillPughSingletonInstance
{
	// private constructor restricting the object creation directly
	private BillPughSingletonInstance() { }
	
	// private class Singleton Helper
	private static class SingletonInstanceHelper
	{
		// global access instance
		private final static BillPughSingletonInstance INSTANCE = new BillPughSingletonInstance();
	}
	
	// public method to create singleton instance
	public static BillPughSingletonInstance getInstance()
	{
		return SingletonInstanceHelper.INSTANCE;
	}
}