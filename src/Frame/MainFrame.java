package Frame;
import Frame.Menu.MainMenuBar;
import Frame.Pan.MainPanel;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {


	// Dimensions de l'écran de l'utilisateur
	Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
	int monitorWidth = monitorSize.width;
	int monitorHeight = monitorSize.height;

	public static JPanel mainPanel = new JPanel();
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
		this.setResizable(true);
		this.setLocation(monitorWidth/3,monitorHeight/5);
		this.pack(); // la taille de la JFrame sera relative à celle de ces composants
	}




	/* Permet de récupérer le mainPanel dans d'autres classes*/
	public static JPanel getMainPanel() {return mainPanel;}

}
