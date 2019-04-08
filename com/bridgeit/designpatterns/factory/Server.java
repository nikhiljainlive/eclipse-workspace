package com.bridgeit.designpatterns.factory;

public class Server implements Computer
{
	private String ram;
	private String processor;
	private String storage;
	
	public Server(String ram, String storage, String processor)
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
		System.out.println("Server running...\n");
	}

	public void setRam(String ram) 
	{
		this.ram = ram;
	}

	public void setProcessor(String processor)
	{
		this.processor = processor;
	}

	public void setStorage(String storage) 
	{
		this.storage = storage;
	}
	

}
