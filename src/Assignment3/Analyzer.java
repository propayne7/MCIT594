package Assignment3;

import java.io.BufferedReader;
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
		// create Path object to format the filename passed to the method
		Path file = Paths.get(filename);
		Charset charset = Charset.forName("US-ASCII");

		// create a linked list to store the sentences
		LinkedList<Sentence> sentences = new LinkedList<>();

		try {
			// create a buffered reader to pull in the file data
			BufferedReader reader = Files.newBufferedReader(file, charset);
			String line = null;
			// read the file line by line, assigning each line to a new sentence object
			while((line = reader.readLine()) != null){

				if(isLineValid(line)){
					int score = getScore(line);
					String text = getText(line);
					Sentence currentSentence = new Sentence(score, text);
					sentences.add(currentSentence);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
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

		if(m.find()){
			System.out.println("Line matches: " + m.group());
		}

		return m.group();
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		return null;
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		return null;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		return 0;
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
