package bridge;

import framework.Move;
import framework.State;
import static bridge.Position.*;

/**
 * This class represents moves in the Bridge Crossing problem.
 * A move object stores its move name and knows how to apply itself
 * to a bridge state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * @author Phil Javinsky III
 */
public class BridgeMove extends Move {

    /**
     * Constructs a new bridge move object.
     * Note that the move name is passed to the parent constructor
     * using <b>super</b>.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "P1 crosses alone" </li>
     * <li> "P2 crosses alone" </li>
     * <li> "P5 crosses alone" </li>
     * <li> "P10 crosses alone" </li>
     * <li> "P1 crosses with P2" </li>
     * <li> "P1 crosses with P5" </li>
     * <li> "P1 crosses with P10" </li>
     * <li> "P2 crosses with P5" </li>
     * <li> "P2 crosses with P10" </li>
     * <li> "P5 crosses with P10" </li>
     * </ul>
     */
    public BridgeMove(String moveName) {
        super(moveName);
        // You must provide the rest
    }
    
    /**
     * Attempts to perform this move on a given bridge state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>BridgeState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new bridge state object is returned that
     * reflects this move.
     * A move cannot be performed if the flashlight is not on the same side
     * as the crossing person(s), or if a pair of persons who are crossing are not
     * on the same side.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the bridge state on which this move is to be performed
     * @return a new bridge state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public State doMove(State otherState) {
        BridgeState state = (BridgeState) otherState;
        
        Position p1pos = state.getP1Position();
        Position p2pos = state.getP2Position();
        Position flpos = state.getFlashlightPosition();
        Position p5pos = state.getP5Position();
        Position p10pos = state.getP10Position();
        int time = state.getTimeSoFar();
        
        BridgeState newState = null;
        
        if (getMoveName().equals("P1 crosses alone")) {
            if (p1pos == flpos) {
                time += 1;
                newState = new BridgeState (changePos(p1pos), p2pos,
                        changePos(flpos), p5pos, p10pos, time);
            }
        }
        else if (getMoveName().equals("P2 crosses alone")){
            if (p2pos == flpos) {
                time += 2;
                newState = new BridgeState (p1pos, changePos(p2pos),
                        changePos(flpos), p5pos, p10pos, time);
            }
        }
        else if (getMoveName().equals("P5 crosses alone")){
            if (p5pos == flpos) {
                time += 5;
                newState = new BridgeState (p1pos, p2pos,
                        changePos(flpos), changePos(p5pos), p10pos, time);
            }
        }
        else if (getMoveName().equals("P10 crosses alone")){
            if (p10pos == flpos) {
                time += 10;
                newState = new BridgeState (p1pos, p2pos,
                        changePos(flpos), p5pos, changePos(p10pos), time);
            }
        }
        else if (getMoveName().equals("P1 crosses with P2")){
            if (p1pos == flpos && p2pos == flpos) {
                time += 2;
                newState = new BridgeState (changePos(p1pos), changePos(p2pos),
                        changePos(flpos), p5pos, p10pos, time);
            }
        }
        else if (getMoveName().equals("P1 crosses with P5")){
            if (p1pos == flpos && p5pos == flpos) {
                time += 5;
                newState = new BridgeState (changePos(p1pos), p2pos,
                        changePos(flpos), changePos(p5pos), p10pos, time);
            }
        }
        else if (getMoveName().equals("P1 crosses with P10")){
            if (p1pos == flpos && p10pos == flpos) {
                time += 10;
                newState = new BridgeState (changePos(p1pos), p2pos,
                        changePos(flpos), p5pos, changePos(p10pos), time);
            }
        }
        else if (getMoveName().equals("P2 crosses with P5")){
            if (p2pos == flpos && p5pos == flpos) {
                time += 5;
                newState = new BridgeState (p1pos, changePos(p2pos),
                        changePos(flpos), changePos(p5pos), p10pos, time);
            }
        }
        else if (getMoveName().equals("P2 crosses with P10")){
            if (p2pos == flpos && p10pos == flpos) {
                time += 10;
                newState = new BridgeState (p1pos, changePos(p2pos),
                        changePos(flpos), p5pos, changePos(p10pos), time);
            }
        }
        else if (getMoveName().equals("P5 crosses with P10")){
            if (p5pos == flpos && p10pos == flpos) {
                time += 10;
                newState = new BridgeState (p1pos, p2pos, changePos(flpos),
                        changePos(p5pos), changePos(p10pos), time);
            }
        }
        return newState;
    }
    
    // Private methods and instance fields should go here
    
    /**
     * This method changed the position of the variable received.
     * @param pos the position variable needing to be switched
     * @return the new position
     */
    private Position changePos(Position pos) {
        Position newPos = null;
        if (pos == WEST) {
            newPos = EAST;
        }
        else if (pos == EAST) {
            newPos = WEST;
        }
        return newPos;
    }
}
