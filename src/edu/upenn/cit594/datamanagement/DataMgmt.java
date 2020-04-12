package edu.upenn.cit594.datamanagement;

public class DataMgmt {
    public double[] formatCoordinates(String stringCoordinates) {
        double[] coordinates = new double[2];
        String removedBrackets = stringCoordinates.replace("[","").replace("]","");
        Double latitude = Double.parseDouble(removedBrackets.substring(0,removedBrackets.indexOf(",")));
        Double longitude = Double.parseDouble(removedBrackets.substring(removedBrackets.indexOf(",") + 1,removedBrackets.length()));

        coordinates[0] = latitude;
        coordinates[1] = longitude;

        return coordinates;
    }

}
