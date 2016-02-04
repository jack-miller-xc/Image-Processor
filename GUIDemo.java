import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIDemo implements ActionListener, ItemListener {

	JTextArea output;
	JScrollPane scrollPane;
	String newline = "\n";
	JPanel panel;
	ImageCanvas canvas;
	private ActionListener l;

	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("Pixel Modification");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Grayscale", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		//menuItem.addActionListener(this);
		menuItem.addActionListener(l);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Threshold", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);
	
		//Build second menu in the menu bar.
		menu = new JMenu("Copy");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Copy", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//Build third menu in the menu bar.
		menu = new JMenu("Inter/Extrapolation");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Brighten", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Darken", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Increase Contrast", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Decrease Contrast", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Increase Saturation", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Decrease Saturation", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Add Noise", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//Build fourth menu in the menu bar.
		menu = new JMenu("Mask Manipulation");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Masking", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//Build fifth menu in the menu bar.
		menu = new JMenu("Kernal Manipulation");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Blur", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Edge Detect", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Gaussian Blur", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//Build sixth menu in the menu bar.
		menu = new JMenu("Level Manipulation");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Leveling", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		//Build seventh menu in the menu bar.
		menu = new JMenu("Warp Manipulation");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Rotate", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Scale", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuBar;
	}

	public Container createContentPane() {
		//Create the content-pane-to-be.
		JPanel contentPane = new JPanel(new BorderLayout());
		
		contentPane.setOpaque(true);

		//Create a scrolled text area.
		output = new JTextArea(5, 30);
		output.setEditable(false);
		scrollPane = new JScrollPane(output);
		
		canvas = new ImageCanvas("Resources/Koala.jpg");
		canvas.setSize(canvas.getWidth(), canvas.getHeight());
		contentPane.add(canvas, BorderLayout.CENTER);

		//Add the text area to the content pane.
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		contentPane.setBackground(Color.CYAN);

		return contentPane;
	}
		
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)(e.getSource());
		if (e.getSource() == "Grayscale") {
			canvas.swapPixels();
		}
		String s = "You have clicked the " + source.getText() + " button: ";
		output.append(s + newline);
	}

	public void itemStateChanged(ItemEvent e) {
		JMenuItem source = (JMenuItem)(e.getSource());
		String s = "Item event detected."
				+ newline
				+ "    Event source: " + source.getText()
				+ " (an instance of " + getClassName(source) + ")"
				+ newline
				+ "    New state: "
				+ ((e.getStateChange() == ItemEvent.SELECTED) ?
						"selected":"unselected");
		output.append(s + newline);
	}

	// Returns just the class name -- no package info.
	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex+1);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = GUIDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Image Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		GUIDemo demo = new GUIDemo();
		frame.setJMenuBar(demo.createMenuBar());
		frame.setContentPane(demo.createContentPane());
		
		//Display the window.
		frame.setSize(1080, 720);
		frame.setVisible(true);
	}
	


	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//createAndShowGUI();
				GUIDemo ip = new GUIDemo();
				ip.createAndShowGUI();
				
			}
		});
	}
}
