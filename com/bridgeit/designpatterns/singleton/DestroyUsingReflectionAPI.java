package com.bridgeit.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DestroyUsingReflectionAPI 
{
	public static void main(String[] args) {
		SingletonInstance firstInstance = SingletonInstance.getInstance();
		SingletonInstance secondInstance = SingletonInstance.getInstance();
		
		System.out.println("Destruction of Singleton Pattern using Reflection API:\n");
		System.out.println("Hash Code of First Instance:\t\t\t   " + firstInstance.hashCode());
		System.out.println("Hash Code of Second Instance:\t\t\t   " + secondInstance.hashCode());
		
		SingletonInstance thirdInstance = null;
		Constructor<?> [] constructors = SingletonInstance.class.getDeclaredConstructors();
		for(Constructor<?> constructor : constructors)
		{
			constructor.setAccessible(true);
			try
			{
				thirdInstance = (SingletonInstance) constructor.newInstance();
				break;
			} 
			catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{

				e.printStackTrace();
			}
			
		}
		
		System.out.println("Hash Code of Third Instance(using Reflection API): " + thirdInstance.hashCode());
	}
}

class SingletonInstance
{
	private SingletonInstance() {
		
//		if(SingletonHelper.INSTANCE != null)
//		{
//			System.err.println("tried to create multiple instances using reflection!");
//			System.exit(0);
//		}
	}
	
	private static class SingletonHelper
	{
		private static final SingletonInstance INSTANCE = new SingletonInstance();
	}
	
	public static SingletonInstance getInstance()
	{
		return SingletonHelper.INSTANCE;
	}
}