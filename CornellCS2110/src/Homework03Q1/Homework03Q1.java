package Homework03Q1;

import java.io.*;

/*
 * README.TXT - q Q1
 * 1. Two modes are available: 'infix' or 'reverse'.
 * 2. The expression has to be in the right format: The parenthesis should not be adjacent to an operator, there should be exactly one space between a number and an operator.
 * 3. After successfully calculating the number, there will be a prompt says 'Calculation successfully completed!'.
 * 4. If the infix format is incorrect, the program will prompt user to re-enter a legal value.
 * 5. If the polish reverse format is incorrect, the program will terminate and you have to start over again.
 * 6. More detailed specification is between the lines.
 */

public class Homework03Q1 {

	public static void main(String args[]) throws IOException {
		
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);

		//initialize the interface of the program
		System.out.println("-----Welcome to the Calculator program!-----");
		System.out.println("-----Tom Zhao. July. 16th. 2017-----");
		System.out.println("-----Please remember that if you want to input a negative number after a left parenthesis\ryou have to input a space between the number and the parenthesis!-----");
		System.out.println("-----Please enter which form of expression you want to input: ('infix' or 'reverse')");
		
		String option = grab.readLine();
		//the function 'process' will proceed the program
		process(option, grab);
		
	}
	
	public static void process(String option, BufferedReader grab) throws IOException {
		/*
		 * @ para option: the mode that the user has chosen.
		 * @ para grab: the buffered reader that allows user to input data.
		 * precondition: the value of option is either 'infix' or 'reverse', or there will be an error.
		 * 				 the format of infix or polish reverse should be correct, or there will be an error.
		 * postcondition: the result and process of calculation by stack can be correctly provided
		 */
		while (!(option.equals("infix") || option.equals("reverse"))) {
			System.out.println("----Your input is incorrect! try to do again!('infix' or 'reverse')");
			option = grab.readLine();
		}
		if (option.equals("infix")) {
			System.out.println("-----Please input the infix form:");
			String temp1 = grab.readLine();
			while (temp1.length() == 0) {
				System.out.println("-----Please at least write something!");
				temp1 = grab.readLine();
			}
			//'Calculator' is a defined class which contains all methods used to finish and store the calculation
			Calculator cal1 = new Calculator("infix", temp1);
			//IMPORTANT: the methods 'isValidInput(String)' will only check the validity of infix format
			while (!cal1.isValidInput(temp1)) {
				System.out.println("-----Please enter the correct form!:");
				temp1 = grab.readLine();
				//System.out.println(temp1);
				cal1 = new Calculator("infix", temp1);
			}
			System.out.println("-----Below is your result and process:");
			//the method 'calculate' will do the actual calculation
			cal1.calculate();
			//'tempContent' will hold the result of the calculation and the prompt for successful calculation if has any; otherwise it will hold 'NaN'
			String tempResult = (!cal1.result.equals(Double.NaN)) ? cal1.result+"\r-----Your calculation is successful!-----" : "NaN";
			System.out.println("The result: " + tempResult);
		} else {
			//the code below takes the same fashion as the code above....
			System.out.println("-----Please input the reverse form:");
			String temp2 = grab.readLine();
			while (temp2.length() == 0) {
				System.out.println("-----Please at least write something!");
				temp2 = grab.readLine();
			}
			Calculator cal2 = new Calculator("reverse", temp2);
			System.out.println("-----Below is your result and process:");
			cal2.calculate();
			String tempResult = (!cal2.result.equals(Double.NaN)) ? cal2.result+"\r-----Your calculation is successful!-----" : "NaN";
			System.out.println("The result: " + tempResult);
		}
	}
}