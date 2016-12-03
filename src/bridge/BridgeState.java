package bridge;

import static bridge.Position.*;
import framework.State;
import graph.SimpleVertex;

/**
 * This class represents states of the Bridge Crossing problem.
 * It creates new bridge states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 * @author Phil Javinsky III
 */
public class BridgeState extends SimpleVertex implements State {

    /**
     * Creates a new bridge state.  
     * Besides storing the positions of the persons and flashlight, a
     * bridge state should also store the time taken to get to this state in
     * integer minutes.
     * @param p1Position position of the person who can cross in 1 minute
     * @param p2Position position of the person who can cross in 2 minutes
     * @param flashlightPosition position of the flashlight
     * @param p5Position position of the person who can cross in 5 minutes
     * @param p10Position  position of the person who can cross in 10 minutes
     * @param timeSoFar time taken so far
     */
    public BridgeState(Position p1Position, 
                       Position p2Position, 
                       Position flashlightPosition, 
                       Position p5Position, 
                       Position p10Position,
                       int timeSoFar) {
        p1Pos = p1Position;
        p2Pos = p2Position;
        flashlightPos = flashlightPosition;
        p5Pos = p5Position;
        p10Pos = p10Position;
        timeSF = timeSoFar;
    }
    
    /**
     * Compares this bridge state with another for equality.
     * Two bridge states are equal if the positions of the persons and 
     * flashlight in one state are matched by their positions in the other.
     * Note that the time taken to cross so far is not taken into account
     * when considering equality.
     * @param other the other bridge state to be compared with this one.
     * @return whether this state is equal to the other state
     */
    public boolean equals(Object other) {
        BridgeState state = (BridgeState) other;
        boolean equal = false;
        if (p1Pos == state.p1Pos
            && p2Pos == state.p2Pos
            && flashlightPos == state.flashlightPos
            && p5Pos == state.p5Pos
            && p10Pos == state.p10Pos) {
                equal = true;
        }
        return equal;
    }
    
    /**
     * Creates a string representation of this state for display to the user
     * trying to solve the problem.
     * Note that the time so far to cross is part of the string representation.
     * @return the string representation of this state
     */
    public String toString() {
        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        StringBuilder fl = new StringBuilder();
        StringBuilder p5 = new StringBuilder();
        StringBuilder p10 = new StringBuilder();
        StringBuilder time = new StringBuilder();
        
        if (p1Pos == WEST)
            p1.append("P1  |   |   \n");
        else if (p1Pos == EAST)
            p1.append("    |   | P1\n");
        
        if (p2Pos == WEST)
            p2.append("P2  |   |   \n");
        else if (p2Pos == EAST)
            p2.append("    |   | P2\n");
        
        if (flashlightPos == WEST)
            fl.append(" f  |===|   \n");
        else if (flashlightPos == EAST)
            fl.append("    |===| f \n");
        
        if (p5Pos == WEST)
            p5.append("P5  |   |   \n");
        else if (p5Pos == EAST)
            p5.append("    |   | P5\n");
        
        if (p10Pos == WEST)
            p10.append("P10 |   |  \n");
        else if (p10Pos == EAST)
            p10.append("    |   | P10\n");
        
        time.append("Time elapsed so far: ");
        time.append(timeSF);
        time.append(" minutes.\n");

        String result = (p1.toString()+p2.toString()+fl.toString()
                +p5.toString()+p10.toString()+time.toString());
	return result;
    }

    /**
     * Getter (accessor) for the position of the flashlight in this state.
     * @return the position of the flashlight
     */
    public Position getFlashlightPosition() {
        return flashlightPos;
    }

    /**
     * Getter (accessor) for the position of person P1 in this state.
     * @return the position of person P1
     */
    public Position getP1Position() {
        return p1Pos;
    }

    /**
     * Getter (accessor) for the position of person P2 in this state.
     * @return the position of person P2
     */
    public Position getP2Position() {
        return p2Pos;
    }

    /**
     * Getter (accessor) for the position of person P5 in this state.
     * @return the position of person P5
     */
    public Position getP5Position() {
        return p5Pos;
    }

    /**
     * Getter (accessor) for the position of person P10 in this state.
     * @return the position of person P10
     */
    public Position getP10Position() {
        return p10Pos;
    }

    /**
     * Getter (accessor) for the time taken to get to this state.
     * @return the time taken to get to this state
     */
    public int getTimeSoFar() {
        return timeSF; // You must provide
    }
    
    // Private methods and instance fields should go here
    private Position p1Pos, p2Pos, flashlightPos, p5Pos, p10Pos;
    private int timeSF;

    @Override
    public int getHeuristic(State goal) {
        return 0;
    }
    
}
