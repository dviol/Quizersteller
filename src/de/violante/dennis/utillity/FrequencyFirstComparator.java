package de.violante.dennis.utillity;

import java.util.Comparator;

import de.violante.dennis.model.questions.Question;

public class FrequencyFirstComparator implements Comparator<Question> {

	@Override
	public int compare(Question o1, Question o2) {
		int freqComp = new Long(o1.getFrequenzy()) .compareTo(o2.getFrequenzy());
		int wrongComp = new Long( o1.getWrongGuesses()).compareTo(o2.getWrongGuesses());

		if (freqComp == 0) {
			if (wrongComp < 0) {
				return 1;
			} else if (wrongComp > 0) {
				return -1;
			} else {
				return 0;
			}

		} else if (freqComp > 0) {

			return 1;
		} else {
			return -1;
		}
	}
	@Override
	public String toString(){
		return "FrequencyFirstComparator";
	}
}
