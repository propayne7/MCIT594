package edu.upenn.cit594;

/**
 * This class is used to handle any errors that could occur due to incorrect CLI arguments
 * Additional error handling (e.g. file-specific errors) are handled in their respective class (e.g. FileInput class)
 */
public class CLIArgsErrorHandling {

    public CLIArgsErrorHandling(String[] args){
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
