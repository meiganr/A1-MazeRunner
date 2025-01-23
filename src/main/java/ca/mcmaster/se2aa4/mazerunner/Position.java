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

    private String currentPos;
    private ArrayList<String> canonicalPath;
    private String factorizedPath; 
    
    
    public boolean reachedEnd(){
        return false; 
    }
    public void setCurrentPos(String pos){
        
    }
    public String getCurrentPos(){
        return null; 
    }
    public void makeFactorizedPath(){
        
    }
    public void printFactorizedPath(){
        
    }
    public void printCanonicalPath(){
        
    }
}
