import Frame.MainFrame;

import javax.swing.*;
import java.io.IOException;

public class Main {

	private static MainFrame mainFrame;

	static {
		try {
			mainFrame = new MainFrame();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		run();
	}

	private static void run(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame.setVisible(true);
			}
		});
	}

	private static MainFrame getMainFrame() {
		return mainFrame;
	}
}
