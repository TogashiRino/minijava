package compiler.analyzer.lex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;

//NOTE: this structure is eligible to change later

public class LexicalEngine {
	private static HashMap<String, String> tokens;

	/**
	 * Reads a line of input and scan it to extract lexemes
	 */
	public void scan() {

	}

	public static void main(String[] args) {

		String file = "int Double int Boolean "; // this will be like our file
		ArrayList<Type> ourList = new ArrayList<Type>();

		ArrayList<String> output = new ArrayList<String>(); // this will be the
															// output
		Type entry = new Type();
		entry.token = "<Integer>";
		entry.regularExpression = "\\bint\\b";
		ourList.add(entry);
		entry = new Type();
		entry.token = "<Boolean>";
		entry.regularExpression = "\\bBoolean\\b";
		ourList.add(entry);
		entry = new Type();
		entry.token = "<Double>";
		entry.regularExpression = "\\bDouble\\b";
		ourList.add(entry);
		
		for (int i = 0; i < ourList.size(); i++) {
			Pattern pat = Pattern.compile(ourList.get(i).regularExpression);
			Matcher match = pat.matcher(file);
			String found = "";
			if (match.find()) {

				found = match.group();

			}
			String entry2 = found + ourList.get(i).token;
			while (match.find()) {

				output.add(entry2);

			}

			file.replace(found, "");

		}

		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}

	}
}
