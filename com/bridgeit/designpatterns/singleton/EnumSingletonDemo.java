package com.bridgeit.designpatterns.singleton;

public class EnumSingletonDemo 
{
	public static void main(String[] args) 
	{
		EnumSingletonInstance firstInstance = EnumSingletonInstance.INSTANCE;
		EnumSingletonInstance secondInstance = EnumSingletonInstance.INSTANCE;
		
		System.out.println("Singleton Object Creation using Enum Method\n");
		System.out.println("Hash Code of First Instance:  " + firstInstance.hashCode());
		System.out.println("Hash Code of Second Instance: " + secondInstance.hashCode());
	}
}

enum EnumSingletonInstance
{
	INSTANCE;
	
	
}