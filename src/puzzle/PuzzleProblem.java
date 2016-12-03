
package puzzle;

import framework.Canvas;
import framework.Move;
import framework.Problem;
import framework.State;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the 8-Puzzle problem.
 * It provides an introductory message describing the problem,
 * stores the problem's possible moves and current state, and
 * checks for whether the problem has been successfully solved.
 * Note that this class extends the abstract class <b>Problem</b> and
 * therefore imports <b>framework.Problem</b>.
 * This class inherits the <b>setIntroduction(), setCurrentState()</b>, and
 * <b>setMoves()</b> methods from its parent
 * and thus it should not have any instance fields for these attributes.
 * @author Phil Javinsky III
 */
public class PuzzleProblem extends Problem {
    
    private PuzzleState currState, finalState;
    private List<Move> moves = new ArrayList<Move>();
    private String intro;
    
    public PuzzleProblem() {
        finalState = new PuzzleState(1,2,3,6,9,8,7,4);
        setFinalState(finalState);
        currState = new PuzzleState(4,1,3,6,9,5,7,2);
        setCurrentState(currState);
        
        setUseChooser(true);
        
        PuzzleMove slide1 = new PuzzleMove("Slide Tile 1");
        PuzzleMove slide2 = new PuzzleMove("Slide Tile 2");
        PuzzleMove slide3 = new PuzzleMove("Slide Tile 3");
        PuzzleMove slide4 = new PuzzleMove("Slide Tile 4");
        PuzzleMove slide5 = new PuzzleMove("Slide Tile 5");
        PuzzleMove slide6 = new PuzzleMove("Slide Tile 6");
        PuzzleMove slide7 = new PuzzleMove("Slide Tile 7");
        PuzzleMove slide8 = new PuzzleMove("Slide Tile 8");
        
        moves.add(slide1);
        moves.add(slide2);
        moves.add(slide3);
        moves.add(slide4);
        moves.add(slide5);
        moves.add(slide6);
        moves.add(slide7);
        moves.add(slide8);
        
        setMoves(moves);
        
        intro = "Welcome to the 8-Puzzle Problem\n\n"
                + "You are given a 3x3 board in which 8 numbered tiles can slide around.\n"
                + "There is one blank space that holds no tile. A legal move consists\n"
                + "of sliding a tile into the blank space if the tile is adjacent to it.\n"
                + "The goal is to move tiles around until the board looks like the final\n"
                + "state below.\n"
                + "                    +---+---+---+\n"
                + "                    | 1 | 2 | 3 |\n"
                + "                    +---+---+---+\n"
                + "                    | 8 |   | 4 |\n"
                + "                    +---+---+---+\n"
                + "                    | 7 | 6 | 5 |\n"
                + "                    +---+---+---+\n";
        setIntroduction(intro);
        
        PuzzleState start1 = new PuzzleState(4,1,3,6,9,5,7,2);
        PuzzleState start2 = new PuzzleState(4,6,1,3,9,2,8,7);
        PuzzleState start3 = new PuzzleState(4,8,1,3,6,5,9,7);
        PuzzleState start4 = new PuzzleState(2,1,3,6,9,7,8,4);
        PuzzleState start5 = new PuzzleState(9,2,5,1,8,6,7,4);
        PuzzleState start6 = new PuzzleState(1,8,3,4,9,2,7,6);
        PuzzleState start7 = new PuzzleState(9,2,7,6,1,8,3,4);
        PuzzleState start8 = new PuzzleState(9,8,7,4,1,2,3,6);

        List<State> initialStates = new ArrayList<State>();
        List<State> finalStates = new ArrayList<State>();
        List<Integer> moveCounts = new ArrayList<Integer>();

        initialStates.add(start1);    finalStates.add(finalState); moveCounts.add(5);
        initialStates.add(start2);    finalStates.add(finalState); moveCounts.add(10);
        initialStates.add(start3);    finalStates.add(finalState); moveCounts.add(13);
        initialStates.add(start4);    finalStates.add(finalState); moveCounts.add(18);
        initialStates.add(start5);    finalStates.add(finalState); moveCounts.add(20);
        initialStates.add(start6);    finalStates.add(finalState); moveCounts.add(24);
        initialStates.add(start7);    finalStates.add(finalState); moveCounts.add(30);
        initialStates.add(start8);    finalStates.add(finalState); moveCounts.add(30);

        setInitialStates(initialStates);
        setFinalStates(finalStates);
        setMoveCounts(moveCounts);
        
        List<Canvas> initialCanvases = new ArrayList<Canvas>();
        List<Canvas> finalCanvases = new ArrayList<Canvas>();

        initialCanvases.add(new PuzzleCanvasIcon(start1));
        initialCanvases.add(new PuzzleCanvasIcon(start2));
        initialCanvases.add(new PuzzleCanvasIcon(start3));
        initialCanvases.add(new PuzzleCanvasIcon(start4));
        initialCanvases.add(new PuzzleCanvasIcon(start5));
        initialCanvases.add(new PuzzleCanvasIcon(start6));
        initialCanvases.add(new PuzzleCanvasIcon(start7));
        initialCanvases.add(new PuzzleCanvasIcon(start8));

        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));
        finalCanvases.add(new PuzzleCanvasIcon(finalState));

        setInitialCanvases(initialCanvases);
        setFinalCanvases(finalCanvases);
    }
    
    /**
     * Returns whether the current state of this problem is a success.
     * Note that this method implements the abstract <b>success</b> method declared
     * in the parent.
     * Note also that the current state of the problem must be gotten using the
     * inherited <b>getCurrentState()</b> method.
     * Since that method returns a value of type <b>State</b>, it must be cast to
     * <b>PuzzleState</b> before processing.
     * The current state is a success if P1, P2, P5, and P10 are all on the
     * east side of the bridge and the time taken to cross is less than 18 minutes.
     * @return <b>true</b> if the current state is a success, <b>false</b> otherwise
     */
    public boolean success() {
        PuzzleState currentState = (PuzzleState) getCurrentState();
        boolean successful = false;
        
        if (currentState.equals(new PuzzleState(1,2,3,6,9,8,7,4)))
            successful = true;
        
        return successful;
    }
}
