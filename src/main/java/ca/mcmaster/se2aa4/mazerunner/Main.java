package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

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
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.trace("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.trace("PASS ");
                    }
                }
                logger.trace(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
        logger.info("**** Computing path\n");
        logger.info("PATH NOT COMPUTED\n");
        logger.info("** End of MazeRunner\n");
    }
}
