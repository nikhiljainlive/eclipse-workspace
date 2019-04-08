//package com.bridgeit.addressbook;
//
//import java.util.Comparator;
//
//public class CompareAddressBook 
//{
//	public static class NameComparator implements Comparator<Person>
//	{
//
//		@Override
//		public int compare(Person personOne, Person personTwo) 
//		{
//			return(personOne.getFirstName().compareTo(personTwo.getFirstName()));
//		}
//		
//	}
//	
//	public static class ZIPComparator implements Comparator<Person>
//	{
//
//		@Override
//		public int compare(Person personOne, Person personTwo) {
//			
//			int personOneZip = Integer.parseInt(personOne.getZip());
//			int personTwoZip = Integer.parseInt(personTwo.getZip());
//			if(personOneZip < personTwoZip)
//			{
//				return -1;
//			}
//			else if(personOneZip > personTwoZip)
//			{
//				return 1;
//			}
//			return 0;
//		}
//
//		
//	}
//}
