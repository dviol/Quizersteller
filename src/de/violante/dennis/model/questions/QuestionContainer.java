package de.violante.dennis.model.questions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import de.violante.dennis.control.Settings;
import de.violante.dennis.utillity.Console;
import de.violante.dennis.utillity.FrequencyFirstComparator;
import de.violante.dennis.utillity.Singleton;

public class QuestionContainer implements Singleton {

	private static QuestionContainer qc;
	private LinkedList<Question> questions;
	private int index;
	private static Comparator<Question> comp;
	

	public void changeCompPrio(Comparator<Question> compe) {
		comp = compe;
	}

	private QuestionContainer() {
		questions = new LinkedList<>();
		comp = new FrequencyFirstComparator();

		index = 0;
	}

	public void add(Question... q) {
		for (Question question : q) {
			questions.add(question);
		}

	}

	public void fillList() {
		System.out.println("To implement");
	}

	public static synchronized QuestionContainer getInstance() {

		if (qc == null) {
			qc = new QuestionContainer();
		}
		return qc;
	}

	public void readyList() {
		Collections.sort(questions, comp);
	}

	public void askQuestion() {
		if (!questions.isEmpty()) {

			questions.get(index++ % questions.size()).returnQuestion();
			index %= questions.size();
		} else {
			Console.getInstance().toConsole("Der Fragenkatalog is leer, Chef!\n");
		}
	}

	public String toString() {
		String out = "VERSION=" + Settings.VERSION + "\n";

		for (Question question : questions) {
			out += question.toString() + "#\n";
		}

		return out;
	}

	public static Comparator<Question> getComp() {
		return comp;
	}

	public static void setComp(Comparator<Question> comp) {
		QuestionContainer.comp = comp;
	}

}
