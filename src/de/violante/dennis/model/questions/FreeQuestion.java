package de.violante.dennis.model.questions;

import de.violante.dennis.control.Settings;

public class FreeQuestion extends Question {

	
	public FreeQuestion(){
		super(Settings.Marker.FREEQUESTION);
	}
	
	public FreeQuestion(long wrong,long frequenzy, String question) {
		super(wrong,frequenzy, Settings.Marker.FREEQUESTION, question);
		// TODO Auto-generated constructor stub
	}



}
