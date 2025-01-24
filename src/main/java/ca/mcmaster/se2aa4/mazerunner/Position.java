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

    private String currentCoordinate;
    private ArrayList<String> canonicalPath;
    private String factorizedPath;
    private String reversedPath;

    public Position(String coordinate){
        
    }
    
    public boolean reachedEnd(String endCoordinate){
        return false; 
    }
    public void setCurrentCoordinate(String coordinate){
        currentCoordinate = coordinate;
    }
    public String getCurrentCoordinate(){
        return currentCoordinate;
    }

    public void addStepToPath(String stepTaken){
        
    }
    public void makeFactorizedPath(){
        
    }
    public void printFactorizedPath(){
        
    }
    public void printCanonicalPath(){
        
    }
    public void reversePath(){

    }
}
