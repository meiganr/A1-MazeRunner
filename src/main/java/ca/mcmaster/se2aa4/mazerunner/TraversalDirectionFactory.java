package ca.mcmaster.se2aa4.mazerunner;

public class TraversalDirectionFactory {
    public TraversalDirection getTraversalDirection(String orientation, String eastCoordinate, String westCoordinate){

        if (orientation.equalsIgnoreCase("east")){
            return new EastToWest(eastCoordinate, westCoordinate);
        }
        else{
            return new WestToEast(eastCoordinate, westCoordinate);
        }
    }
}
