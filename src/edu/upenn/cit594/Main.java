package edu.upenn.cit594;

import edu.upenn.cit594.data.MainArgs;

public class Main {
    public static void main(String[] args){
        // error handling -- if the below class encounters any errors, the program will exit
        CLIArgsErrorHandling errors = new CLIArgsErrorHandling(args);
        // create mainArgs object and initialize properties with the values passed in from the CLI
        MainArgs mainArgs = new MainArgs(args);
    }
}
