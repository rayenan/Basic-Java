/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 2
 *Student GPAs PART II
*/ 

public class StudentPersonal 
{
	private String name; //Name of student
	private long id; //Identification number 
	private String birthDate; //Student's birthday
	private String addStreet; //Address (street)
	private String addCity; //Address (city)
	private String addProvince; //Address (province)
	private String addCountry; //Address (country)
	private String addPostal; //Address (postal) 
	private String email; //Email address
	private String emergencyName; //Emergency contact name
	private long emergencyPhone; //Emergency contact phone number 
	
	//Default constructor
	public StudentPersonal() 
	{
		 this.name = " ";
		 this.id = 0; 
		 this.birthDate = " ";
		 this.addStreet = " "; 
		 this.addCity = " ";
		 this.addProvince = " "; 
		 this.addCountry = " ";
		 this.addPostal = " ";
		 this.email = " ";
		 this.emergencyName = " ";
		 this.emergencyPhone = 0; 
	}
	
	//Constructor 
	public StudentPersonal(String name, long id, String birthDate, String addStreet, String addCity, String addProvince, String addCountry, String addPostal, String email, String emergencyName, long emergencyPhone) 
	{
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
		this.addStreet = addStreet;
		this.addCity = addCity;
		this.addProvince = addProvince;
		this.addCountry = addCountry;
		this.addPostal = addPostal;
		this.email = email;
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone;
	}

	
	//Student Info Constructor 
	public StudentPersonal(String name, long id, String birthDate, String email)
	{
		this.name = name; 
		this.birthDate = birthDate;
		this.email = email;
		
		if (id > 0) {
			this.id = id;
		} else {
			System.err.println("Error: Incorrect ID number");
		}
			
	}
	
	//Student Address Constructor
	public StudentPersonal(String addStreet, String addCity, String addProvince, String addCountry, String addPostal) 
	{
		this.addStreet = addStreet; 
		this.addCity = addCity; 
		this.addProvince = addProvince;
		this.addCountry = addCountry;
		this.addPostal = addPostal; 
	}
	
	//Student Emergency Contact Info Constructor 
	public StudentPersonal(String emergencyName, long emergencyPhone)
	{
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone; 
	}
	
	
	/*NAME*/
	//Mutator 
	public void setName(String name)
	{
		this.name = name; 
	}
	
	//Accessor
	public String getName()
	{
		return this.name; 
	}
	
	/*IDENTIFICATION NUMBER*/
	//Mutator
	public void setId(long io)
	{
		this.id = id;
	}
	
	//Accessor 
	public long getId()
	{
		return this.id; 
	}
	
	/*BIRTHDATE*/
	//Mutator 
	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate; 
	}
	
	//Accessor
	public String getBirthDate()
	{
		return this.birthDate; 
	}
	
	/*STREET*/
	//Mutator 
	public void setStreet(String addStreet)
	{
		this.addStreet = addStreet; 
	}
	
	//Accessor
	public String getStreet()
	{
		return this.addStreet; 
	}
	
	/*CITY*/
	//Mutator
	public void setCity(String addCity)
	{
		this.addCity = addCity; 
	}
	
	//Accessor
	public String getCity()
	{
		return this.addCity;
	}
	
	/*PROVINCE*/
	//Mutator
	public void setProvince(String addProvince)
	{
		this.addProvince = addProvince; 
	}
	
	//Accessor 
	public String getProvince()
	{
		return this.addProvince; 
	}
	
	/*COUNTRY*/
	//Mutator
	public void setCountry(String addCountry)
	{
		this.addCountry = addCountry;
	}
	
	//Accessor 
	public String getCountry() 
	{
		return this.addCountry;
	}
	
	/*POSTAL CODE*/
	//Mutator
	public void setPostal(String addPostal)
	{
		this.addPostal = addPostal; 
	}
	
	//Accessor
	public String getPostal()
	{
		return this.addPostal;
	}
	
	/*EMAIL*/
	//Mutator
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	//Accessor
	public String getEmail()
	{
		return this.email;
	}
	
	/*EMERGENCY CONTACT NAME*/
	//Mutator
	public void setEmergencyName(String emergencyName)
	{
		this.emergencyName = emergencyName;
	}
	
	//Accessor
	public String getEmergencyName()
	{
		return this.emergencyName;
	}
	
	/*EMERGENCY PHONE NUMBER*/
	//Mutator
	public void setEmergencyPhone(long emergencyPhone)
	{
		this.emergencyPhone = emergencyPhone;
	}
	
	//Accessor
	public long getEmergencyPhone()
	{
		return this.emergencyPhone;
	}
	
	//To String method
	public String toString()
	{
		String studentInfo = this.name + this.id + this.birthDate + this.addStreet + this.addCity + this.addProvince + this.addCountry + this.addPostal + this.emergencyName + this.emergencyPhone;
		
		return studentInfo; 
	}
	
	//Equals method
	public boolean equals(StudentPersonal other)
	{
		boolean samePerson = false; 
		if( (this.name == other.name) && (this.id == other.id) ) {
			samePerson = true; 
		}
		
		return samePerson; 
	}
	
	//Main method to test 
	public static void main(String[] args) 
	{
		//Test default constructor and toString 
		StudentPersonal studentInfo = new StudentPersonal();
		System.out.println(studentInfo.toString());
	}
	
	
	
	
}
