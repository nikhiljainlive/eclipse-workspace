package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OOPSUtility 
{
	public static ObjectMapper objM = new ObjectMapper();
	
	public static <Inventory> List<Inventory> readJsonFromFile(String fileName)
	{
		try 
		{
			List<Inventory> list = objM.readValue(new File(fileName), new TypeReference <List<Inventory>>(){});
			
			return list;
		}
		catch (IOException e) 
		{			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static <T> void writeObjectToJson(List<T> list, String fileName) 
	{
		Object[] arr = list.toArray();
		try 
		{

			objM.writeValue(new File(fileName), arr);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
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
	
	public static boolean isRegexPresent(String inputString, String regex)
	{
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inputString);
		
		while(m.find())
		{
			return true;
		}
		
		return false;
	}
}
