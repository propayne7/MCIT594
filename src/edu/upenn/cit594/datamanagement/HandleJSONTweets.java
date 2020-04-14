package edu.upenn.cit594.datamanagement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.ArrayList;

public class HandleJSONTweets {
    String pattern = "\\W*(?i)(flu)(?-i)\\W";
    JSONArray tweets;
    ArrayList<TextOutputObj> filteredTweets = new ArrayList<>();
    DataMgmt dataMgmt = new DataMgmt();

    public HandleJSONTweets(JSONArray tweets){
        this.tweets = tweets;
        filterFluOnly(tweets);
    }

    public void filterFluOnly(JSONArray tweets) {
        Pattern p = Pattern.compile(pattern);
        for(Object o : tweets) {
            JSONObject jsonObject = (JSONObject) o;
            String tweetText = jsonObject.get("text").toString();
            String coordinates = jsonObject.get("location").toString();
            Matcher m = p.matcher(tweetText);
            while(m.find()){
                TextOutputObj outputObj = new TextOutputObj();
                outputObj.setCoordinates(dataMgmt.formatCoordinates(coordinates));
                outputObj.setTweet(tweetText);
                filteredTweets.add(outputObj);
            }
        }
    }

    public ArrayList<TextOutputObj> getFilteredTweets() {
        return filteredTweets;
    }
}
