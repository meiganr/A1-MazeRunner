package ca.mcmaster.se2aa4.mazerunner;

public class RightHandStrategy extends Strategy{

    public RightHandStrategy(String coordinates, Direction startingDirection){
        super(coordinates, startingDirection);
    }

    @Override
    protected void movePointingWest(char[][] maze, int x, int y){
        if (maze[x - 1][y] == '#'){ // if there is wall on right
            if (maze[x][y - 1] == ' ') {// if no wall in front
                // move forward
                nextCoordinate = x + "," + (y - 1);
                setCurrentXAndYIndex(nextCoordinate);
                setStepTaken("FORWARD");
            }
            else{ // if there is wall in front
                // rotate left
                direction = Direction.SOUTH;
                setStepTaken("TURN LEFT");
            }
        }
        else{ // no wall on right
            // rotate right
            direction = Direction.NORTH;
            setStepTaken("TURN RIGHT");
            // move forward
            nextCoordinate = (x-1) + "," + y;
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
        updateNextCoordinate(nextCoordinate);
    }

    @Override
    protected void movePointingSouth(char[][] maze, int x, int y){
        if (maze[x][y - 1] == '#'){ // if there is wall on right
            if (maze[x+1][y] == ' ') {// if no wall in front
                // move forward
                nextCoordinate = (x + 1) + "," + y;
                setCurrentXAndYIndex(nextCoordinate);
                setStepTaken("FORWARD");
            }
            else{ // if there is wall in front
                // rotate left
                direction = Direction.EAST;
                setStepTaken("TURN LEFT");
            }
        }
        else{ // no wall on right
            // rotate right
            direction = Direction.WEST;
            setStepTaken("TURN RIGHT");
            // move forward
            nextCoordinate = x + "," + (y - 1);
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
        updateNextCoordinate(nextCoordinate);
    }

    @Override
    protected void movePointingNorth(char[][] maze, int x, int y){
        if (maze[x][y + 1] == '#'){ // if there is wall on right
            if (maze[x-1][y] == ' ') {// if no wall in front
                // move forward
                nextCoordinate = (x - 1) + "," + y;
                setCurrentXAndYIndex(nextCoordinate);
                setStepTaken("FORWARD");
            }
            else{ // if there is wall in front
                // rotate left
                direction = Direction.WEST;
                setStepTaken("TURN LEFT");
            }
        }
        else{ // no wall on right
            // rotate right
            direction = Direction.EAST;
            setStepTaken("TURN RIGHT");
            // move forward
            nextCoordinate = x + "," + (y + 1);
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
        updateNextCoordinate(nextCoordinate);
    }

    @Override
    protected void movePointingEast(char[][] maze, int x, int y){
        if (maze[x + 1][y] == '#'){ // if there is a wall on the right

            if (maze[x][y + 1] == ' '){ // if there is no wall in front
                // move forwards
                nextCoordinate = x + "," + (y + 1);
                setCurrentXAndYIndex(nextCoordinate);
                setStepTaken("FORWARD");
            }
            else{ // if there is wall in front (cannot move forwards)
                // rotate left
                direction = Direction.NORTH;
                setStepTaken("TURN LEFT");
            }
        }
        else{ // if there is no wall on right
            // rotate right
            direction = Direction.SOUTH;
            setStepTaken("TURN RIGHT");
            // move forward
            nextCoordinate = (x + 1) + "," + y;
            setCurrentXAndYIndex(nextCoordinate);
            setStepTaken("FORWARD");
        }
        updateNextCoordinate(nextCoordinate);
    }
}

