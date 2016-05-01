package de.violante.dennis.utillity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.violante.dennis.control.Settings;
import de.violante.dennis.model.questions.FreeQuestion;
import de.violante.dennis.model.questions.MultipleChoice;
import de.violante.dennis.model.questions.Question;
import de.violante.dennis.model.questions.QuestionContainer;

public class Questionparser {

	private static String path = "./question.qst";
	private static String message = "Questionfile not found, want to search for it?\nNo creates a new Questionfile.";
	private static String title = "Questionfile not found.";

	public static void readyQuestions() throws IOException {
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

			QuestionContainer qc = QuestionContainer.getInstance();
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			String[] items;
			int mode = 0;
			Question q;
			boolean fillQuestion = false;

			while ((line = br.readLine()) != null) {
				items = line.split("=");

				if (items[0].equals("VERSION") && Double.parseDouble(items[1]) > Settings.VERSION) {
					System.out.println("Leider ist der Questionmaster für dieses Fragenset veraltet");

				} else if (items[0].toUpperCase().equals(Settings.Marker.MULTIPLECHOICE.toString().toUpperCase())) {
					q = new MultipleChoice();
					fillQuestion = true;
				} else if (items[0].toUpperCase().equals(Settings.Marker.FREEQUESTION.toString().toUpperCase())) {
					q = new FreeQuestion();
					fillQuestion = true;
				} else {
					System.out.println("Junge, du hast was falsch programmiert (In Questionparser)");
				}

				if (fillQuestion) {

					while ((line = br.readLine()) != null && !line.equals("#")) {
						items = line.split("=");
						String check = items[0].toUpperCase();

						if (check.equals(Settings.Marker.QUESTION.toString())) {

						}

					}

				}

				fillQuestion = false;

			}

			br.close();

		}
	}
}
