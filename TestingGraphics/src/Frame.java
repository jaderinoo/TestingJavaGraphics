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
    static int number;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    
    public Frame() {

        //Creating the Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 530);

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
               number = Integer.parseInt(text);
               System.out.println("sent");
            }
        });
        
        JLabel lblNewLabel = new JLabel("Map view:");
        lblNewLabel.setBounds(10, 11, 71, 14);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("EnemyCount: ");
        lblNewLabel_1.setBounds(452, 11, 71, 14);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Hp:");
        lblNewLabel_2.setBounds(290, 387, 71, 14);
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
        
        textField_1 = new JTextField();
        textField_1.setText("0");
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(421, 8, 21, 20);
        frame.getContentPane().add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setText("0");
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(523, 8, 21, 20);
        frame.getContentPane().add(textField_2);
        
        JLabel lblExp = new JLabel("EXP:");
        lblExp.setBounds(290, 433, 71, 14);
        frame.getContentPane().add(lblExp);
        
        JLabel lblLvl = new JLabel("LVL:");
        lblLvl.setBounds(290, 410, 71, 14);
        frame.getContentPane().add(lblLvl);
        
        JLabel lblShield = new JLabel("Shield:");
        lblShield.setBounds(371, 433, 71, 14);
        frame.getContentPane().add(lblShield);
        
        JLabel lblWeapon = new JLabel("Weapon:");
        lblWeapon.setBounds(371, 410, 71, 14);
        frame.getContentPane().add(lblWeapon);
        
        JLabel lblBonuses = new JLabel("Bonuses:");
        lblBonuses.setBounds(371, 387, 71, 14);
        frame.getContentPane().add(lblBonuses);
        
        JTextArea textArea_1 = new JTextArea(24, 80);
        textArea_1.setForeground(Color.BLACK);
        textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
        textArea_1.setBackground(Color.LIGHT_GRAY);
        textArea_1.setBounds(10, 330, 614, 46);
        frame.getContentPane().add(textArea_1);
        
        JLabel lblUsersMovecount = new JLabel("User's Movecount:");
        lblUsersMovecount.setBounds(127, 387, 92, 14);
        frame.getContentPane().add(lblUsersMovecount);
        frame.setVisible(true);
    }
    
    public static int getNumber() {
    	System.out.print("Number: " + number);
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