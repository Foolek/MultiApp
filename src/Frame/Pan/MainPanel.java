package Frame.Pan;

import Frame.Pan.Applications.Calculatrice;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	private JPanel leftPan;
	private JPanel rightPan;


	/* Constructeur par défaut */
	public MainPanel(){
		// Attributs
		this.setName("MainPan");

		// Couleurs
		this.setBackground(Color.darkGray);

		// Dimensions & agencement
		this.setPreferredSize(new Dimension(1200,1000));

		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbl.setConstraints(this, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.FIRST_LINE_START;

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.weightx = 0;
		gbc.weighty = 0;

		gbc.gridwidth = 1;
		gbc.gridheight = 1;


		// Ajout de composants
		this.add(panMenu(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		this.add(panAffichage(), gbc);
	}


	/* Panneau Gauche */
	private JPanel panMenu(){
		leftPan = new JPanel();

		leftPan.setBackground(new Color(185, 205, 237));
		leftPan.setPreferredSize(new Dimension(300,0));

		GridBagLayout gbl = new GridBagLayout();
		leftPan.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 0;
		gbc.weighty = 0;

		gbl.setConstraints(leftPan, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		return leftPan;
	}


	/* Panneau Droite */
	private JPanel panAffichage(){
		rightPan = new JPanel();

		rightPan.setBackground(new Color(35, 63, 107));
		rightPan.setLayout(new BorderLayout());
		rightPan.add(new Calculatrice(), BorderLayout.CENTER);

		return rightPan;
	}
}
