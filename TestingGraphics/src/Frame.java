import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.Timer;
import javax.swing.JDialog;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Frame extends JDialog{
    static JFrame frame = new JFrame();
    static JLabel lblError = new JLabel("");
    
    static JFrame frame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setVisible(true);
        frame.setMinimumSize(frame.getSize());
        frame.pack();

		return frame;
    }

    
    /**
     * @wbp.parser.entryPoint
     */
    static JPanel mainMenu() {

        JPanel menuPane = new JPanel();
        menuPane.setLayout(null);
        menuPane.setSize(500,300);
        
        JPanel panel = new JPanel();
        panel.setForeground(SystemColor.desktop);
        panel.setBackground(new Color(0,0,0,0));
        panel.setBounds(0, 0, 500, 300);
        panel.setVisible(true);
        menuPane.add(panel);

        
        JButton btnNewGame = new JButton("New Game");
        btnNewGame.setBounds(256, 94, 231, 41);
        menuPane.add(btnNewGame);
        
        JButton btnLoadBaseGame = new JButton("Load Base Game");
        btnLoadBaseGame.setBounds(256, 146, 231, 41);
        menuPane.add(btnLoadBaseGame);
        
        JButton btnLoadMap = new JButton("Load Map");
        btnLoadMap.setBounds(11, 205, 231, 41);
        menuPane.add(btnLoadMap);
        
        JButton btnLoadMapList = new JButton("Load Map List");
        btnLoadMapList.setBounds(256, 205, 231, 41);
        menuPane.add(btnLoadMapList);
        
        btnNewGame.addActionListener(new ActionListener(){
        	@Override 
        	public void actionPerformed(ActionEvent e) {
        		panel.setBackground(new Color(0,0,0,50));
        		try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		panel.setBackground(new Color(0,0,0,75));
        		try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		panel.setBackground(new Color(0,0,0,100));
        	}});
        		
        
        btnLoadBaseGame.addActionListener(new ActionListener(){
        	@Override 
        	public void actionPerformed(ActionEvent e) {
        		menuPane.setVisible(false);
        		try {
					//Main.loadGame(2, frame);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//Load base game
        	}	
        });
        
        btnLoadMap.addActionListener(new ActionListener(){
        	@Override 
        	public void actionPerformed(ActionEvent e) {
        		menuPane.setVisible(false);
        		try {
					//Main.loadGame(0, frame);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//Load specific map
        	}	
        });
        
        btnLoadMapList.addActionListener(new ActionListener(){
        	@Override 
        	public void actionPerformed(ActionEvent e) {
        		menuPane.setVisible(false);
        		try {
					//Main.loadGame(1, frame);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//Load Map list
        	}	
        });
        
    	SwingUtilities.updateComponentTreeUI(frame);
    return menuPane;
    }

    static JPanel newGame() {
    	
    	JPanel newGamePane = new JPanel();
    	newGamePane.setLayout(null);
    	newGamePane.setSize(500,300);
        
        JButton btnContinue = new JButton("Continue");
        btnContinue.setBounds(295, 121, 144, 32);
        newGamePane.add(btnContinue);
        
        JButton btnReturn = new JButton("Return to Menu");
        btnReturn.setBounds(10, 121, 144, 32);
        newGamePane.add(btnReturn);
        
        JTextField textName = new JTextField();
        textName.setBounds(232, 20, 207, 20);
        newGamePane.add(textName);
        textName.setColumns(10);
        
        JLabel lblPleaseEnterA = new JLabel("Please Enter a Player Name:");
        lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPleaseEnterA.setBounds(10, 11, 315, 32);
        newGamePane.add(lblPleaseEnterA);
        
        
        lblError.setBounds(10, 54, 207, 20);
        newGamePane.add(lblError);
        
        
        btnContinue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String name  = textName.getText();
        		try {
					//Main.newGame(name);
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
        });
        
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		return;
        	}
        });

    	return newGamePane;
    }
    
    
    
    
    //ErrorLabel----------------------------------------------------------
    public static void setlblError() {
    	lblError.setText("A save with this name already exists, please select another name.");
    }
    
	Timer timerOut = new Timer(200,  e -> fadeOut());
	Timer timerIn = new Timer(200,  e -> fadeIn());
    private float alfa = 1;
    int counter = 0;
    private JLabel label;
    private boolean isFadeIn = true;
    private JButton fadeIn, fadeOut;
    
    private float alpha;

    
    void fadeIn() {
    	timerIn.start();
    	timerIn.setInitialDelay(0);
    	
        if(counter == 7) {
        	timerIn.stop();
        	
        }
    	counter++;
    	System.out.println(counter);
        alfa = isFadeIn ? alfa + 0.1f : alfa -0.1f;
        if(alfa <=0 ) {
            alfa = 0; isFadeIn = true;
        }

        fadeIn.setEnabled(! isFadeIn); fadeOut.setEnabled(isFadeIn);
        label.setText("Alfa is " + alfa);
        setOpacity(alfa); //set JDialog opacity
    }
    
    void fadeOut() {
    	timerOut.start();
    	timerOut.setInitialDelay(0);
    	
        if(counter == 7) {
        	timerOut.stop();
        	
        }
    	counter++;
    	System.out.println(counter);
        alfa = isFadeIn ? alfa + 0.1f : alfa -0.1f;
        if(alfa >= 1) {
            alfa = 1; isFadeIn = false;
        }

        fadeIn.setEnabled(! isFadeIn); fadeOut.setEnabled(isFadeIn);
        label.setText("Alfa is " + alfa);
        setOpacity(alfa); //set JDialog opacity
    }
}




/*
 * //Send button listener send.addActionListener(new ActionListener(){
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * System.out.println("Enter"); if(Main.selection == 0) { Main.newGame(); }
 * 
 * if(Main.selection == 1) { try { Main.loadGame(); } catch (IOException e1) {
 * // TODO Auto-generated catch block e1.printStackTrace(); } } } });
 */




/*
 * pane.addKeyListener(new KeyListener() {
 * 
 * @Override public void keyTyped(KeyEvent e) {}
 * 
 * @Override public void keyReleased(KeyEvent e) {}
 * 
 * @Override public void keyPressed(KeyEvent e) {
 * 
 * if (e.getKeyCode() == KeyEvent.VK_UP) { if(Main.selection == 0) {
 * Main.selection++; if (Main.selection == 1) { System.out.println("Load Game");
 * } }
 * 
 * } if (e.getKeyCode() == KeyEvent.VK_DOWN) { if(Main.selection == 1 ) {
 * Main.selection--; if (Main.selection == 0) { System.out.println("New Game");
 * } } } } });
 * 
 * 
 */
