package com.bridgeit.oops.inventorydatamanagement;

public class Inventory 
{
	private String name;
	private int weight;
	private int price;
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-20s  %-10d  %-10d  %10d\n", name, weight, price, calculateValue())); //.append(pulses).append("\t").append(wheat);
		
		return sb.toString();
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public int calculateValue()
	{
		return weight * price;
	}
}
