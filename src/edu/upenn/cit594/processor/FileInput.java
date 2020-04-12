package edu.upenn.cit594.processor;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInput {

    public FileInput(String fileType, String fileName) throws IOException, ParseException {
        // handle file type input
        String inputFormat = fileType;
        boolean jsonFileInput = inputFormat.matches("(?i)(json)");
        boolean textFileInput = inputFormat.matches("(?i)(text)") || inputFormat.matches("(?i)(txt)");
        // check that the tweet file type input doesn't contain both JSON and text as the file type
        boolean incorrectInput = jsonFileInput == textFileInput;
        // if the tweet file type input is incorrect, display a message and exit the program
        if(incorrectInput){
            System.out.println("You entered \"" + inputFormat + "\" as the tweet file input type.\n" +
                    "this is incorrect. Please check your file input type and try again.");
            System.exit(0);
        }

        if(jsonFileInput){
            getJSONTweets(fileName);
        }

        if(textFileInput){
            tabDelimitedInput(fileName);
        }

    }

    public JSONArray getJSONTweets(String fileName) throws ParseException, IOException {
        // create a FileReader to read the JSON file
        FileReader reader = null;
        // error handling to ensure the file is found. If not found, display a message and exit the program.
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + fileName + "\" was not found. Please check your file name and try again.");
            System.exit(0);
        }
        // create JSONParser to parse the file passed in to the FileReader
        JSONParser parser = new JSONParser();
        // add tweets from JSON file to JSONArray
        JSONArray tweets = (JSONArray) parser.parse(reader);
        // return tweets (JSONArray)
        return tweets;
    }

    public ArrayList<TextInputObj> tabDelimitedInput(String fileName) throws IOException {
        // create a BufferedReader to read the tab-delimited text file file
        BufferedReader reader = null;
        // error handling to ensure the file is found. If not found, display a message and exit the program.
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + fileName + "\" was not found. Please check your file name and try again.");
            System.exit(0);
        }
        ArrayList<TextInputObj> tweetArray = new ArrayList<>();


        while (reader.readLine() != null) {
            TextInputObj obj = new TextInputObj();
            String currentTweet = reader.readLine();
            String[] currentTweetArray = currentTweet.split("\t");
            JSONParser parser = new JSONParser();
            obj.coordinates = currentTweetArray[0];
            obj.identifier = currentTweetArray[1];
            obj.date = currentTweetArray[2];
            obj.tweetText = currentTweetArray[3];
            tweetArray.add(obj);
        }
        return tweetArray;
    }
}
