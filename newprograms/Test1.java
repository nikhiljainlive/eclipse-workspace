package newprograms;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Test1 
{
	public static void main(String[] args)
	{
		// rice objects
		JSONObject rice1 = new JSONObject();
		rice1.put("name", "white rice");
		rice1.put("weight", "14");
		rice1.put("price", "37");
		
		JSONObject rice2 = new JSONObject();
		rice2.put("name", "yellow rice");
		rice2.put("weight", "18");
		rice2.put("price", "35");
		
		JSONObject rice3 = new JSONObject();
		rice3.put("name", "fried rice");
		rice3.put("weight", "10");
		rice3.put("price", "32");
		
		// array of rice elements
		JSONArray riceList = new JSONArray();
		riceList.add(rice1);
		riceList.add(rice2);
		riceList.add(rice3);
		
		// pulses objects
		JSONObject pulses1 = new JSONObject();
		pulses1.put("name", "black pulses");
		pulses1.put("weight", "19");
		pulses1.put("price", "45");
		
		JSONObject pulses2 = new JSONObject();
		pulses2.put("name", "yellow pulses");
		pulses2.put("weight", "23");
		pulses2.put("price", "43");
		
		JSONObject pulses3 = new JSONObject();
		pulses3.put("name", "green pulses");
		pulses3.put("weight", "12");
		pulses3.put("price", "40");
		
		// arrays of pulses
		JSONArray pulsesList = new JSONArray();
		pulsesList.add(pulses1);
		pulsesList.add(pulses2);
		pulsesList.add(pulses3);
		
		// wheat objects
		JSONObject wheat1 = new JSONObject();
		wheat1.put("name", "yellow wheat");
		wheat1.put("weight", "25");
		wheat1.put("price", "22");
		
		JSONObject wheat2 = new JSONObject();
		wheat2.put("name", "brown wheat");
		wheat2.put("weight", "21");
		wheat2.put("price", "11");
		
		JSONObject wheat3 = new JSONObject();
		wheat3.put("name", "whitish yellow wheat");
		wheat3.put("weight", "6");
		wheat3.put("price", "7");
		
		// arrays of wheats
		JSONArray wheatList = new JSONArray();
		wheatList.add(wheat1);
		wheatList.add(wheat2);
		wheatList.add(wheat3);
		
		JSONObject obj = new JSONObject();
		obj.put("rice", riceList);
		obj.put("pulses", pulsesList);
		obj.put("wheat", wheatList);
		System.out.println(obj);
	}
}
