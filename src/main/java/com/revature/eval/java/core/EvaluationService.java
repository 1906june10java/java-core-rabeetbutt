package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		//splits phrase up at spaces and hyphens
		String [] splitPhrase = phrase.split("-|\\s");
		
		String acronym = "";
		
		//iterates through the split phrase to append the first character of each substring
		for (String s : splitPhrase) {
			char upper = Character.toUpperCase(s.charAt(0));
			acronym = acronym + upper;
		}
		
		phrase = acronym;
		
		return phrase;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		  
		int score = 0;
		String upperString = string.toUpperCase();
		
		//iterates through the string in which scores are assigned based on letter values
		for (int i = 0; i < upperString.length(); i++) {
			
			char letter = upperString.charAt(i);
			
			if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O'|| letter == 'U'|| letter == 'L'
		     || letter == 'N' || letter == 'R' || letter == 'S'|| letter == 'T') {
				score += 1;
			}
			
			if (letter == 'D'|| letter == 'G') {
				score += 2;
			}
		
			if (letter == 'B'|| letter == 'C' || letter == 'M' || letter == 'P') {
				score += 3;
			}
			
			if (letter == 'F'|| letter == 'H' ||letter == 'V'|| letter == 'W' || letter == 'Y') {
				score += 4;
			}
			
			if (letter == 'K') {
				score += 5;
			}
			
			if (letter == 'J' || letter == 'X') {
				score += 8;
			}
			
			if (letter == 'Q' || letter == 'Z') {
				score += 10;
			}	
			
		}
		
		return score;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
			
		//throws non numeric exception 
		if (string.contains("!")) {
			throw new IllegalArgumentException();
		}
		
		String cleanNum = string;	
		
		//removes all non-numeric characters from number
		cleanNum = string.replaceAll("[^0-9]", "");
		
		if (cleanNum.length() > 11) {
			throw new IllegalArgumentException();
		}
		
		
		
		return cleanNum;
	}
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount (String string) {
		
			
		  Map<String, Integer> wordMap = new HashMap<String,Integer>();
		  
		  //removes newline characters and spaces 
		  string = string.replace("\n", "");
		  String[] splitString = string.split("\\s|,");
		  
		  //iterates over split phrase and counts the occurrences of each phrase 
		  //non-positive limit means the string can have any length and the pattern will be applied indefinitely
		  for (String s : splitString) {
			  int count = (string.split(s, -1).length) - 1;
			  wordMap.put(s, count);
		  }
		  return wordMap;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
	
			int first = 0;
			int last = sortedList.size() - 1;
			int key = Integer.valueOf(t.toString());
			int mid = (first + last)/2;  
			
			//loops through until all elements have been checked
			while( first <= last ){  
				
				if (Integer.valueOf(sortedList.get(mid).toString()) < key){  
					//check right side of sub-array
					first = mid + 1;
					
			    } else if (Integer.valueOf(sortedList.get(mid).toString()) == key){  
			    	//key is found
			    	return mid;
			    	
			    } else {  
			    	//check left side of sub-array
			    	last = mid - 1;  
			    }
				
				//find new middle based on value of key
			    mid = (first + last)/2;  
			}  
				
			throw new IllegalArgumentException();
			
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}
		
	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		String s = Integer.toString(input);
		char[] digits = s.toCharArray();
		int ArmstrongVal = 0;
		
		//iterates over array and computes Armstrong for each digit
		for (char c : digits) {
			ArmstrongVal = ArmstrongVal + (int)(Math.pow(Character.getNumericValue(c), digits.length));
		}
		
		if (ArmstrongVal == input) {
			return true;
		}
		else {
			return false;
		}
		
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {

		List<Long> primeFactors = new ArrayList<Long>();
		
		for (long i = 2; i <= l; i++) {
			//checks if long is divisible by factor
			while (l % i == 0) {
				primeFactors.add(i);
				l /= i;
			}
		}
		
		return primeFactors;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		
		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			string = string.toLowerCase();
			
			char[] plainText = string.toCharArray();
			String encodedText = "";
			int counter = 0;
			int newAscii = 0;
			
			for (char c : plainText) {
				
				if ((int)c >= 97 && (int)c <= 122 || (int) c >= 48 && (int)c <= 57) {
					
					if ((int)c >= 97 && (int)c <= 122) { 
						//formula to encrypt ASCII 
						newAscii = (int)c + (25 - 2 * ((int)c - 97));
					}
					else {
						newAscii = (int)c;
					}
					
					counter += 1;
					
					//prints out space every 5 characters to get format 
					if (counter == 5) {
						encodedText = encodedText + (char)newAscii + " ";
						counter = 0;
					}
					
					else {
						encodedText = encodedText + (char)newAscii;
					}
				}			
				
			}
			//removes whitespace at the end of the string
			encodedText = encodedText.replaceAll("\\s$", "");
			return encodedText;
			
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			string = string.toLowerCase();
			
			char[] cipherText = string.toCharArray();
			String decodedText = "";
			int newAscii = 0;
			
			for (char c : cipherText) {
				
				if ((int)c >= 97 && (int)c <= 122 || (int) c >= 48 && (int)c <= 57) {
					
					if ((int)c >= 97 && (int)c <= 122) { 
						//formula for decryption
						newAscii = (int)c - (25 + 2 * ((int)c - 122));
					}
					else {
						newAscii = (int)c;
					}
					
					decodedText = decodedText + (char)newAscii;
				}
				
			}
			
			return decodedText;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		// removes ? from second operand
		String newString = string.replaceAll("[?]", " ");
		String[] word = newString.split("\\s");
		
		String firstDig = word[3];
		
		//addition, subtraction, division, multiplication are determined from string array
		if (firstDig.equals("plus")) {
			return (Integer.parseInt(word[2]) + Integer.parseInt(word[4])); 
		}
		
		else if (firstDig.equals("minus")) {
			return (Integer.parseInt(word[2]) - Integer.parseInt(word[4])); 
		}
		
		else if (firstDig.equals("multiplied")) {
			return (Integer.parseInt(word[2]) * Integer.parseInt(word[5])); 
		}
		
		else {
			return (Integer.parseInt(word[2]) / Integer.parseInt(word[5])); 
		}
		
	}

}
