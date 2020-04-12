package edu.upenn.cit594;

import edu.upenn.cit594.logging.Log;
import edu.upenn.cit594.processor.FileInput;
import org.json.simple.parser.ParseException;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        /**** BEGIN ERROR HANDLING OF CLI ARGUMENTS ****/
        // check whether the length of args is 0
        if(args.length == 0){
            System.out.println("The following arguments must be entered (separated by a space) in the command" +
                    " line when running this program: " +
                    "\ntweet file type (text or json)\ntweet file path\nstate file path\nlog file path");
            System.out.println();
            System.out.println("This program will now exit. Please re-run the program with the correct" +
                    " arguments.");
            System.exit(0);
        }

        for(int i = 0; i < args.length; i++){
            if(args[i] == null){
                switch(i){
                    case 0:
                        System.out.println("The tweet file type is missing. Please check your inputs and try again.");
                        System.exit(0);
                    case 1:
                        System.out.println("The tweet file name is missing. Please check your inputs and try again.");
                        System.exit(0);
                    case 2:
                        System.out.println("The state file name is missing. Please check your inputs and try again.");
                        System.exit(0);
                    case 3:
                        System.out.println("The log file name is missing. Please check your inputs and try again.");
                        System.exit(0);
                }
            }
        }
        /**** END ERROR HANDLING OF CLI ARGUMENTS ****/

    }
}
