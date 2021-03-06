package Frame;
import Frame.Panneaux.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MainFrame extends JFrame {


	// Dimensions de l'écran de l'utilisateur
	Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
	int monitorWidth = monitorSize.width;
	int monitorHeight = monitorSize.height;

	public static JPanel mainPanel = new JPanel();



	/* Constructeur par défaut */
	public MainFrame() throws IOException {
		// A la fermeture
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Attributs de la fenêtres
		this.setTitle("MultiApp");
		this.setName("Fenetre");

		// Panel & barre de menu
		this.setLayout(new GridBagLayout());
		this.setContentPane(new MainPanel());

		// Dimensions & agencement
		this.setResizable(false);
//		this.setLocation(monitorWidth/4,monitorHeight/18); A remettre
		this.setLocation(monitorWidth/50,monitorHeight/18);
		this.pack(); // la taille de la JFrame sera relative à celle de ces composants
	}


}
