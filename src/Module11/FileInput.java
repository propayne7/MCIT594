package Module11;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class FileInput {

    public JSONArray getJSONTweets(String fileName) throws IOException, ParseException {
        // create a new JSONParser to pull in the JSON file
        JSONParser parser = new JSONParser();
        // add tweets from JSON file to JSONArray
        JSONArray tweets = (JSONArray) parser.parse(new FileReader("C:\\Users\\payne\\Desktop\\MCIT594\\src\\Module11\\flu_tweets.json"));
        // return tweets (JSONArray)
        return tweets;
    }


    private class JSONCreateObject {
        String coordinates;
        String identifier;
        String date;
        String tweetText;

        public String getCoordinates() {
            return coordinates;
        }

        public String getDate() {
            return date;
        }

        public String getTweetText() {
            return tweetText;
        }

        public String getIdentifier() {
            return identifier;
        }
    }

    public ArrayList<JSONCreateObject> tabDelimitedInput(String filName) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\payne\\Desktop\\MCIT594\\src\\Module11\\flu_tweets.txt"));
        ArrayList<JSONCreateObject> tweetArray = new ArrayList<>();


        while (reader.read() != -1) {
            JSONCreateObject obj = new JSONCreateObject();
            String currentTweet = reader.readLine();
            String[] currentTweetArray = currentTweet.split("\t");
            JSONParser parser = new JSONParser();
            obj.coordinates = currentTweetArray[0];
            obj.identifier = currentTweetArray[1];
            obj.date = currentTweetArray[2];
            obj.tweetText = currentTweetArray[3];
            tweetArray.add(obj);
        }

        for(JSONCreateObject o : tweetArray){
            System.out.println(o.coordinates);
            System.out.println(o.tweetText);
        }

        return tweetArray;
    }
}
