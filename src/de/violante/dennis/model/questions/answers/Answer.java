package de.violante.dennis.model.questions.answers;

import de.violante.dennis.control.Settings;

public abstract class Answer {

	protected String content;
	private Settings.Marker typ;
	
	public Answer(String content, Settings.Marker typ){
		this.content = content;
		this.typ = typ;
	}
	
	
	public String getContent(){
		return this.content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	
	public String toString(){
		String out = Settings.addEqual(getTyp().toString(),content)+"\n";
		return out;
	}
	public Settings.Marker getTyp(){
		return this.typ;
	}
	
}
