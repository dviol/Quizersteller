package de.violante.dennis.control;

import java.util.HashMap;

import de.violante.dennis.model.questions.Question;
import de.violante.dennis.model.questions.QuestionContainer;
import de.violante.dennis.utillity.FrequencyFirstComparator;
import de.violante.dennis.utillity.HasSettings;
import de.violante.dennis.utillity.WrongFirstComparator;


public class Settings implements HasSettings {

	public enum language{
		EN,DE;
	}
	
	public static boolean GUIMODE = true;
	public static language lang = language.DE;
	

	public enum Marker{
		WRONGANSWER,RIGHTANSWER,QUESTION,IMAGE,FREEQUESTION,MULTIPLECHOICE,FREQUENCY,WRONGCOUNT,VERSION;
	}

	
	public static final double  VERSION = 0.1;
	
	

	
	public static String settingmaker(){
		String temp = "";
		temp+=addEqual("ALL_OK",Question.getALL_OK());
		temp+=addEqual("FAIL", Question.getFAIL());
		temp+=addEqual("Comparator",QuestionContainer.getComp().toString());
		temp+=addEqual("Language", lang.toString());
			
		return temp;
	}
	
	public void applySettings(String[] sett){
		
		switch (sett[0].toLowerCase()) {
		case "all_ok":
			Question.setALL_OK(sett[1]);
			break;
		case "fail":
			Question.setFAIL(sett[1]);
			break;	
		case "comparator":
			if(sett[0].toLowerCase().equals((new FrequencyFirstComparator()).toString().toLowerCase())){

			QuestionContainer.setComp(new FrequencyFirstComparator());
			}else{
				QuestionContainer.setComp(new WrongFirstComparator());
			}
			
			
			break;		
			

		default:
			break;
		}
		
		
	}
	
	public static String printVersion(){
		return addEqual(Marker.VERSION.toString(),String.valueOf(VERSION));
	}
	
	
	public static String addEqual(String a, String b){
		return a+"="+b;
	}



	
}
