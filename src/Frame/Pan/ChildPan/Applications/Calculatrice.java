package Frame.Pan.ChildPan.Applications;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.List;


public class Calculatrice extends JPanel{

	private static JLabel result;
	private JPanel clavier;
	private String[] btn_string = {"7","8","9","4","5","6","1","2","3","0",".","=","+","-","*","/"};
	private JButton[] buttonsNb = new JButton[btn_string.length];
	private JPanel chiffres;
	private JPanel operateurs;
	private	Font police = new Font("Tahoma", Font.BOLD, 20);


	public static JLabel getResult() {
		return result;
	}

	/* Constructeur par défaut */
	public Calculatrice() {
		// Couleur
		this.setBackground(new Color(35, 63, 107));


		this.setPreferredSize(new Dimension(400,500));


		////////////////////////////
		/////// AGENCEMENT ///////
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
		/////// FIN DE L'AGENCEMENT ///////
		///////////////////////////////////


	}




	/* ÉCRAN DU RÉSULTAT */
	private JLabel screenResult() {
		result = new JLabel();

		// dimensions
		result.setPreferredSize(new Dimension(400,100));

		// Affichage du texte
		result.setFont(police);
		result.setHorizontalAlignment(SwingConstants.CENTER); // le contenu du label sera centré (texte)

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
			buttonsNb[i] = new JButton();

			buttonsNb[i].setFont(police);
			buttonsNb[i].setText(btn_string[i]);

			chiffres.add(buttonsNb[i]);
		}

		return chiffres;
	}



	/* BOUTONS DU CLAVIER (OPERATEUR) */
	private JPanel btnOperateur(){
		operateurs = new JPanel();
		operateurs.setPreferredSize(new Dimension(100,400));



		///////////////////////////
		/////// AGENCEMENT ///////

		GridBagLayout glb = new GridBagLayout();
		operateurs.setLayout(glb);

		GridBagConstraints gbc = new GridBagConstraints();

		int x = 0;
		int y = 0;

		for (int i = 12; i < btn_string.length; i++ ){
			buttonsNb[i] = new JButton();
			buttonsNb[i].setPreferredSize(new Dimension(100,100));

			buttonsNb[i].addMouseListener(new btnMouseListener());


			buttonsNb[i].setText(btn_string[i]);
			buttonsNb[i].setFont(police);



			gbc.gridx = x;
			gbc.gridy = y;

			operateurs.add(buttonsNb[i], gbc);

			y++;
		}

		/////// FIN DE L'AGENCEMENT ///////
		//////////////////////////////////

		return operateurs;
	}



	/* Action Listener des boutons*/
	public void initActionList(){
		for (int i = 0; i < 11; i ++){
			buttonsNb[i].addActionListener(new BoutonListener());
			buttonsNb[i].addMouseListener(new btnMouseListener());
		}


		for (JButton btn:
		     buttonsNb) {
			switch (btn.getActionCommand()){
				case "=":
					btn.addMouseListener(new btnMouseListener());
				case "+":
				case "x":
				case "-":
				case "/":
			}
		}
	}

	/* Ajout d'une classe anonyme implémentant l'ActionListener */
	class BoutonListener implements ActionListener{
		String valTemp = new String();
		String valFinal = new String();
		int[] valInt;
		Array[] test;

		@Override
		public void actionPerformed(ActionEvent e) {
			valTemp = e.getActionCommand();
			valFinal = result.getText() + valTemp;



			switch(e.getActionCommand()){
				case "+":
				case "-":
				case "x":
				case "/":
				case "=":

			}

			result.setText(valFinal);

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