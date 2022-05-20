package Frame.Pan.ChildPan;

import javax.swing.*;
import java.awt.*;

import static Frame.MainFrame.getMainPanel;

public class LeftChild extends JPanel {

	/* Permet de récuperer MainFrame*/
	private Component ancetre(){
		return getMainPanel().getParent();
	}

	/* Constructeur par défaut */
	public LeftChild(){

		this.setName("LeftChild mainPan");

		this.setPreferredSize(new Dimension(300,800));

		this.setBackground(new Color(185, 205, 237));

	}
}
