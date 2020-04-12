package edu.upenn.cit594.datamanagement;

public class TextOutputObj {
    private double[] coordinates;
    private String tweet;
    private String state;

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }
}
