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
    static int selection = 0;
    
    public static void main(String[] args) throws IOException, InterruptedException {
    	paint();
    	
    	System.out.println("Please Select an Option:\n"
				+ " 1 - New Game\n"
				+ " 2 - Load Base Game");

		System.out.print("Selection: ");
		selection = 0;
		
    }
    
    public static void newGame() {
    	System.out.println("newGame");
    }
    
    public static void loadGame() {
    	System.out.println("loadGame");
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
}