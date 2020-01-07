package Lecture02;

import java.io.*;

import Lecture01.CharFreq;

public class Lecture02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		
		System.out.println("Please enter a string to detect chars:");
		String text_input = grab.readLine();
		
		String all_chars = populate_chars();
		CharFreq[] freqs = new CharFreq[all_chars.length()];
		
		for (int a = 0; a < freqs.length; a++) {
			freqs[a] = new CharFreq(all_chars.charAt(a), 0);
		}
		
		char explore;
		for (int i = 0; i < text_input.length(); i++) {
			explore = text_input.charAt(i);
			int j = 0;
			boolean found_it = false;
			while (j < all_chars.length() && !found_it) {
				if (explore == all_chars.charAt(j)) {
					found_it = true;
				} else {
					j++;
				}
			}
			if (!found_it)
				System.out.println("false");
			else
				freqs[j].freq++;
		}
		printFreq(all_chars, freqs);
	}
	
	public static void printFreq(String all_chars, CharFreq[] freqs) {
		for (int i = 0; i < freqs.length; i++) {
			if (freqs[i].freq > 0) {
				System.out.println("The character " + freqs[i].my_char + " appears " + freqs[i].freq + " times.");
			}
		}
	}
	
	public static String populate_chars() {
		String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower_case = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String punct = "~!@#$%^&*()_+{}|:\"<>? ";
		
		return (upper_case + lower_case + digits + punct);
	}

}