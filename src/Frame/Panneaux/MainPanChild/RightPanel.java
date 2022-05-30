package Frame.Panneaux.MainPanChild;

import Frame.Panneaux.Applications.Calculatrice;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RightPanel extends JPanel{


	Component application;

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	public RightPanel(){
		this.setLayout(gbl);
	}


	@Override
	protected void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("C:\\Users\\Foolek\\Documents\\GitHub\\JAVA\\MultiApp\\src\\images\\DefaultBackGround.png"));
			g.drawImage(img, 0, 0, 1200,1200, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
