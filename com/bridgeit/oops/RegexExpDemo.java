package com.bridgeit.oops;

import utility.OOPSUtility;

public class RegexExpDemo 
{
	public static void main(String[] args) 
	{
		String test = "Hello <<name>>, We have your full " + 
				"name as <<full name>> in our system. your contact number is 91­xxxxxxxxxx.\n" + 
				"Please,let us know in case of any clarification. Thank you BridgeLabz XX/XX/XXXX.";
		
		test = OOPSUtility.replaceString(test, "x{10}", "8770627394");
		test = OOPSUtility.replaceString(test, "<+.{4}>+", "Nikhil");
		test = OOPSUtility.replaceString(test, "<+.{4} .{4}>+", "Nikhil Jain");
		test = OOPSUtility.replaceString(test, "X{2}/X{2}/X{4}", "01/03/2019");

		System.out.println(test);
	}
}
