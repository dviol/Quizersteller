package de.violante.dennis.utillity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import de.violante.dennis.model.enums.Charsets;
import de.violante.dennis.model.questions.Question;

public class Utillity {

	public static int randomInt(int maxVal) {
		return (int) Math.round(Math.random() * maxVal);
	}

	public static int[] returnTwoRand(int maxVal) {
		int[] temp = { randomInt(maxVal), randomInt(maxVal) };
		return temp;
	}

	public static <T extends Collection<E>, E> void shuffle(T col) {
		E temp = null;
		E ele1 = null;
		int[] rand = new int[2];
		int range = col.size() - 1;
		LinkedList<E> old = new LinkedList<>();
		old.addAll(col);

		for (int i = 0; i < col.size() * 10; i++) {

			rand = returnTwoRand(range);

			if (rand[0] != rand[1]) {

				temp = old.get(rand[0]);
				ele1 = old.get(rand[1]);
				old.set(rand[0], ele1);
				old.set(rand[1], temp);
			}

		}
		col.removeAll(col);
		col.addAll(old);

	}

	public static File returnOrCreateFile(String path, Charsets cs) throws IOException {
		Charset charset = Charset.forName(cs.getCharset());
		File file = new File(path);
		if (!file.exists()) {
			File pfile = file.getParentFile();

			pfile.mkdirs();
			file.createNewFile();

		}
		return file;
	}

	public static File returnOrCreateFile(String path) throws IOException {
		return returnOrCreateFile(path, Charsets.UTF8);
	}

	public static void write(String input, String path) throws IOException {
		writeToFile(input, path, false);
	}

	public static void append(String input, String path) throws IOException {

		writeToFile(input, path, true);
	}

	private static void writeToFile(String input, String path, boolean append) throws IOException {
		FileWriter fw = new FileWriter(returnOrCreateFile(path).getAbsoluteFile(), append);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(input);
		bw.close();

	}

	public static int parseInt(String promptM) throws IOException {
		return Integer.parseInt(prompt(promptM));
	}

	public static String prompt(String promptM) throws IOException {
		System.out.println(promptM);
		return readUserInput();
	}

	public static String readUserInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		// br.close();
		return s;
	}

//	public static BigInteger getMax(Collection<Question> c) {
//		if (!c.isEmpty()) {
//			Iterator<Question> it = c.iterator();
//			BigInteger max = it.next().getWrongGuesses();
//			BigInteger temp = null;
//			while (it.hasNext()) {
//				temp = it.next().getWrongGuesses();
//				if (temp.compareTo(max) > 0) {
//					max = temp;
//				}
//
//			}
//			return max;
//
//		} else {
//			return null;
//		}
//
//	}

	public static String normalizeAnswer(String param) {
		String temp = param;
		String toRem = " \n\t\r\b";
		// String old = "";

		for (int i = 0; i < toRem.length(); i++) {
			temp = temp.replaceAll(String.valueOf(toRem.charAt(i)), "");
		}

		return temp;

	}

}
