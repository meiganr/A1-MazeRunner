package ca.mcmaster.se2aa4.mazerunner;

public class EntryAndExit {
    private char[][] maze;
    private String eastCoordinate;
    private String westCoordinate;
    private int rows;
    private int cols;


    public EntryAndExit(char[][] maze, int rows, int cols){
        this.maze = maze;
        this.rows = rows;
        this.cols = cols;
        findEntryCoordinate();
        findExitCoordinate();
    }

    private void findEntryCoordinate(){
        for (int i = 0; i < rows; i++){
            if (maze[i][0] == ' '){
                eastCoordinate = String.valueOf(i);
            }
        }
        eastCoordinate = eastCoordinate + ",0";
    }
    private void findExitCoordinate(){
        for (int i = 0; i < rows; i++){
            if (maze[i][cols - 1] == ' '){
                westCoordinate = String.valueOf(i);
            }
        }
        westCoordinate = westCoordinate + "," + String.valueOf(cols - 1);
    }

    public String getEastCoordinate(){
        return eastCoordinate;
    }
    public String getWestCoordinate(){
        return westCoordinate;
    }

}
