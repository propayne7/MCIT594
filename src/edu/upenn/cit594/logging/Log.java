package edu.upenn.cit594.logging;
import edu.upenn.cit594.datamanagement.MainArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Implement a Log class using the Singleton design pattern
 * - the file name is pulled from the singleton MainArgs object that contains the filename passed in via CLI args
 */
public class Log {
    // pull in the file name from the MainArgs
//    private static String fileName = MainArgs.getInstance().getLogFileName();
    // create a PrintWriter object
    private PrintWriter out;
    // create a private variable to store the instance of the Log
    private static Log logInstance;

    // create private constructor
    private Log(String fileName){
        fileName = MainArgs.getInstance().getLogFileName();
        boolean fileNameTest = MainArgs.getInstance().getLogFileName().matches("(([a-zA-Z0-9\\\\s_\\\\\\\\.\\\\-\\\\(\\\\):])+(.txt)$)");

        if(!fileNameTest){
            System.out.println("A .txt file must be input for the log file. The fourth CLI argument is " + fileName +
                    " and does not have \".txt\" as the file extension.\nPlease fix the input and try again.");
            System.out.println("This program will now exit.");
            System.exit(0);
        }

        try {
            out = new PrintWriter(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // singleton accessor method
    public static Log getInstance(){
        if(logInstance == null){
            logInstance = new Log(MainArgs.getInstance().getLogFileName());
        }
        return logInstance;
    }

    // private method to get the filename from MainArgs. This will be used when creating a log file.
    private String getFileName(){
        return MainArgs.getInstance().getLogFileName();
    }

    public void printToLog(String msg){
        out.println(msg);
        out.flush();
    }
}


