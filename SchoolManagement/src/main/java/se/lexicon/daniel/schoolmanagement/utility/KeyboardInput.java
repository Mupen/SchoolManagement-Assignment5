package se.lexicon.daniel.schoolmanagement.utility;

import java.time.LocalDate;
import java.util.Scanner;

	public class KeyboardInput {
		// Scanner function and Random function.
		static Scanner keyboard = new Scanner(System.in);
		
		
	    public static String getString(String inputString) {
	        System.out.print(inputString);
	        return keyboard.nextLine();
	    }
	    
		public static LocalDate getLocalDate(String inputString) {
			System.out.print(inputString);
			LocalDate newDateInput = LocalDate.parse(keyboard.nextLine());
	        return newDateInput;
		}
		
		public static int getInt() {
			try {
				System.out.println("Enter a number: ");
				String input = keyboard.nextLine();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {System.out.println("Not a valid number");
				return getInt();
			}
		}
		
	    public static int StringToInt(String inputString) {
			if(inputString.equals(null) || inputString.equals("") || !inputString.matches("[0-9]+")) {
				System.out.println("Not a valid input...");
				return StringToInt(KeyboardInput.getString("Please enter a valid input: "));
			}
			else {
				int intNumber = Integer.parseInt(inputString);
				return intNumber;
			}
	    }
	}
