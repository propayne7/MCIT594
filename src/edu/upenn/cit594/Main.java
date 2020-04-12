package edu.upenn.cit594;
import edu.upenn.cit594.processor.FileInput;
import org.json.simple.parser.ParseException;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        // error handling -- if the below class encounters any errors, the program will exit
        CLIArgsErrorHandling errors = new CLIArgsErrorHandling(args);
    }
}
