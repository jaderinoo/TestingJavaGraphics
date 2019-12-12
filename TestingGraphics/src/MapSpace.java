import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class MapSpace {
    /**
     * @wbp.parser.entryPoint
     */
    static JFrame mapSpace() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        
        JButton send = new JButton("Enter");
        frame.getContentPane().add(send, BorderLayout.SOUTH);
        frame.setVisible(true);

        //Sets send as the default key
        frame.getRootPane().setDefaultButton(send);
        
        JPanel pane = new JPanel();
        
        frame.getContentPane().add(pane);
        
        pane.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
            	
            	if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("Up");
                    Main.row++;
                    System.out.println(Main.row);
                    try {
						Main.paint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                	System.out.println("Down");
                	Main.row--;
                	System.out.println(Main.row);
                	try {
						Main.paint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
        });
        
        pane.setFocusable(true);
        pane.requestFocusInWindow();
        
        
    
        //Send button listener
        send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Enter");
            }
        });
		return frame;
    }
    
    
    
}
