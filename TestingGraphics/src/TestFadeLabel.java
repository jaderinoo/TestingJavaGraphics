import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFadeLabel {

    public static void main(String[] args) {
        new TestFadeLabel();
    }

    public TestFadeLabel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {

        private float direction = -0.05f;
        private FadeLabel label = new FadeLabel();

        public MainPane() {
            setLayout(new BorderLayout());
           
            label = new FadeLabel();


            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float alpha = label.getAlpha();
                    alpha += direction;
                    if (alpha < 0) {
                        alpha = 0;
                        direction = 0.05f;
                    } else if (alpha > 1) {
                        alpha = 1;
                        direction = -0.05f;
                    }
                    label.setAlpha(alpha);
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }
    }

    public class FadeLabel extends JLabel {

        private float alpha;

        public FadeLabel() {
            setText("Hide and go seek");
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            setAlpha(1f);
        }

        public void setAlpha(float value) {
            if (alpha != value) {
                float old = alpha;
                alpha = value;
                firePropertyChange("alpha", old, alpha);
                repaint();
            }
        }

        public float getAlpha() {
            return alpha;
        }


        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getAlpha()));
            super.paint(g2d);
            g2d.dispose();
        }

    }
}