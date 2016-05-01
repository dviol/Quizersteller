package de.violante.dennis.model.questions.answers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.violante.dennis.control.Settings;

public class ImageAnswer extends Answer {

	JFrame f;

	public ImageAnswer(String content) {
		super(content, Settings.Marker.IMAGE);
		ImageIcon icon = new ImageIcon(this.content);
		f = new JFrame(); // creates jframe f

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JLabel lbl = new JLabel(icon);

		f.getContentPane().add(lbl);

		f.setSize(icon.getIconWidth(), icon.getIconHeight());

		int x = (screenSize.width - f.getSize().width) / 2;
		int y = (screenSize.height - f.getSize().height) / 2;

		f.setLocation(x, y);
	}

	public void resetLocation(Point p) {
		f.setLocation(p);
	}

	public Point getLocation() {
		return f.getLocation();
	}

	public void show() {
		f.setVisible(true); // makes the jframe visible

	}
	
	public void hide(){
		f.setVisible(false);
		f = null;
	}

}
