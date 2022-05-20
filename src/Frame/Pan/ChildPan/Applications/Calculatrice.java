package Frame.Pan.ChildPan.Applications;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Frame.MainFrame.getMainPanel;
import static Frame.Pan.MainPanel.getLeftPan;

public class Calculatrice extends JPanel {

	private JLabel result;
	private JPanel clavier;


	/* Permet de récuperer MainFrame*/
	private Component ancetre() {
		return getMainPanel().getParent();
	}


	/* Constructeur par défaut */
	public Calculatrice() {

		// Agencement de la calculatrice
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);

		gbc.gridy = 0;
		gbc.gridx = 0;

		gbc.gridwidth = 100;
		gbc.gridheight = 100;

		this.add(screenResult(), gbc);

		gbc.gridy = 1;
		this.add(keypad(), gbc);


	}


	/* Écran du résultat */
	private JLabel screenResult(){
		JLabel result = new JLabel("ECRAN RESULTAT");

		// Affichage du texte
		result.setHorizontalAlignment(SwingConstants.CENTER); // le contenu du label sera centré (texte)

		// dimensions
		result.setPreferredSize(new Dimension(400,100));

		// Customisation du panel
		result.setOpaque(true); // TRUE = setBackground visible
		result.setBorder(new LineBorder(Color.black, 3,false));
		result.setBackground(Color.yellow);

		return result;
	}


	/* Clavier de boutons */
	private JPanel keypad(){
		JPanel pad = new JPanel();
		pad.setPreferredSize(new Dimension(400,500));

		this.add();
		return pad;
	}

	/* Bouttons de 0 à 9*/
	private JButton[] btnNmbr(){
		JButton btn[] = new JButton[10];

		for(int i = 0; i < btn.length; i++){
			btn[i] = new JButton(""+i);
		}
		System.out.println(btn);

		return btn;
	}



}