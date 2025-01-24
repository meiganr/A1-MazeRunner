package ca.mcmaster.se2aa4.mazerunner;

// to run: java -jar target/mazerunner.jar -i ./examples/straight.maz.txt

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Strategy;
import main.java.ca.mcmaster.se2aa4.mazerunner.Position;
import main.java.ca.mcmaster.se2aa4.mazerunner.StraightStrategy;

import org.apache.commons.cli.*;

public class Game {

    private static final Logger logger = LogManager.getLogger();
 
    private Strategy strategy;
    private Maze maze;
    private String mazeName;
    private File mazeFile;
    private Position position;

    public Game(String[] args, int strategyOption){
        makeMaze(args);

        if (strategyOption == 1){
            strategy = new StraightStrategy(maze.getStartCoordinate());
        }
                
        position = new Position(maze.getStartCoordinate());
    }

    private void makeMaze(String[] args){
        logger.info("** Starting Maze Runner\n");

          Options options = new Options();
          CommandLineParser parser = new DefaultParser();
          options.addOption("i", true, "the provided maze's path from file");

        try{
            CommandLine cmd = parser.parse(options, args);
            mazeName = cmd.getOptionValue("i"); 
            logger.info("**** Reading the maze from file " + mazeName);


            mazeFile = new File(mazeName);
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));

            // finding rows and cols in provided mazeFile to create Maze
            String line;
            int rows = 0;
            int cols = 0;

            while ((line = reader.readLine()) != null) {
                rows++;
                cols = line.length();
            }

            logger.info("creating maze"); 
            logger.debug(rows); 
            logger.debug(cols);
            
            // create Maze object
            maze = new Maze(mazeFile, rows, cols);
            

        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }

        logger.debug(maze.getStartCoordinate());
        logger.debug(maze.getEndCoordinate());
    }



    public void runMaze(){

        String nextCoordinate;

        while (position.reachedEnd(maze.getEndCoordinate()) == false){
            nextCoordinate = strategy.decideNextMove(maze.getMaze(), position.getCurrentCoordinate());

            if (nextCoordinate.equals(null)){

            }
            else{
                position.setCurrentCoordinate(nextCoordinate); // set as new current coordinate
                position.addStepToPath(strategy.getStepTaken());
            }
        }

        logger.info("**** Computing path\n");
        position.printCanonicalPath();
        
        logger.debug("PATH NOT COMPUTED\n");
        logger.info("** End of MazeRunner\n");
    }


    public static void main(String[] args) {
        Game g = new Game(args,1);
        g.runMaze();
    
    }
}
