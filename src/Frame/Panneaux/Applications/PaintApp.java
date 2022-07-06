package Frame.Panneaux.Applications;

import Frame.Panneaux.MainPanel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

import static Frame.Panneaux.MainPanel.rightpan;

public class PaintApp extends JPanel {

	public PaintApp(){
		this.setBackground(Color.white);
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(1200, 900));
		JMenuBar mb = new JMenuBar();
		mb.setAlignmentX(0);
		mb.setPreferredSize(new Dimension(1200,20));
		mb.setBorder(new MatteBorder(1,1,1,1,Color.black));
		mb.setBorderPainted(true);
		this.add(mb, BorderLayout.NORTH);
		mb.add(new JMenu("test"));
	}
}
