package edu.upenn.cit594.logging;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Implement a Log class using the Singleton design pattern
 * -
 */
public class Log {
    private PrintWriter out;
    private static Log logInstance = new Log();
    // create private constructor
    private Log(){}

//    public Log getInstance(String logFile){
//        if()
//        return logInstance;
//    }
}


