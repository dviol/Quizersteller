package de.violante.dennis.model.questions;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.LinkedList;

import de.violante.dennis.control.Settings;
import de.violante.dennis.model.questions.answers.Answer;
import de.violante.dennis.model.questions.answers.QuestionToAnswer;
import de.violante.dennis.model.questions.answers.RightAnswer;
import de.violante.dennis.utillity.Console;
import de.violante.dennis.utillity.HasSettings;
import de.violante.dennis.utillity.Utillity;

public abstract class Question implements Comparable<Question>,HasSettings {

	// Type of Question and Messages, wether you failed or nailed
	private final Settings.Marker typ;
	private static  String ALL_OK = "Alles richtig!\n";
	private static  String FAIL = "Du hast einen oder mehrere Fehler gemacht."
			+ "Hier ist eine Liste der richtigen Antworten:\n";
	private  QuestionToAnswer question;

	// Wrong guesses
	private long wrongGuesses;
	private LinkedList<RightAnswer> rightAnswers;
	private long frequenzy;
	public LinkedList<Answer> answerContainer;

	

	public Answer[] add(Answer... a) {

		for (Answer answer : a) {
			if (answer.getTyp() == Settings.Marker.RIGHTANSWER) {
				rightAnswers.add((RightAnswer) answer);
			}
			answerContainer.add(answer);

		}

		return a;
	}

	public void resetQuestion() {
		this.frequenzy = 0;
		this.wrongGuesses = 0;
	}

	public Question(Settings.Marker qt){
		typ = qt;
		answerContainer = new LinkedList<>();
		rightAnswers = new LinkedList<>();
	}
	
	public Question(long wrong, long frequenzy, Settings.Marker typ, String question) {
		this.frequenzy = frequenzy;
		wrongGuesses = wrong;
		answerContainer = new LinkedList<>();
		rightAnswers = new LinkedList<>();
		this.typ = typ;
		this.question = new QuestionToAnswer(question);
		
	}

	public Question(long wrong, long frequenzy, Settings.Marker typ, String question,
			Comparator<Question> compMode) {
		this(wrong, frequenzy, typ, question);
		
	}

	/**
	 * Consolemode: Asks questions with Answerpossibilities, if provided GUIMODE
	 * == true: Returns a linked list
	 * 
	 * @return Linked List of Question at position 0 and Answers 1 to n
	 */
	public LinkedList<Answer> returnQuestion() {
		frequenzy++;
		LinkedList<Answer> temp = new LinkedList<>();
		temp.add(this.question);
		temp.addAll(answerContainer);
		if (Settings.GUIMODE) {
			Console c = Console.getInstance();

			for (Answer answer : temp) {
				if (answer.getTyp() != Settings.Marker.IMAGE) {
					c.toConsole(answer.getContent());
				} else {
					answer.getContent();
				}

			}
		}
		return temp;
	}

	private boolean contains(LinkedList<String> userAnswers, LinkedList<RightAnswer> rightAnswers) {
		BigInteger pass = new BigInteger("0");

		for (String uAnswer : userAnswers) {
			for (Answer rAnswer : rightAnswers) {
				String userEntry = Utillity.normalizeAnswer(uAnswer).toLowerCase();
				String oneRight = Utillity.normalizeAnswer(rAnswer.getContent()).toLowerCase();

				if (userEntry.equals(oneRight)) {

					pass = incrementBigInt(pass);
				}

			}
		}
		if (pass.equals(rightAnswers.size())) {
			return true;
		}

		return false;
	}

	public LinkedList<RightAnswer> checkAnswer(LinkedList<String> userInput) {

		if (!(userInput.size() == rightAnswers.size() && contains(userInput, rightAnswers))) {
			wrongGuesses++;
			if (Settings.GUIMODE) {
				return rightAnswers;
			} else {
				Console c = Console.getInstance();
				c.toConsole(FAIL);
				for (Answer ans : rightAnswers) {
					c.toConsole(ans.getContent() + "\n");

				}
			}
		}

		return null;
	}

	/**
	 * @param q
	 *            The other Question to compare
	 */
	public int compareTo(Question q) {
		
		
		return QuestionContainer.getComp().compare(this, q);

	}

	// Incremention and Decremention Methods

	public BigInteger incrementBigInt(BigInteger big) {

		BigInteger temp = big.add(new BigInteger("1"));
		return temp;
	}


	// Getters and Setters

	public Settings.Marker getTyp() {
		return this.typ;
	}

	public long getFrequenzy() {
		return this.frequenzy;
	}

	public long getWrongGuesses() {
		return this.wrongGuesses;
	}

	@Override
	public String toString() {
		String out = Settings.addEqual("TYP", String.valueOf(getTyp()));
		
		out += "\n";
		out += Settings.addEqual("WRONG",String.valueOf(wrongGuesses)) + "\n";
		out += Settings.addEqual("FREQ",String.valueOf(frequenzy)) + "\n";
		for (Answer answer : answerContainer) {
			out += answer.toString(); 
		}
		return out;
	}

	public static String getALL_OK() {
		return ALL_OK;
	}

	public static void setALL_OK(String aLL_OK) {
		ALL_OK = aLL_OK;
	}

	public static String getFAIL() {
		return FAIL;
	}

	public static void setFAIL(String fAIL) {
		FAIL = fAIL;
	}

	public LinkedList<RightAnswer> getRightAnswers() {
		return rightAnswers;
	}

	public void setRightAnswers(LinkedList<RightAnswer> rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	public LinkedList<Answer> getAnswerContainer() {
		return answerContainer;
	}

	public void setAnswerContainer(LinkedList<Answer> answerContainer) {
		this.answerContainer = answerContainer;
	}

	public QuestionToAnswer getQuestion() {
		return question;
	}

	public void setWrongGuesses(long wrongGuesses) {
		this.wrongGuesses = wrongGuesses;
	}

	public void setFrequenzy(long frequenzy) {
		this.frequenzy = frequenzy;
	}

}
