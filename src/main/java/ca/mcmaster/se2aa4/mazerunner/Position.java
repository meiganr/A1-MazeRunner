package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*; 

public class Position {
    private static final Logger logger = LogManager.getLogger();

    private String currentCoordinate;
    private ArrayList<String> canonicalPath;
    private String factorizedPath;
    private String reversedPath;

    public Position(String coordinate){
        currentCoordinate = coordinate;
        canonicalPath = new ArrayList<>();
    }
    
    // checked if reached the end of the maze
    public boolean reachedEnd(String endCoordinate){
        if (currentCoordinate.equals(endCoordinate)){
            return true;
        }
        return false; 
    }

    public void setCurrentCoordinate(String coordinate){
        currentCoordinate = coordinate;
    }
    public String getCurrentCoordinate(){
        return currentCoordinate;
    }

    public void addStepsToPath(List<String> stepsTaken){
        for (String step : stepsTaken){
            if (step.equals("FORWARD")){
                canonicalPath.add("F");
            }
            else if (step.equals("TURN RIGHT")){
                canonicalPath.add("R");
            }
            else if (step.equals("TURN LEFT")){
                canonicalPath.add("L");
            }
        }
    }
    public void makeFactorizedPath(){
        
    }
    public void printFactorizedPath(){
        
    }
    public void printCanonicalPath(){
        
        for (int i = 0; i < canonicalPath.size(); i++){
            System.out.print(canonicalPath.get(i));
        }
        System.out.println(); 
    }
    public void reversePath(){

    }
}
