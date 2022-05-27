package Frame.Pan;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class RightChild extends JPanel {
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("C:\\Users\\Foolek\\Documents\\GitHub\\MultiApp\\src\\images\\index.jpg"));
			g.drawImage(img, 0, 0, getWidth(),getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
