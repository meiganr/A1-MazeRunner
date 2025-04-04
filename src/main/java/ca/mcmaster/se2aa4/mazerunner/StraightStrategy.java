package ca.mcmaster.se2aa4.mazerunner;

public class StraightStrategy extends Strategy {

    public StraightStrategy(String coordinates, Direction startingDirection){
        super(coordinates, startingDirection);
    }

    protected void movePointingEast(char[][] maze, int x, int y){
        if (maze[x][y + 1] == ' '){ // move forward

            nextCoordinate = x + "," + (y + 1);
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
    }
    protected void movePointingNorth(char[][] maze, int x, int y){
        // do nothing
    }
    protected void movePointingSouth(char[][] maze, int x, int y){
        // do nothing
    }

    protected void movePointingWest(char[][] maze, int x, int y){
        if (maze[x][y - 1] == ' '){ // move forward

            nextCoordinate = x + "," + (y - 1);
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
    }
}
