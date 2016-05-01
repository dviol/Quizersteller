package de.violante.dennis.utillity;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.violante.dennis.control.Settings;

public class Confighandler implements Singleton {

	private static Confighandler c;
	private static String path = "./conf.ini";
	private static String message = "Configfile not found, want to search for it?\nNo creates a new configfile.";
	private static String title = "Configfile not found.";

	public static synchronized Confighandler getInstance() {

		if (c == null) {
			c = new Confighandler();
		}
		return c;

	}
	
	

	public void parse(){
		
	}
	public void writeChanges(String toWrite){
		
	}
	
	
	private Confighandler() {

		File f = new File(path);

		if (!f.exists()) {

			if (Settings.GUIMODE) {

				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION);

				switch (reply) {
				case JOptionPane.YES_OPTION:
					JFileChooser jfc = new JFileChooser(f);
					f = jfc.getSelectedFile();
					path = f.getAbsolutePath();
					break;
				case JOptionPane.NO_OPTION:

					try {
						f.createNewFile();
						writeChanges(Settings.settingmaker());
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
				case JOptionPane.CANCEL_OPTION:
					System.exit(0);
					break;

				default:
					break;
				}

			}
		}

	}



	public static String getPath() {
		return path;
	}



	public static void setPath(String path1) {
		path = path1;
	}



	public static String getMessage() {
		return message;
	}



	public static void setMessage(String message1) {
		message = message1;
	}



	public static String getTitle() {
		return title;
	}



	public static void setTitle(String title1) {
		title = title1;
	}
	
}
