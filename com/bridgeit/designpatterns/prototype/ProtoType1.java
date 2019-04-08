//package com.bridgeit.designpatterns.prototype;
//
////A Java program to demonstrate working of 
////Prototype Design Pattern with example 
////of a ColorStore class to store existing objects. 
//
//import java.util.HashMap; 
//import java.util.Map; 
//
////Driver class 
//class Prototype
//{ 
//	public static void main (String[] args) 
//	{ 
//		ColorStore.getColor("blue").addColor(); 
//		ColorStore.getColor("black").addColor(); 
//		ColorStore.getColor("black").addColor(); 
//		ColorStore.getColor("blue").addColor(); 
//	} 
//} 
//
//abstract class ProtoType1 implements Cloneable 
//{ 
//	
//	protected String colorName; 
//	
//	abstract void addColor(); 
//	
//	public Object clone() 
//	{ 
//		Object clone = null; 
//		try
//		{ 
//			clone = super.clone(); 
//		} 
//		catch (CloneNotSupportedException e) 
//		{ 
//			e.printStackTrace(); 
//		} 
//		return clone; 
//	} 
//} 
//
//class blueColor extends ProtoType1 
//{ 
//	public blueColor() 
//	{ 
//		this.colorName = "blue"; 
//	} 
//
//	@Override
//	void addColor() 
//	{ 
//		System.out.println("Blue color added"); 
//	} 
//	
//} 
//
//class blackColor extends ProtoType1{ 
//
//	public blackColor() 
//	{ 
//		this.colorName = "black"; 
//	} 
//
//	@Override
//	void addColor() 
//	{ 
//		System.out.println("Black color added"); 
//	} 
//} 
//
//class ColorStore { 
//
//	private static Map<String, ProtoType1> colorMap = new HashMap<String, ProtoType1>(); 
//	
//	static
//	{ 
//		colorMap.put("blue", new blueColor()); 
//		colorMap.put("black", new blackColor()); 
//	} 
//	
//	public static ProtoType1 getColor(String colorName) 
//	{ 
//		return (ProtoType1) colorMap.get(colorName).clone(); 
//	} 
//} 
//
//
//
//
