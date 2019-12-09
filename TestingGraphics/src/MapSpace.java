import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MapSpace {
    static JFrame mapSpace() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }
}
