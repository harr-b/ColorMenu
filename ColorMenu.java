/**
 * 
 */
package edu.miamioh.bergmahb;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * @author Harrison Overall class that constructs a GUI with a color changing
 *         panel
 */
public class ColorMenu extends JFrame {

	private JPanel panel;
	private JMenuBar menuBar;
	String currentColor = "Red";

	public ColorMenu() {
		panel = new JPanel();
		panel.setSize(10, 10);
		panel.setBackground(Color.red);
		menuBar = new JMenuBar();
		JMenu color = new JMenu("Color");
		menuBar.add(color);

		JMenuItem redButton = new JMenuItem("Red");
		JMenuItem greenButton = new JMenuItem("Green");
		JMenuItem blueButton = new JMenuItem("Blue");
		color.add(redButton);
		color.add(greenButton);
		color.add(blueButton);
		add(panel);
		add(menuBar, BorderLayout.NORTH);

		ActionListener menuListener = new MenuListener();
		MouseListener mouseClicks = new MouseClickListener();
		panel.addMouseListener(mouseClicks);
		redButton.addActionListener(menuListener);
		greenButton.addActionListener(menuListener);
		blueButton.addActionListener(menuListener);
	}

	// Listens for clicks in the MenuBar to change the background color of the
	// JPanel
	class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String colorChosen = ((JMenuItem) e.getSource()).getText();
			if (colorChosen.equals("Red")) {
				panel.setBackground(Color.red);
				currentColor = "Red";
			} else if (colorChosen.equals("Green")) {
				panel.setBackground(Color.GREEN);
				currentColor = "Green";
			} else if (colorChosen.equals("Blue")) {
				panel.setBackground(Color.BLUE);
				currentColor = "Blue";
			}
		}

	}

	// Listens for click of the mouse in the program frame
	class MouseClickListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (currentColor.equals("Red")) {
				panel.setBackground(Color.GREEN);
				currentColor = "Green";
			} else if (currentColor.equals("Green")) {
				panel.setBackground(Color.BLUE);
				currentColor = "Blue";
			} else {
				panel.setBackground(Color.RED);
				currentColor = "Red";
			}

		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

	}

	/**
	 * @param args
	 *            Main method to run the GUI
	 */
	public static void main(String[] args) {
		JFrame frame = new ColorMenu();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Color Menu");
	}

}
