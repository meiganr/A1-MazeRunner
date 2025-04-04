package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.*; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private File mazeFile;
    private char[][] maze;

    private String eastCoordinate;
    private String westCoordinate;
    private Position position;

    EntryAndExit entryAndExit;
    TraversalDirection traversalDirection;

 
    private static final Logger logger = LogManager.getLogger();

    public Maze(File mazeFile, int rows, int cols, String orientation) {
        this.mazeFile = mazeFile;
        maze = new char[rows][cols];
        createMaze();
        entryAndExit = new EntryAndExit(maze, rows, cols);
        setEastAndWestCoordinates();

        if (orientation.equals("east")){
            traversalDirection = new EastToWest(getEastCoordinate(), getWestCoordinate());
        }
        else {
            traversalDirection = new WestToEast(getEastCoordinate(), getWestCoordinate());
        }

        position = new Position(traversalDirection.getMazeEntrance());

    }
    public String getMazeEntrance(){
        return traversalDirection.getMazeEntrance();
    }

    private void setEastAndWestCoordinates(){
        eastCoordinate = entryAndExit.getEastCoordinate();
        westCoordinate = entryAndExit.getWestCoordinate();
    }

    public String getEastCoordinate(){
        return eastCoordinate;
    }
    public String getWestCoordinate(){
        return westCoordinate;
    }

    public String getCurrentCoordinate(){
        return position.getCurrentCoordinate();
    }
    public Direction getStartingDirection(){
        return traversalDirection.getStartingDirection();
    }

    public char[][] getMaze(){
        return maze;
    }

    public boolean reachedEndOfMaze(){
        boolean reachedEnd = position.reachedEnd(traversalDirection.getMazeExit());
        return reachedEnd;
    }

    public void setNewCoordinates(String nextCoordinate, List<String> stepsTaken){
        position.setCurrentCoordinate(nextCoordinate); // set as new current coordinate
        position.addStepsToPath(stepsTaken);
    }

    public void printPaths(){
        System.out.println("Printing canonical path");
        position.printCanonicalPath();
        System.out.println("\nPrinting factorized path");
        position.makeFactorizedPath();
        position.printFactorizedPath();
    }
    public void verifyInputPath(String inputPath){
        boolean legitInputPath = position.isInputPathLegit(inputPath); 

        if (legitInputPath){
            System.out.println("The path " + inputPath + " is accepted for " + mazeFile);
        }
        else{
            System.out.println("The path " + inputPath + " is not accepted for " + mazeFile);
        }

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
        //System.out.println("The Maze:"); 
        //printMaze(); 
    }
    
    private void printMaze(){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze.length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println(' ');
        }
        System.out.println();
    }
}
