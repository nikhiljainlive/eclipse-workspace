package cliniquemangementprogramme;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.UtilityMethods;

public class CliniqueManager 
{
	public static ObjectMapper objM = new ObjectMapper();
	
	public static void main(String[] args)
	{
		String doctorFile = "/home/admin1/eclipse-workspace/Programs/src/cliniquemangementprogramme/Doctor.json";
		String patientFile = "/home/admin1/eclipse-workspace/Programs/src/cliniquemangementprogramme/Patient.json";
		String appointmentFile = "/home/admin1/eclipse-workspace/Programs/src/cliniquemangementprogramme/Appointments.json";
		
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
	
		try {
			List<Doctor> doctorList = objM.readValue(new File(doctorFile), new TypeReference<List<Doctor>>() {});
			List<Patient> patientList = objM.readValue(new File(patientFile), new TypeReference<List<Patient>>() {});
			List<Appointment> appointmentList = objM.readValue(new File(appointmentFile),
					new TypeReference<List<Appointment>>() {});
			
			boolean value = true;
			while(value) 
			{
				System.out.println("+++++++++++++++++++++++++++++++");
				System.out.println("Clinique Management Programme");
				System.out.println("+++++++++++++++++++++++++++++++");
				System.out.println("1. Add Doctor");
				System.out.println("2. Add Patient");
				System.out.println("3. See Doctors");
				System.out.println("4. See Patients");
				System.out.println("5. Search Doctors");
				System.out.println("6. Search Patients");
				System.out.println("7. Take Appointment");
				System.out.println("8. Print Appointment Reports");
				System.out.println("9. Popular Doctor in Clinic!");
				System.out.println("10.Our Popular Specialization!");
				System.out.println("11.Exit");
				System.out.println("================================");
				
				switch(UtilityMethods.inputInt("enter your choice: "))
				{
					case 1: CliniqueUtility.addDoctor(doctorList);
							break;
						
					case 2: CliniqueUtility.addPatient(patientList);
							break;
							
					case 3: System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization", "Availability");
							System.out.println("==============================================================");
							for(int i = 0; i < doctorList.size(); i++)
							{
								doctor = doctorList.get(i);
								System.out.println(doctor.toString());
							}
							break;
							
					case 4: System.out.printf("%\n-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
							System.out.println("==============================================================");
							for(int i = 0; i < patientList.size(); i++)
							{
								patient = patientList.get(i);
								System.out.println(patient.toString());
							}
							break;
							
					case 5: CliniqueUtility.searchDoctors(doctorList);
							break;
						
					case 6: CliniqueUtility.searchPatients(patientList);
							break;
							
					case 7: CliniqueUtility.fixAppointment(doctorList, patientList);
							break;
							
					case 8: CliniqueUtility.printAppointments(appointmentList);
							break;
							
					case 9 :	if(doctorList.isEmpty())
								{
									System.out.println("Doctors are not available at this time\n");
								}
								else
								{
									System.out.println("Popular Doctor is " + doctorList.get(0).getName() + "\n");
								}
								break;
					
					case 10 : 	if(doctorList.isEmpty())
								{
									System.out.println("Doctors are not available at this time\n");
								}
								else
								{
									System.out.println("Popular Specialization is "
											+ doctorList.get(0).getSpecialization() + "\n");
								}
								break;
					
					case 11 : 	value = false;
								break;
								
					default: System.out.println("Invalid Input! Try Again...\n");
							break;		
			}
			
				
				
			}	
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}
}
