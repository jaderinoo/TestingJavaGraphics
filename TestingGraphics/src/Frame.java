//Usually you will require both swing and awt packages
// even if you are working with just swings.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

class Frame extends JFrame {
	final JFrame frame = new JFrame();
    String text = "Null";
    int number = 0;
    int enemies = 0;
    int userInput = 0;
    private JTable table;
    private JTextField textField;
    private JTextField turnNumber;
    private JTextField enemyCount;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    
    public Frame() {

        //Creating the Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 588);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setBounds(0, 458, 634, 33);
        JLabel lblCommandLine = new JLabel("Command Line:");
        lblCommandLine.setBounds(10, 9, 83, 14);
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        tf.setBounds(103, 6, 367, 20);
        panel.setLayout(null);
        panel.add(lblCommandLine); // Components Added using Flow Layout
        panel.add(lblCommandLine); // Components Added using Flow Layout
        panel.add(tf);

		JTextArea textArea = new JTextArea(24, 80);
		textArea.setBounds(10, 36, 432, 283);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(Color.black);
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
		System.setOut(new PrintStream(new OutputStream() {
    	@Override
    	public void write(int b) throws IOException {
    		textArea.append(String.valueOf((char) b));
    	}
    }));
    	frame.getContentPane().setLayout(null);
    	frame.getContentPane().add(textArea);

        //Adding Components to the frame.
        frame.getContentPane().add(panel);
        JButton send = new JButton("Enter");
        send.setBounds(480, 5, 67, 23);
        panel.add(send);
        JButton reset = new JButton("Reset");
        reset.setBounds(557, 5, 67, 23);
        panel.add(reset);
        
        //Reset button listener
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               tf.setText("");
            }
        });
        
        //Send button listener
        send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                text  = tf.getText();
            	System.out.println("sent");
            	setUserInput(text);
            }
        });
        
        JLabel lblNewLabel = new JLabel("Map view:");
        lblNewLabel.setBounds(10, 11, 71, 14);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("EnemyCount: ");
        lblNewLabel_1.setBounds(452, 11, 71, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Hp:");
        lblNewLabel_2.setBounds(245, 385, 30, 14);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Turn #");
        lblNewLabel_3.setBounds(382, 11, 46, 14);
        frame.getContentPane().add(lblNewLabel_3);
        
        table = new JTable();
        table.setToolTipText("");
        table.setBounds(452, 36, 172, 283);
        frame.getContentPane().add(table);
        
        textField = new JTextField();
        textField.setText("0");
        textField.setEditable(false);
        textField.setBounds(69, 8, 21, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        turnNumber = new JTextField();
        turnNumber.setText("0");
        turnNumber.setEditable(false);
        turnNumber.setColumns(10);
        turnNumber.setBounds(421, 8, 21, 20);
        frame.getContentPane().add(turnNumber);
        
        enemyCount = new JTextField();
        enemyCount.setText("0");
        enemyCount.setEditable(false);
        enemyCount.setColumns(10);
        enemyCount.setBounds(523, 8, 21, 20);
        frame.getContentPane().add(enemyCount);
        
        JLabel lblExp = new JLabel("EXP:");
        lblExp.setBounds(245, 435, 39, 14);
        frame.getContentPane().add(lblExp);
        
        JLabel lblLvl = new JLabel("LVL:");
        lblLvl.setBounds(245, 410, 39, 14);
        frame.getContentPane().add(lblLvl);
        
        JLabel lblShield = new JLabel("Shield:");
        lblShield.setBounds(357, 435, 71, 14);
        frame.getContentPane().add(lblShield);
        
        JLabel lblWeapon = new JLabel("Weapon:");
        lblWeapon.setBounds(357, 410, 71, 14);
        frame.getContentPane().add(lblWeapon);
        
        JLabel lblBonuses = new JLabel("Bonuses:");
        lblBonuses.setBounds(357, 385, 71, 14);
        frame.getContentPane().add(lblBonuses);
        
        JTextArea textArea_1 = new JTextArea(24, 80);
        textArea_1.setForeground(Color.BLACK);
        textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
        textArea_1.setBackground(Color.LIGHT_GRAY);
        textArea_1.setBounds(10, 330, 614, 46);
        frame.getContentPane().add(textArea_1);
        
        JLabel lblUsersMovecount = new JLabel("User's Movecount:");
        lblUsersMovecount.setBounds(103, 387, 92, 14);
        frame.getContentPane().add(lblUsersMovecount);
        
        textField_3 = new JTextField();
        textField_3.setText("0");
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(205, 384, 21, 20);
        frame.getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setText("0");
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBounds(295, 385, 21, 20);
        frame.getContentPane().add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setText("0");
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(295, 410, 21, 20);
        frame.getContentPane().add(textField_5);
        
        textField_6 = new JTextField();
        textField_6.setText("0");
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(295, 435, 21, 20);
        frame.getContentPane().add(textField_6);
        
        textField_7 = new JTextField();
        textField_7.setText("0");
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        textField_7.setBounds(421, 435, 21, 20);
        frame.getContentPane().add(textField_7);
        
        textField_8 = new JTextField();
        textField_8.setText("0");
        textField_8.setEditable(false);
        textField_8.setColumns(10);
        textField_8.setBounds(421, 410, 21, 20);
        frame.getContentPane().add(textField_8);
        frame.setVisible(true);
    }
    
    public int setTurnNumber(int x) {
	    this.number = x;
	    turnNumber.setText(Integer.toString(number));
        return number;
    }
    
    public int setEnemies(int x) {
    	this.enemies = x; 
    	enemyCount.setText(Integer.toString(enemies));
        return enemies;
    }
    
    public int getEnemys() {
        return enemies;
    }
    
    public int setUserInput(String text) {
        userInput = Integer.parseInt(text);
    	getUserInput();
        return userInput;
    }
    
    public int getUserInput() {
    //	System.out.println("usrinpt: " + userInput);
    	
        return userInput;
    }
    
    
    
    public int getTurnNumber() {
        return number;
    }
    
	public void init() {
		this.pack();
		this.setVisible(true);
		this.setAlwaysOnTop(true);

	}
	
	public JFrame getFrame() {
		return this;
	}
}