package view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Pacifique Harerimana
 */
public class TestSwing {
    public static void main(String[] args) {
        // create container
        JFrame testFrame = new JFrame();
        testFrame.setTitle("JAVA Thursday Class");
        
//        testFrame.show();
        testFrame.setSize(500, 600);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // creating component
        JTextArea comment = new JTextArea();
        
        testFrame.add(comment);
        testFrame.setVisible(true);
    }
}
