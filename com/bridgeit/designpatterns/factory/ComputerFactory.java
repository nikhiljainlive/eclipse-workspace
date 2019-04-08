package com.bridgeit.designpatterns.factory;

public class ComputerFactory 
{
	enum computerType
	{
		laptop, pc, server
	}
	
	public static Computer createComputer(computerType type, String ram, String storage, String processor)
	{
		switch(type)
		{
			case laptop: Computer newLaptop = new Laptop(ram, storage, processor);
							return newLaptop;
							
			case pc: Computer newPC = new PC(ram, storage, processor);
							return newPC;
							
			case server: Computer newServer = new Server(ram, storage, processor);
							return newServer;
							
			default: return null;
		}
		
	}
}
