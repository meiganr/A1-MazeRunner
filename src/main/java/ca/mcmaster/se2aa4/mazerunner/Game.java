package ca.mcmaster.se2aa4.mazerunner;

// to run: java -jar target/mazerunner.jar -i ./examples/tiny.maz.txt

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.cli.*;

public class Game {

    private static final Logger logger = LogManager.getLogger();
 
    private Strategy strategy;
    private Maze maze;
    private String mazeName;
    private File mazeFile;
    private String nextCoordinate;
    private String currentCoordinate;
    private String inputPath; 

    public Game(String[] args, int strategyOption, String orientation){
        makeMaze(args, orientation);

        if (strategyOption == 1){
            strategy = new RightHandStrategy(maze.getMazeEntrance(), maze.getStartingDirection());
        }
        else if (strategyOption == 2){
            strategy = new StraightStrategy(maze.getMazeEntrance(), maze.getStartingDirection());
        }
        runMaze(); 

    }

    private void makeMaze(String[] args, String orientation){
        
        logger.info("** Starting Maze Runner\n");

          Options options = new Options();
          CommandLineParser parser = new DefaultParser();
          options.addOption("i", true, "the provided maze's path from file");
          options.addOption("p", true, "a path to be verified for the given maze file"); 

        try{
            CommandLine cmd = parser.parse(options, args);
            mazeName = cmd.getOptionValue("i"); 

            if (cmd.hasOption("p")){
                inputPath = cmd.getOptionValue("p"); 
            }
            else{
                inputPath = ""; 
            }
            
            logger.info("**** Reading the maze from file " + mazeName);
            System.out.println("Maze File: " + mazeName); 


            mazeFile = new File(mazeName);
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));

            // finding rows and cols in provided mazeFile to create Maze
            String line;
            int rows = 0;
            int cols = 0;

            // finding the number of rows and cols
            while ((line = reader.readLine()) != null) {
                rows++;
                cols = line.length();
            }

            logger.info("creating maze"); 
            logger.debug(rows); 
            logger.debug(cols);
            
            // create Maze object
            maze = new Maze(mazeFile, rows, cols, orientation);
            
            reader.close();
        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }

        logger.debug(maze.getEastCoordinate());
        logger.debug(maze.getWestCoordinate());
    }



    private void runMaze(){
        currentCoordinate = maze.getCurrentCoordinate();
        Direction currentDirection = maze.getStartingDirection(); 


        while (maze.reachedEndOfMaze() == false){
            nextCoordinate = strategy.decideNextMove(maze.getMaze(), currentCoordinate, currentDirection);

            if (nextCoordinate.equals(null)){
                // do nothing
            }
            else{
                maze.setNewCoordinates(nextCoordinate, strategy.getStepsTaken());
                strategy.emptyListOfSteps();
            }

            currentDirection = strategy.getCurrentDirection();
            currentCoordinate = maze.getCurrentCoordinate();

        }



        logger.info("**** Computing path");
        System.out.println("Printing paths");
        maze.printPaths();


        // verify that input path is legit
        if (inputPath.isEmpty() == false){
            maze.verifyInputPath(inputPath); 
        }
    
        
        logger.info("** End of MazeRunner");
    }


    public static void main(String[] args) {
        new Game(args,1, "east");
    
    }
}

