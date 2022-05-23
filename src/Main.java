import Frame.MainFrame;

import javax.swing.*;

public class Main {

	private static MainFrame mainFrame = new MainFrame();

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
