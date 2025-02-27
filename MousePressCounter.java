import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */
public class MousePressCounter implements Runnable, MouseListener {
    int count = 0;
	
	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {


		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String toDisplay = "Mouse Around and See!";
        

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "Mouse press count:" + count;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
                
			}
		};
		frame.add(panel);
		panel.addMouseListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        count++;
        toDisplay.paintComponent(e);
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
