package Homework01Q1;

import java.io.*;

/*
 * 	Author: Tom Zhao
 * 	Date: July. 4th. 2017
 * 	For: CS2110 Homework01 - Question01
 * 	Important information:
 * 		1. There are 2 functions which stand respectively for 2 ways to input data(byInput and byFile)
 * 		2. There are 4 functions which are used for analyzing dataset, including an additional function to provide any outliers(greater than the standard deviation)
 * 		3. There is a final option to output data and it will request a response('yes' or 'no', not first-letter-case-sensitive)
 * 		4. The maximum of quantity of input data is 1000, as indicated in the constant 'MAX_LENGTH'
 * 		5. The array 'numbers' and int 'pointer' are global variables
 * 		6. IMPORTANT: Homework01 - Question01 and Question02 are just in different classes! Ignore the Lecture package if has any
 * 		7. IMPORTANT: If inputing data by 'readlines', you have to do one number per line!
 * 		8. IMPORTANT: You may be required to enter the full directory of the file if it says 'No such directory'!
 */

public class Homework01 {

	public static void main(String[] args) throws IOException{
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		final int MAX_LENGTH = 1000;
		String inputOption = "";
		double outputData[] = new double[4];
		boolean flag = false;
		double[] numbers = new double[MAX_LENGTH];
		int pointer = 0;
		
		System.out.println("Please choose the way you want to input data:(readlines or readfile)");
		
		inputOption = grab.readLine();
		while (!flag) {
			if (inputOption.equals("readlines")) {
				System.out.println("You choose to read lines!");
				outputData = byInput(grab, numbers, pointer);
				flag = true;
			} else if (inputOption.equals("readfile")) {
				System.out.println("You choose to read files!");
				outputData = byFile(grab, numbers, pointer);
				flag = true;
			} else {
				System.out.println("Your input does not match the options above. Try to re-enter:(readlines or readfile)");
				inputOption = grab.readLine();
				flag = false;
			}
		}
		if (!Double.isNaN(outputData[0])) {
			System.out.println("Do you want to put the analysis and data into a file?(yes or no)");
		}
		String yesno = grab.readLine();
		if ((yesno.equals("yes") || yesno.equals("Yes")) && !Double.isNaN(numbers[0])) {
			System.out.println("Please enter the output file name:");
			String fileName = grab.readLine();
			FileOutputStream plop = new FileOutputStream (fileName) ;
			PrintWriter scribble = new PrintWriter(plop);
			scribble.println("Data Analysis:");
			scribble.println("MaxValue: "+outputData[0]);
			scribble.println("MinValue: "+outputData[1]);
			scribble.println("Avg: "+outputData[2]);
			scribble.println("Standard Deviation: "+outputData[3]);
			scribble.print("Possible Outliers: ");
			double[] outliers = possibleOutliers(numbers, pointer, stddv(numbers, pointer, mean(numbers, pointer)), mean(numbers, pointer));
			if (outliers.length < 1) {
				scribble.println("None");
			} else {
				for (int i = 0; i < outliers.length; i++) {
					System.out.print(" " + outliers[i]);
				}
			}
			System.out.println();
			scribble.flush();
			scribble.close();
			System.out.println("Your data has been saved! Program has terminated!");
		} else {
			System.out.println("Program has terminated!");
		}
	}
	
	public static double[] byInput(BufferedReader grab, double[] numbers, int pointer) throws IOException {
		System.out.println("Please enter a series of numbers and end with a punctuation:(Only 1 number per line!)");
		pointer = 0;
		String input;
		do {
			input = grab.readLine();
			try {
				numbers[pointer] = Double.parseDouble(input);
			} catch (NumberFormatException e) {
				System.out.println("Your input period has been ended!");
				break;
			}
			pointer++;
		} while (!(input.compareTo(".") == 0));
		
		for (int i = 0; i < pointer+1; i++) {
			System.out.println("The first number is "+numbers[i]);
		}
		
		System.out.println("MaxValue: "+minMax(numbers, pointer)[0]);
		System.out.println("MinValue: "+minMax(numbers, pointer)[1]);
		System.out.println("Avg: "+mean(numbers, pointer));
		System.out.println("Standard Deviation: "+stddv(numbers, pointer, mean(numbers, pointer)));
		System.out.print("Possible Outliers: ");
		double[] outliers = possibleOutliers(numbers, pointer, stddv(numbers, pointer, mean(numbers, pointer)), mean(numbers, pointer));
		if (outliers.length < 1) {
			System.out.println("None");
		} else {
			for (int i = 0; i < outliers.length; i++) {
				System.out.print(" " + outliers[i]);
			}
		}
		System.out.println();
		
		double[] datas = {minMax(numbers, pointer)[0], minMax(numbers, pointer)[1], mean(numbers, pointer), stddv(numbers, pointer, mean(numbers, pointer))};
		
		return datas;
	}
	
	public static double[] byFile(BufferedReader grab, double[] numbers, int pointer) throws IOException {
		System.out.println("Please enter the name of the file:");
		String fileName = null;
		FileReader secret = null;
		BufferedReader james = null;
		boolean flag = false;
		while (!flag) {
			try {
				fileName = grab.readLine();
				secret = new FileReader (fileName);
				james = new BufferedReader (secret);
				flag = true;
			} catch (FileNotFoundException e) {
				System.out.println("No such directory. Try to re-enter the filename:");
			}
		}
		String numLine = "";
		String input = "";
		
		while (input != null) {
			input = james.readLine();
			numLine += " ";
			if (input == null)
				break;
			numLine += input;
		}

		numLine = numLine.substring(1);
		pointer = 0;
		for (int i = 0; i < numLine.length()-1; i++) {
			if (numLine.charAt(i) == ' ' && numLine.charAt(i+1) != ' ') {
				pointer++;
			}
		}
		
		numbers = new double[pointer+1];
		String[] numString = new String[pointer+1];
		int numCount = 0;
		
		numString = numLine.split(" ");
		
		for (int i = 0; i < numString.length; i++) {
			try {
				if (numString[i] != " ") {
					numbers[numCount] = Double.parseDouble(numString[i]);
					numCount++;
				}
			} catch (NumberFormatException e) {
				System.out.println("Not a legal file! Please enter a file that only contains numbers and spaces!");
				System.out.println("You program has terminated!");
				numbers[0] = Double.NaN;
				
				return numbers;
			}
		}
		
		james.close();
		for (int i = 0; i < pointer+1; i++) {
			System.out.println("The first number is "+numbers[i]);
		}
		
		System.out.println("MaxValue: "+minMax(numbers, pointer)[0]);
		System.out.println("MinValue: "+minMax(numbers, pointer)[1]);
		System.out.println("Avg: "+mean(numbers, pointer));
		System.out.println("Standard Deviation: "+stddv(numbers, pointer, mean(numbers, pointer)));
		System.out.print("Possible Outliers: ");
		double[] outliers = possibleOutliers(numbers, pointer, stddv(numbers, pointer, mean(numbers, pointer)), mean(numbers, pointer));
		if (outliers.length < 1) {
			System.out.println("None");
		} else {
			for (int i = 0; i < outliers.length; i++) {
				System.out.print(" " + outliers[i]);
			}
		}
		System.out.println();
		
		double[] datas = {minMax(numbers, pointer)[0], minMax(numbers, pointer)[1], mean(numbers, pointer), stddv(numbers, pointer, mean(numbers, pointer))};
		
		return datas;
	}
	
	public static double[] minMax(double[] numbers, int pointer) {
		double max = numbers[0];
		double min = numbers[0];
		double[] temp = new double[2];
		for (int i = 0; i < pointer+1; i++) {
			if (numbers[i] <= min) {
				min = numbers[i];
			}
			if (numbers[i] >= max) {
				max = numbers[i];
			}
		}
		temp[0] = max;
		temp[1] = min;
		return temp;
	}

	public static double stddv(double[] numbers, int pointer, double mean) {
		double numerator = 0;
		for (int m = 0; m < pointer+1; m++) {
			double sqdif = Math.abs(numbers[m] - mean)*Math.abs(numbers[m] - mean);
			numerator += sqdif;
		}
		double stddv = Math.sqrt(numerator / (pointer+1));
		
		return stddv;
	}
	
	public static double mean(double[] numbers, int pointer) {
		double sum = 0;
		for (int e = 0; e < pointer+1; e++) {
			sum += numbers[e];
		}
		double mean = sum / (pointer+1);
		
		return mean;
	}
	
	public static double[] possibleOutliers(double[] numbers, int pointer, double stddv, double mean) {
		double[] temp = new double[pointer];
		int p = 0;
		int a = 0;
		
		for (int i = 0; i < pointer; i++) {
			if (Math.abs(numbers[i] - mean) > stddv) {
				temp[i] = numbers[i];
				p++;
			} else {
				temp[i] = Double.NaN;
			}
		}
		double[] possibles = new double[p];
		for (int i = 0; i < pointer; i++) {
			if (!Double.isNaN(temp[i])) {
				possibles[a] = temp[i];
				a++;
			}
		}
		
		return possibles;
	}
}