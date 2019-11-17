
public class Main {
	//Initial Commit
	public static void main(String[] args) throws InterruptedException {
		Frame frame = new Frame();
	    frame.init();  
	    frame.setTurnNumber(1);
	    frame.setEnemies(2);
	    
	    System.out.println("Type an Int");
	    grabInput(frame);
	    System.out.println(frame.getUserIntInput());
	    printTest(frame , frame.getTurnNumber());
		frame.text = null;
	    
	    System.out.println("Type a String");
	    grabInput(frame);
	    System.out.println(frame.getUserStringInput());
	    printTest(frame , frame.getTurnNumber());
	    frame.text = null;

	}

	
	public static void grabInput(Frame frame) throws InterruptedException {
		do{
		    Thread.sleep(750);
		}while(frame.text == null);
		System.out.println("Input taken");
	}
	
	public static void printTest(Frame frame, int turnNumber) throws InterruptedException {
		frame.enemies--;
		
		for (int i = 0; i < 5; i++) {
			Thread.sleep(500);
			turnNumber++;
			frame.setTurnNumber(turnNumber);
		}
	}

}