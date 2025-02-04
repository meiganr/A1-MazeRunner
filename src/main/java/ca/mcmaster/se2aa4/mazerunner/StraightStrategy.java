package ca.mcmaster.se2aa4.mazerunner;

public class StraightStrategy extends Strategy {


    
    public StraightStrategy(String coordinates, Direction startingDirection){
        super(coordinates, startingDirection);
    }
    
    @Override
    public String decideNextMove(char[][] maze, String coordinate, Direction direction) {
        String nextCoordinate = null;

        int x = getCurrentXIndex();
        int y = getCurrentYIndex();

        if (maze[x][y + 1] == ' '){ // move forward

            nextCoordinate = x + "," + (y + 1);
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
        return nextCoordinate;

    }
}
