package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Strategy {

    private String currentX; 
    private String currentY; 

    public Strategy(){
        currentX = "0"; 
        currentY = "0"; 
    }

    public String decideNext(char[][] maze, String position){

        return null; 

    }

    
}
