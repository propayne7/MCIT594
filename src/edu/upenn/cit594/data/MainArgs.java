package edu.upenn.cit594.data;

/**
 * This class creates a final object named MainArgs.
 * Using the singleton pattern, this class returns an instance of the object with the properties
 * being the args that were passed as CLI arguments.
 */

public final class MainArgs {
    private static MainArgs instance;

    private String tweetFileType;
    private String tweetFileName;
    private String stateFileName;
    private String logFileName;

    public MainArgs(String[] args){
        setTweetFileType(args[0]);
        setTweetFileName(args[1]);
        setStateFileName(args[2]);
        setLogFileName(args[3]);
    }

    public static MainArgs getInstance(){
        return instance;
    }

    public String getTweetFileType() {
        return tweetFileType;
    }

    private void setTweetFileType(String tweetFileType) {
        this.tweetFileType = tweetFileType;
    }

    public String getTweetFileName() {
        return tweetFileName;
    }

    private void setTweetFileName(String tweetFileName) {
        this.tweetFileName = tweetFileName;
    }

    public String getStateFileName() {
        return stateFileName;
    }

    private void setStateFileName(String stateFileName) {
        this.stateFileName = stateFileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    private void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
}
