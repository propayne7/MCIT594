package Module11;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;

public class TweetRunner {
    public static void main(String[] args) throws ParseException, IOException {
        System.out.println("WHO DID DAT");

        JSONParser parser = new JSONParser();

        JSONArray tweets = (JSONArray)parser.parse(new FileReader("C:\\Users\\payne\\Desktop\\MCIT594\\src\\Module11\\flu_tweets.json"));

        Iterator iter =  tweets.iterator();

        while(iter.hasNext()){
            JSONObject tweet = (JSONObject)iter.next();
            System.out.println(tweet.get("text"));
        }
    }

}
