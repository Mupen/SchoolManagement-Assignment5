package se.lexicon.daniel.schoolmanagement;

import se.lexicon.daniel.schoolmanagement.controller.ConsoleMenuController;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) {
        
    	ConsoleMenuController ui = new ConsoleMenuController();
    	while(ui.isRunning()) {
    		ui.run();
    		
    	}
    }
}
