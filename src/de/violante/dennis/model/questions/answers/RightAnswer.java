package de.violante.dennis.model.questions.answers;

import de.violante.dennis.control.Settings;

public class RightAnswer extends Answer {

	public RightAnswer(String content) {
		super(content, Settings.Marker.RIGHTANSWER);
	}
}
