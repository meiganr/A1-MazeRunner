package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Strategy;

import org.apache.commons.cli.*;

public class Game {

    private static final Logger logger = LogManager.getLogger();

    //String mazeFile; 
    private Strategy strategy; 
    private Maze maze; 
    private String mazeFile; 

    public Game(int strategyOption, String mazeFile, int rows, int cols){
        if (strategyOption == 1){
            strategy = new Strategy(); //TODO change to specific strategy
        }

        this.mazeFile = mazeFile; 
        maze = new Maze(mazeFile, rows, cols); 
    }








    

    public static void main(String[] args) {
    
        //System.out.println("** Starting Maze Runner");
        logger.info("** Starting Maze Runner\n");

        Options options = new Options();
        options.addOption("i", true, "the provided maze's path from file");

        CommandLineParser parser = new DefaultParser();


        try {
            CommandLine cmd = parser.parse(options, args);
            String mazeFile = cmd.getOptionValue("i"); 

            logger.info("**** Reading the maze from file " + mazeFile);
            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));


            String line;
            int rows = 0; 
            int cols = 0;

            while ((line = reader.readLine()) != null) {
                rows++; 
            }
            cols = line.length(); 


            new Game(0, mazeFile, rows, cols); 


        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
        logger.info("**** Computing path\n");
        logger.info("PATH NOT COMPUTED\n");
        logger.info("** End of MazeRunner\n");
    }
}
