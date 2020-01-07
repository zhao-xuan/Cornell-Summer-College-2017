package Homework02;

public class Person {

	private String firstName;
	private String lastName;
	private String id;
	private Date birthdate;
	//Empty initializer
	public Person() {
		
	}
	//init of a 'Person' object
	public Person(String firstName, String lastName, Date birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = new codeGenerator().idGenerator(birthdate);
		this.birthdate = birthdate;
	}
	public String getName() { return (this.firstName + this.lastName); }
	public String getId() { return this.id; }
	public Date getBirthdate() { return this.birthdate; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setName (String firstName, String lastName) { this.firstName = firstName; this.lastName = lastName; }
	//Print the basic information of the 'Person' object
	public void printPerson() {
		System.out.println("Name: "+this.firstName+" "+this.lastName);
		System.out.println("Birthdate: "); this.birthdate.printDate();
	}
}