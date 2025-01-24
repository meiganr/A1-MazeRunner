package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

import main.java.ca.mcmaster.se2aa4.mazerunner.EntryAndExit;

public class Maze {
    private File mazeFile;
    private char[][] maze;

    private String startPosition;
    private String endPosition;

    EntryAndExit entryAndExit;

 
    private static final Logger logger = LogManager.getLogger();

    public Maze(File mazeFile, int rows, int cols){
        this.mazeFile = mazeFile;
        maze = new char[rows][cols];
        createMaze();

        entryAndExit = new EntryAndExit(maze, rows, cols);
        setStartAndEndPosition();
    }

    private void setStartAndEndPosition(){
        startPosition = entryAndExit.getEntry();
        endPosition = entryAndExit.getExit();
    }
    public String getStartPosition(){
        return startPosition;
    }
    public String getEndPosition(){
        return endPosition;
    }

    private void createMaze(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));

            // populating the array
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    maze[row][idx] = line.charAt(idx);
                }
                row++;
            }
        } catch (IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }
    
    private void printMaze(){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze.length; j++){
                logger.debug(maze[i][j]);
            }
            logger.debug(' ');
        }
    }

    public boolean move(String position){
        return false; 
    }
    public boolean turn(String direction){
        return false; 

    }

}
