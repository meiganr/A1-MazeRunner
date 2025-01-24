package main.java.ca.mcmaster.se2aa4.mazerunner;

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
    private String entry;
    private String exit;
    private int rows;
    private int cols;


    public EntryAndExit(char[][] maze, int rows, int cols){
        this.maze = maze;
        this.rows = rows;
        this.cols = cols;
        findEntry();
        findExit();
    }

    private void findEntry(){
        for (int i = 0; i < rows; i++){
            if (maze[i][0] == ' '){
                entry = String.valueOf(i);
            }
        }
        entry = entry + ",0";
    }
    private void findExit(){
        for (int i = 0; i < rows; i++){
            if (maze[i][cols - 1] == ' '){
                exit = String.valueOf(i);
            }
        }
        exit = exit + "," + String.valueOf(cols - 1);
    }

    public String getEntry(){
        return entry;
    }
    public String getExit(){
        return exit;
    }


}
