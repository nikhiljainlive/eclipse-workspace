package com.bridgeit.designpatterns.factory;

public interface Computer
{
	public String getRam();
	public String getProcessor();
	public String getStorage();
	public void showConfig();
	public void run();
}
