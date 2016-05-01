package de.violante.dennis.model.questions.answers;

import de.violante.dennis.control.Settings;

public class WrongAnswer extends Answer {

	public WrongAnswer(String content) {
		super(content,Settings.Marker.WRONGANSWER);
	}
}
