import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        FontMetrics fm = g.getFontMetrics();
        Font newFont = new Font("Playbill", Font.PLAIN, 30);
        JLabel label = new JLabel("text");
        g.setFont(newFont);
  
        g.drawString("Hello, Java Graphics World!", getWidth()/2- fm.stringWidth("Hello, Java Graphics World!")/2, getHeight()/2- fm.getAscent()/2);
    }
}

public class HelloGraphics implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        panel.setBackground(Color.red);
        panel.setForeground(Color.blue);
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
