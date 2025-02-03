package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*; 



public class StraightStrategy extends Strategy {

    private static final Logger logger = LogManager.getLogger();

    
    public StraightStrategy(String coordinates){
        super(coordinates);

    }
    
    @Override
    public String decideNextMove(char[][] maze, String coordinate, Direction direction) {
        String nextCoordinate = null;

        int x = getCurrentXIndex();
        int y = getCurrentYIndex();

        if (maze[x][y + 1] == ' '){ // move forward

            nextCoordinate = x + "," + (y + 1);
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
        return nextCoordinate;

    }
}
