package ca.mcmaster.se2aa4.mazerunner;

public class EastToWest implements TraversalDirection{

    private String mazeEntrance;
    private String mazeExit;
    private Direction startingDirection;

    public EastToWest(String eastEntrance, String westExit){
        mazeEntrance = eastEntrance;
        mazeExit = westExit;
        startingDirection = Direction.EAST;
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
