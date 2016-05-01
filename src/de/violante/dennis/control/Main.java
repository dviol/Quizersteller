package de.violante.dennis.control;

import java.util.Comparator;

import org.omg.PortableServer.POAPackage.WrongAdapter;

import de.violante.dennis.model.questions.FreeQuestion;
import de.violante.dennis.model.questions.MultipleChoice;
import de.violante.dennis.model.questions.Question;
import de.violante.dennis.model.questions.QuestionContainer;
import de.violante.dennis.model.questions.answers.QuestionToAnswer;
import de.violante.dennis.model.questions.answers.RightAnswer;
import de.violante.dennis.utillity.WrongFirstComparator;

public class Main {

	

	public static void main(String[] args) {

		QuestionContainer qc = QuestionContainer.getInstance();
		Question q1 = new MultipleChoice();
		Question q2 = new FreeQuestion();
		Question q3 = new MultipleChoice();
		Question q4 = new MultipleChoice();
		q1.add(new RightAnswer("Test"));
		q1.add(new QuestionToAnswer("q1"));
		q2.add(new QuestionToAnswer("q2"));
		q3.add(new QuestionToAnswer("q3"));
		q4.add(new QuestionToAnswer("q4"));
		
		q1.setFrequenzy(2);
		q1.setWrongGuesses(1);
		
		q2.setFrequenzy(3);
		q2.setWrongGuesses(1);
		q3.setWrongGuesses(3);
		q3.setFrequenzy(2);
		q4.setFrequenzy(4);
		q4.setWrongGuesses(2);
		qc.add(q1,q2,q3,q4);
		
		
		System.out.print(qc.toString());
		qc.readyList();
		System.out.print("\nFrequency first!\n");
		System.out.print(qc.toString());
		QuestionContainer.setComp(new WrongFirstComparator());
		System.out.print("\nWrong first\n");
		qc.readyList();
		System.out.println(qc.toString());
		
		
		
}

}
