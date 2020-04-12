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
    public HandleJSONTweets(JSONArray tweets){
        this.tweets = tweets;
        filterFluOnly(tweets);

        for(TextOutputObj o : filteredTweets){
            System.out.println(o.getCoordinates());
            System.out.println(o.getTweet());
        }
    }

    public double[] formatCoordinates(String stringCoordinates) {
        double[] coordinates = new double[2];
        String removedBrackets = stringCoordinates.replace("[","").replace("]","");
        Double latitude = Double.parseDouble(removedBrackets.substring(0,removedBrackets.indexOf(",")));
        Double longitude = Double.parseDouble(removedBrackets.substring(removedBrackets.indexOf(",") + 1,removedBrackets.length()));

        coordinates[0] = latitude;
        coordinates[1] = longitude;

        return coordinates;
    }

    public void filterFluOnly(JSONArray tweets) {
        System.out.println("Running the filterFluOnly function:");
        Pattern p = Pattern.compile(pattern);
        for(Object o : tweets) {
            JSONObject jsonObject = (JSONObject) o;
            String tweetText = jsonObject.get("text").toString();
            String coordinates = jsonObject.get("location").toString();
            Matcher m = p.matcher(tweetText);
            while(m.find()){
                TextOutputObj outputObj = new TextOutputObj();
                outputObj.setCoordinates(formatCoordinates(coordinates));
                outputObj.setTweet(tweetText);
                filteredTweets.add(outputObj);
            }
        }
    }
}
