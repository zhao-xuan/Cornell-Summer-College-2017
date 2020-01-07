package Lecture01;

import java.io.*;

public class Lecture01 {
	public static void main(String[] args) throws IOException {
		while (true) {
			InputStreamReader nab = new InputStreamReader(System.in);
			BufferedReader grab = new BufferedReader(nab);
			System.out.println("Please enter a number");
			String input;
			boolean success = true;
			int x = 0, max_tries = 0;
			do {
				try {
					max_tries = max_tries + 1;
					input = grab.readLine();
					x = Integer.parseInt(input);
					success = true;
				} catch (IOException e) {
					System.out.println("There is an IOException! You have " +(3 - max_tries+1)+ "times to try. Try to re-enter:");
				} catch (NumberFormatException nfe) {
					System.out.println("There is a NumberFormetException! You have " +(3 - max_tries+1)+ "times to try. Try to re-enter:");
					success = false;
				}
			} while (!success && max_tries <= 3);
			long answer = success ? (x*x) : -19;
			System.out.println("x squared = " + answer);
		}
	}
}