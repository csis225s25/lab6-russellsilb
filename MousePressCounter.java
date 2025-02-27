import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
public class MousePressCounter  extends JFrame  {
JButton reset;
    private int count = 0;

    public MousePressCounter () {
        setTitle("Repaint Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.black);
                FontMetrics fm = g.getFontMetrics();
				String toDisplay = "Mouse press count: ";
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();
				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;
				g.drawString(toDisplay + count, xStart, yStart);
                
           
        
            }
        };
       
        
    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            count++;
            repaint();
        }
    });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MousePressCounter ();
    }
}