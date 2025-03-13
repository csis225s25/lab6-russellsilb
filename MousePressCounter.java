import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 6 demo of mouse events.
 * 
 * @author Zhoxi, Russell
 * @version Spring 2025
 */
public class MousePressCounter implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener, ActionListener {
	//instance variables
    String toDisplay;
    int count;
    JPanel panel;
	JButton resetButton;

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {


		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		panel = new JPanel(new BorderLayout()) {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "Mouse press count: " + count;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};
		// create a button
		resetButton = new JButton("Reset");
		// create a panel for the button
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(resetButton);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		resetButton.addActionListener(this);

		frame.add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	//increase the count when the mouse is clicked
	@Override
	public void mouseClicked(MouseEvent e) {
		count++;
        panel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed: " + e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased: " + e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered: " + e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited: " + e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("mouseDragged: " + e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("mouseMoved: " + e);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("mouseWheelMoved: " + e);
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}

	//reset the count when the button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		count = 0;
		panel.repaint();
	}
}
