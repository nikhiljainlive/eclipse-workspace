package com.bridgeit.designpatterns.factory;

public class Laptop implements Computer
{
	private String ram;
	private String storage;
	private String processor;
	
	public Laptop(String ram, String storage, String processor)
	{
		this.ram = ram;
		this.storage = storage;
		this.processor = processor;
	}
	
	@Override
	public String getRam() 
	{
		return ram;
	}
	
	@Override
	public String getProcessor() 
	{
		return processor;
	}
	
	@Override
	public String getStorage() 
	{
		return storage;
	}
	
	@Override
	public void showConfig() 
	{
		System.out.println("Ram: " + ram + "\nStorage: " + storage + "\nProcessor:  " + processor + "\n");
	}
	
	@Override
	public void run() 
	{
		System.out.println("Laptop running...\n");	
	}

	
	
}
