package Frame.Panneaux.Applications;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Calculatrice extends JPanel{

	private static JLabel ecran; // Affichage de la calculatrice


	// Boutons avec leurs valeur en string
	private final String[] btn_string = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "=", "C", "+", "-", "*", "/"};
	private final JButton[] btnNombres = new JButton[btn_string.length];

	private boolean clicOperateur = false, update = false;

	private double chiffre1; // Va servir à mettre la valeur entrée de côté pour être réutiliser lors de la selection d'un opérateur
	private String operateur = ""; // pour récupérer l'opérateur


	private final Font police = new Font("Tahoma", Font.BOLD, 20);



	/* Constructeur par défaut */

	public Calculatrice() {

		// AGENCEMENT
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		this.add(keypad(),gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;


		this.add(screenResult());
	}




	/* ÉCRAN DU RÉSULTAT */
	private JLabel screenResult() {
		ecran = new JLabel();
		ecran.setPreferredSize(new Dimension(400,100));

		ecran.setFont(police);
		ecran.setHorizontalAlignment(SwingConstants.RIGHT); // le contenu du label sera centré (texte)

		ecran.setOpaque(true); // TRUE = setBackground visible
		ecran.setBorder(new LineBorder(Color.black, 1,false)); // Couleur bordure, épaisseur bordure, bordure arrondie

		return ecran;
	}




	/* CLAVIER DE BOUTTONS */
	private JPanel keypad(){
		// contient Jpanel panChiffres et Jpanel operateurs
		JPanel clavier = new JPanel();
		clavier.setPreferredSize(new Dimension(400,400));
		clavier.setOpaque(true);

		/////// AGENCEMENT ///////
		GridBagLayout gbl = new GridBagLayout();
		clavier.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		clavier.add(btnpanChiffres(),gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;

		clavier.add(btnOperateur(), gbc);

		return clavier;
	}




	/* BOUTONS DU CLAVIER (CHIFFRES) */
	private JPanel btnpanChiffres(){
		// contient btnNombres
		JPanel panChiffres = new JPanel();
		panChiffres.setPreferredSize(new Dimension(300,400));
		panChiffres.setLayout(new GridLayout(0,3));

		for(int i = 0; i < 12; i++ ){
			btnNombres[i] = new JButton();

			btnNombres[i].setFont(police);
			btnNombres[i].setText(btn_string[i]);
			btnNombres[i].setFocusPainted(false);
			btnNombres[i].addMouseListener(new btnMouseListener());

			if (i == 11) {
				btnNombres[i].addActionListener(new EgalListener());
			} else {
				btnNombres[i].addActionListener(new ChiffreListener());
			}

			panChiffres.add(btnNombres[i]);

		}
		return panChiffres;
	}




	/* BOUTONS DU CLAVIER (OPERATEUR) */
	private JPanel btnOperateur(){
		JPanel panOperateur = new JPanel();
		panOperateur.setPreferredSize(new Dimension(100,400));

		GridBagLayout glb = new GridBagLayout();
		panOperateur.setLayout(glb);
		GridBagConstraints gbc = new GridBagConstraints();

		int x = 0; // X alignement
		int y = 0; // Y alignement

		for (int i = 12; i < btn_string.length; i++ ){
			btnNombres[i] = new JButton();

			btnNombres[i].setText(btn_string[i]);
			btnNombres[i].setFont(police);
			btnNombres[i].setPreferredSize(new Dimension(100,400/5));
			btnNombres[i].setFocusPainted(false);
			btnNombres[i].addMouseListener(new btnMouseListener());

			switch (i) {
				case 12 -> {
					btnNombres[i].setForeground(Color.red);
					btnNombres[i].addActionListener(new ResetListener());
				}
				case 13 -> btnNombres[i].addActionListener(new PlusListener());
				case 14 -> btnNombres[i].addActionListener(new MoinsListener());
				case 15 -> btnNombres[i].addActionListener(new MultiListener());
				case 16 -> btnNombres[i].addActionListener(new DivListener());
			}

			gbc.gridx = x;
			gbc.gridy = y;

			panOperateur.add(btnNombres[i], gbc);

			y++;
		}
		return panOperateur;
	}

	/* METHODE POUR FAIRE LES CALCULS SELON OPERATEUR*/
	private void calcul(){
		if(operateur.equals("+")){
			chiffre1 = chiffre1 + Double.parseDouble(ecran.getText());
			ecran.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("-")){
			chiffre1 = chiffre1 - Double.parseDouble(ecran.getText());
			ecran.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("*")){
			chiffre1 = chiffre1 * Double.parseDouble(ecran.getText());
			ecran.setText(String.valueOf(chiffre1));
		}
		if(operateur.equals("/")){
			try{
				chiffre1 = chiffre1 / Double.parseDouble(ecran.getText());
				ecran.setText(String.valueOf(chiffre1));
			} catch(ArithmeticException e) {
				ecran.setText("0");
			}
		}
	}





	/* LISTENER POUR LES CHIFFRES, LES AFFICHER ET LES STOCKER */
	class ChiffreListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			//On affiche le chiffre additionnel dans le label
			String str = ((JButton)e.getSource()).getText();
			if(update){
				update = false;
			}
			else{
				if(!ecran.getText().equals("0"))
					str = ecran.getText() + str;
			}
			ecran.setText(str);
		}

	}




	/* LISTER POUR BOUTON EGAL */
	class EgalListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			calcul();
			update = true;
			clicOperateur = false;
		}
	}



	/* LISTENER BOUTON ADDITION  */
	class PlusListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.parseDouble(ecran.getText());
				clicOperateur = true;
			}
			operateur = "+";
			update = true;
		}
	}



	/* LISTENER BOUTON SOUSTRACTION  */
	class MoinsListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.parseDouble(ecran.getText());
				clicOperateur = true;
			}
			operateur = "-";
			update = true;
		}
	}



	/* LISTENER BOUTON MULTIPLIER  */
	class MultiListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{chiffre1 = Double.parseDouble(ecran.getText());
				clicOperateur = true;
			}
			operateur = "*";
			update = true;
		}
	}



	/* LISTENER BOUTON DIVISION  */
	class DivListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.parseDouble(ecran.getText());
				clicOperateur = true;
			}
			operateur = "/";
			update = true;
		}
	}



	/* LISTENER BOUTON RESET "C"  */
	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			clicOperateur = false;
			update = true;
			chiffre1 = 0;
			operateur = "";
			ecran.setText("");
		}
	}



	/* Ajout d'un effet sur les boutons au passage du curseur */
	static class btnMouseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {
			e.getComponent().setBackground(new Color(211, 227, 195));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			e.getComponent().setBackground(null); // background par défaut
		}
	}
}