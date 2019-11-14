import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
	//Initial Commit
	public static void main(String[] args) throws InterruptedException {
		Frame frame = new Frame();
	    frame.init();
	    
	    frame.setTurnNumber(1);
	    
	    System.out.println("Type 1");
	    int turnNumber = frame.getTurnNumber();
	    
	    
	    
	    frame.setEnemies(2);
	    
	    
	    
	    
	}
	
	public static void printTest(Frame frame, int turnNumber) throws InterruptedException {
		frame.enemies--;
		System.out.println("printTest");
		
		while(turnNumber != 10) {
			Thread.sleep(500);
			turnNumber++;
			frame.setTurnNumber(turnNumber);
		}
	}

}