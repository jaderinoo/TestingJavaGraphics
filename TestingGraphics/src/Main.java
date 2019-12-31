import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Main {
    
    static int row = 0;
    static int col = 0;
    static int selection = 0;
    
    public static void main(String[] args) {
        JFrame f=new JFrame("Test slider component app");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.getContentPane().add(initSlider());
        f.pack();
        f.setState(JFrame.MAXIMIZED_BOTH);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
 
    public static JComponent initSlider() {
        JSLSlider slider=new JSLSlider();
        slider.addSliderComponent(new JButton("JButton instance - component 1"));
        slider.addSliderComponent(new JLabel("Long text JLabel instance - component 2"));
        slider.addSliderComponent(new JTextField("JTextField instance - component 3"));
        slider.refresh();
        
        return slider;
    }



    @SuppressWarnings("unchecked")
	public static void saveUpdater(ArrayList<Player> playerList, String name) throws IOException {
    	
    	//Create the jsonArray
    	JSONArray objList = new JSONArray();
    	
    	//Loop all information into jsonObject
    	for(int i = 0; i != playerList.size(); i++) {

    		JSONObject playerDetails = new JSONObject();
    		playerDetails.put("Name",playerList.get(i).getName());
    		playerDetails.put("Str",playerList.get(i).getStr());
    		JSONObject PlayerObject = new JSONObject(); 
    		PlayerObject.put("Character", playerDetails);
    		objList.add(PlayerObject);
    	}
    	
    	//Write JSON file
        try (FileWriter file = new FileWriter("src\\saves\\" + name + ".json")) {
 
            file.write(objList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
    @SuppressWarnings("unchecked")
	public static ArrayList<Player> saveReader(String name) throws org.json.simple.parser.ParseException {
    	ArrayList<Player> playerList = new ArrayList<Player>();
    	
    	JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("src\\saves\\" + name + ".json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> parsePlayerObject( (JSONObject) emp, playerList ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return playerList;
    }

    private static void parsePlayerObject(JSONObject character, ArrayList<Player> playerList) 
    {
        //Get the player object for Character
        JSONObject playerObject = (JSONObject) character.get("Character");
         
        //Get employee first name
        String name = (String) playerObject.get("Name");    
        System.out.println(name);
         
        //Get employee last name
        int str = Math.toIntExact((long) playerObject.get("Str"));  
        System.out.println(str);

        Player player = new Player(name,str);
        playerList.add(player);
    }
    
    
    public static void waiter() {
    	Scanner sc = new Scanner(System.in); 
    	  
    	System.out.println("Waiting lmao");
        // String input 
        String name = sc.nextLine(); 
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