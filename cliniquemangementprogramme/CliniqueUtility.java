package cliniquemangementprogramme;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.UtilityMethods;

public class CliniqueUtility 
{
	public static ObjectMapper objM = new ObjectMapper();
	
	public static void addDoctor(List<Doctor> doctorList)
	{
		String doctorFile = "/home/admin1/eclipse-workspace/Programs/src/cliniquemangementprogramme/Doctor.json";
		String name = UtilityMethods.stringInput("enter Doctor's Name: ").toUpperCase();
		int id = UtilityMethods.inputInt("enter Doctor's id: ");
		String spl = UtilityMethods.stringInput("enter Specialization: ").toUpperCase();
		String avl = UtilityMethods.stringInput("enter Availability: ").toUpperCase();
		
		Doctor newDoctor = new Doctor(name, id, spl, avl);
		doctorList.add(newDoctor);
		try 
		{
			objM.writerWithDefaultPrettyPrinter().writeValue(new File(doctorFile), doctorList);
			System.out.println("\nNew Doctor Added!\n");
			System.out.printf("%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization", "Availability");
			System.out.println("==============================================================");
			System.out.println(newDoctor.toString());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addPatient(List<Patient> patientList)
	{
		String patientFile = "/home/admin1/eclipse-workspace/Programs/src/cliniquemangementprogramme/Patient.json";
		String name = UtilityMethods.stringInput("enter Patient's Name: ").toUpperCase();
		int id = UtilityMethods.inputInt("enter Patient's id: ");
		String mobNum = UtilityMethods.stringInput("enter Mobile Number: ");
		int age = UtilityMethods.inputInt("enter Patient's age: ");
		
		Patient newPatient = new Patient(name, id, mobNum, age);
		patientList.add(newPatient);
		
		try 
		{
			objM.writerWithDefaultPrettyPrinter().writeValue(new File(patientFile), patientList);
			System.out.println("\nNew Patient Added!\n");
			System.out.printf("%-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
			System.out.println("==============================================================");
			System.out.println(newPatient.toString());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void searchDoctors(List<Doctor> doctorList)
	{
		Search searchStart = new Search();
		
		System.out.println("\t1. By Name");
		System.out.println("\t2. By ID");
		System.out.println("\t3. By Specialization");
		System.out.println("\t4. By Availability");
		
		switch(UtilityMethods.inputInt("\tenter choice: "))
		{
			case 1: searchStart.searchDocByName(UtilityMethods.stringInput("\tenter Doctor's Name: ").toUpperCase(), doctorList);
					break;
					
			case 2: searchStart.searchDocById(UtilityMethods.inputInt("\tenter Doctor's ID: "), doctorList);
					break;
			
			case 3: searchStart.searchDocBySPL(UtilityMethods.stringInput("\tenter specialization: ").toUpperCase(),
					doctorList);
					break;
			
			case 4: searchStart.searchDocByAvl(UtilityMethods.stringInput("\tenter availability(e.g. 10AM): ").toUpperCase(),
					doctorList);
					break;
			
			default: System.out.println("\tinvalid choice");
		}
	}
	
	public static void searchPatients(List<Patient> patientList)
	{
		Search searchStart = new Search();
		
		System.out.println("\t1. By Name");
		System.out.println("\t2. By ID");
		System.out.println("\t3. By Mobile Number");
		System.out.println("\t4. By Age");
		
		switch(UtilityMethods.inputInt("\tenter choice: "))
		{
			case 1: searchStart.searchPatientByName(UtilityMethods.stringInput("\tenter Patient's Name: ").toUpperCase(), patientList);
					break;
					
			case 2: searchStart.searchPatientById(UtilityMethods.inputInt("\tenter Patient's ID: "), patientList);
					break;
			
			case 3: searchStart.searchPatientByMobNum(UtilityMethods.stringInput("\tenter Mobile Number: "), patientList);
					break;
			
			case 4: searchStart.searchPatientByAge(UtilityMethods.inputInt("\tenter age: "), patientList);
					break;
			
			default: System.out.println("\tinvalid choice");
		}
	}
	
	public static void fixAppointment(List<Doctor> doctorList, List<Patient> patientList )		//List<Appointment> appointmentList
	{
		String appointmentFile = "/home/admin1/eclipse-workspace/Programs/src/cliniquemangementprogramme/Appointments.json";
		try {
			List<Appointment> appointmentList = objM.readValue(new File(appointmentFile),
					new TypeReference<List<Appointment>>() {});
			
			Search searchStart = new Search();
			String doctorName = UtilityMethods.stringInput("enter Doctor's name: ").toUpperCase();
			if(searchStart.searchDocByName(doctorName, doctorList) == true)
			{
				String patientName = UtilityMethods.stringInput("enter Patient's name: ").toUpperCase();
				if(searchStart.searchPatientByName(patientName, patientList) == true)
				{
					String date = UtilityMethods.stringInput("enter date(DD/MM/YYYY): ");
					int index = searchStart.getAppointedDocIndex(doctorName, appointmentList);
					int docCount;
					
					//System.out.println(index);
					if(index == -1)
					{
						docCount = 1;
					}
					else
					{
						docCount = appointmentList.get(index).getDocAppointmentCount();
						docCount = docCount + 1;
					}
					if(docCount <= 5)
					{
						Appointment newAppointment = new Appointment(doctorName, patientName, date, docCount );
						appointmentList.add(newAppointment);
						objM.writerWithDefaultPrettyPrinter().writeValue(new File(appointmentFile), appointmentList);
						
						System.out.println("\nAppointment Added!\n");
						System.out.printf("%-20s %-20s %-10s\n", "Doctor Name", "Patient Name", "Date of Appointment");
						System.out.println("==============================================================");
						System.out.println(newAppointment.toString());	
					}
					else
					{
						System.out.println("Sorry.. Doctor's not available right now!");
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void printAppointments(List<Appointment> appointmentList)
	{
		System.out.println("\n \t----List of Appointments----\n");
		System.out.printf("%-20s %-20s %-10s\n", "Doctor Name", "Patient Name", "Date of Appointment");
		System.out.println("==============================================================");
		for(int i = 0; i < appointmentList.size(); i++)
		{
			System.out.println(appointmentList.get(i).toString());
		}
	}
}
