package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.processor.TextInputObj;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandleTextTweets {
    String pattern = "\\W*(?i)(flu)(?-i)\\W";
    ArrayList<TextInputObj> tweets = new ArrayList<>();
    ArrayList<TextOutputObj> filteredTweets = new ArrayList<>();
    DataMgmt dataMgmt = new DataMgmt();

    public HandleTextTweets(ArrayList<TextInputObj> tweets){
        this.tweets = tweets;
        filterFluOnly(tweets);
    }

    public void filterFluOnly(ArrayList<TextInputObj> tweets) {
        System.out.println("Running the filterFluOnly function:");
        Pattern p = Pattern.compile(pattern);
        for(TextInputObj o : tweets) {
            String tweetText = o.getTweetText();
            String coordinates = o.getCoordinates();
            Matcher m = p.matcher(tweetText);
            while(m.find()){
                TextOutputObj outputObj = new TextOutputObj();
                outputObj.setCoordinates(dataMgmt.formatCoordinates(coordinates));
                outputObj.setTweet(tweetText);
                filteredTweets.add(outputObj);
            }
        }
    }


}
