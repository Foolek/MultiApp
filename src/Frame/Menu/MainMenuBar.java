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

	public MainMenuBar(){
		this.add(initItem());
	}

	private JMenu initItem(){
		menu = new JMenu("Mon CV");

		return menu;
	}



}
