package Frame.Pan;

import Frame.Pan.ChildPan.LeftChild;
import Frame.Pan.ChildPan.RightChild;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static Frame.MainFrame.getMainPanel;

public class MainPanel extends JPanel {

	private static LeftChild leftPan;
	private static RightChild rightPan;

	public static LeftChild getLeftPan() {
		return leftPan;
	}

	/* Permet de récuperer MainFrame*/
	private Component ancetre(){
		return getMainPanel().getParent();
	}


	/* Constructeur par défaut */
	public MainPanel(){
		// Attributs
		this.setName("MainPan");

		// Couleurs
		this.setBackground(new Color(66, 135, 245));

		// Dimensions & agencement
		GridBagLayout gbd = new GridBagLayout();
		this.setLayout(gbd);

		// Ajout de composants
		this.add(panGauche());
		this.add(panDroite());


	}

	/* initialisation des composants */
	// panel gauche
	private LeftChild panGauche(){
		LeftChild leftPan = new LeftChild();
		return leftPan;
	}
	// panel droite
	private RightChild panDroite() {
		RightChild rightPan = new RightChild();
		return rightPan;
	}

	public static RightChild getRightPan() {
		return rightPan;
	}
}
