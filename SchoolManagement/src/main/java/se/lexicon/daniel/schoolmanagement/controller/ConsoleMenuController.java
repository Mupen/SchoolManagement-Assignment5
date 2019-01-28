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
		System.out.println("|--------------------------------------|");
		System.out.println("|    School Management Assignment 5    |");
		System.out.println("|--------------------------------------|");
		System.out.println("");

		schoolServiceInstance = SchoolService.getSchoolServiceInstance();
		
		schoolServiceInstance.registerNewStudent("Roger", "Roger@Gmail.com", "Nygatan 350 01 Växjö");
		schoolServiceInstance.registerNewStudent("Lamar", "Lamar@Gmail.com", "Nygatan 350 02 Växjö");
		schoolServiceInstance.registerNewStudent("Wyatt", "Wyatt@Gmail.com", "Nygatan 350 03 Växjö");
		schoolServiceInstance.registerNewStudent("Sergio", "Sergio@Gmail.com", "Nygatan 350 04 Växjö");
		schoolServiceInstance.registerNewStudent("Keith", "Keith@Gmail.com", "Nygatan 350 05 Växjö");
		schoolServiceInstance.registerNewStudent("Kevin", "Kevin@Gmail.com", "Nygatan 350 06 Växjö");
		schoolServiceInstance.registerNewStudent("Peter", "Peter@Gmail.com", "Nygatan 350 07 Växjö");
		schoolServiceInstance.registerNewStudent("Wiley", "Wiley@Gmail.com", "Nygatan 350 08 Växjö");
		schoolServiceInstance.registerNewStudent("Jeffrey", "Jeffrey@Gmail.com", "Nygatan 350 09 Växjö");
		schoolServiceInstance.registerNewStudent("Jerry", "Jerry@Gmail.com", "Nygatan 350 10 Växjö");
		schoolServiceInstance.registerNewStudent("Michael", "Michael@Gmail.com", "Nygatan 350 11 Växjö");
		schoolServiceInstance.registerNewStudent("Jeremy", "Jeremy@Gmail.com", "Nygatan 350 12 Växjö");
		schoolServiceInstance.registerNewStudent("Roderick", "Roderick@Gmail.com", "Nygatan 350 13 Växjö");
		schoolServiceInstance.registerNewStudent("Tyler", "Tyler@Gmail.com", "Nygatan 350 14 Växjö");
		schoolServiceInstance.registerNewStudent("Travis", "Travis@Gmail.com", "Nygatan 350 15 Växjö");
		schoolServiceInstance.registerNewStudent("Gary", "Gary@Gmail.com", "Nygatan 350 16 Växjö");
		schoolServiceInstance.registerNewStudent("James", "James@Gmail.com", "Nygatan 350 17 Växjö");
		schoolServiceInstance.registerNewStudent("Frank", "Frank@Gmail.com", "Nygatan 350 18 Växjö");
		schoolServiceInstance.registerNewStudent("Harold", "Harold@Gmail.com", "Nygatan 350 19 Växjö");
		schoolServiceInstance.registerNewStudent("Brian ", "Brian@Gmail.com", "Nygatan 350 20 Växjö");
		
		schoolServiceInstance.registerNewCourse("Math", LocalDate.parse("2018-01-01"), 8);
		schoolServiceInstance.registerNewCourse("English", LocalDate.parse("2018-03-07"), 12);
		schoolServiceInstance.registerNewCourse("Java", LocalDate.parse("2018-06-14"), 16);
		schoolServiceInstance.registerNewCourse(".Net", LocalDate.parse("2018-09-21"), 18);
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
				" [View]   View student or course list \n" +
				" [Edit]   Edit student or coruse. (Identifier needed) \n" +
				" [Create] Create student or coruses. (Input needed) \n" +
				" [Remove] Remove student or coruse or student from course (Identifier needed) \n" +
				" [Quit]   Immediately terminate the program...\n" +
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
					" [Student]  View specific student. (Identifier needed) \n" +
					" [Students] View student list \n" +
					" [Course]   View specific coruse. (Identifier needed) \n" +
					" [Courses]  View coruse list \n" +
					" [Back]     Immediately go back to starting menu \n" +
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
				System.out.println(schoolServiceInstance.findStudentByName(studentName));
				break;
				
			case "students":
				System.out.println("");
				System.out.println("|----------------------|");
				System.out.println("| View student list... |");
				System.out.println("|----------------------|");
				System.out.println("");
				System.out.println(schoolServiceInstance.findAllStudentModels().toString());
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
				schoolServiceInstance.findAllCourseModels().toString();
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
}
