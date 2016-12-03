package waterjug;

import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Water Jug problem.
 * It provides an introductory message describing the problem,
 * stores the problem's possible moves and current state, and
 * checks for whether the problem has been successfully solved.
 * Note that this class extends the abstract class <b>Problem</b> and
 * therefore imports <b>framework.Problem</b>.
 * This class inherits the <b>setIntroduction(), setCurrentState()</b>, and
 * <b>setMoves()</b> methods from its parent
 * and thus it should not have any instance fields for these attributes.
 * @author your name here
 */
public class WaterJugProblem extends Problem {

    /**
     * Constructs a new water jug problem object.  A new water jug state object
     * should be constructed with zero gallons in both jugs.
     * This state should be set as the current state of the problem using
     * the inherited <b>setCurrentState()</b> method.
     * The six valid water jug moves should be created and stored on a list using
     * the inherited <b>setMoves()</b> method.
     * The appropriate introduction string for this problem should be stored
     * using the inherited <b>setIntroduction()</b>.
     */
    public WaterJugProblem() {
        finalState = new WaterJugState(2,4);
        setFinalState(finalState);
        currState = new WaterJugState(0,0);
        setCurrentState(currState);
        
        setUseChooser(false);
        
        WaterJugMove fillX = new WaterJugMove("Fill Jug X");
        WaterJugMove fillY = new WaterJugMove("Fill Jug Y");
        WaterJugMove emptyX = new WaterJugMove("Empty Jug X");
        WaterJugMove emptyY = new WaterJugMove("Empty Jug Y");
        WaterJugMove xToY = new WaterJugMove("Transfer Jug X to Jug Y");
        WaterJugMove yToX = new WaterJugMove("Transfer Jug Y to Jug X");
        
        moves.add(fillX);
        moves.add(fillY);
        moves.add(emptyX);
        moves.add(emptyY);
        moves.add(xToY);
        moves.add(yToX);
        
        setMoves(moves);
        
        intro = ("Welcome to the Water Jug Problem.\n\n"
                + "You are given two enpty jugs: jug X holds 3 gallons, jug Y holds 4.\n"
                + "Neither has any measuring markers on it. You have a ready supply\n"
                + "of water. You can fill either jug, empty either on the ground,\n"
                + "or pour all or some of either jug into the other. The goal is to\n"
                + "get exactly 2 gallons of water into either jug.\n");
        setIntroduction(intro);
    }

    /**
     * Returns whether the current state of this problem is a success.
     * Note that this method implements the abstract <b>success</b> method declared
     * in the parent.
     * Note also that the current state of the problem must be gotten using the
     * inherited <b>getCurrentState()</b> method.
     * Since that method returns a value of type <b>State</b>, it must be cast to
     * <b>WaterJugState</b> before processing.
     * The current state is a success if either jug has 2 gallons.
     * @return <b>true</b> if the current state is a success, <b>false</b> otherwise
     */
    public boolean success() {
	WaterJugState currentState = (WaterJugState)getCurrentState();
        
        boolean success = false;
        
        if (currentState.getXJugLevel() == 2 || currentState.getYJugLevel() == 2)
            success = true;
        
        return success;
    }
    
    // Private instance fields are not necessary since they are inherited.
    private WaterJugState currState, finalState;
    private List<Move> moves = new ArrayList<Move>();
    private String intro;
}
