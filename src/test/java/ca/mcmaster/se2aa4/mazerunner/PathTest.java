package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;


public class PathTest {
    @Test
    public void CanonicalPathForSmallMaze(){
        String[] args = {"-i", "examples/small.maz.txt"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedCanonicalPath = "FRFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLF"; 
        String actualCanonicalPath = lines[2].trim();

        assertEquals(expectedCanonicalPath, actualCanonicalPath);
    }

    @Test
    public void FactorizedPathForSmallMaze(){
        String[] args = {"-i", "examples/small.maz.txt"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedFactorizedPath = "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F"; 
        String actualFactorizedPath = lines[5].trim();
        
        assertEquals(expectedFactorizedPath, actualFactorizedPath);
    }

    @Test
    public void CanonicalPathForTinyMaze(){
        String[] args = {"-i", "examples/tiny.maz.txt"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedCanonicalPath = "FFFFFLLFFRFFRFFLLFFRFFRFFF"; 
        String actualCanonicalPath = lines[2].trim();
        
        assertEquals(expectedCanonicalPath, actualCanonicalPath);
    }
    @Test
    public void FactorizedPathForTinyMaze(){
        String[] args = {"-i", "examples/tiny.maz.txt"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedFactorizedPath = "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F"; 
        String actualFactorizedPath = lines[5].trim();
        
        assertEquals(expectedFactorizedPath, actualFactorizedPath);
    }

    @Test
    public void CanonicalPathForDirectMaze(){
        String[] args = {"-i", "examples/direct.maz.txt"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedCanonicalPath = "FRFFLFFFRFLFRFLFF"; 
        String actualCanonicalPath = lines[2].trim();

        assertEquals(expectedCanonicalPath, actualCanonicalPath);
    }

    @Test
    public void FactorizedPathForDirectMaze(){
        String[] args = {"-i", "examples/direct.maz.txt"};

       // Create stream to hold the output paths
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));
       PrintStream oldOut = System.out; // save the old System.out

       Game.main(args); 

       System.setOut(oldOut);
       String[] lines = out.toString().split("\\R");

        String expectedFactorizedPath = "F R 2F L 3F R F L F R F L 2F"; 
        String actualFactorizedPath = lines[5].trim();
        
        assertEquals(expectedFactorizedPath, actualFactorizedPath);
    }

    @Test
    public void ValidationPForTinyMaze(){
        String[] args = {"-i", "examples/tiny.maz.txt", "-p", "RFFF"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedValidation = "The path RFFF is accepted for examples/tiny.maz.txt"; 
        String actualValidation = lines[6].trim();
        
        assertEquals(expectedValidation, actualValidation);
    }
    @Test
    public void ValidationPForSmallMaze(){
        String[] args = {"-i", "examples/small.maz.txt", "-p", "FFRFFR"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedFactorizedPath = "The path FFRFFR is accepted for examples/small.maz.txt"; 
        String actualFactorizedPath = lines[6].trim();
        
        assertEquals(expectedFactorizedPath, actualFactorizedPath);
    }

    @Test
    public void InvalidationPForSmallMaze(){
        String[] args = {"-i", "examples/small.maz.txt", "-p", "LFL"};

        // Create stream to hold the output paths
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintStream oldOut = System.out; // save the old System.out

        Game.main(args); 

        System.setOut(oldOut);
        String[] lines = out.toString().split("\\R");

        String expectedFactorizedPath = "The path LFL is not accepted for examples/small.maz.txt"; 
        String actualFactorizedPath = lines[6].trim();
        
        assertEquals(expectedFactorizedPath, actualFactorizedPath);
    }




}
