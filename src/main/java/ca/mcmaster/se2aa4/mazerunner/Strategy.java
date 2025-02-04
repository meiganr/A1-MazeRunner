package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public abstract class Strategy {

   protected int currentXIndex;
    protected int currentYIndex;
    protected List<String> stepsTaken;
    protected Direction direction;

    protected Strategy(String coordinate, Direction startingDirection){
        setCurrentXAndYIndex(coordinate);
        stepsTaken = new ArrayList<>();
        direction = startingDirection;
    }

    // // MOVE ENUM
    // public enum Direction {
    //     NORTH, SOUTH, EAST, WEST;
    // }

    protected Direction getCurrentDirection(){
        return direction;
    }

    protected void setCurrentXAndYIndex(String coordinate){
        currentXIndex = Integer.parseInt(coordinate.substring(0,1));
        currentYIndex = Integer.parseInt(coordinate.substring(2));
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
    public abstract String decideNextMove(char[][] maze, String coordinate, Direction direction);

}

