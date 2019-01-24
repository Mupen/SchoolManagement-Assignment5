package se.lexicon.daniel.schoolmanagement.controller;

import se.lexicon.daniel.schoolmanagement.utility.KeyboardInput;

public class ConsoleViewController {
	
	public void startingUserInterface() {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [View] view student or course list \n" +
				" [Edit] Edit student or coruse. But you will need to know name or id \n" +
				" [Create] Create student or coruses. You will need to fill in its values \n" +
				" [Remove] Remove student or coruse or student from course but you will need to know it's name or id \n" +
				" [Quit] Immediately terminate the program\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "view":
			viewUserInterface();
			break;
		case "edit":
			editUserInterface();
			break;
		case "create":
			createUserInterface();
			break;
		case "remove":
			removeUserInterface();
			break;
		case "quit":
			System.out.println("Terminating the program...");
			break;
		}
	}

	public void viewUserInterface() {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [Students] view student or course list \n" +
				" [Courses] Edit student or coruse. But you will need to know name or id \n" +
				" [Everything] Create student or coruses. You will need to fill in its values \n" +
				" [Remove] Remove student or coruse or student from course but you will need to know it's name or id \n" +
				" [Quit] Immediately terminate the program\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "students":
			break;
		case "courses":
			break;
		case "everything":
			break;
		}
	}

	public void editUserInterface() {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [View] view student or course list \n" +
				" [Edit] Edit student or coruse. But you will need to know name or id \n" +
				" [Create] Create student or coruses. You will need to fill in its values \n" +
				" [Remove] Remove student or coruse or student from course but you will need to know it's name or id \n" +
				" [Quit] Immediately terminate the program\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "View":
			break;
		case "Edit":
			break;
		case "Create":
			break;
		case "Remove":
			break;
		case "Quit":
			break;
		}
	}

	public void createUserInterface() {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [View] view student or course list \n" +
				" [Edit] Edit student or coruse. But you will need to know name or id \n" +
				" [Create] Create student or coruses. You will need to fill in its values \n" +
				" [Remove] Remove student or coruse or student from course but you will need to know it's name or id \n" +
				" [Quit] Immediately terminate the program\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "View":
			break;
		case "Edit":
			break;
		case "Create":
			break;
		case "Remove":
			break;
		case "Quit":
			break;
		}
	}

	public void removeUserInterface() {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [View] view student or course list \n" +
				" [Edit] Edit student or coruse. But you will need to know name or id \n" +
				" [Create] Create student or coruses. You will need to fill in its values \n" +
				" [Remove] Remove student or coruse or student from course but you will need to know it's name or id \n" +
				" [Quit] Immediately terminate the program\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "View":
			break;
		case "Edit":
			break;
		case "Create":
			break;
		case "Remove":
			break;
		case "Quit":
			break;
		}
	}
}
