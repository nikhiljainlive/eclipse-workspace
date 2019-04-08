package com.bridgeit.addressbook;

public class Person 
{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String address, String city, 
			String state, String zip, String phone)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setState(state);
		setCity(city);
		setZip(zip);
		setPhone(phone);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Full Name: " + firstName + " ").append(lastName + "\n").append("Full Address: " + address + ", ").append(city + ", ")
		.append(state + ", ").append("Pin code: " + zip + "\n").append("Phone: " + phone + "\n");
	
		return sb.toString();
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	private void setFirstName(String firstName) 
	{
		//if(OOPSUtility.checkString(firstName, " |\\W")) 
		{
			this.firstName = firstName;	
		}
//		else
//		{
//			System.out.println("name can not contain numbers");
//		}
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	private void setLastName(String lastName) 
	{
		//if(OOPSUtility.checkString(lastName, " |\\W")) 
		{
			this.lastName = lastName;
		}
//		else
//		{
//			System.out.println("name can not contain numbers");
//		}
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getState() 
	{
		return state;
	}
	
	public void setState(String state) 
	{
		//if(OOPSUtility.checkString(state, "\\d| ")) 
		{
			this.state = state;	
		}
//		else
//		{
//			System.out.println("numeric input not allowed!");
//		}
	}
	
	public String getZip() 
	{
		return zip;
	}
	
	public void setZip(String zip) 
	{
		//if(OOPSUtility.checkString(state, "\\D| ")) 
		{
			this.zip = zip;	
		}
//		else
//		{
//			System.out.println("only numeric input allowed!");
//		}
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		//if(OOPSUtility.checkString(state, "\\D| ")) 
		{
			this.phone = phone;
		}
//		else
//		{
//			System.out.println("only numeric input allowed!");
//		}
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		//if(OOPSUtility.checkString(state, "\\d|\\W| ")) 
		{
			this.city = city;	
		}
//		else
//		{
//			System.out.println("invalid input");
//		}
	}
	
	public void updatePerson(String address, String city, String state, String zip, String phone)
	{
		
	}
}
