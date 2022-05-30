package Frame.Panneaux.MainPanChild;

import Frame.Panneaux.Applications.Calculatrice;
import Frame.Panneaux.Applications.PaintApp;
import Frame.Panneaux.Espaceur;
import Frame.Panneaux.MainPanChild.AbstractClasses.customJlabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import static Frame.Panneaux.MainPanel.rightpan;

public class LeftPanel extends JPanel {


	public LeftPanel(){

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();



		this.setLayout(gbl);

		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridwidth = 1; // nombre de colones occupées
		gbc.gridheight = 1; // nombre de lignes occupées
		gbc.weighty = 1;

		this.add(logo(), gbc);

		gbc.gridy = 1;

		this.add(new Espaceur(299,100),gbc);

		gbc.gridy = 2;

		this.add(new customJlabel("Calculatrice", "CalculatriceMenu", CascadiaFont(), Color.white, new Calculatrice()), gbc);

		gbc.gridy = 3;

		this.add(new customJlabel("test", "CalculatriceMenu", CascadiaFont(), Color.white, new JButton("test")), gbc);

		gbc.gridy = 4;

		this.add( new customJlabel("test", "CalculatriceMenu", CascadiaFont(), Color.white, new JLabel("adil")), gbc);

		gbc.gridy = 5;


		this.add(new Espaceur(299,600),gbc);


		this.setBackground(new Color(43, 51, 54));
		this.setPreferredSize(new Dimension(300,0));
		this.setBorder(new MatteBorder(0,0,0,1,Color.black));

	}


	private JPanel logo(){
		JPanel logo = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				try {
					Image img = ImageIO.read(new File("C:\\Users\\Foolek\\Documents\\GitHub\\JAVA\\MultiApp\\src\\images\\logoMinimalistGrey.png"));
					g.drawImage(img, 0, 0, 301,152, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		logo.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rightpan.removeAll();
				rightpan.revalidate();
				rightpan.repaint();
				System.gc();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		logo.setPreferredSize(new Dimension(299,120));


		return logo;
	}




	private Font CascadiaFont(){
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Foolek\\Documents\\GitHub\\JAVA\\MultiApp\\src\\Font\\Cascadia.ttf"));
		} catch (FontFormatException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		genv.registerFont(font);
		font = font.deriveFont(15f);

		return font;
	}


}
