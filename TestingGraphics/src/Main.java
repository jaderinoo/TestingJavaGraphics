import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main {
	//Initial Commit
    static JFrame frame = MapSpace.mapSpace();
    
    static int row = 0;
    static int col = 0;
    
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in); 

    	paint();

    	while(row <= 30) {
    		System.out.println("row + ?");
    		row = row + sc.nextInt();
    	}

    


    }


    public static void paint() throws IOException {

        final BufferedImage image = ImageIO.read(new File("src\\tilesets\\Player.png"));
        
        JPanel pane = new JPanel() {
        	
            @Override
            
            protected void paintComponent(Graphics g) {
            	super.removeAll();
                super.paintComponent(g);
                super.updateUI();
                g.drawImage(image, row*16, col*16, null);
            }
        };

        frame.add(pane);
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
	    frame.setEnemies((frame.enemies--));
		frame.setMapArea();
	}

}