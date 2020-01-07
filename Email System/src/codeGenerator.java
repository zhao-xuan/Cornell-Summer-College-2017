package Homework02;

public class codeGenerator {
	
	//By using the combination of calculation of the hours, minute of the current time, and the month and day of the person's birthdate, the code generator could generate id of that account
	private Date currentTime = new Date();
	private String code;
	
	public codeGenerator() {
		code = "";
	}
	
	public String idGenerator(Date birthdate) {
		int temp1 = Integer.parseInt(Integer.toString(currentTime.getHour()) + Integer.toString(currentTime.getMinute())) * currentTime.getSecond();
		int temp2 = Integer.parseInt(Integer.toString(birthdate.getMonth()) + Integer.toString(birthdate.getDay())) *birthdate.getYear();
		code = Integer.toString(temp1 + temp2);
		
		return code;
	}
}