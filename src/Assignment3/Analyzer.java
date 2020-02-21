package Assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		// create a linked list to store the sentences
		LinkedList<Sentence> sentences = new LinkedList<>();

		// handle the case where "null" is passed as the filename
		if (filename == null){
			sentences = null;
			return sentences;
		}

		try {
			// create a buffered reader to pull in the file data
			FileReader fr = new FileReader(filename);
			BufferedReader reader = new BufferedReader(fr);
			String line = null;
			// read the file line by line, assigning each line to a new sentence object
			while((line = reader.readLine()) != null){

				if(isLineValid(line)){
					int score = getScore(line);
					String text = getText(line);

					if(Math.abs(score) <= 2 && text != null) {
						Sentence currentSentence = new Sentence(score, text);
						sentences.add(currentSentence);
					}
				}
			}
		} catch (IOException e) {
			sentences = null;
			e.printStackTrace();
		}

		return sentences;
	}

	// method to test the line is in the valid format
	public static boolean isLineValid(String line){
		// regex to test if the line begins with a hyphen (to represent a negative number), or begins with a digit
		// if the above is true, test to see that the format is "score _space_ character"
		Pattern p = Pattern.compile("(?=(?=[-])|(?=[\\d]))(^[^\\s]+)(\\s)([a-zA-z])");
		Matcher m = p.matcher(line);

		if(m.find()){
			int score = getScore(line);
			if(Math.abs(score) <= 2){
				return true;
			}
		}

		return false;
	}

	// create a method to parse the score from the line
	public static int getScore(String line){
		// use regex to parse everything up to the first space in the line
		Pattern p = Pattern.compile("(^[^\\s]+)");
		Matcher m = p.matcher(line);
		int score = -99;

		if(m.find()){
			score = Integer.parseInt(m.group());
		}

		return score;
	}

	// create a method to parse the text from the line
	public static String getText(String line){
		Pattern p = Pattern.compile("(?<=\\s).*");
		Matcher m = p.matcher(line);
		String text  = "";

		if(m.find()){
			text = m.group();
		} else {
			text = null;
		}

		return text;
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		LinkedHashSet<Word> wordSet = new LinkedHashSet<>();
		ArrayList<String> uniqueWordArrayList = new ArrayList<>();
		ArrayList<Word> wordArrayList = new ArrayList<>();

		if(sentences == null){
			wordSet = null;
			return wordSet;
		}

		// iterate through each sentence, splitting each sentence into an array of words (type: String)
		// add valid strings to the wordSet
		for(Sentence s : sentences){
			if(s == null){
				break;
			}
			// split the sentence into an array using the space as a delimiter
			String lowerCaseSentence = s.text.toLowerCase();
			String[] wordArray = lowerCaseSentence.split(" ");

			for(String str : wordArray) {
				boolean result = str.matches("^[a-zA-Z]+$");
				if (result) {
					Word currentWord = new Word(str);
					currentWord.total = s.getScore();
					wordArrayList.add(currentWord);
				}
			}
		}

		boolean emptyUniqueWordArray = uniqueWordArrayList.isEmpty();

		for(Word w : wordArrayList){
			if(emptyUniqueWordArray){
				uniqueWordArrayList.add(w.getText());
			} else {
				if(!uniqueWordArrayList.contains(w.text)){
					uniqueWordArrayList.add(w.getText());
				}
			}
		}

		for(String str : uniqueWordArrayList){
			Word currentWord = new Word(str);
			wordSet.add(currentWord);
		}

		Iterator<Word> itr = wordSet.iterator();

		while(itr.hasNext()){
			Word hashSetWord = itr.next();
			for(Word w : wordArrayList){
				if(hashSetWord.text.equals(w.text)){
					hashSetWord.increaseTotal(w.getTotal());
				}
			}
		}

		for(Word w : wordSet){
			System.out.println(w.getText());
		}

		return wordSet;
	}

	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		HashMap<String, Double> wordMap = new HashMap();
		Iterator<Word> itr = words.iterator();

		if(words == null){
			return null;
		}

		while(itr.hasNext()){
			Word currentWord = itr.next();
			double score = (double) currentWord.getTotal() / (double )currentWord.getCount();
			wordMap.put(currentWord.text, score);
		}

		return wordMap;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		if(wordScores == null || sentence == null || wordScores.isEmpty()){
			return 0;
		}

		double score = 0;
		String[] lowerCaseSentence = sentence.toLowerCase().split(" ");
		int count = lowerCaseSentence.length;

		for(String s : lowerCaseSentence){
			if(wordScores.containsKey(s)){
				score += wordScores.get(s);
			}
		}

		double sentiment = score / count;

		return sentiment;
	}

	/*
	 * You do not need to modify this code but can use it for testing your program!
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);

	}
}
