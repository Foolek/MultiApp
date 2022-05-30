package Frame.Panneaux.MainPanChild.AbstractClasses;

import Frame.Panneaux.MainPanChild.RightPanel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Frame.MainFrame.mainPanel;
import static Frame.Panneaux.MainPanel.rightpan;

public class customJlabel extends JLabel {




	public customJlabel(String text, String name, Font font, Color c, Component comp){

		this.setText(text);
		this.setName(name);
		this.setFont(font);
		this.setForeground(c);
		this.setPreferredSize(new Dimension(299,getHeight()));
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
				e.getComponent().setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setForeground(Color.white);
			}
		});
	}


	public static JPanel getMainPanel() {return mainPanel;}



	public static RightPanel getRightpan() {
		return rightpan;
	}
}
