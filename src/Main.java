import Frame.MainFrame;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		run();
	}

	private static void run(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}
