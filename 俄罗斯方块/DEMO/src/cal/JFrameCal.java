package cal;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameCal extends JFrame {
	/**
	 * This class helps user to close the window
	 * 
	 * @author Lenovo
	 *
	 */
	private class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}

	/**
	 * set the window at the center of the screen
	 * 
	 * @param jf
	 */
	public static void setFrameCenter(JFrame jf) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - jf.getWidth()) / 2;
		int y = (screen.height - jf.getHeight()) / 2 - 32;
		jf.setLocation(x, y);
	}
	public JButton jbt[]={
			
	};

	public JFrameCal() {
		// set the title of the application
		setTitle("Java Calculator");
		// be able to close the window
		addWindowListener(new WindowCloser());
		// user can't change the size of the window
		setResizable(false);
		// set the size of the window
		setSize(300, 400);
		// set the window at the center of the screen
		setFrameCenter(this);
		// the user can see the window
		setVisible(true);
	}
}
