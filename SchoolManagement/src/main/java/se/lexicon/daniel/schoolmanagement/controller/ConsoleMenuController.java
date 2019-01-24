package se.lexicon.daniel.schoolmanagement.controller;


public class ConsoleMenuController {
 	private ConsoleViewController viewMenu; 
 	private boolean running;
 	
 	/* 
 	* @param schoolMangment Initialize the interface that give access 
 	* to signatures from other locations in the program. 
 	*/
 	
	public ConsoleMenuController() {
		viewMenu = new ConsoleViewController();
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void run() {
		viewMenu.startingUserInterface(); 	
		setRunning(false);
	}

}
