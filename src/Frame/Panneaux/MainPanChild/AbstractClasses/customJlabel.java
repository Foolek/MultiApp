package Frame.Panneaux.MainPanChild.AbstractClasses;


import Frame.Panneaux.Applications.Calculatrice;
import Frame.Panneaux.Applications.PaintApp;
import Frame.Panneaux.MainPanChild.RightPanel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Frame.Panneaux.MainPanel.rightpan;

public class customJlabel extends JLabel {




	public customJlabel(String text, String name, Font font, Color c, Component comp){

		this.setText(text);
		this.setName(name);
		this.setFont(font);
		this.setForeground(c);
		this.setPreferredSize(new Dimension(199,0));
		this.setBorder(new MatteBorder(0,0,1,0, Color.black));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rightpan.removeAll();
				rightpan.add(comp);
				rightpan.revalidate();
				rightpan.repaint();
				System.gc();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(true);
				setBackground(Color.white);
				e.getComponent().setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setOpaque(false);
				e.getComponent().setForeground(Color.white);
			}
		});
	}

}
