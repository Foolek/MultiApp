package Frame.Panneaux.MainPanChild;


import Frame.Panneaux.Applications.PaintApp;
import Frame.Panneaux.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class RightPanel extends JPanel{

	public RightPanel(){
		GridBagLayout gbl = new GridBagLayout();
		this.setBackground(new Color(43, 51, 54));
		this.setLayout(gbl);


	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		try {
//			Image img = ImageIO.read(new File("src/images/DefaultBackGround.png"));
//			g.drawImage(img, 0, 0,MainPanel.getW(),MainPanel.getH()-LeftPanel.WIDTH, this);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
