package Frame;
import Frame.Menu.MainMenuBar;
import Frame.Pan.ChildPan.Applications.Calculatrice;
import Frame.Pan.MainPanel;
import com.sun.tools.javac.Main;
import Frame.Pan.ChildPan.Applications.Calculatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame implements ActionListener {


	// Dimensions de l'écran de l'utilisateur
	Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
	int monitorWidth = monitorSize.width;
	int monitorHeight = monitorSize.height;

	public static MainPanel mainPanel;
	private static JMenuBar mainJmenu = new MainMenuBar();



	/* Constructeur par défaut */
	public MainFrame(){
		// A la fermeture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Attributs de la fenêtres
		this.setTitle("MultiApp");
		this.setName("Fenetre");

		// Panel & barre de menu
		this.setLayout(new GridBagLayout());
		this.setContentPane(new MainPanel());
		this.setJMenuBar(mainJmenu);

		// Dimensions & agencement
		this.setResizable(false);
		this.setLocation(monitorWidth/3,monitorHeight/5);
		this.pack(); // la taille de la JFrame sera relative à celle de ces composants
	}




	/* Permet de récupérer le mainPanel dans d'autres classes*/
	public static JPanel getMainPanel() {return mainPanel;}




	@Override
	public void actionPerformed(ActionEvent e) {
		Calculatrice.getResult().setText("test");
	}
}
