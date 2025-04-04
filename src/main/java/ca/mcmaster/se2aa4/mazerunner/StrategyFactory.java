package ca.mcmaster.se2aa4.mazerunner;

public class StrategyFactory {
    
    public Strategy getStrategy(StrategyType strategyName, String mazeEntrance, Direction startingDirection){

        if (strategyName == StrategyType.RIGHT_HAND){
            return new RightHandStrategy(mazeEntrance, startingDirection);
        }
        else if (strategyName == StrategyType.STRAIGHT){
            return new StraightStrategy(mazeEntrance, startingDirection);
        }
        else{ // default strategy
            return new RightHandStrategy(mazeEntrance, startingDirection); 
        }
    }
}
