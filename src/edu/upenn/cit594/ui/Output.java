package edu.upenn.cit594.ui;

import java.util.TreeMap;

public class Output {

    public Output(TreeMap<String, Integer> stateTweetCounts){
        for(String s : stateTweetCounts.keySet()){
            System.out.println(s + ": " + stateTweetCounts.get(s));
        }
    }
}
