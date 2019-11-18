import javax.swing.JFrame;

public class Main extends JFrame {
	//Initial Commit
	public static void main(String[] args) throws InterruptedException {
		Frame frame = new Frame();
	    frame.init();  
	    frame.setTurnNumber(1);
	    frame.setEnemies(2);
	    
	    grabInput(frame,0);
	    printTest(frame , frame.getTurnNumber(), frame.getUserIntInput());
	    
	    grabInput(frame,0);
	    printTest(frame , frame.getTurnNumber(), frame.getUserIntInput());
	    
	}

	
	public static void grabInput(Frame frame, int type) throws InterruptedException {
		
		//If type == 0, Grab int
		//If type == 1, Grab String
		if(type == 0){
		    System.out.println("Int Selection: ");

		}else if(type == 1) {
		    System.out.println("String Selection: ");
		}
		
		//Wait for user input
		do{
		    Thread.sleep(750);
		}while(frame.text == null);
		
		//After grabbing the selection, send it to user and reset text to null for later
		if(type == 0){
		    System.out.println("Username: " + frame.getUserIntInput());

		}else if(type == 1) {
		    System.out.println("Username: " + frame.getUserStringInput());
		}
		frame.text = null;
	}
	
	public static void printTest(Frame frame, int turnNumber, int userInput) throws InterruptedException {
		frame.enemies--;
		
		for (int i = 0; i < userInput; i++) {
			Thread.sleep(500);
			turnNumber++;
			frame.setTurnNumber(turnNumber);
		}
		frame.setMapArea();
	}

}