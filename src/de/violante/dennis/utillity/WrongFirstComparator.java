package de.violante.dennis.utillity;

import java.util.Comparator;

import de.violante.dennis.model.questions.Question;

public class WrongFirstComparator implements Comparator<Question> {

	@Override
	public int compare(Question o1, Question o2) {
		int freqComp = new Long(o1.getFrequenzy()).compareTo(o2.getFrequenzy());
		int wrongComp = new Long(o1.getWrongGuesses()).compareTo(o2.getWrongGuesses());

		if (wrongComp == 0) {
			if (freqComp > 0) {
				return 1;
			} else if (freqComp < 0) {
				return -1;
			} else {
				return 0;
			}

		} else if (wrongComp < 0) {

			return 1;
		} else {
			return -1;
		}
	}
	@Override
	public String toString(){
		return "WrongFirstComparator";
	}

}
