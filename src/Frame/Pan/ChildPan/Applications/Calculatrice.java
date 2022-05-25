package Frame.Pan.ChildPan.Applications;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;


public class Calculatrice extends JPanel{

	private static JLabel result; // Affichage de la calculatrice

	private JPanel clavier; // contient Jpanel chiffres et Jpanel operateurs
	private JPanel chiffres; // contient btnNombres
	private JPanel operateurs;
	private String[] btn_string = {"7","8","9","4","5","6","1","2","3","0",".","=","C","+","-","X","/"};
	private JButton[] btnNombres = new JButton[btn_string.length];

	private boolean clicOperateur = false, update = false;

	private double chiffre1; // Va servir à mettre la valeur entrée de côté pour être réutiliser lors de la selection d'un opérateur

	private	Font police = new Font("Tahoma", Font.BOLD, 20);



	/* Constructeur par défaut */

	public Calculatrice() {
		this.setBackground(new Color(35, 63, 107));
		this.setPreferredSize(new Dimension(400,500));


		// AGENCEMENT
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		this.add(keypad(),gbc);
		initActionList();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		this.add(screenResult());
	}




	/* Getter */
	public static JLabel getResult() {
		return result;
	}




	/* ÉCRAN DU RÉSULTAT */
	private JLabel screenResult() {
		result = new JLabel();

		// dimensions
		result.setPreferredSize(new Dimension(400,100));

		// Affichage du texte
		result.setFont(police);
		result.setHorizontalAlignment(SwingConstants.RIGHT); // le contenu du label sera centré (texte)

		// Customisation du panel
		result.setOpaque(true); // TRUE = setBackground visible
		result.setBorder(new LineBorder(Color.black, 1,false));
		result.setBackground(Color.yellow);


		return result;
	}




	/* CLAVIER DE BOUTTONS */
	private JPanel keypad(){
		clavier = new JPanel();
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



		clavier.add(btnchiffres(),gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;


		clavier.add(btnOperateur(), gbc);
		/////// FIN DE L'AGENCEMENT ///////


		return clavier;
	}




	/* BOUTONS DU CLAVIER (CHIFFRES) */
	private JPanel btnchiffres(){
		chiffres = new JPanel();

		// DIMENSION
		chiffres.setPreferredSize(new Dimension(300,400));

		// AGENCEMENT
		chiffres.setLayout(new GridLayout(0,3));

		for(int i = 0; i < 12; i++ ){
			btnNombres[i] = new JButton();

			btnNombres[i].setFont(police);
			btnNombres[i].setText(btn_string[i]);
			btnNombres[i].setFocusPainted(false);
			chiffres.add(btnNombres[i]);
		}
		return chiffres;
	}




	/* BOUTONS DU CLAVIER (OPERATEUR) */
	private JPanel btnOperateur(){
		operateurs = new JPanel();
		operateurs.setPreferredSize(new Dimension(100,400));

		GridBagLayout glb = new GridBagLayout();
		operateurs.setLayout(glb);
		GridBagConstraints gbc = new GridBagConstraints();

		int x = 0; // X alignement
		int y = 0; // Y alignement

		for (int i = 12; i < btn_string.length; i++ ){
			btnNombres[i] = new JButton();

			btnNombres[i].setText(btn_string[i]);
			btnNombres[i].setFont(police);
			btnNombres[i].setPreferredSize(new Dimension(100,400/5));
			btnNombres[i].setFocusPainted(false);

			switch (i){
				case 12:
					btnNombres[i].setForeground(Color.RED);
			}

			gbc.gridx = x;
			gbc.gridy = y;

			operateurs.add(btnNombres[i], gbc);

			y++;
		}
		return operateurs;
	}




	/* Action Listener des boutons*/
	public void initActionList(){

//		for (int i = 0; i < 10; i ++){
//			btnNombres[i].addActionListener(new BoutonListener());
//		}
		for (int i = 0; i < btn_string.length; i ++){
			btnNombres[i].addActionListener(new BoutonListener());
			btnNombres[i].addMouseListener(new btnMouseListener());
		}
	}

	/* Ajout d'une classe anonyme implémentant l'ActionListener */
	class BoutonListener implements ActionListener{
		String valeurDuBoutton = new String();
		String valAffichee = new String();
		double doubleVal;

		@Override
		public void actionPerformed(ActionEvent e) {
			valeurDuBoutton = e.getActionCommand(); // la valeur du boutton = valeur affichée sur le bouton
			valAffichee = result.getText() + valeurDuBoutton; // la valeur affichée => Récupération du Text affiché à l'écran à laquel on ajoute une nouvelle valeur de bouton
			doubleVal = Double.valueOf(valAffichee).doubleValue(); // Conversion de la valeur affichée en double


			switch (e.getActionCommand()){
				case "+":
					doubleVal = doubleVal + Double.valueOf(result.getText()).doubleValue();
				case "X":
				case "-":
				case "=":
				case "C":
				default:
					result.setText(valAffichee);
					break;
			}

		}




	}

	class btnMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			return;
		}

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