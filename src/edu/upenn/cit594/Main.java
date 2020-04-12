package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.AnalyzeTweets;
import edu.upenn.cit594.datamanagement.MainArgs;
import edu.upenn.cit594.logging.Log;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        // error handling -- if the below class encounters any errors, the program will exit
        new CLIArgsErrorHandling(args);

        // create mainArgs object and initialize properties with the values passed in from the CLI
        new MainArgs(args);

        // create Log object
        Log.getInstance();

        // conduct Tweet analysis
        new AnalyzeTweets();
    }
}
