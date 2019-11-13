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

class Frame extends JFrame {
	final JFrame frame = new JFrame();
    String text = "Null";
    public Frame() {

        //Creating the Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

		JTextArea textArea = new JTextArea(24, 80);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(Color.black);
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
		System.setOut(new PrintStream(new OutputStream() {
    	@Override
    	public void write(int b) throws IOException {
    		textArea.append(String.valueOf((char) b));
    	}
    }));
    	frame.getContentPane().add(textArea);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
        
        //Send button listener
        send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               text  = tf.getText();
               System.out.println(text);
            }
        });
        
        //Reset button listener
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               tf.setText("");
            }
        });
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