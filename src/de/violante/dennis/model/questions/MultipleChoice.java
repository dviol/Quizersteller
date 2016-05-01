package de.violante.dennis.model.questions;

import java.util.LinkedList;

import de.violante.dennis.control.Settings;
import de.violante.dennis.model.questions.answers.Answer;
import de.violante.dennis.utillity.Utillity;

public class MultipleChoice extends Question {

	public MultipleChoice(){
		super(Settings.Marker.MULTIPLECHOICE);
	}
	
	public MultipleChoice(long wrong, long frequenzy, String question) {
		super(wrong, frequenzy, Settings.Marker.MULTIPLECHOICE, question);
		// TODO Auto-generated constructor stub
	}

	public LinkedList<Answer> returnQuestion() {
		if (answerContainer.size() > 1) {
			Utillity.shuffle(answerContainer);
		}

		return super.returnQuestion();
	}

}
