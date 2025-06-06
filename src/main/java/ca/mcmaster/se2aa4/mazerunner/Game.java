package ca.mcmaster.se2aa4.mazerunner;
// example with tiny maze file
// to run: java -jar target/mazerunner.jar -i ./examples/tiny.maz.txt -p LL

import java.io.*;
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

    public Game(String[] args, StrategyType strategyOption, String orientation) throws Exception{
        makeMaze(args, orientation);
        StrategyFactory strategyFactory = new StrategyFactory(); 
        strategy = strategyFactory.getStrategy(strategyOption, maze.getMazeEntrance(), maze.getStartingDirection());

        runMaze(); 

    }

    private void makeMaze(String[] args, String orientation) throws Exception{
        
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

            // Check if no file was provided
            if (mazeName == null || mazeName.equals("")) {
                throw new IllegalArgumentException("Maze file path not provided.");
            }
            
            logger.info("**** Reading the maze from file " + mazeName);
            //System.out.println("Maze File: " + mazeName); 

            mazeFile = new File(mazeName);

            // check if the file does not exist
            if (!mazeFile.exists()){
                throw new FileNotFoundException("The maze file " + mazeName + " does not exist");
            }
            
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
            throw new Exception(e); 
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
        StrategyType strategyName = StrategyType.RIGHT_HAND;
        try{
            new Game(args,strategyName, "east");
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        
    
    }
}

