package newprograms;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewTest 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		String path = "C:\\Users\\Nikhil Jain\\eclipse-workspace\\Programs\\src\\files\\file.json";
		
		ObjectMapper objM = new ObjectMapper();
		
		Microsoft stockP = objM.readValue(new File(path), Microsoft.class);
		
	}
}
