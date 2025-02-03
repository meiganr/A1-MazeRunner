package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

 //import main.java.ca.mcmaster.se2aa4.mazerunner.EntryAndExit;

public class Maze {
    private File mazeFile;
    private char[][] maze;

    private String startCoordinate;
    private String endCoordinate;

    EntryAndExit entryAndExit;

    private Position position;
 
    private static final Logger logger = LogManager.getLogger();

    public Maze(File mazeFile, int rows, int cols){
        this.mazeFile = mazeFile;
        maze = new char[rows][cols];
        createMaze();

        entryAndExit = new EntryAndExit(maze, rows, cols);
        setStartAndEndCoordinates();
        position = new Position(getStartCoordinate());
    }

    private void setStartAndEndCoordinates(){
        startCoordinate = entryAndExit.getEntryCoordinate();
        endCoordinate = entryAndExit.getExitCoordinate();
    }

    public String getStartCoordinate(){
        return startCoordinate;
    }
    
    public String getEndCoordinate(){
        return endCoordinate;
    }
    public String getCurrentCoordinate(){
        return position.getCurrentCoordinate();
    }

    public char[][] getMaze(){
        return maze;
    }

    public boolean reachedEndOfMaze(){
        boolean reachedEnd = position.reachedEnd(getEndCoordinate());
        return reachedEnd;
    }

    public void setNewCoordinates(String nextCoordinate, String stepTaken){
        position.setCurrentCoordinate(nextCoordinate); // set as new current coordinate
        position.addStepToPath(stepTaken);
    }

    public void printPaths(){
        System.out.println("Printing canonical path");
        position.printCanonicalPath();
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
            reader.close();
        } catch (IOException e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        printMaze(); 
    }
    
    private void printMaze(){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze.length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println(' ');
        }
    }
}
