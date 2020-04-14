package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.logging.Log;
import edu.upenn.cit594.processor.FileInput;
import org.json.simple.parser.ParseException;

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
    }

    public void calcDist(ArrayList<TextOutputObj> tweets, HashMap<String, Double[]> stateInfo){
        for()
    }

}
