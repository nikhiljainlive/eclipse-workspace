package OOPS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpDemo 
{
	public static void main(String[] args) 
	{
		String test = "Hello <<name>>, We have your full " + 
				"name as <<full name>> in our system. your contact number is 91­xxxxxxxxxx.\n" + 
				"Please,let us know in case of any clarification. Thank you BridgeLabz XX/XX/XXXX.";
		
		test = replaceString(test, "x{10}", "8770627394");
		test = replaceString(test, "<+.{4}>+", "Nikhil");
		test = replaceString(test, "<+.{4} .{4}>+", "Nikhil Jain");
		test = replaceString(test, "X{2}/X{2}/X{4}", "01/03/2019");

		System.out.println(test);
	}
	
	public static String replaceString(String str, String regex, String replaceStr)
	{
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		while(m.find())
		{
			str = str.replaceAll(m.group(0), replaceStr);
		}
		
		return str;
	}
	
}
