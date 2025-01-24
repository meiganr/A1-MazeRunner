package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public abstract class Strategy {

    protected int currentXIndex;
    protected int currentYIndex;
    protected String stepTaken;

    protected Strategy(String coordinate){
        setCurrentXAndYIndex(coordinate);
        stepTaken = null;
    }

    protected void setCurrentXAndYIndex(String coordinate){
        currentXIndex = Integer.parseInt(coordinate.substring(0,1));
        currentYIndex = Integer.parseInt(coordinate.substring(2));
    }
   
    public int getCurrentXIndex(){
        return currentXIndex;
    }
    public int getCurrentYIndex(){
        return currentYIndex;
    }
    protected void setStepTaken(String stepTaken){
        this.stepTaken = stepTaken;
    }
    public String getStepTaken(){
        return stepTaken;
    }

    public abstract String decideNextMove(char[][] maze, String coordinate);

}

