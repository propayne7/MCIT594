package edu.upenn.cit594.processor;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;

public class FileInput {

    public String FileInputCheck(String fileType, String fileName){
        // check the file type is acceptable (json JSON .json .JSON txt .txt TEXT .TEXT)
        String proceedWithType = fileTypeCheck(fileType);
        // check the specified file type matches the extension of the input file name
        fileTypeMatchesFileExtension(proceedWithType, fileName);

        return proceedWithType;
    }
    public String fileTypeCheck(String fileType){
        // handle file type input
        String inputFormat = fileType;
        boolean jsonFileInput = inputFormat.matches("(?i)(json)");
        boolean textFileInput = inputFormat.matches("(?i)(text)") || inputFormat.matches("(?i)(txt)");
        // check that the tweet file type input doesn't contain both JSON and text as the file type
        boolean incorrectInput = jsonFileInput == textFileInput;
        // if the tweet file type input is incorrect, display a message and exit the program
        if(incorrectInput){
            System.out.println("You entered \"" + inputFormat + "\" as the tweet file input type.\n" +
                    "This file type is incorrect since it is neither JSON nor text. Please check your file input type and try again.");
            System.exit(0);
        }

        if(jsonFileInput){
            return "JSON";
        }

        if(textFileInput){
            return "TEXT";
        }
        return null;
    }

    public void fileTypeMatchesFileExtension(String fileType, String fileName){
        if(fileType.equals("JSON") && !fileName.matches("(([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.json)$)")){
            System.out.println("A JSON file type was specified as the input, but the file name does not have a .json file extension.");
            System.out.println("Please check your inputs and try again.");
            System.out.println("This program will now exit.");
            System.exit(0);
        }

        if(fileType.equals("TEXT") && !fileName.matches("(([a-zA-Z0-9\\\\s_\\\\\\\\.\\\\-\\\\(\\\\):])+(.txt)$)")){
            System.out.println("A text file type was specified as the input, but the file name does not have a .txt extension.");
            System.out.println("Please check your inputs and try again.");
            System.out.println("This program will now exit.");
            System.exit(0);
        }

    }

    public JSONArray getJSONTweets(String fileName) throws ParseException, IOException {
        // create a FileReader to read the JSON file
        FileReader reader = null;
        // error handling to ensure the file is found. If not found, display a message and exit the program.
        try {
            // check the file can be read
            File file = new File(fileName);
            if(file.canRead()){
                reader = new FileReader(fileName);
            } else {
                System.out.println("The file is not able to be read. Please check the access permissions of the tweet input file.");
                System.out.println("This program will now exit.");
                System.exit(0);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File \"" + fileName + "\" was not found. Please check your file name and try again.");
            System.exit(0);
        }
        // create JSONParser to parse the file passed in to the FileReader
        JSONParser parser = new JSONParser();
        // add tweets from JSON file to JSONArray
        JSONArray tweets = (JSONArray) parser.parse(reader);
        // return tweets (JSONArray)
        return tweets;
    }

    public ArrayList<TextInputObj> getTabDelimitedTweets(String fileName) throws IOException {
        // create a BufferedReader to read the tab-delimited text file file
        BufferedReader reader = null;
        // error handling to ensure the file is found. If not found, display a message and exit the program.
        try {
            // check the file can be read
            File file = new File(fileName);
            if(file.canRead()){
                reader = new BufferedReader(new FileReader(fileName));
            } else {
                System.out.println("The file is not able to be read. Please check the access permissions of the tweet input file.");
                System.out.println("This program will now exit.");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + fileName + "\" was not found. Please check your file name and try again.");
            System.exit(0);
        }
        ArrayList<TextInputObj> tweetArray = new ArrayList<>();


        while (reader.readLine() != null) {
            TextInputObj obj = new TextInputObj();
            String currentTweet = reader.readLine();
            String[] currentTweetArray = currentTweet.split("\t");
            JSONParser parser = new JSONParser();
            obj.setCoordinates(currentTweetArray[0]);
            obj.setIdentifier(currentTweetArray[1]);
            obj.setDate(currentTweetArray[2]);
            obj.setTweetText(currentTweetArray[3]);
            tweetArray.add(obj);
        }
        return tweetArray;
    }

    /***
     * START HERE on 4/13 --> get state data loaded in. need to think of the following:
     *  - data structure to hold states
     *  - how to compare state longitude and latitude with tweets
     */


}
