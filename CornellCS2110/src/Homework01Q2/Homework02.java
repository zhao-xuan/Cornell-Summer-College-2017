package Homework01Q2;

import java.io.*;

/*
 * 	Author: Tom Zhao
 * 	Date: July. 4th. 2017
 * 	For: CS2110 Homework01 - Question02
 * 	Important information:
 * 		1. There is only one way to input data, as the question indicates
 * 		2. IMPORTANT: Homework01 - Question01 and Question02 are just in different classes! Ignore the Lecture package if has any
 * 		3. IMPORTANT: You may be required to enter the full directory of the file if it says 'No such directory'!
 */

public class Homework02 {

	public static void main(String[] args) throws IOException {
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		System.out.println("Please enter a file name to see how many distinct words there are:");
		String fileName = null;
		FileReader secret = null;
		BufferedReader james = null;
		boolean flag = false;
		String input = "";
		String stringLine = "";
		
		while (!flag) {
			try {
				fileName = grab.readLine();
				secret = new FileReader (fileName);
				james = new BufferedReader (secret);
				flag = true;
			} catch (FileNotFoundException e) {
				System.out.println("No such directory; Try to re-enter:");
			}
		}
		System.out.println(stringLine);
		int index1 = 0;
		int index2 = 0;
		char target;
		String singleWord = "";
		String[] initialWordList = new String[100];
		
		while (input != null) {
			input = james.readLine();
			if (input == null)
				break;
			stringLine += input;
		}
		stringLine = stringLine.substring(0);
		stringLine = trimPunc(stringLine);
		System.out.println("The origial text: " + stringLine);
		
		while (index1 < stringLine.length()) {
			do {
				target = stringLine.charAt(index1);
				singleWord += target;
				index1++;
			} while (index1 < stringLine.length() && !checkPunc(stringLine.charAt(index1)));
			index1++;
			initialWordList[index2] = singleWord.substring(0);
			index2++;
			singleWord = "";
		}
		
		for (int i = 0; i < initialWordList.length && initialWordList[i] != null; i++) {
			String temp = initialWordList[i];
			for (int j = i+1; j < initialWordList.length && initialWordList[j] != null; j++) {
				if (initialWordList[j].equals(temp)) {
					initialWordList[j] = "";
				}
			}
			initialWordList[i].trim();
		}
		
		int length = 0;
		//System.out.println(initialWordList[0]);
		for (int i = 0; i < initialWordList.length && initialWordList[i] != null; i++) {
			if (initialWordList[i].indexOf(' ') != -1 && initialWordList[i].indexOf('\r') != -1) {
				initialWordList[i].substring(1);
			}
			if (checkWord(initialWordList[i])) {
				length++;
			}
		}
		
		String[] realWordList = new String[length];
		
		int index3 = 0;
		for (int i = 0; i < initialWordList.length; i++) {
			if (index3 < length && checkWord(initialWordList[i])) {
				//System.out.println(realWordList[i]);
				realWordList[index3] = initialWordList[i];
				index3++;
			}
		}
		System.out.println("The separate list of string: ");
		for (int i = 0; i < realWordList.length; i++) {
			System.out.println("The " + (i+1) + " th word in the Array: " + realWordList[i]);
		}
		System.out.println("There are " + realWordList.length + " distinct words in the file!");
	}
	
	public static boolean checkWord(String word) {
		return (word == null ? false : ((word.equals(" ") || word == "" || word.equals("\n") || word.equals("\r")) ? false : true));
	}
	
	public static boolean checkPunc(char c) {
		String punc = ".~!@#$%^&*()_+{}|:\"<>? ";
		for (int i = 0; i < punc.length(); i++) {
			if (c == punc.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static String trimPunc(String s) {
		String punc = "~!@#$%^&*()_+{}|:\"<>?`-=[]\\;',./\'";
		for (int i = 0; i < punc.length(); i++) {
			s = s.replace(punc.charAt(i), ' ');
		}
		return s;
	}
}