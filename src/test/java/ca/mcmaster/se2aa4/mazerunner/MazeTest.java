package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;


class MazeTest {
    @Test
    void testSmallMazeEastEntrance(){
        File mazeFile = new File("examples/small.maz.txt"); 
        int rows = 11; 
        int cols = 11; 
        Maze maze = new Maze(mazeFile,rows, cols, "east");
       
        String eastFacingMazeCoordinate = "8,0"; 
        String actualEastFacingMazeCoordinate = maze.getMazeEntrance();

        assertEquals(eastFacingMazeCoordinate, actualEastFacingMazeCoordinate);
    }

    @Test
    void testTinyMazeWestEntrance(){
        File mazeFile = new File("examples/tiny.maz.txt"); 
        int rows = 7; 
        int cols = 7; 
        Maze maze = new Maze(mazeFile,rows, cols, "west");
       
        String westFacingMazeCoordinate = "1,6"; 
        String actualWestFacingMazeCoordinate = maze.getMazeEntrance();
        

        assertEquals(westFacingMazeCoordinate, actualWestFacingMazeCoordinate);
    }

    @Test
    void testMazeLayout(){

        File mazeFile = new File("examples/tiny.maz.txt");
        int rows = 7; 
        int cols = 7; 
        Maze maze = new Maze(mazeFile,rows, cols, "east");
       
        char[][] expectedMazeLayout = {
            {'#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' '},
            {'#','#','#',' ','#','#','#'},
            {'#',' ',' ',' ',' ',' ','#'},
            {'#','#','#',' ','#','#','#'},
            {' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#'}};

        char[][] actualMazeLayout = maze.getMaze(); 

        assertArrayEquals(expectedMazeLayout, actualMazeLayout);
    }


    @Test
    void testRHS_TurningRightNextCoordinate(){
        char[][] maze = {
            {'#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' '},
            {'#','#','#',' ','#','#','#'},
            {'#',' ',' ',' ',' ',' ','#'},
            {'#','#','#',' ','#','#','#'},
            {' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#'}};

            String coordinate = "5,3";
            Direction direction = Direction.WEST; 

            RightHandStrategy rhs = new RightHandStrategy(coordinate, direction);

            String actualNextCoordinate = rhs.decideNextMove(maze, coordinate, direction); 
            String expectedNextCoordinate = "4,3"; 

            assertEquals(expectedNextCoordinate, actualNextCoordinate);

    }

    @Test
    void testRHS_TurningLeftFromEastDirection(){
        char[][] maze = {
            {'#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' '},
            {'#','#','#',' ','#','#','#'},
            {'#',' ',' ',' ',' ',' ','#'},
            {'#','#','#',' ','#','#','#'},
            {' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#'}};

            String coordinate = "5,5";
            Direction direction = Direction.EAST; 

            RightHandStrategy rhs = new RightHandStrategy(coordinate, direction);
            rhs.decideNextMove(maze, coordinate, direction); 

            String actualNextDirection = rhs.getCurrentDirection().toString();
            String expectedNextDirection = Direction.NORTH.toString();

            assertEquals(expectedNextDirection, actualNextDirection);
    }

    @Test
    void testRHS_TurningRightFromNorthDirection(){
        char[][] maze = {
            {'#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' '},
            {'#','#','#',' ','#','#','#'},
            {'#',' ',' ',' ',' ',' ','#'},
            {'#','#','#',' ','#','#','#'},
            {' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#'}};

            String coordinate = "3,3";
            Direction direction = Direction.NORTH; 

            RightHandStrategy rhs = new RightHandStrategy(coordinate, direction);
            rhs.decideNextMove(maze, coordinate, direction); 

            String actualNextDirection = rhs.getCurrentDirection().toString();
            String expectedNextDirection = Direction.EAST.toString(); 
            

            assertEquals(expectedNextDirection, actualNextDirection);
    }


    @Test
    void testRHS_MoveStraightNextCoordinate(){
        char[][] maze = {
            {'#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' '},
            {'#','#','#',' ','#','#','#'},
            {'#',' ',' ',' ',' ',' ','#'},
            {'#','#','#',' ','#','#','#'},
            {' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#'}};

            String coordinate = "4,3";
            Direction direction = Direction.NORTH; 

            RightHandStrategy rhs = new RightHandStrategy(coordinate, direction);

            String actualNextCoordinate = rhs.decideNextMove(maze, coordinate, direction); 
            String expectedNextCoordinate = "3,3"; 

            assertEquals(expectedNextCoordinate, actualNextCoordinate);
    }

}