package se.lexicon.daniel.schoolmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;
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
		String userInput = KeyboardInput.getString("\n What action do you want to take? \n" +
				"\n" +
				" [View]   View student or course list \n" +
				" [Edit]   Edit student or coruse. (Identifier needed) \n" +
				" [Create] Create student or coruses. (Input needed) \n" +
				" [Remove] Remove student or coruse or student from course (Identifier needed) \n" +
				" [Quit]   Immediately terminate the program...\n" +
				" \n" +
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
			String userInput = KeyboardInput.getString("\n What action do you want to take? \n" +
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
				System.out.println("|--------------------------------|");
				System.out.println("| Start View Specific Student... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				String studentName = KeyboardInput.getString("\n Write the name of the student! \n" + " Your selection...");
				schoolServiceInstance.findStudentByName(studentName.toLowerCase()).forEach(n -> System.out.print(n.stringBuilder()));
				System.out.println("");
				System.out.println("|-------------------------------|");
				System.out.println("| Stop View Specific Student... |");
				System.out.println("|-------------------------------|");
				System.out.println("");
				break;
				
			case "students":
				System.out.println("");
				System.out.println("|----------------------------|");
				System.out.println("| Start View Student List... |");
				System.out.println("|----------------------------|");
				System.out.println("");
				schoolServiceInstance.findAllStudentModels().forEach(n -> System.out.print(n.stringBuilder()));
				System.out.println("");
				System.out.println("|---------------------------|");
				System.out.println("| Stop View Student List... |");
				System.out.println("|---------------------------|");
				System.out.println("");
				break;
				
			case "course":
				System.out.println("");
				System.out.println("|-------------------------------|");
				System.out.println("| Start View Specific Coruse... |");
				System.out.println("|-------------------------------|");
				System.out.println("");
				String courseName = KeyboardInput.getString(" Write the name of the coruse! \n" + " Your selection...");
				schoolServiceInstance.findCourseByName(courseName.toLowerCase()).forEach(n -> System.out.print(n.stringBuilder()));
				System.out.println("");
				System.out.println("|------------------------------|");
				System.out.println("| Stop View Specific Coruse... |");
				System.out.println("|------------------------------|");
				System.out.println("");
				break;
				
			case "courses":
				System.out.println("");
				System.out.println("|------------------------------------|");
				System.out.println("| Start View Specific Coruse List... |");
				System.out.println("|------------------------------------|");
				System.out.println("");
				schoolServiceInstance.findAllCourseModels().forEach(n -> System.out.print(n.stringBuilder()));
				System.out.println("");
				System.out.println("|-----------------------------------|");
				System.out.println("| Stop View Specific Coruse List... |");
				System.out.println("|-----------------------------------|");
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
			String userInput = KeyboardInput.getString("\n What action do you want to take? \n" +
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
				List<StudentModels> editStudentModelsObjectList = filteringStudentModelsUserInput();
				if(editStudentModelsObjectList == null) {
					System.out.println("\n***** You can't find any result *****");
				}
				else {
					schoolServiceInstance.removeStudent(editStudentModelsObjectList.get(0));
				}
				System.out.println("");
				System.out.println("|-------------------------------------|");
				System.out.println("| Finished Remove Specific student... |");
				System.out.println("|-------------------------------------|");
				System.out.println("");
				break;
				
			case "course":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Remove Specific Course List... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				List<CourseModels> editCourseModelsObjectList = filteringCourseModelsUserInput();
				if(editCourseModelsObjectList == null) {
					System.out.println("\n***** You can't find any result *****");
				}
				else {
					schoolServiceInstance.removeCourse(editCourseModelsObjectList.get(0));
				}
				System.out.println("");
				System.out.println("|-----------------------------------------|");
				System.out.println("| Finished Remove Specific Course List... |");
				System.out.println("|-----------------------------------------|");
				System.out.println("");
				break;
				
			case "student-course":
				System.out.println("");
				System.out.println("|----------------------------------------|");
				System.out.println("| Remove Specific Student From Course... |");
				System.out.println("|----------------------------------------|");
				System.out.println("");
				System.out.println("***** Work in progress *****");
				System.out.println("");
				System.out.println("|------------------------------------------|");
				System.out.println("| Finished Specific Student From Course... |");
				System.out.println("|------------------------------------------|");
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
	
	public void editUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString("\n What action do you want to take? \n" +
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
				System.out.println("|--------------------------------|");
				System.out.println("| Start Edit Specific Student... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				List<StudentModels> editStudentModelsObjectList = filteringStudentModelsUserInput();
				if(editStudentModelsObjectList == null) {
					System.out.println("\n***** You can't find any result *****");
				}
				else {
					editStudentInterface(editStudentModelsObjectList);
				}
				System.out.println("");
				System.out.println("|-----------------------------------|");
				System.out.println("| Finished Edit Specific Student... |");
				System.out.println("|-----------------------------------|");
				System.out.println("");
				break;
				
			case "course":
				System.out.println("");
				System.out.println("|-------------------------------|");
				System.out.println("| Start Edit Specific Course... |");
				System.out.println("|-------------------------------|");
				System.out.println("");
				List<CourseModels> editCourseModelsObjectList = filteringCourseModelsUserInput();
				if(editCourseModelsObjectList == null) {
					System.out.println("\n***** You can't find any result *****");
				}
				else {
					editCoruseInterface(editCourseModelsObjectList);
				}
				System.out.println("");
				System.out.println("|----------------------------------|");
				System.out.println("| Finished Edit Specific Course... |");
				System.out.println("|----------------------------------|");
				System.out.println("");
				break;
				
			case "student-course":
				System.out.println("");
				System.out.println("|-----------------------------------|");
				System.out.println("| Add Specific Student To Course... |");
				System.out.println("|-----------------------------------|");
				System.out.println("");
				System.out.println("***** Work in progress *****");
				System.out.println("");
				System.out.println("|--------------------------------------------|");
				System.out.println("| Finished Add Specific Student To Course... |");
				System.out.println("|--------------------------------------------|");
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
	
	public void editStudentInterface(List<StudentModels> editObjectList) {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString("\n What action do you want to take? \n" +
					"\n" +
					" [Name] Edit Specific student name. \n" +
					" [Email] Edit Specific student email. \n" +
					" [Address] Edit Specific student address. \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "name":
				System.out.println("");
				System.out.println("|-------------------------------|");
				System.out.println("| Edit Specific Student Name... |");
				System.out.println("|-------------------------------|");
				System.out.println("");
				
				String userInputStudentName = KeyboardInput.getString("\n [Name]...");
				schoolServiceInstance.editStudentNameByName(editObjectList.get(0), userInputStudentName);
				
				System.out.println("");
				System.out.println("|----------------------------------|");
				System.out.println("| Finished Editing Student Name... |");
				System.out.println("|----------------------------------|");
				System.out.println("");
				break;
				
			case "email":
				System.out.println("");
				System.out.println("|---------------------------------|");
				System.out.println("| Edit Specific Studentc Email... |");
				System.out.println("|---------------------------------|");
				System.out.println("");
				
				String userInputStudentEmaile = KeyboardInput.getString("\n [Email]...");
				schoolServiceInstance.editStudentEmailByName(editObjectList.get(0), userInputStudentEmaile);
				
				System.out.println("");
				System.out.println("|-----------------------------------|");
				System.out.println("| Finished Editing Student Email... |");
				System.out.println("|-----------------------------------|");
				System.out.println("");
				break;

			case "address":
				System.out.println("");
				System.out.println("|----------------------------------|");
				System.out.println("| Edit Specific Student Address... |");
				System.out.println("|----------------------------------|");
				System.out.println("");
				
				String userInputStudentAddress = KeyboardInput.getString("\n [Address]...");
				schoolServiceInstance.editStudentAddressByName(editObjectList.get(0), userInputStudentAddress);
				
				System.out.println("");
				System.out.println("|-------------------------------------|");
				System.out.println("| Finished Editing Student Address... |");
				System.out.println("|-------------------------------------|");
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
	
	public void editCoruseInterface(List<CourseModels> editObjectList) {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString("\n What action do you want to take? \n" +
					"\n" +
					" [Name] Edit Specific coruse Name. \n" +
					" [Date] Edit Specific coruse Date. \n" +
					" [Weeks] Edit Specific coruse Duration. \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "name":
				System.out.println("");
				System.out.println("|------------------------------|");
				System.out.println("| Edit Specific Course Name... |");
				System.out.println("|------------------------------|");
				System.out.println("");
				
				String userInputStudentName = KeyboardInput.getString("\n [Name]: ");
				schoolServiceInstance.editCoursetNameByName(editObjectList.get(0), userInputStudentName);
				
				System.out.println("");
				System.out.println("|---------------------------------|");
				System.out.println("| Finished Editing Course Name... |");
				System.out.println("|---------------------------------|");
				System.out.println("");
				break;
				
			case "date":
				System.out.println("");
				System.out.println("|---------------------------------------|");
				System.out.println("| Edit Specific Course Starting Date... |");
				System.out.println("|---------------------------------------|");
				System.out.println("");
				
				LocalDate userInputCourseStartDate = KeyboardInput.getLocalDate("[Date]: ");
				schoolServiceInstance.editCoursetStartDateByName(editObjectList.get(0), userInputCourseStartDate);
				
				System.out.println("");
				System.out.println("|------------------------------------------|");
				System.out.println("| Finished Editing Course Starting Date... |");
				System.out.println("|------------------------------------------|");
				System.out.println("");
				break;

			case "weeks":
				System.out.println("");
				System.out.println("|---------------------------------------|");
				System.out.println("| Edit Specific Course Week Duration... |");
				System.out.println("|---------------------------------------|");
				System.out.println("");
				
				int userInputCourseWeekDuration = KeyboardInput.StringToInt(KeyboardInput.getString("[Weeks]: "));
				schoolServiceInstance.editCoursetWeekDurationByName(editObjectList.get(0), userInputCourseWeekDuration);
				
				System.out.println("");
				System.out.println("|------------------------------------------|");
				System.out.println("| Finished Editing Course Week Duration... |");
				System.out.println("|------------------------------------------|");
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

	public List<StudentModels> filteringStudentModelsUserInput() {
		String studentName = KeyboardInput.getString("\n Write the name of the student! \n" + " Your selection... ");
		List<StudentModels> editStudentObjectList = schoolServiceInstance.findStudentByName(studentName);
		int studentListSize = editStudentObjectList.size();
		
		if (1 == studentListSize) {
			System.out.println("\n***** You have one result *****");
			editStudentObjectList.forEach(n -> System.out.print(n.stringBuilder()));
			return editStudentObjectList;
		} 
		else if (2 <= studentListSize) {
			System.out.println("\n***** You have more result than one *****");
			editStudentObjectList.forEach(n -> System.out.print(n.stringBuilder()));
			String stringStudentID = KeyboardInput.getString("\n Write the id of the student you want to edit \n" + " Your selection... ");
			int studentID = KeyboardInput.StringToInt(stringStudentID);
			
			List<StudentModels> editFinalStudentObjectList = schoolServiceInstance.findStudentByIdFromNameList(editStudentObjectList, studentID);
			if (editFinalStudentObjectList != null) {editFinalStudentObjectList.forEach(n -> System.out.print(n.stringBuilder()));}
			else {System.out.println("\n***** Can't find a existing id *****");}
			return editFinalStudentObjectList;
		}
		return null;
	}
	
	public List<CourseModels> filteringCourseModelsUserInput() {
		String coruseName = KeyboardInput.getString("\n Write the name of the Coruse! \n" + " Your selection... ");
		List<CourseModels> editCoruseObjectList = schoolServiceInstance.findCourseByName(coruseName);
		int coruseListSize = editCoruseObjectList.size();
		
		if (1 == coruseListSize) {
			System.out.println("\n***** You have one result *****");
			editCoruseObjectList.forEach(n -> System.out.print(n.stringBuilder()));
			return editCoruseObjectList;
		} 
		else if (2 <= coruseListSize) {
			System.out.println("\n***** You have more result than one *****");
			editCoruseObjectList.forEach(n -> System.out.print(n.stringBuilder()));
			String stringStudentID = KeyboardInput.getString("\n Write the id of the student you want to edit \n" + " Your selection... ");
			int studentID = KeyboardInput.StringToInt(stringStudentID);
			
			List<CourseModels> editFinalCoruseObjectList = schoolServiceInstance.findCourseByIdFromNameList(editCoruseObjectList, studentID);
			if (editFinalCoruseObjectList != null) {editFinalCoruseObjectList.forEach(n -> System.out.print(n.stringBuilder()));}
			else {System.out.println("\n***** Can't find a existing id *****");}
			return editFinalCoruseObjectList;
		}
		return null;
	}
}
