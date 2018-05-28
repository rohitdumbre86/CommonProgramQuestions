package com.algorithm.company.thoughtworks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GalacticEconomy {

	Map<String, String> galaticNameToRomanNumeral = new HashMap<String, String>();
	Map<String, Double> elementsToCreditMap = new HashMap<String, Double>();

	public void parseStatement(String statement) {

		String[] words = statement.split(" ");
		String romanConnotations = "IVXLCM";

		// A question is asked.
		if (words[words.length - 1].equals("?")) {
			parseQuery(statement);
		} else if (words[words.length - 1].equalsIgnoreCase("Credits")) {
			parseElementCredits(statement);
		} else if (romanConnotations.contains(words[words.length - 1])) {
			createGalaticToRomanNumeralDictionary(statement);
		} else {
			System.out.println("I have no idea what you are talking about.");
		}
	}

	/**
	 * @param value
	 *            Creates a dictionary of galatic to roman numeral.
	 */
	public void createGalaticToRomanNumeralDictionary(String value) {

		String[] conversions = value.split(" ");
		galaticNameToRomanNumeral.put(conversions[0], conversions[2]);

	}

	/**
	 * @param value
	 *            Parses out element and its value.
	 */
	public void parseElementCredits(String value) {
		String[] conversions = value.split(" ");

		String romanNumeral = "";
		int price = 1;
		String element = "";

		for (String conversion : conversions) {

			if (galaticNameToRomanNumeral.get(conversion) != null) {
				romanNumeral += galaticNameToRomanNumeral.get(conversion);
			} else if (conversion.charAt(0) >= '0' && conversion.charAt(0) <= '9') {
				price = Integer.parseInt(conversion);
			} else if (!conversion.equals("is") && !conversion.equalsIgnoreCase("Credits")) {
				element = conversion;
			}

		}

		if (!isValidRomanNumeral(romanNumeral)) {
			System.out.println("I have no idea what you are talking about.");
			return;
		}

		int priceValue = getHinduNumber(romanNumeral);
		
		if(priceValue <= 0) {
			System.out.println("I have no idea what you are talking about.");
			return;
		}
		
		elementsToCreditMap.put(element, (double) price / priceValue);

	}

	private boolean isValidRomanNumeral(String romanNumeral) {

		int noOfRepeatations = 1;
		String minimumRepeatingNotations = "IXCM";
		for (int i = 1; i < romanNumeral.length(); i++) {
			
			if (noOfRepeatations > 3) {
				return false;
			}

			if (romanNumeral.charAt(i) == romanNumeral.charAt(i - 1)
					&& minimumRepeatingNotations.contains(romanNumeral.charAt(i) + "")) {			

				noOfRepeatations++;
			} else {
				noOfRepeatations = 1;
			}

		}

		return true;

	}

	/**
	 * @param value
	 *            Parses the question and outputs a price. Will out a error message
	 *            if the question is not valid.
	 */
	public void parseQuery(String value) {

		String numeral = "";
		Double elementPerUnit = null;

		String[] queries = value.split(" ");
		String answer = "";

		for (String query : queries) {
			if (elementsToCreditMap.get(query) != null) {
				elementPerUnit = elementsToCreditMap.get(query);
				answer += " " + query;
			} else if (galaticNameToRomanNumeral.get(query) != null) {
				numeral += galaticNameToRomanNumeral.get(query);
				answer += " " + query;
			}
		}
		
		if (!isValidRomanNumeral(numeral)) {
			System.out.println("I have no idea what you are talking about.");
			return;
		}

		int hinduNumber = getHinduNumber(numeral);
		int priceOfQuantity = elementPerUnit != null ? (int) (elementPerUnit * hinduNumber) : hinduNumber;

		System.out.println(answer + " is " + priceOfQuantity);
	}

	/**
	 * @param romanNumeral
	 *            The roman number strings.
	 * @return A decimal number
	 */
	public int getHinduNumber(String romanNumeral) {
		int hinduNumber = 0;
		int currentNumber = 0;
		int previousNumber = Integer.MAX_VALUE;

		for (int i = 0; i < romanNumeral.length(); i++) {
			char currChar = romanNumeral.charAt(i);
			currentNumber = 0;

			switch (currChar) {

			case 'I':
				currentNumber = 1;
				break;
			case 'V':
				currentNumber = 5;
				break;
			case 'X':
				currentNumber = 10;
				break;
			case 'L':
				currentNumber = 50;
				break;
			case 'C':
				currentNumber = 100;
				break;
			case 'D':
				currentNumber = 500;
				break;
			case 'M':
				currentNumber = 1000;
				break;

			}

			if (currentNumber > previousNumber) {
				hinduNumber -= previousNumber;
				hinduNumber += currentNumber - previousNumber;
			} else {
				hinduNumber += currentNumber;
			}

			previousNumber = currentNumber;
		}

		return hinduNumber;
	}

	public static void main(String[] args) {

		GalacticEconomy parser = new GalacticEconomy();
		String line = null;
		try {
			FileReader filReader = new FileReader(
					"C:\\Users\\rdumb\\eclipse-workspace\\CommonProgramQuestions\\src\\com\\algorithm\\company\\thoughtworks\\GalaticEnterprise.txt");
			BufferedReader bufferedReader = new BufferedReader(filReader);
			while ((line = bufferedReader.readLine()) != null) {
				parser.parseStatement(line);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
