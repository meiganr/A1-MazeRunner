package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

public class Position {

    private String currentCoordinate;
    private List<String> canonicalPath;
    private StringBuffer factorizedPath;

    public Position(String coordinate){
        currentCoordinate = coordinate;
        canonicalPath = new ArrayList<>();
        factorizedPath = new StringBuffer();
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
        int count = 1;
        int sizeOfPath = canonicalPath.size();

        for (int i = 1; i < sizeOfPath; i++){

            if (canonicalPath.get(i) == canonicalPath.get(i - 1)){
                count++;
            }
            else{ // add the factorized part to the factorized path
                if (count > 1){
                    factorizedPath.append(count + canonicalPath.get(i - 1) + " ");
                }
                else {
                    factorizedPath.append(canonicalPath.get(i - 1) + " ") ;
                }
                count = 1;
            }
        }

        if (count > 1)
            factorizedPath.append(count + canonicalPath.get(sizeOfPath - 1));
        else
            factorizedPath.append(canonicalPath.get(sizeOfPath - 1));
    }

    public void printFactorizedPath(){
        System.out.println(factorizedPath.toString());
    }
    
    public void printCanonicalPath(){
        
        for (int i = 0; i < canonicalPath.size(); i++){
            System.out.print(canonicalPath.get(i));
        }
        System.out.println(); 
    }
    
    public boolean isInputPathLegit(String inputPath){
        String pathAsString = ""; 
        for (int i = 0; i < canonicalPath.size(); i++){
            pathAsString += (canonicalPath.get(i));
        }

        if (pathAsString.contains(inputPath)){
            return true; 
        }
        else{
            return false; 
        }
    }
}
