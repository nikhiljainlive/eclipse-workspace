package com.bridgeit.designpatterns.factory;

import com.bridgeit.designpatterns.factory.ComputerFactory.computerType;

public class Client 
{
	public static void main(String[] args)
	{
		Computer newComputer1 = ComputerFactory.createComputer(computerType.laptop, "4GB", "1 TB", "1GHz");
		
		newComputer1.run();
		newComputer1.showConfig();
		
		Computer newComputer2 = ComputerFactory.createComputer(computerType.pc, "2GB", "500 GB", "1GHz");
		
		newComputer2.run();
		newComputer2.showConfig();
		
		Computer newComputer3 =  ComputerFactory.createComputer(computerType.server, "10GB", "500 TB", "10GHz");
	
		newComputer3.run();
		newComputer3.showConfig();
	}
	
	
}
