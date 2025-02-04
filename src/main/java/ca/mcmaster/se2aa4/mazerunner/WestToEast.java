package ca.mcmaster.se2aa4.mazerunner;

public class WestToEast implements TraversalDirection{

    private String mazeEntrance;
    private String mazeExit;
    private Direction startingDirection;

    public WestToEast(String eastExit, String westEntrance){
        mazeEntrance = westEntrance;
        mazeExit = eastExit;
        startingDirection = Direction.WEST;
    }
    public String getMazeEntrance(){
        return mazeEntrance;
    }
    public Direction getStartingDirection(){
        return startingDirection;
    }
    public String getMazeExit(){
        return mazeExit;
    }
}
