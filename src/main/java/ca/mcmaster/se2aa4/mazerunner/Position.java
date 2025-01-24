package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
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

    public void addStepToPath(String stepTaken){
         if (stepTaken.equals("FORWARD")){
            canonicalPath.add("F");
        }
        else if (stepTaken.equals("TURN RIGHT")){
            canonicalPath.add("R");
        }
        else if (stepTaken.equals("TURN LEFT")){
            canonicalPath.add("L");
        }
    }
    public void makeFactorizedPath(){
        
    }
    public void printFactorizedPath(){
        
    }
    public void printCanonicalPath(){
        
        for (int i = 0; i < canonicalPath.size(); i++){
            logger.info(canonicalPath.get(i));
        }
    }
    public void reversePath(){

    }
}
