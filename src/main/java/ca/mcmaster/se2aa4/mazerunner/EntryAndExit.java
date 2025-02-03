package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class EntryAndExit {
    private char[][] maze;
    private String entryCoordinate;
    private String exitCoordinate;
    private int rows;
    private int cols;


    public EntryAndExit(char[][] maze, int rows, int cols){
        this.maze = maze;
        this.rows = rows;
        this.cols = cols;
        findEntryCoordinate();
        findExitCoordinate();
    }

    private void findEntryCoordinate(){
        for (int i = 0; i < rows; i++){
            if (maze[i][0] == ' '){
                entryCoordinate = String.valueOf(i);
            }
        }
        entryCoordinate = entryCoordinate + ",0";
    }
    private void findExitCoordinate(){
        for (int i = 0; i < rows; i++){
            if (maze[i][cols - 1] == ' '){
                exitCoordinate = String.valueOf(i);
            }
        }
        exitCoordinate = exitCoordinate + "," + String.valueOf(cols - 1);
    }

    public String getEntryCoordinate(){
        return entryCoordinate;
    }
    public String getExitCoordinate(){
        return exitCoordinate;
    }


}
