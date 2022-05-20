package Frame.Menu;

import Frame.Pan.MainPanel;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Frame.MainFrame.getMainPanel;

public class MainMenuBar extends JMenuBar {


	/* Permet de récuperer MainFrame*/
	private Component parent(){
		return getMainPanel().getParent();
	}

	private JMenu menu;
	private JPanel MainPanel;

	public MainMenuBar(){
		this.add(initItem());
		MainPanel = new MainPanel();
	}

	private JMenu initItem(){
		menu = new JMenu("Mon CV");
		menu.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(getMainPanel().getParent(),"mouseclicked", "mouseclicked", JOptionPane.INFORMATION_MESSAGE);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(getMainPanel().getParent(),"mousePressed", "mousePressed", JOptionPane.ERROR_MESSAGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(getMainPanel().getParent(),"mouseReleased", "mouseReleased", JOptionPane.INFORMATION_MESSAGE);

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		return menu;
	}



}
