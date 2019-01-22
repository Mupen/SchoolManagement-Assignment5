package se.lexicon.daniel.schoolmanagement.controller;

public class ConsoleMenuController {
	// object from class
// 	private EmployeeService employeeService;
	private boolean running;
		
	public ConsoleMenuController() {
		// object initialization
//		employeeService = EmployeeServiceImpl.get();
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void run() {
		//Write code here	
		System.out.println("Check Before exit");
		setRunning(false);
		System.out.println("Check After exit");
	}
}
