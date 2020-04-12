package edu.upenn.cit594.processor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
public class FileInput {

    public FileInput(String[] args) throws IOException, ParseException {
        // handle file type input
        String inputFormat = args[0];
        if(inputFormat.matches("(?i)(json)")){
            getJSONTweets(args[1]);
        }
        if(inputFormat.matches("(?i)(txt)") || inputFormat.matches("(?i)(text)")){
            tabDelimitedInput(args[1]);
        }

    }

    public JSONArray getJSONTweets(String fileName) throws IOException, ParseException {
        // create a new JSONParser to pull in the JSON file
        JSONParser parser = new JSONParser();
        // add tweets from JSON file to JSONArray
        JSONArray tweets = (JSONArray) parser.parse(new FileReader(fileName));
        // return tweets (JSONArray)
        return tweets;
    }


    private class JSONCreateObject {
        String coordinates;
        String identifier;
        String date;
        String tweetText;
    }

    public ArrayList<TextInputObj> tabDelimitedInput(String fileName) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
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

//        for(TextInputObj o : tweetArray){
//            System.out.println(o.coordinates + ", " + o.tweetText);
//        }

        return tweetArray;
    }
}
