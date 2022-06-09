package Frame.Panneaux.MainPanChild;

import Frame.Panneaux.Applications.Calculatrice;
import Frame.Panneaux.Applications.PaintApp;
import Frame.Panneaux.Espaceur;
import Frame.Panneaux.MainPanChild.AbstractClasses.customJlabel;
import Frame.Panneaux.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.AclEntry;

import static Frame.Panneaux.MainPanel.rightpan;

public class LeftPanel extends JPanel {


	public LeftPanel(){

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

//		this.setPreferredSize(new Dimension(200, MainPanel));


		this.setLayout(gbl);



		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridwidth = 1; // nombre de colones occupées
		gbc.gridheight = 1; // nombre de lignes occupées
		gbc.weighty = 1;

//		this.add(logo(), gbc);

		gbc.gridy = 1;

		this.add(menuPan());

		gbc.gridy = 2;


		this.add(new Espaceur(199,getHeight()/2),gbc);


		this.setBackground(new Color(43, 51, 54));
		this.setBorder(new MatteBorder(0,0,0,1,Color.black));

	}

	private JPanel menuPan(){
		JPanel menu = new JPanel();
		menu.setPreferredSize(new Dimension(199,130));
		menu.setBackground(new Color(43, 51, 54));


		menu.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;

		gbc.weighty = 1;
		gbc.gridy = 0;

		menu.add(new customJlabel("Calculatrice", "CalculatriceMenu", CascadiaFont(), Color.white, new Calculatrice()), gbc);

		gbc.gridy = 1;


		menu.add(new customJlabel("Paint", "CalculatriceMenu", CascadiaFont(), Color.white, new PaintApp()), gbc);

		gbc.gridy = 2;

		menu.add( new customJlabel("test", "CalculatriceMenu", CascadiaFont(), Color.white, new JLabel("adil")), gbc);



		return menu;
	}


	private JPanel logo(){
		JPanel logo = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				try {
					Image img = ImageIO.read(new File("src/images/logoMinimalistGrey.png"));
					g.drawImage(img, 0, 0, getWidth(),152, this);
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
		logo.setPreferredSize(new Dimension(0,0));


		return logo;
	}




	private Font CascadiaFont(){
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Font/Cascadia.ttf"));
		} catch (FontFormatException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		genv.registerFont(font);
		font = font.deriveFont(13f);

		return font;
	}


}
