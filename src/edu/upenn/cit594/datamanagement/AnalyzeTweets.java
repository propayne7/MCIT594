package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.logging.Log;
import edu.upenn.cit594.processor.FileInput;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/***
 * This class is used to convert the tweet data from strings to the necessary data types to conduct the analysis
 */
public class AnalyzeTweets {
    String fileType;
    String fileName;
    String stateFileName;
    Log log = Log.getInstance();
    FileInput io = new FileInput();
    Object tweets;

    public AnalyzeTweets() throws IOException, ParseException {
        this.fileType = MainArgs.getInstance().getTweetFileType();
        this.fileName = MainArgs.getInstance().getTweetFileName();
        this.stateFileName = MainArgs.getInstance().getStateFileName();

        String proceedWithType = io.FileInputCheck(fileType, fileName);

        if(proceedWithType.equals("JSON")){
            new HandleJSONTweets(io.getJSONTweets(fileName));
        }
        if(proceedWithType.equals("TEXT")){
            new HandleTextTweets(io.getTabDelimitedTweets(fileName));
        }

//        System.out.println(tweets.getClass());

    }

}
