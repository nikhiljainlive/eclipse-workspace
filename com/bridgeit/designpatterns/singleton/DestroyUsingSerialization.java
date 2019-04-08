package com.bridgeit.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DestroyUsingSerialization 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		EagerInitSingleton firstInstance = EagerInitSingleton.getInstance();
		
		System.out.println(firstInstance.hashCode());
		
		try 
		{
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("abc.txt"));
			out.writeObject(firstInstance);
			out.close();
			
			ObjectInput in = new ObjectInputStream(new FileInputStream("abc.txt"));
			EagerInitSingleton sameInstance = (EagerInitSingleton) in.readObject();
			in.close();
			
			System.out.println(sameInstance.hashCode());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class EagerInitSingleton implements Serializable
{
		private static final long serialVersionUID = -5041267943004627728L;
		
		// this instance will get created whenever this class will be loaded
		private static final EagerInitSingleton instance = new EagerInitSingleton();

		// constructor is marked as private to restrict the object initailization of this calss
		private EagerInitSingleton() { }
		
		// replacing the object read from stream
		protected Object readResolve()
		{
			return instance;
		}
		
		// public method to return the instance
		public static EagerInitSingleton getInstance()
		{
			return instance;
		}
	
}