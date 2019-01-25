package se.lexicon.daniel.schoolmanagement.controller;

import java.time.LocalDate;

import se.lexicon.daniel.schoolmanagement.service.SchoolService;
import se.lexicon.daniel.schoolmanagement.service.SchoolServiceSignatures;
import se.lexicon.daniel.schoolmanagement.utility.KeyboardInput;

public class ConsoleMenuController {
	private SchoolServiceSignatures schoolServiceInstance;
	private boolean running;

	/* 
	 * @param schoolMangment Initialize the interface that give access 
	 * to signatures from other locations in the program. 
	 */

	public ConsoleMenuController() {

		System.out.println("");
		System.out.println("|--------------------------------|");
		System.out.println("| School Management Assignment 5 |");
		System.out.println("|--------------------------------|");
		System.out.println("");

		schoolServiceInstance = SchoolService.getSchoolServiceInstance();

		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void run() {

		startingUserInterface(); // What action do you want to take?

	}

	public void startingUserInterface() {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [View] view student or course list \n" +
				" [Edit] Edit student or coruse. But you will need to know name or id \n" +
				" [Create] Create student or coruses. You will need to fill in its values \n" +
				" [Remove] Remove student or coruse or student from course but you will need to know it's name or id \n" +
				" [Quit] Immediately terminate the program...\n" +
				"\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "view":

			System.out.println("");
			System.out.println("|-------------------------|");
			System.out.println("| View student or courses |");
			System.out.println("|-------------------------|");
			System.out.println("");
			viewUserInterface();
			break;
		case "edit":
			System.out.println("");
			System.out.println("|-------------------------|");
			System.out.println("| Edit student or courses |");
			System.out.println("|-------------------------|");
			System.out.println("");
			editUserInterface();
			break;
		case "create":
			System.out.println("");
			System.out.println("|---------------------------|");
			System.out.println("| Create student or courses |");
			System.out.println("|---------------------------|");
			System.out.println("");
			createUserInterface();
			break;
		case "remove":
			System.out.println("");
			System.out.println("|---------------------------|");
			System.out.println("| Remove student or courses |");
			System.out.println("|---------------------------|");
			System.out.println("");
			removeUserInterface();
			break;
		case "quit":
			System.out.println("");
			System.out.println("|----------------------------|");
			System.out.println("| Terminating the program... |");
			System.out.println("|----------------------------|");
			System.out.println("");
			setRunning(false);
			break;
		default:
			System.out.println("");
			System.out.println("|-------------------|");
			System.out.println("| No such choice... |");
			System.out.println("|-------------------|");
			System.out.println("");

		}
	}

	public void viewUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] View Specific student. (name needed) \n" +
					" [Students] View student list \n" +
					" [Course] View Specific coruse. (name needed) \n" +
					" [Courses] View coruse list \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|--------------------------|");
				System.out.println("| View Specific student... |");
				System.out.println("|--------------------------|");
				System.out.println("");

				String studentName = KeyboardInput.getString(" Write the name of the student! \n" + " Your selection... ");
				schoolServiceInstance.findStudentByName(studentName);

				break;
			case "students":
				System.out.println("");
				System.out.println("|----------------------|");
				System.out.println("| View student list... |");
				System.out.println("|----------------------|");
				System.out.println("");

				schoolServiceInstance.findAllStudentModels();

				break;
			case "course":
				System.out.println("");
				System.out.println("|-------------------------|");
				System.out.println("| View Specific coruse... |");
				System.out.println("|-------------------------|");
				System.out.println("");

				String courseName = KeyboardInput.getString(" Write the name of the coruse! \n" + " Your selection... ");
				schoolServiceInstance.findCourseByName(courseName);

				break;
			case "courses":
				System.out.println("");
				System.out.println("|---------------------|");
				System.out.println("| View coruse list... |");
				System.out.println("|---------------------|");
				System.out.println("");

				schoolServiceInstance.findAllCourseModels();

				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				
				stopLoop = true;
				
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}

	}

	public void editUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] Edit Specific student. (name or id needed) \n" +
					" [Course] Edit Specific coruse. (name or id needed) \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|--------------------------|");
				System.out.println("| Edit Specific student... |");
				System.out.println("|--------------------------|");
				System.out.println("");
				break;
			case "course":
				System.out.println("");
				System.out.println("|-------------------------|");
				System.out.println("| Edit Specific coruse... |");
				System.out.println("|-------------------------|");
				System.out.println("");
				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}

	public void createUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] Create Specific student. (user input needed) \n" +
					" [Course] Create Specific coruse. (user input needed) \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|----------------------------|");
				System.out.println("| Create Specific student... |");
				System.out.println("|----------------------------|");
				System.out.println("");
				
				String userInputStudentName = KeyboardInput.getString(" [Student Name?]: ");
				String userInputStudentEmail = KeyboardInput.getString(" [Student Email?]: ");
				String userInputStudentAddress = KeyboardInput.getString(" [Student Address?]: ");
				schoolServiceInstance.registerNewStudent(userInputStudentName, userInputStudentEmail, userInputStudentAddress);
				
				System.out.println("");
				System.out.println("|----------------------------------|");
				System.out.println("| Finished Creating new student... |");
				System.out.println("|----------------------------------|");
				System.out.println("");
				break;
				
			case "course":
				System.out.println("");
				System.out.println("|---------------------------|");
				System.out.println("| Create Specific coruse... |");
				System.out.println("|---------------------------|");
				System.out.println("");
				
				String userInputCourseName = KeyboardInput.getString("[Course Name?]: ");
				LocalDate userInputCourseStartDate = KeyboardInput.getLocalDate("[Date]: ");
				int userInputCourseWeekDuration = KeyboardInput.StringToInt(KeyboardInput.getString("[Weeks]: "));
				schoolServiceInstance.registerNewCourse(userInputCourseName, userInputCourseStartDate, userInputCourseWeekDuration);
				
				System.out.println("");
				System.out.println("|---------------------------------|");
				System.out.println("| Finished Creating new coruse... |");
				System.out.println("|---------------------------------|");
				System.out.println("");
				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}
	public void removeUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] Remove Specific student. (name or id needed) \n" +
					" [Course] Remove Specific coruse. (name or id needed) \n" +
					" [Student-Course] Remove Specific student from course. (name or id needed from both) \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|----------------------------|");
				System.out.println("| Remove Specific student... |");
				System.out.println("|----------------------------|");
				System.out.println("");
				break;
			case "course":
				System.out.println("");
				System.out.println("|---------------------------|");
				System.out.println("| Remove Specific coruse... |");
				System.out.println("|---------------------------|");
				System.out.println("");
				break;
			case "student-course":
				System.out.println("");
				System.out.println("|----------------------------------------|");
				System.out.println("| Remove Specific student from course... |");
				System.out.println("|----------------------------------------|");
				System.out.println("");
				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}
}
