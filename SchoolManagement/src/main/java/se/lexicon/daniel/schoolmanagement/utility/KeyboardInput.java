package se.lexicon.daniel.schoolmanagement.utility;

import java.util.Scanner;

	public class KeyboardInput {
		// Scanner function and Random function.
		static Scanner keyboard = new Scanner(System.in);
	    public static String getString(String inputString) {
	        System.out.print(inputString);
	        return keyboard.nextLine();
	    }
	}
