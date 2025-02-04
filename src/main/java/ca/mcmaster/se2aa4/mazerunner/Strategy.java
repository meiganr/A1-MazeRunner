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
    public abstract String decideNextMove(char[][] maze, String coordinate, Direction direction);

}

