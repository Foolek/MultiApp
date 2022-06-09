package Frame.Panneaux;

import Frame.Panneaux.MainPanChild.LeftPanel;
import Frame.Panneaux.MainPanChild.RightPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	public static RightPanel rightpan = new RightPanel();

	static int w = 1400;
	static int h = 900;


	/* Constructeur par défaut */
	public MainPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbl.setConstraints(this, gbc);

		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		this.add(new LeftPanel(), gbc);

		gbc.gridx = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		this.add(rightpan, gbc);

		this.setBackground(Color.darkGray);
		this.setPreferredSize(new Dimension(w,h));
	}

}
