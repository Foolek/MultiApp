package Frame.Pan.ChildPan;

import Frame.Pan.ChildPan.Applications.Calculatrice;
import Frame.Pan.MainPanel;

import javax.swing.*;
import java.awt.*;

import static Frame.MainFrame.getMainPanel;

public class RightChild extends JPanel {


	/* Permet de récuperer MainFrame*/
	private Component ancetre(){
		return getMainPanel().getParent();
	}

	/* Constructeur par défaut */
	public RightChild(){
		// Nom
		this.setName("rightChild mainPan");

		this.setBackground(new Color(35, 63, 107));

		this.setPreferredSize(new Dimension(800,800));

		this.add(new Calculatrice());
	}

}
