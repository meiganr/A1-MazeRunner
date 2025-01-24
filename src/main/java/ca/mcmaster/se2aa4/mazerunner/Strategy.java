package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public abstract class Strategy {

    private int currentXIndex;
    private int currentYIndex;

    protected Strategy(int currentXIndex, int currentYIndex){
        this.currentXIndex = currentXIndex;
        this.currentYIndex = currentYIndex;
    }
    protected void setCurrentXIndex(int newPos){
        currentXIndex = newPos;
    }
    protected void setCurrentYIndex(int newPos){
        currentYIndex = newPos;
    }
    public int getCurrentXIndex(){
        return currentXIndex;
    }
    public int getCurrentYIndex(){
        return currentYIndex;
    }

    public abstract String decideNext(char[][] maze, String position);

}

