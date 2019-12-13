import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Main {
	//Initial Commit
   // static JFrame frame = Frame.frame();
    
    static int row = 0;
    static int col = 0;
    static int selection = 0;
    
    public static void main(String[] args) throws IOException, InterruptedException {
    	//frame.add(Frame.mainMenu());

    	
    	//new File("src\\saves\\test").mkdir();
    }
    
    public static void newGame() {
    	System.out.println("newGame");
    	
    }
    
    public static void loadGame() throws IOException {
    	System.out.println("loadGame");
    	
    	paint();
    }

    public static void playerUpdater(Player player) throws IOException {
    	
    	
    	
    	
    	
		FileWriter fileWriter = new FileWriter("src\\saves\\" + player.getName() + "\\" + player.getName() + ".txt", false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
	    BufferedReader reader = new BufferedReader(new FileReader("src\\saves\\" + player.getName() + "\\" + player.getName() + ".txt"));

	    //Print stats to new file
	    printWriter.println(player.getName() +
	    		"\n" + player.getStr());
	    
	    printWriter.close();
	    reader.close();
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

        //frame.add(pane);
    }
}