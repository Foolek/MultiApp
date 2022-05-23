package Frame.Pan.ChildPan;

import Frame.Pan.ChildPan.Applications.Calculatrice;
import Frame.Pan.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RightChild extends JPanel {

	private static Calculatrice cal = new Calculatrice();

	/* Constructeur par défaut */
	public RightChild(){
		// Nom
		this.setName("rightChild mainPan");

		this.setBackground(new Color(35, 63, 107));

		this.setPreferredSize(new Dimension(800,800));

		this.setLayout(new BorderLayout())
		;
		this.add(cal, BorderLayout.CENTER);
	}


	public static Calculatrice getCal() {
		return cal;
	}
}
