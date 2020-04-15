package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.logging.Log;
import edu.upenn.cit594.processor.FileInput;
import org.json.simple.parser.ParseException;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/***
 * This class is used to convert the tweet data from strings to the necessary data types to conduct the analysis
 */
public class AnalyzeTweets {
    String fileType;
    String fileName;
    String stateFileName;
    ArrayList<TextOutputObj> filteredTweets;
    HashMap<String, Double[]> stateMap;

    Log log = Log.getInstance();
    FileInput io = new FileInput();

    public AnalyzeTweets() throws IOException, ParseException {
        // get the arguments passed to the CLI in the main method of the Main class
        this.fileType = MainArgs.getInstance().getTweetFileType();
        this.fileName = MainArgs.getInstance().getTweetFileName();
        this.stateFileName = MainArgs.getInstance().getStateFileName();

        // validate the file inputs and determine whether the file is text or JSON
        String proceedWithType = io.FileInputCheck(fileType, fileName);

        if(proceedWithType.equals("JSON")){
           filteredTweets = new HandleJSONTweets(io.getJSONTweets(fileName)).getFilteredTweets();
        }

        if(proceedWithType.equals("TEXT")){
           filteredTweets = new HandleTextTweets(io.getTabDelimitedTweets(fileName)).getFilteredTweets();
        }

        // pull in the state data as an HashMap - state name = key, coordinates = value
        stateMap = io.processStateData(stateFileName);

        determineDistances(filteredTweets, stateMap);
    }

    public void determineDistances(ArrayList<TextOutputObj> tweets, HashMap<String, Double[]> stateInfo){

        for(TextOutputObj tweet : tweets){
            double minDistance = Double.MAX_VALUE;
            String state = null;
            for(String s : stateInfo.keySet()){
                double tweetLatitude = tweet.getCoordinates()[0];
                double stateLatitude = stateMap.get(s)[0];
                double tweetLongitude = tweet.getCoordinates()[1];
                double stateLongitude = stateMap.get(s)[1];
                double calcDistance = calcDistance(tweetLatitude, stateLatitude, tweetLongitude, stateLongitude);

                if(calcDistance < minDistance){
                    minDistance = calcDistance;
                    state = s;
                }

                System.out.println("Tweet: " + tweet.getTweet());
                System.out.println("State: " + state +"\n");

            }
        }

    }

    public double calcDistance(double x1, double x2, double y1, double y2){
        double xDiffSquared = Math.pow(x2 - x1, 2);
        double yDiffSquared = Math.pow(y2 - y1, 2);
        double euclideanDistance = Math.sqrt(xDiffSquared + yDiffSquared);

        return euclideanDistance;
    }

}
