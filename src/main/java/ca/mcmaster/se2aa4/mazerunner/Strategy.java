package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public abstract class Strategy {

    protected int currentXIndex;
    protected int currentYIndex;
    protected List<String> stepsTaken;
    protected Direction direction;

    protected String nextCoordinate;

    protected Strategy(String coordinate, Direction startingDirection){
        setCurrentXAndYIndex(coordinate);
        stepsTaken = new ArrayList<>();
        direction = startingDirection;
        nextCoordinate = null; 
    }

    protected Direction getCurrentDirection(){
        return direction;
    }

    protected void setCurrentXAndYIndex(String coordinate){
        String[] xAndY = coordinate.split(",");
        currentXIndex = Integer.parseInt(xAndY[0]);
        currentYIndex = Integer.parseInt(xAndY[1]);
    }
   
    public int getCurrentXIndex(){
        return currentXIndex;
    }
    public int getCurrentYIndex(){
        return currentYIndex;
    }
    protected void setStepTaken(String stepTaken){
        this.stepsTaken.add(stepTaken);
    }
    public void emptyListOfSteps(){
        stepsTaken.clear();
    }
    public List<String> getStepsTaken(){
        return stepsTaken;
    }

    // Template method
    public String decideNextMove(char[][] maze, String coordinate, Direction direction){
        this.direction = direction; // sets the direction

        int x = getCurrentXIndex();
        int y = getCurrentYIndex();

        if (this.direction == Direction.EAST){
            movePointingEast(maze, x, y);
        }
        else if (this.direction == Direction.NORTH){
            movePointingNorth(maze, x, y);
        }
        else if (this.direction == Direction.SOUTH){
            movePointingSouth(maze, x, y);
        }
        else{ // if direction is West
            movePointingWest(maze, x, y);
        }

        return nextCoordinate;

    }

    protected void updateNextCoordinate(String nextCoordinate){
        this.nextCoordinate = nextCoordinate;
    }

    protected abstract void movePointingEast(char[][] maze, int x, int y);
    protected abstract void movePointingNorth(char[][] maze, int x, int y);
    protected abstract void movePointingSouth(char[][] maze, int x, int y);
    protected abstract void movePointingWest(char[][] maze, int x, int y);


}

